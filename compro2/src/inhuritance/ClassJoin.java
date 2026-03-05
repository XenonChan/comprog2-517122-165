package inhuritance;
import java.util.Scanner;
class Component {
    String model;
    int socket;
    int memType;
    boolean valid;

    Component(String model, int socket, int memType) {
        this.model = model;
        this.socket = socket;
        this.memType = memType;
        this.valid = isVaildSpec(model, socket, memType);
    }

    void printInfo() {
        System.out.println(this.valid);
        System.out.println(this.model);
        System.out.println(this.socket);
        System.out.println(this.memType);
    }
    boolean isVaildSpec(String model, int socket, int memType) {
        if (model != null && socket > 0 && (memType > 0 && memType <= 10) && model.length() > 0) {
            return true;
        } else {
            return false;
        }
    }
}

class CPU2 extends Component {
    int clocks;

    CPU2(String model, int clocks, int socket, int memType) {
        super(model, socket, memType);
        this.clocks = clocks;
        if(clocks <= 0) {
            super.valid = false;
        }
    }
    @Override
    void printInfo() {
        super.printInfo();
        System.out.println(this.clocks);
    }

    
}

class MainBoard2 extends Component {
    MainBoard2(String model, int socket, int memType) {
        super(model, socket, memType);

    }
    @Override
    void printInfo() {
        super.printInfo();
    }

}

public class ClassJoin {
    // Do not change the main method
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String model = scan.nextLine();
        int clocks = scan.nextInt();
        int socket = scan.nextInt();
        int memType = scan.nextInt();

        if(model.length() == 0 && socket % 2 == 0)
            model = null;
        Component cpu = new CPU2(model, clocks, socket, memType);
        cpu.printInfo();

        scan.nextLine(); // skip new line character
        model = scan.nextLine();
        socket = scan.nextInt();
        memType = scan.nextInt();
        if(model.length() == 0 && socket % 2 == 0)
            model = null;
        Component mb = new MainBoard2(model, socket, memType);
        mb.printInfo();
    }
}