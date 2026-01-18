import java.util.ArrayList;
import java.util.Scanner;

class Food {
    String name;
    ArrayList<String> ingredients = new ArrayList<String>();
    int weight;

    public Food(String name, String ingredient, int weight) {
        this.name = name;
        ingredients.add(ingredient);
        this.weight += weight;
    }

    public void addContent(String ingredient, int weight) {
        ingredients.add(ingredient);
        this.weight += weight;
    }

    public void printInfo() {
        System.out.println(this.name);
        System.out.println(this.weight);
        
        for(String i : ingredients) {
            System.out.print(i + " ");
        }
        System.out.println();
    } 
}

public class FoodContents1 {
    public static void main(String[] args) {
 Scanner scan = new Scanner(System.in);
 String foodName = scan.next();
 String content1 = scan.next();
 int w1 = scan.nextInt();

 Food food = new Food(foodName, content1, w1);

 int q = scan.nextInt();
 while(q != 0) {
 if(q == 1) {
food.printInfo();
 } else if(q == 2) {
String ingredient = scan.next();
int weight = scan.nextInt();
 food.addContent(ingredient, weight);
 }
 q = scan.nextInt();
 }
 }
}
