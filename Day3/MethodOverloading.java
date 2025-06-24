package Day3;

public class MethodOverloading {

    
    public int sum(int a, int b,int c) {
        return a + b+ c;
    }

    
    public double sum(double a, double b,double c) {
        return a + b+ c;
    }

    public static void main(String[] args) {
        MethodOverloading obj = new MethodOverloading();
        System.out.println("Sum of integers: " + obj.sum(10, 20,30));
        System.out.println("Sum of doubles: " + obj.sum(10.5, 20.3,7.18));
    }
}
