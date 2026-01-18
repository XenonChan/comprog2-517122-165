import java.util.Scanner;

public class StartBattle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int first_shot = 0;
        int fisrt_unshot = 0;
        int shot = 0;
        int unshot = 0;
        int overshot = 0;

        int[][] arr = new int[r][c];

        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int n = sc.nextInt();

        for(int i=0;i<n;i++) {
            
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            if(x >= r || x < 0 || y >= c || y < 0) {
                overshot++;
            } else if (arr[x][y] == 1) {
                first_shot++;
                arr[x][y]++;
            } else if (arr[x][y] == 0) {
                fisrt_unshot++;
                arr[x][y]--;
            } else if (arr[x][y] > 1) {
                shot++;
            } else if (arr[x][y] < 0) {
                unshot++;
            }
        }
        System.out.println(first_shot);
        System.out.println(fisrt_unshot);
        System.out.println(shot);
        System.out.println(unshot);
        System.out.println(overshot);
    }
}
