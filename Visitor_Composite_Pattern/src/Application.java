import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        Manager CEO = new Manager("001", "HACHALU", "HUNDESSA", LocalDate.of(1988, 01, 01), 5000);
        Manager manager = new Manager("125", "Joe", "Boy", LocalDate.of(1988, 06, 01), 1000);
        Employee employe1 = new Employee("123", "Mickael", "Gabreal", LocalDate.of(1988, 06, 01));
        Employee employe2 = new Employee("124", "Stiv", "Man", LocalDate.of(1988, 06, 01));

//      manager employees
        manager.addEmployee(employe1);
        manager.addEmployee(employe2);
        CEO.addEmployee(manager);

//      employee manager
        employe1.setManager(manager);
        manager.setManager(CEO);

        CEO.setPosition("CEO");
        manager.setPosition("Manager");

        /*Employee class must implement a method called getManagers() which should return the list of
        managers in order (manager, manager of manager, etc.). The list should have at least one Manager in it
        (in case of the CEO of the company return an empty list!).
        */
        ActionGetEmployeeManagers getManagers = new ActionGetEmployeeManagers();
        employe1.accept1(getManagers);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Employee name " + employe1.getFirstName() + " " + employe1.getLastName() + " is/are ");
        System.out.println("His manager/s:");
        getManagers.getManagers().forEach(manager1 -> System.out.println(manager1.getFirstName() + " " + manager1.getLastName()));
        System.out.println("-----------------------------------------------------------");

        /*
        Manager class must implement a method called getEmployees()which should return the list of
        employees that work for this manager(including the employees of employees, etc.)
        */

        ActionGetManagerEmployee managerTeam = new ActionGetManagerEmployee();
        manager.accept(managerTeam);
        System.out.println("Manager Name " + manager.getFirstName() + " " + manager.getLastName() + "\n List of his team: ");
        managerTeam.getManagerEmployees().forEach(c -> System.out.println(c.getFirstName() + c.getLastName()));
        System.out.println("-----------------------------------------------------------");

       /*
       3) Manager class must implement a method called getTotalSalary() which should return a Double
        representing the total salary of all employees under this manager plus the manager himself/herself.
        */
        ActionGetTotalSalary actionGetTotalSalary = new ActionGetTotalSalary();
        CEO.accept(actionGetTotalSalary);
        System.out.println(CEO.getFirstName() +" team total Employee Salary " + actionGetTotalSalary.getTotalSalary());

        /*
        Manager class must implement a method called getTotalAnnualSalary() which should return a Double
        representing the total annual salary of all employees under this manager plus the manager
        himself/herself (remember that managers annual salary is 12 * salary + bonus).
        */
        ActiongetTotalAnnualSalary actiongetTotalAnnualSalary = new ActiongetTotalAnnualSalary();
        CEO.accept(actiongetTotalAnnualSalary);
        System.out.println(CEO.getFirstName()+ " Total Employee Annual Salary " + actiongetTotalAnnualSalary.getTotalAnnualSalary());

        /*
        Manager class must implement a method called getTotalAnnualBudget() which should return a
        Double representing the total annual salary of all employees under this manager plus the manager
        himself/herself plus teamBudget.
        */
        ActionAnnualBudget actionAnnualBudget = new ActionAnnualBudget();
        CEO.accept(actionAnnualBudget);
        System.out.println(CEO.getFirstName()+ " Total Annual Budget " + actionAnnualBudget.getTotalAnnualBudget());
    }
}
