public class Task4 {
    public static void fillArray(int[] a, int n) {
        int SegmentLength = 100;
        for(int i = 0; i < n; i++) {
            a[i] = (int)  (Math.random()*SegmentLength);
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int[] a = new int[n];

        int Sum, Min, Max;

        fillArray(a, n);

        System.out.println("Исходный массив: ");
        Sum = 0;
        Min = a[0];
        Max = a[0];

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
            Sum += a[i];
            if (a[i] < Min) {
                Min = a[i];
            }
            if (a[i] > Max) {
                Max = a[i];
            }
        }
        System.out.println();
        System.out.println("Среднее значение: " + (double) Sum/n);
        System.out.println("Максимум: " + Max);
        System.out.println("Минимум: " + Min);

    }
}
