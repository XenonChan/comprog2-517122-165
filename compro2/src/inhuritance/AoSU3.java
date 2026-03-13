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

class Carry extends Hero  {
    Carry(String name, int health, int type, int atk, int def_atk, int def_magic) {
        super(name, health, type, atk, def_atk, def_magic);
    }   
}

class Fighter extends Hero {
    Fighter(String name, int health, int type, int atk, int def_atk, int def_magic) {
        super(name, health, type, atk, def_atk, def_magic);
    }
}

class Mage extends Hero {
    Mage(String name, int health, int type, int atk, int def_atk, int def_magic) {
        super(name, health, type, atk, def_atk, def_magic);
    }
}

class Tank extends Hero {
    Tank(String name, int health, int type, int atk, int def_atk, int def_magic) {
        super(name, health, type, atk, def_atk, def_magic);
    }
}

class Support extends Hero {
    Support(String name, int health, int type, int atk, int def_atk, int def_magic) {
        super(name, health, type, atk, def_atk, def_magic);
    }
}

class Assasin extends Hero {
    Assasin(String name, int health, int type, int atk, int def_atk, int def_magic) {
        super(name, health, type, atk, def_atk, def_magic);
    }
}

class Team {
    Hero[] members;
    boolean isBalanced;

    Team(Hero[] members) {
        if(is5MemberTeam(members)) {
            if(isValid(members)) {
                this.members = members;
                this.isBalanced = isBalanced(members);
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

    boolean isBalanced(Hero[] members) {
        if(members == null || members.length < 5 || members.length > 5) return false;
        boolean carry = false;
        boolean fighter = false;
        boolean mage = false;
        boolean tank = false;

        for(int i=0;i<members.length;i++) {
            if(members[i] instanceof Carry) carry = true;
            if(members[i] instanceof Fighter) fighter = true;
            if(members[i] instanceof Mage) mage = true;
            if(members[i] instanceof Tank) tank = true;
        }
        if(carry && fighter && mage && tank) {
            System.out.println("balanced team");
            return true;
        } else {
            System.out.print("team needs ");
            if(!carry) System.out.print("carry ");
            if(!fighter) System.out.print("fighter ");
            if(!mage) System.out.print("mage ");
            if(!tank) System.out.print("tank ");
            System.out.println();
            return false;
        }
    }
}

public class AoSU3 {
 public static void main(String[] args) {
 Scanner scan = new Scanner(System.in);
 int N = scan.nextInt();
Hero[] members = null;
 if(N > 0) {
 members = new Hero[N];
 for(int i = 0; i < N; ++i) {
 int type = scan.nextInt();
 String name = scan.next();
 int hp = scan.nextInt();
 int attkType = scan.nextInt();
 int attkDmg = scan.nextInt();
 int phyDef = scan.nextInt();
 int magDef = scan.nextInt();
 if(type == 1)
 members[i] = new Carry(name, hp, attkType,
 attkDmg, phyDef, magDef);
if(type == 2) {
    members[i] = new Fighter(name, hp, attkType,
    attkDmg, phyDef, magDef);
}
if(type == 3) {
    members[i] = new Mage(name, hp, attkType,
 attkDmg, phyDef, magDef);
}
if(type == 4) {
    members[i] = new Tank(name, hp, attkType,
 attkDmg, phyDef, magDef);
}
if(type == 5) {
    members[i] = new Support(name, hp, attkType,
 attkDmg, phyDef, magDef);
}
if(type == 6) {
    members[i] = new Support(name, hp, attkType,
 attkDmg, phyDef, magDef);
}
 }
 }
 Team t = new Team(members);
 System.out.println(t.is5MemberTeam(members));
 System.out.println(t.isValid(members));
 System.out.println(t.isBalanced(members));
 }
}
