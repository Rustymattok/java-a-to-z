package testpart1;

public class Contains
{
    public static void main(String[] args)
    {
        String first = "пример кода";
        String second = "прим";
        Contains contains = new Contains();
        boolean flag = false;
        char [] a = first.toCharArray();
        char [] b = second.toCharArray();
        for (int i = 0; i < a.length ; i++)
        {
            if (a[i] == b[0]){
                if ( contains.compare(i, a, b)){
                    flag = contains.compare(i,a,b);
                    break;
                }
            }
        }
        System.out.println(flag);
    }

    public boolean compare(int k,char[] a,char[] b){
        boolean flag = false;
        for (int i = 0; i < b.length; i++)
        {
            if((a[i+k] == b[i]) && b.length <= a.length){
                flag = true;
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
