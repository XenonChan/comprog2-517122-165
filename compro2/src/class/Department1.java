import java.util.Scanner;

class Dept {
    int personel;
    int student;
    int ministryBudget;
    int eduFee;
    int serviceFee;
    int donation;

    public Dept(int personel, int student) {
        this.personel = personel;
        this.student = student;
        ministryBudget = 0;
        eduFee = 0;
        serviceFee = 0;
        donation = 0;

        computeIncome(personel, student);
    }

    public void computeIncome(int personel, int student) {
        ministryBudget = (personel * 500000) + (student * 3000);
        eduFee = student * 5000;
        serviceFee = 300000;
        donation = 100000;
    }

    public void printReport() {
        System.out.println("ministry budget = " + ministryBudget);
        System.out.println("education fee = " + eduFee);
        System.out.println("service fee = " + serviceFee);
        System.out.println("donation = " + donation);
    }
}

public class Department1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Dept de = new Dept(n, k);
        
        de.printReport();
    }
    
}
