package recursiveapps;

import java.util.Scanner;

public class RecursiveApps {

    private static long[] cacheMemory;

    public static void main(String[] args) {

        System.out.print("What's the size of Fibonacci array that you want: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        cacheMemory = new long[n + 1];
        for (int i= 0; i<=n;i++){
        System.out.println(fibonacci(i) + " ");
}
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (cacheMemory[n]!=0){
            return cacheMemory[n];
        }
        long nthNumber = (fibonacci(n - 1) + fibonacci(n - 2));
        cacheMemory[n] = nthNumber;
        return nthNumber;
        

    }

}
