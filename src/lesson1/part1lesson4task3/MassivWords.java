package part1lesson4task3;

public class MassivWords
{
    private String[] words;

    public MassivWords(String[] words){
        this.words = words;
    }

    public void sortWords(){

        for (int i = 0; i < words.length ; i++)
        {
            for (int j = i+1; j < words.length; j++)
            {
                if(words[i].equals(words[j])){
                    words[j] = "";
                }

            }
        }
    }

    public void showMassive(){
        for (int i = 0; i < words.length ; i++)
        {
            if(!words[i].equals(""))
            {
                System.out.print( words[i] + " ");
            }
        }
    }

    public String[] getWords()
    {
        return words;
    }

}
