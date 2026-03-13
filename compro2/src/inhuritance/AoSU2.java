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

class Team {
    Hero[] members;

    Team(Hero[] members) {
        if(is5MemberTeam(members)) {
            if(isValid(members)) {
                this.members = members;
            } else {
                this.members = null;
                return;
            }
        } else {
            this.members = null;
            return;
        }
    }

    boolean is5MemberTeam(Hero[] members) {
        if(members == null) {
            System.out.println("member is missing");
            return false;
        }
        if(members.length == 5) {
            System.out.println("full team");
            return true;
        } else if (members.length > 5 ) {
            System.out.println("too many members");
        } else if (members.length < 5) {
            System.out.println("member is missing");
        }
        return false;
    }

    boolean isValid(Hero[] members) {
        if(members == null || members.length < 5 || members.length > 5) return false;
        for(int i=0;i<members.length;i++) {
            for(int j=i + 1 ; j < members.length;j++) {
                if(members[i].name.equals(members[j].name)) {
                    System.out.println("cannot select same hero: " + members[i].name);
                    return false;
                }
            }
        }
        System.out.println("valid hero selection");
        return true;
    }
}
public class AoSU2 {
 public static void main(String[] args) {
 Scanner scan = new Scanner(System.in);
 int N = scan.nextInt();
Hero[] members = null;
 if(N > 0) {
 members = new Hero[N];
 for(int i = 0; i < N; ++i) {
 String name = scan.next();
 int hp = scan.nextInt();
 int attkType = scan.nextInt();
 int attkDmg = scan.nextInt();
 int phyDef = scan.nextInt();
 int magDef = scan.nextInt();
 members[i] = new Hero(name, hp, attkType,
 attkDmg, phyDef, magDef);
 }
 }
 Team t = new Team(members);
 System.out.println(t.is5MemberTeam(members));
 System.out.println(t.isValid(members));
 }
}

