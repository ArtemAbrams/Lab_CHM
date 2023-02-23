import java.util.Scanner;

class SecantMethod {
    public static final double eps = 1e-6;
    public static double ResultOfFunction(double x)
    {
        return Math.exp(x) - 2 * Math.pow(x - 1, 2);
    }
    public static void twentyIteration()
    {
        double x0 = 0.1;
        double x1 = 0.15;
        double x2 = 0.0;
        double minus;
        System.out.println("20 ітерацій рівняння e^x-2(x-1)^2 = 0 на інтервалі [0.1; 0.5]");
        for(int i =1; i<21; i++)
        {
            double fx0 = ResultOfFunction(x0);
            double fx1 = ResultOfFunction(x1);
            x2 = x1 - fx1 * (x1 - x0) / (fx1 - fx0);
            x0 = x1;
            x1 = x2;
            minus = Math.abs(x1-x0);
            System.out.println("Номер ітерації: " + i + "\t X: " + x1 + " |X(" + i+1 + ") - X(" + i + ")|: " + minus);
        }
    }
    public static void FindResult()
    {
        System.out.println("Знайти розвязок e^x-2(x-1)^2 = 0 на інтервалі [0.1; 0.5] при eps=" + eps);
        double x0 = 0.1;
        double x1 = 0.15;
        double x2 = 0.0;
        int iterations = 0;
        double minus;
        do
        {
            double fx0 = ResultOfFunction(x0);
            double fx1 = ResultOfFunction(x1);
            x2 = x1 - fx1 * (x1 - x0) / (fx1 - fx0);
            x0 = x1;
            x1 = x2;
            iterations++;
            minus= Math.abs(x1-x0);
            System.out.println("Номер ітерації: " + iterations + "\t X: " + x1 + " |X(" +  (iterations+1) +  ") - X(" + (iterations) + ")|: " + minus);
        }
        while (Math.abs(x1 -x0) > eps);
        System.out.println();
        System.out.println("Результат обрахунку");
        System.out.println("x = " + x1 + " f(x) = " + ResultOfFunction(x1));
    }
    public static void main(String[] args)
    {
        boolean choice;
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть true якщо хочете побачити результат 20 ітерацій, якщо хочете побачити результат про доясегненні епсілон введіть false");
        choice = Boolean.parseBoolean(in.next());
        if(choice)
            twentyIteration();
        else
            FindResult();
    }
}