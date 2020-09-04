package texttext;

import java.util.HashMap;
import java.util.Map;

public class Article {
    public static boolean generateBy(String origin, String line){
        boolean flag = true;
        String[] lineData = line.toLowerCase().split("\\s*(\\s|,|!|\\.)\\s*");
        String[] originData = origin.toLowerCase().split("\\s*(\\s|,|!|\\.)\\s*");
        Map<String,Integer> mapOrigin = new HashMap<>();

        for (int i = 0; i < originData.length; i++) {
            if(mapOrigin.get(originData[i]) != null) {
                mapOrigin.put(originData[i], mapOrigin.get(originData[i]) + 1);
            }else {
                mapOrigin.put(originData[i],0);
            }
        }

        for (int i = 0; i < lineData.length; i++) {
            if(mapOrigin.get(lineData[i]) == null){
                flag = false;
            }
        }

        return flag;
    }
}
