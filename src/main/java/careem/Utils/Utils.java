package careem.Utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by bhara on 26-02-2017.
 */
public class Utils {

    public static Map<String,Integer> mapping;
    public static LinkedList<String> hubs;

    public static int getMapppedValue(String value){
        if(mapping == null){
            init();
        }
        return mapping.get(value);
    }

    public static void init(){

        mapping = new HashMap<>();
        mapping.put("Jayanagar",0); //WareHouse
        mapping.put("WhiteField",1); //Destination
        mapping.put("BIA",3); //Destination
        mapping.put("Koramangala",2); // HUB
        mapping.put("Majestic",4); //WareHouse
        mapping.put("KR Puram",5); //HUB
    }

    public static LinkedList<String> getHubs(){
        if(hubs == null){
            hubs = new LinkedList<>();
            hubs.add("Koramangala");
            hubs.add("KR Puram");

        }
      return hubs;
    }

    public static String getPartnerName(String hubName){
        if(hubName.equalsIgnoreCase("Koramangala")){
            return "EKART";
        }else{
            return "NewKart";
        }
    }
}
