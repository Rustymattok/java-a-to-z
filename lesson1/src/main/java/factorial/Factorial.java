package factorial;

public class Factorial
{
    private int n;

    public Factorial(int n){

        this.n = n;
    }

    public double getFactorial(){
        double result = 1;
        for (int i = 1; i <= n; ++i){
            result *= i;
        }
        return result;
    }

}
