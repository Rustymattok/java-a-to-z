package ru.makarov.application.logic;
/**
 * This class describe validation entered text.
 */
public class ValidationKey {
    private String text;
    private String dir;
    private String mask;
    private String indexLogic;
    private String logFile;

    public ValidationKey(String text) {
        this.text = text;
    }
    /**
     * THis method take diretory.
     * @return String - way of directory.
     */
    public String checkDir(){
        char[] massiv = text.toCharArray();
        for (int i = 0; i < massiv.length; i++) {
            if(massiv[i] == '-' && massiv[i+1] == 'd'){
                 int index = i + 3;
                 int length = 0;
                  while(massiv [index] != ' '){
                      index ++;
                      length++;
                }
                dir = String.copyValueOf(massiv,i + 3,length);
            }
        }
        return dir;
    }
    /**
     * THis method take mask.
     * @return String - way of mask.
     */
    public String checkMask(){
        char[] massiv = text.toCharArray();
        for (int i = 0; i < massiv.length; i++) {
            if(massiv[i] == '-' && massiv[i+1] == 'n'){
                int index = i + 3;
                int length = 0;
                while(massiv [index] != ' '){
                    index ++;
                    length++;
                }
                mask = String.copyValueOf(massiv,i + 3,length);
            }
        }
        return  mask;
    }
    /**
     * THis method take logic.
     * @return String - way of logic.
     */
    public String checkLogic(){
        char[] massiv = text.toCharArray();
        for (int i = 0; i < massiv.length; i++) {
            if(massiv[i] == '-' && (massiv[i+1] == 'm' || massiv[i+1] == 'f' || massiv[i+1] == 'r')){
                    indexLogic = String.copyValueOf(massiv,i + 1,1);
            }
        }
        return  indexLogic;
    }
    /**
     * THis method take logFile.
     * @return String - logFile.
     */
    public String logFile(){
        char[] massiv = text.toCharArray();
        for (int i = 0; i < massiv.length; i++) {
            if(massiv[i] == '-' && massiv[i+1] == 'o'){
                int index = i + 3;
                int length = 0;
                while(index != massiv.length){
                    index ++;
                    length++;
                }
                logFile = String.copyValueOf(massiv,i + 3,length);
            }
        }
        return logFile;
    }
}
