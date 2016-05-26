package part1lesson4task3;

public class TestMassive
{
    public static void main(String[] args)
    {
        String[] value = {"mir","dubl","rev","mir","ura","mir","dubl","dssd","dssd"};
        MassivWords massivWords = new MassivWords(value);
        massivWords.showMassive();
        massivWords.sortWords();
        System.out.println();
        massivWords.showMassive();
    }
}
