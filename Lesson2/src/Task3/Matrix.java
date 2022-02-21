package Task3;

public class Matrix {
    private double[][] a;
    private int m, n;

    Matrix(int m, int n) {
        a = new double[m + 1][n + 1];
        this.m = m;
        this.n = n;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = 0;
            }
        }
    }

    public double getCell(int i, int j) {
        return a[i][j];
    }

    public void setCell(int i, int j, double x) {
        a[i][j] = x;
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public String toString() {
        String s = "";
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                s = (String.format("%s %s", s, a[i][j]));
            }
            s = (String.format("%s\n", s));
        }
        return s;
    }

    static Matrix sum(Matrix A, Matrix B) {
        Matrix C = new Matrix(A.m, A.n);
        if ((A.m == B.m) && (A.n == B.n)) {
            for (int i = 1; i <= C.m; i++) {
                for (int j = 1; j <= C.n; j++) {
                    C.setCell(i, j, A.getCell(i, j) + B.getCell(i, j));
                }
            }
        }
        else {
            System.out.printf("Размеры матриц %sx%s и %sx%s не совпадают %n", A.m, A.n, B.m, B.n);
        }
        return C;
    }

    static Matrix multiplyByNumber(double k, Matrix A) {
        Matrix C = new Matrix(A.m, A.n);
        for (int i = 1; i <= C.m; i++) {
            for (int j = 1; j <= C.n; j++) {
                C.setCell(i, j, k*A.getCell(i, j));
            }
        }
        return C;
    }
    private static double getCellInMult(int x, int y, Matrix A, Matrix B) {
        double result = 0;
        for (int i = 1; i <= A.n; i++) {
            result += A.getCell(x, i)*B.getCell(i, y);
        }
        return result;
    }
    static Matrix mult(Matrix A, Matrix B) {
        Matrix C = new Matrix(A.m, B.n);
        if (A.n == B.m) {
            for (int i = 1; i <= C.m; i++) {
                for (int j = 1; j <= C.n; j++) {
                    C.setCell(i, j, getCellInMult(i, j, A, B));
                }
            }
        }
        else {
            System.out.printf("Недопустимые размеры матриц: %sx%s и %sx%s %n", A.m, A.n, B.m, B.n);
        }
        return C;
    }
}
