package inhuritance;

import java.util.Scanner; 

class GameCharacter{
  String name;
  int atk;
  int def;
  int lv;
  GameCharacter(String name, int atk, int def, int lv) {
    this.name = name;
    this.atk = atk;
    this.def = def;
    this.lv = lv;
  }
  
  void stat(){
      System.out.println(this.name + " " + this.atk + " " + this.def + " " + this.lv);
  }
}
class Hero extends GameCharacter{
    Hero(String name){ 
          super(name, 10, 5, 1);
    }
    void hit(Monster x){
        int lv = x.score / 100;

        this.lv += lv;

        this.atk = 10+3*lv;
        this.def = 5+2*lv;
    }
}
class Monster extends GameCharacter{
    int score;
    Monster(String name, int level, int score){
        super(name, 2*level, 3*level, level);
        this.score = score;
    }
}
public class RolePlayingGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        Hero[] heroes = new Hero[M];
        for(int i=0;i<M;i++){
          String name = scan.next();
          heroes[i] = new Hero(name);
        }
        int N = scan.nextInt();
        Monster[] monster = new Monster[N];
        boolean[] alive = new boolean[N];
        for(int i=0;i<N;i++){
          int level = scan.nextInt();
          int score = scan.nextInt();
          monster[i] = new Monster(Integer.toString(i+1), level, score);
        }
        int K = scan.nextInt(); //รับจำนวนคำสั่ง
        for(int i=0;i<K;i++){ //วนรับคำสั่งเพื่อดำเนินการ
          int iHero = scan.nextInt()-1;
          int iMonster = scan.nextInt()-1;
          if (!alive[iMonster]){
            heroes[iHero].hit(monster[iMonster]); //ฮีโรตัวที่ iHero ตี สัตว์ประหลาดตัวที่ iMonster รู้มาจากคำสั่ง
            alive[iMonster] = !alive[iMonster];
          }
        }
        for(int i=0;i<M;i++){
          heroes[i].stat(); //เรียกเมธอดเพื่อแสดงข้อมูล
        }
    }
}

