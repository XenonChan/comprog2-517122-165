package inhuritance;
import java.util.Scanner;

class Hero {
    String name;
    int health;
    int type;
    int atk;
    int def_atk;
    int def_magic;

    Hero(String name, int health, int type, int atk, int def_atk, int def_magic) {
        this.name = name;
        this.health = health;
        this.type = type;
        this.atk = atk;
        this.def_atk = def_atk;
        this.def_magic = def_magic;

        checkAndWarn();
    }

    void printInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("HP: " + this.health);
        System.out.println("Attack: " + this.atk + (type == 1 ? " (physical)":" (magical)"));
        System.out.println("Defense: " + this.def_atk + " (physical), " + this.def_magic + " (magical)");
        checkAndWarn();
    }

    boolean checkAndWarn() {
        if(this.health < 0 || this.atk < 0 || this.def_atk < 0 || this.def_magic < 0) {
            System.out.println("warning: value cannot be negative");
            return false;
        }
        return true;
    }
}
public class AoSU1 {
 public static void main(String[] args) {
 Scanner scan = new Scanner(System.in);
 String name = scan.next();
 int hp = scan.nextInt();
 int attkType = scan.nextInt();
 int attkDmg = scan.nextInt();
 int phyDef = scan.nextInt();
 int magDef = scan.nextInt();

 Hero hero = new Hero(name, hp, attkType,
 attkDmg, phyDef, magDef);
 hero.printInfo();
 System.out.println(hero.checkAndWarn());
 }
}
