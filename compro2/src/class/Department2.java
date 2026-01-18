import java.util.Scanner;

class Dept {
    int personel;
    int student;
    int ministryBudget;
    int eduFee;
    int serviceFee;
    int donation;
    int salary;
    int elec;
    int eduCost;
    int income;
    int expense;

    public Dept(int personel, int student) {
        this.personel = personel;
        this.student = student;
        ministryBudget = 0;
        eduFee = 0;
        serviceFee = 0;
        donation = 0;

        computeIncome(personel, student);
        computeExpense(personel, student);
    }

    public int computeIncome(int personel, int student) {
        ministryBudget = (personel * 500000) + (student * 3000);
        eduFee = student * 5000;
        serviceFee = 300000;
        donation = 100000;;

        return income = ministryBudget + eduFee + serviceFee + donation;
    }

    public int computeExpense(int personel, int student) {
        salary = personel * 600000;
        elec = (personel + student) * 2000;
        eduCost = student * 4000;

        return expense = salary + elec + eduCost;
    }

    public void printReport() {
        System.out.println("total income = " + income);
        System.out.println("total expense = " + expense);
        System.out.println("income - expense = " + (income - expense));
        System.out.println("ministry budget = " + ministryBudget);
        System.out.println("education fee = " + eduFee);
        System.out.println("service fee = " + serviceFee);
        System.out.println("donation = " + donation);
        System.out.println("salary = " + salary);
        System.out.println("electricity = " + elec);
        System.out.println("educational cost = " + eduCost);
    }
}

public class Department2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Dept dept = new Dept(n, k);

        dept.printReport();
    }
}
