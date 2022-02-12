public class Task7 {
    public static void main(String[] args) {
        int a, b, c, N;
        N = 11;
        a = 0;
        b = 1;
        for (int i = 1; i <= N; i++) {
            System.out.print(b + " ");
            c = b;
            b = a + b;
            a = c;
        }
    }
}
