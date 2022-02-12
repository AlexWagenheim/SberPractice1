public class Task2 {
    public static void FillArray(int[] a, int n) {
        int SegmentLength = 100;
        for(int i = 0; i < n; i++) {
            a[i] = (int)  (Math.random()*SegmentLength);
        }
    }

    public static void QuickSort(int[] a, int n, int L, int R) {
        int x, y, i, j;
        x = a[(L + R)/2];
        i = L;
        j = R;

        do {
            while (a[i] < x) {
                i++;
            }
            while (a[j] > x) {
                j--;
            }
            if (i <= j) {
                y = a[i];
                a[i] = a[j];
                a[j] = y;
                i++;
                j--;
            }
        }while (i <= j);
        if (L < j) {
            QuickSort(a, n, L, j);
        }
        if (i < R) {
            QuickSort(a, n, i, R);
        }

    }

    public static void main(String[] args) {
        int n = 10;
        int[] a = new int[n];

        FillArray(a, n);

        System.out.println("Исходный массив: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        QuickSort(a, n, 0, n - 1);

        System.out.println("Отсортированный массив: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
