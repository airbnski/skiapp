package airbnski.resort.service;

import airbnski.resort.client.api.ClientResortService;
import airbnski.resort.client.model.ClientResort;
import airbnski.resort.generated.model.Resort;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Component
public class ResortService {

    private static ResortServiceUtils util = new ResortServiceUtils();

    private final static int size = util.getSize();

    private static final int[] chId = util.concatRegionIds();

    private static final ExecutorService executor =  Executors.newWorkStealingPool(30);

    private static Resort[] results = new Resort[size];

    private static ClientResortService clientResortService = new ClientResortService();

    public static Resort getResort(Integer id) throws ExecutionException, InterruptedException {
        CompletableFuture<ClientResort> clientResort = clientResortService.getResource(id);
        return util.convertClient((ClientResort) clientResort.get());
    }

    /*public ClientWeather getClientWeather() {
        return clientWeather;
    }

    public void setClientSlope(ClientSlope clientSlope) {
        this.clientSlope = clientSlope;
    }*/

    public static Resort[] getAllResorts() {

        if(results[0]!=null) return results;



        //Test SwissSkiService API
        /*
            SwissSkiService api = new SwissSkiService();
            System.out.println(api.getResortById(1009));

         */

        CompletableFuture[] futures = IntStream.range(0,size)
                .mapToObj(i->CompletableFuture.supplyAsync(()-> {
                    CompletableFuture<ClientResort> result = null;
                    result = clientResortService.getResource(chId[i]);
                    return result;
                },executor))
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).thenAccept(ignore -> {
            for (int i = 0; i < size; i++ ) {
                CompletableFuture current = null;
                try {
                    current = (CompletableFuture) futures[i].get();
                    results[i] = util.convertClient((ClientResort) current.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }).join();
        return results;
    }

    public static Resort[] getResortByCoordinates(Double longitude, Double latitude) {
        if(results[0]==null) results = getAllResorts();
        Resort[] filteredByCoordinates = Arrays.stream(results).filter(c -> c.isWithinCoordinates(longitude,latitude,null)).toArray(Resort[]::new);
        return filteredByCoordinates;
    }
}









