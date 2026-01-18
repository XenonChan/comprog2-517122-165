import java.util.Scanner;

public class ReversePrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for(int i=n-1;i>=0;i--) {
            int x = scanner.nextInt();
            arr[i] = x;
        }

        for(int i=0;i<n;i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
}