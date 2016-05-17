package factorial;

public class Factorial
{
    private int n;

    public Factorial(int n){
        this.n = n;
    }

    public void factorial(){
        int result;
        do
        {
            result = 1;
            if(n < 0){
                result = -1;
                break;
            }
            for (int i = 2; i <= n; i++)
                result *= i;
            if (n == 0 || n == 1)
            {
                result = 1;
            }
        } while (n < 0);
        System.out.println(result);
    }

}
