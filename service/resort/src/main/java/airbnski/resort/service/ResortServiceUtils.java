package airbnski.resort.service;

import airbnski.resort.client.model.ClientResort;
import airbnski.resort.generated.model.Resort;
import airbnski.resort.generated.model.Weather;
import airbnski.weather.client.model.GeolocationWeather;
import airbnski.weather.client.api.ClientWeatherService;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

public class ResortServiceUtils {

    private static ClientWeatherService clientWeatherService = new ClientWeatherService();
    private static SwissSkiService api = new SwissSkiService();

    private final static int[] regionsCHId = {515, 387, 385, 384, 383, 382};
    private final static int[] berneseCHId = {1002, 12874, 1003, 3719, 5448, 5449, 3785, 3788, 1000,
            4187, 1001, 3786, 3787};
    private final static int[] centralCHId = {3724, 1004, 5453, 15113, 1005, 5454, 1008, 12392, 3720,
            3789, 5456, 15115, 2968, 12960, 3790, 1007, 14640, 3038};
    private final static int[] easternCHId = {3725, 15168, 3828, 1023, 3839, 15169, 4392, 1020, 1022,
            4394, 1021, 3792 };
    private final static int[] graubundenCHId = {1012, 1014, 1010, 4398, 4396, 4395, 1018, 3801, 1009,
            14677, 1016, 2405, 1011, 4397, 3712, 14678, 3728, 5029, 4050, 13947, 3722, 3721, 3799, 1015,
            630, 14692, 14697, 14697, 3800, 4048, 1019 };
    private final static int[] ticinoCHId = {3169, 3683, 13875, 3715, 3705, 15201, 12774, 3713, 3709};
    private final static int[] valaisCHId = {990, 998, 3782, 5676, 13470, 5677, 13470, 5677, 4388, 2387,
            4185, 3714, 991, 3784, 3723, 15410, 4186, 4601, 4184, 999, 12872, 15247, 3841, 5413, 5413, 4909,
            989, 5670, 5412, 13753, 4387, 4835, 3727, 988, 5428, 996, 994, 997, 987, 3112, 15349, 3783, 2291,
            3781, 3718, 2893, 2890, 993, 3711, 3708, 15388, 4600, 5427, 992, 1037, 15355, 995, 4046};
    private final static int size = berneseCHId.length + centralCHId.length + easternCHId.length + graubundenCHId.length + ticinoCHId.length + valaisCHId.length;
    private static final int[] chId = concatRegionIds();

    public static int[] concatRegionIds() {
        int[] a = IntStream.concat(IntStream.of(berneseCHId), IntStream.of(centralCHId)).toArray();
        int[] b = IntStream.concat(IntStream.of(easternCHId), IntStream.of(graubundenCHId)).toArray();
        int[] c = IntStream.concat(IntStream.of(ticinoCHId), IntStream.of(valaisCHId)).toArray();
        int[] chID = IntStream.concat(IntStream.of(a), IntStream.of(b)).toArray();
        chID = IntStream.concat(IntStream.of(chID), IntStream.of(c)).toArray();
        return chID;
    }

    public static int getSize() {
        return size;
    }

    protected static Resort convertClient(ClientResort clientResort) throws ExecutionException, InterruptedException {
        Resort resort = new Resort();
        resort.setId(clientResort.getId());
        resort.setName(clientResort.getName());
        resort.setWebsite(clientResort.getWebsite());
        resort.setStatus(clientResort.getStatus());
        resort.setLongitude(clientResort.getLongitude());
        resort.setLatitude(clientResort.getLatitude());
        resort.distanceFromCenter(8.541888260467331,47.37892103064415);
        if (Arrays.stream(clientResort.getSlope()).count()>0)
            resort.setImage(clientResort.getSlope()[0].getMedia().getOriginal().getUrl());
        clientWeatherService.setLongitude(clientResort.getLongitude());
        clientWeatherService.setLatitude(clientResort.getLatitude());
        CompletableFuture<GeolocationWeather> futureWeather = clientWeatherService.getResource();
        GeolocationWeather clientWeather  = (GeolocationWeather) futureWeather.get();
        Weather weather = new Weather();
        weather.setOutlook(clientWeather.getWeather()[0].getMain());
        weather.setTemperature(clientWeather.getTemperature().getTemp());
        resort.setWeather(weather);
        Resort r = api.getResortById(clientResort.getId());
        if (r!=null && r.getSlope()!=null)resort.setSlope(r.getSlope());
        return resort;
    }
}
