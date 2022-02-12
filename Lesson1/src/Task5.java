public class Task5 {

    public static boolean isPrime(int x, int[] Primes, int PrimesCount) {
        int m = 0;
        if (PrimesCount == 0) {
            return true;
        } else {
            for(int i = 0; i < PrimesCount; i++) {
                m = x%Primes[i];
                if (m == 0) {
                    return false;
                }
            }
            return m != 0;
        }
    }

    public static void main(String[] args) {
        int n = 100;
        int[] Primes = new int[n];
        int PrimesCount = 0;

        for(int i = 2; i <= n; i++) {
            if (isPrime(i, Primes, PrimesCount)) {
                System.out.print(i + " ");
                Primes[PrimesCount] = i;
                PrimesCount++;
            }
        }
    }
}
