public class Task6 {
    public static void main(String[] args) {
        int M, N; //M - ширина, N - высота
        M = 4;
        N = 3;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
