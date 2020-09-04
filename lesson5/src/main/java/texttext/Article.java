package texttext;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String[] lineData = line.toLowerCase().split("\\s*(\\s|,|!|\\.)\\s*");
        boolean flag = true;
        for (int i = 0; i < lineData.length; i++) {
            if(!origin.contains(lineData[i])){
                flag =false;
            }
        }
        return flag;
    }
}
