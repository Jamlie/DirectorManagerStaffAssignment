import com.jam.*;

public class Main {
    public static void main(String[] args) {
        Database db = Database.getInstance();
        Director directorJohn = new Director(1, "John", 30, 100, 40);
        Director directorJane = new Director(2, "Jane", 35, 100, 40);

        Manager managerBob = new Manager(3, "Bob", 40, 50, 40);
        Manager managerAlice = new Manager(4, "Alice", 45, 50, 50);

        directorJohn.addManager(managerBob);
        directorJane.addManager(managerAlice);

        EmployeeModel employeeModel = new EmployeeModel(5, "Eve", 50, 25, 40);

        Staff staffEve = new Staff(employeeModel);
        Staff staffCarl = new Staff(6, "Carl", 55, 25, 40);
        Staff staffFrank = new Staff(7, "Frank", 60, 25, 40);
        Staff staffGrace = new Staff(8, "Grace", 65, 25, 40);

        managerBob.addStaff(staffEve);
        managerBob.addStaff(staffCarl);
        managerAlice.addStaff(staffFrank);
        managerAlice.addStaff(staffGrace);

        db.printEmployees();
        db.close();

        IReport staffReport = new StaffReporter<>(managerAlice);
        staffReport.generateReport();

        IReport budgetReport = new BudgetReporter<>(managerAlice);
        budgetReport.generateReport();
    }
}