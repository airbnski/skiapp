package airbnski.resort.service;

import airbnski.resort.generated.model.Resort;
import airbnski.resort.generated.model.Slope;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

public class SwissSkiService {

    private JSONArray data;
    public Map<Integer, Resort> dataMap;

    public SwissSkiService() {
        //Initialize data on load
        JSONParser parser = new JSONParser();
        dataMap = new HashMap<Integer, Resort>();
        try {

            //File file = ResourceUtils.getFile("classpath:ski-ch.json");
            InputStream inputStream = getClass().getResourceAsStream("/ski-ch.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            Object obj = parser.parse(reader);

            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
            JSONObject jsonObject = (JSONObject) obj;

            // A JSON array. JSONObject supports java.util.List interface.
            JSONArray list = (JSONArray) jsonObject.get("features");
            this.data = list;
            // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
            // Iterators differ from enumerations in two ways
            Iterator<JSONObject> iterator = list.iterator();
            int i = 1;
            while (iterator.hasNext()) {
                Resort resortObj = new Resort();
                JSONObject resort = iterator.next();

                JSONObject prop = (JSONObject) resort.get("properties");
                JSONArray sources = (JSONArray) prop.get("sources");
                if(!sources.isEmpty()){
                    for( Object src : sources){
                        JSONObject srcObj = (JSONObject) src;
                        if(((String) srcObj.get("type")).equals("skimap.org")){

                            resortObj.setId(Integer.parseInt((String) srcObj.get("id")));
                            break;
                        }else{
                            String []temp = ((String) srcObj.get("id")).split("/");
                            int tempId;
                            if(temp.length > 1){
                                tempId = Integer.parseInt(temp[1]);
                            }else{
                                tempId = -1;
                            }
                            resortObj.setId(tempId);
                        }
                    }
                }
                JSONArray websites = (JSONArray) prop.get("websites");
                if(!websites.isEmpty()){
                    resortObj.setWebsite( (String) websites.get(0));
                }

                resortObj.setName( (String) prop.get("name"));
                resortObj.setStatus( (String) prop.get("status"));

                JSONObject geo = (JSONObject) resort.get("geometry");
                if(geo!=null){
                    JSONArray coordinates = (JSONArray) geo.get("coordinates");
                    if(coordinates.size()>1){
                        Double x = (Double) coordinates.get(1);
                        Double y = (Double) coordinates.get(0);

                        resortObj.setLatitude(x);
                        resortObj.setLongitude(y);
                    }
                }

                JSONObject stats = (JSONObject) prop.get("statistics");
                if(stats!=null){
                    JSONObject runs = (JSONObject) stats.get("runs");
                    if(runs!=null){
                        JSONObject activity = (JSONObject) runs.get("byActivity");
                        if(activity!=null){
                            JSONObject downhill = (JSONObject) activity.get("downhill");
                            if(downhill!=null){

                                JSONObject diff = (JSONObject) downhill.get("byDifficulty");
                                if(diff!=null){
                                    Slope slope = new Slope();
                                    JSONObject intermediate = (JSONObject) diff.get("intermediate");
                                    if(intermediate!=null){
                                        slope.setMediumDistance((int)((double) intermediate.get("lengthInKm")));
                                    }
                                    JSONObject easy = (JSONObject) diff.get("easy");
                                    if(easy!=null){
                                        slope.setEasyDistance((int)((double) easy.get("lengthInKm")));
                                    }
                                    JSONObject advanced = (JSONObject) diff.get("advanced");
                                    if(advanced!=null){
                                        slope.setHardDistance((int)((double) advanced.get("lengthInKm")));
                                    }
                                    resortObj.setSlope(slope);
                                }
                            }
                        }
                    }
                }

                //Add to Map if id exists
                if(resortObj.getId()!=null){
                    dataMap.put(resortObj.getId(), resortObj);
                }
            }// While


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Only for testing
    public static  void main(String []args){
        SwissSkiService api = new SwissSkiService();

        //Use Methods
        Resort davos = api.getResortById(1009);
        System.out.println(davos);

        Collection<Resort> allResorts = api.getAllValidResorts();
        for( Resort resort : allResorts){
            System.out.println(resort.toString());
        }
    }
    */

    public Resort getResortById(int id){
        return dataMap.get(id);
    }

    public Collection<Resort> getAllValidResorts(){
        return dataMap.values();
    }

}
