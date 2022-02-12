public class Task1 {
    public static void FillArray(int[] a, int n) {
        int SegmentLength = 100;
        for(int i = 0; i < n; i++) {
            a[i] = (int)  (Math.random()*SegmentLength);
        }
    }

    public static void BubbleSort(int[] a, int n) {
        int buffer;
        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j > i - 1; j--) {
                if (a[j] < a[j - 1]) {
                    buffer = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = buffer;
                }
            }
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

        BubbleSort(a, n);

        System.out.println("Отсортированный массив: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
