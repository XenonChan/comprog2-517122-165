import java.util.Scanner;
class Theater {
    String title;
    boolean threeD;
    boolean luxury;
    int basePrice;
    int numSeats;
    int[] seats;

    public Theater(boolean threeD, boolean luxury, int numSeats) {
        this.title = null;
        this.threeD = threeD;
        this.luxury = luxury;
        this.basePrice = 0;
        this.numSeats = numSeats;
        this.seats = new int[numSeats];
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public void printInfo() {

        if (this.title == null || this.title.isEmpty()) {
            System.out.println("invalid title");
        }

        if (this.basePrice < 1) {
            System.out.println("invalid price");
        }


        if (this.threeD) {
            System.out.println("3D");
        } else {
            System.out.println("No 3D");
        }

        if (this.luxury) {
            System.out.println("Luxury");
        } else {
            System.out.println("Standard");
        }

        System.out.println(this.numSeats);

        if (this.title == null || this.title.isEmpty()) {
            System.out.println("title is not set");
        } else {
            System.out.println(this.title);
        }

        // Output price
        if (this.basePrice < 1) {
            System.out.println("price is not set");
        } else {
            System.out.println(this.basePrice);
        }
    }
    public int reserveOne(int seatNumber) {
        if(seatNumber <= 0 || seatNumber > numSeats || seats[seatNumber - 1] == 1) {
            System.out.println("sorry");
            return -1;
        } else {
            seats[seatNumber - 1] = 1;
            return basePrice;
        }
    }
 
    public int reserveMultiple(int numberOfSeats, int seatNumber) {
        boolean found = false;
        if(seatNumber + numberOfSeats - 1 > numSeats || seatNumber <= 0) {
            System.out.println("sorry");
            return -1;
        } else {
            for(int i=seatNumber - 1;i<seatNumber - 1 + numberOfSeats;i++) {
            if(seats[i] == 1) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("sorry");
            return -1;
        } else {
            for(int i=seatNumber - 1;i<seatNumber - 1 + numberOfSeats;i++) {
                seats[i] = 1;
            }
            return basePrice * numberOfSeats;
        }
        }
    }
}
// Do not modify the code below. You must leave it as is.
public class Theater2 {
public static void main(String[] args) {
 Scanner scan = new Scanner(System.in);
 int threeD1 = scan.nextInt();
 int luxury1 = scan.nextInt();
 int numSeats = scan.nextInt();
 boolean threeD = false;
 boolean luxury = false;
 if(threeD1 == 1)
 threeD = true;
 if(luxury1 == 1)
 luxury = true;
 Theater t = new Theater(threeD, luxury, numSeats);

 String dummy = scan.nextLine(); // throw away new line character
 String title = scan.nextLine();
 t.setTitle(title);

 int basePrice = scan.nextInt();
 t.setBasePrice(basePrice);

 int N = scan.nextInt();
 for(int i = 0; i < N; ++i) {
 int numberOfSeats = scan.nextInt();
 int seatNumber = scan.nextInt();
 int totalPrice;
 if(numberOfSeats == 1)
 totalPrice = t.reserveOne(seatNumber);
 else
 totalPrice = t.reserveMultiple(numberOfSeats, seatNumber);
 if(totalPrice > 0)
 System.out.println(totalPrice);
 }

 t.printInfo();
 }
}