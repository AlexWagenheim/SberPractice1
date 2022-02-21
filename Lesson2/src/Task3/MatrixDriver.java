package Task3;

public class MatrixDriver {

    private static void fillArray(Matrix A, int m, int n) {
        int SegmentLength = 10;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                A.setCell(i, j, (int) (Math.random()*SegmentLength));
            }
        }
    }

    public static void main(String[] args) {
        double k = 10;
        int m1 = 3;
        int n1 = 4;
        int m2 = 3;
        int n2 = 4;
        int m3 = 4;
        int n3 = 3;

        Matrix A = new Matrix(m1, n1);
        fillArray(A, m1, n1);
        System.out.println("A:");
        System.out.println(A);

        Matrix B = new Matrix(m2, n2);
        fillArray(B, m2, n2);
        System.out.println("B:");
        System.out.println(B);

        Matrix C = new Matrix(m3, n3);
        fillArray(C, m3, n3);
        System.out.println("C:");
        System.out.println(C);

        System.out.println("A + B:");
        System.out.println(Matrix.sum(A, B));

        System.out.printf("k = %s; k*A: %n", k);
        System.out.println(Matrix.multiplyByNumber(k, A));

        System.out.println("A*C:");
        System.out.println(Matrix.mult(A, C));
    }
}
