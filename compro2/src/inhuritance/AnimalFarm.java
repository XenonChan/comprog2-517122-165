package inhuritance;

import java.util.Scanner;

class Animal {
    static int count = 1;
    String id;
    int maxFood;
    int curFood;

    Animal(int maxFood) {
        this.id = "Animal_" + this.count++;
        this.maxFood = maxFood;
        this.curFood = 0;
    }

    void eat(int feed) {
        if(this.curFood + feed <= maxFood) {
            this.curFood+= feed;
        } else {
            this.curFood = this.maxFood;
        }
    }
    void printInfo() {
        System.out.println(this.id + " " + this.curFood + "/" + this.maxFood);
    }
}

class Cow extends Animal {
    Cow(int maxFood) {
        super(maxFood);
    }
} 

class Sheep extends Animal {
    Sheep() {
        super(30);
    }
    @Override
    void eat(int feed) {
        super.eat(feed/2);
    }
}

public class AnimalFarm {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 // init animals
 int numAnimals = sc.nextInt();
 Animal[] animals = new Animal[numAnimals];
 for (int i = 0; i < numAnimals; ++i) {
 String type = sc.next();
 if (type.equals("Cow")) {
 int maxFood = sc.nextInt();
 animals[i] = new Cow(maxFood);
 } else if (type.equals("Sheep")) {
animals[i] = new Sheep();
 } else {
 int maxFood = sc.nextInt();
animals[i] = new Animal(maxFood);
 }
 }
 // eat
 while (true) {
    int index = sc.nextInt();
 if (index == -1) {
 break;
 }
 int food = sc.nextInt();
animals[index].eat(food);
 }
 // filter
 String report = sc.next();
if(report.equals("All")) {
    for(int i=0;i<numAnimals;i++) {
        animals[i].printInfo();
    }
} else if (report.equals("Cow")) {
    for(int i=0;i<numAnimals;i++) {
        if(animals[i].getClass().equals(Cow.class)) {
            animals[i].printInfo();
        }
    }
} else if (report.equals("Sheep")) {
    for(int i=0;i<numAnimals;i++) {
        if(animals[i].getClass().equals(Sheep.class)) {
            animals[i].printInfo();
        }
    }
} else if (report.equals("Other")) {
    for(int i=0;i<numAnimals;i++) {
        if(!animals[i].getClass().equals(Sheep.class) && !animals[i].getClass().equals(Cow.class)) {
            animals[i].printInfo();
        }
    }
}
 }
} 
