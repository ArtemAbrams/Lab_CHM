import java.util.Scanner;

public class Main
{
    private static final double Epsilon = 1e-6;
    public static double ResultOfFunction(double x)
    {
        return Math.exp(x) - 2 * Math.pow((x-1) ,2);
    }
    public static double ResultOfDerivativesOfFunction(double x)
    {
        return Math.exp(x) - 4 * (x -1);
    }
    public static void twentyIteration()
    {
        double x_n = 0.2;
        double x_next = 0;
        double dummyX_n;
        double minus;
        System.out.println("20 ітерацій рівняння e^x-2(x-1)^2 = 0 на інтервалі [0.2; 0.5]");
        for(int i =1; i<21; i++)
        {
            x_next = x_n - ResultOfFunction(x_n) / ResultOfDerivativesOfFunction(x_n);
            dummyX_n = x_n;
            x_n = x_next;
            minus = Math.abs(x_next - dummyX_n);
            System.out.println("Номер ітерації: " + i + "\t X: " + x_next + " |X(" + i + ") - X(" + (i - 1) + ")|: " + Math.abs(x_next - dummyX_n));
        }
    }
    public static void FindResult()
    {
        System.out.println("Знайти розвязок e^x-2(x-1)^2 = 0 на інтервалі [0.2; 0.5] при eps=" + Epsilon);
        double x_n = 0.2;
        double x_next = 0;
        double dummyX_n;
        int countOfIteration = 0;
        double minus;
        do {
            x_next = x_n - ResultOfFunction(x_n) / ResultOfDerivativesOfFunction(x_n);
            countOfIteration++;
            dummyX_n = x_n;
            x_n = x_next;
            minus = Math.abs(x_next - dummyX_n);
            System.out.println("Номер ітерації: " + countOfIteration + "\t X: " + x_next + " |X(" + countOfIteration + ") - X(" + (countOfIteration - 1) + ")|: " + Math.abs(x_next - dummyX_n));
        }
        while (Math.abs(x_next - dummyX_n) > Epsilon);
        System.out.println();
        System.out.println("Результат обрахунку");
        System.out.println("x = " + x_next + " f(x) = " + ResultOfFunction(x_next));
    }
    public static void main(String[] args) {
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