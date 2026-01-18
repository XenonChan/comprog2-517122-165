import java.util.Scanner;

public class ShotCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int shot = 0;
        int un_shot = 0;
        
        int n = sc.nextInt();

        for(int i=0;i<n;i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            if(x <= r && x > 0 && y <= c && y > 0) {
                shot++;
            } else {
                un_shot++;
            }
        }
        System.out.println(shot);
        System.out.println(un_shot);
    }
}
