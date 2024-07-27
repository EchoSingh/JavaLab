import java.util.Scanner;

class Employee {
    String EmpID;
    String Empname;
    long EmpPhone;
    float EmpSalary;

    public void accept(Scanner obj) {
        System.out.println("Enter Staff ID: ");
        EmpID = obj.nextLine();
        System.out.println("Enter Name: ");
        Empname = obj.nextLine();
        System.out.println("Enter Phone number: ");
        EmpPhone = obj.nextLong();
        obj.nextLine(); // Consume the newline
        System.out.println("Enter Salary: ");
        EmpSalary = obj.nextFloat();
        obj.nextLine(); // Consume the newline
    }

    public void display() {
        System.out.println("Staff ID: " + EmpID);
        System.out.println("Name: " + Empname);
        System.out.println("Phone: " + EmpPhone);
        System.out.println("Salary: " + EmpSalary);
    }
}

class Teaching extends Employee {
    String domain;
    int n;

    public void accept(Scanner obj) {
        super.accept(obj);
        System.out.println("Enter Domain:");
        domain = obj.nextLine();
        System.out.println("Enter number of Publications:");
        n = obj.nextInt();
        obj.nextLine(); // Consume the newline
    }

    public void display() {
        super.display();
        System.out.println("Domain: " + domain);
        System.out.println("Publications: " + n);
    }
}

class Technical extends Employee {
    String skill;

    public void accept(Scanner obj) {
        super.accept(obj);
        System.out.println("Enter Technical Skills:");
        skill = obj.nextLine();
    }

    public void display() {
        super.display();
        System.out.println("Technical Skills: " + skill);
    }
}

class Contract extends Employee {
    int period;

    public void accept(Scanner obj) {
        super.accept(obj);
        System.out.println("Enter Period:");
        period = obj.nextInt();
        obj.nextLine(); // Consume the newline
    }

    public void display() {
        super.display();
        System.out.println("Contract Period: " + period);
    }
}

public class EmployeeFour {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);

        Teaching teach = new Teaching();
        System.out.println("Enter the details of Teaching Staff:");
        teach.accept(obj);

        Technical tech = new Technical();
        System.out.println("Enter the details of Technical Staff:");
        tech.accept(obj);

        Contract con = new Contract();
        System.out.println("Enter the details of Contract Staff:");
        con.accept(obj);

        System.out.println("The details of Teaching Staff:");
        teach.display();
        System.out.println("The details of Technical Staff:");
        tech.display();
        System.out.println("The details of Contract Staff:");
        con.display();
        
        obj.close();
    }
}
