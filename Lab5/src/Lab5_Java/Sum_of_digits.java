package Lab5_Java;

public class Sum_of_digits {
    public static int recursion(int n) {
        if (n < 10) {
            return n;
        }
        else {
            return n % 10 + recursion(n / 10);
        }
    }
    public static void main(String[] args) {
        System.out.println(recursion(456));
    }
}

