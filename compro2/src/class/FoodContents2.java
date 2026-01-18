import java.util.ArrayList;
import java.util.Scanner;

class Food {
    String name;
    ArrayList<String> ingredients = new ArrayList<String>();
    int weight;
    int cal;

    public Food(String name, String ingredient, int weight, int cal) {
        this.name = name;
        ingredients.add(ingredient);
        this.weight += weight;
        this.cal += weight * cal;
    }

    public void addContent(String ingredient, int weight, int cal) {
        ingredients.add(ingredient);
        this.weight += weight;
        this.cal += weight * cal;
    }

    public void printInfo() {
        System.out.println(this.name);
        System.out.println(this.weight + " " + this.cal);
        
        for(String i : ingredients) {
            System.out.print(i + " ");
        }
        System.out.println();
    } 
}

public class FoodContents2 {
    public static void main(String[] args) {
 Scanner scan = new Scanner(System.in);
 String foodName = scan.next();
 String content1 = scan.next();
 int w1 = scan.nextInt();
 int cal = scan.nextInt();

 Food food = new Food(foodName, content1, w1, cal);

 int q = scan.nextInt();
 while(q != 0) {
 if(q == 1) {
food.printInfo();
 } else if(q == 2) {
String ingredient = scan.next();
int weight = scan.nextInt();
int calw = scan.nextInt();
 food.addContent(ingredient, weight, calw);
 }
 q = scan.nextInt();
 }
 }
}
