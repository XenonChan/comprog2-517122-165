import java.util.Scanner;

public class KeepTwo {

    String keepTwo(String str) {

        if (str.length() == 0) return "";

        char ch = str.charAt(0);
        int ch_1 = str.indexOf(ch);
        int ch_2 = str.indexOf(ch, ch_1 + 1);
        
        int last_ch = str.lastIndexOf(ch);

        if(last_ch > ch_2 && ch_2 != -1) {
            str = str.substring(0, last_ch) + str.substring(last_ch + 1);
            return keepTwo(str);
        }
        return ch + keepTwo(str.substring(1));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        KeepTwo kt = new KeepTwo();
        System.out.print(kt.keepTwo(str));
    }
}