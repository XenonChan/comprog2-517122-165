import java.util.Scanner;

public class RemoveAnyDup {
 String removeAnyDup(String str) {
    
    if(str.length() == 0) return  "";

    char ch = str.charAt(0);
    int ch_1 = str.indexOf(ch);
    int ch_2 = str.indexOf(ch, ch_1 + 1);

    if(ch_2 != -1) {
        str = str.substring(0, ch_2) + str.substring(ch_2 + 1);
        return removeAnyDup(str);
    }

    return ch + removeAnyDup(str.substring(1));
 }

 public static void main(String[] args) {
 Scanner scan = new Scanner(System.in);
 String str = scan.next();
 RemoveAnyDup remover = new RemoveAnyDup ();
 String result = remover.removeAnyDup(str);
 System.out.print(result);
 }
}