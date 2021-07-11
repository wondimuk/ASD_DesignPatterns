import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class Manager extends Employee implements Consumer<Visitor> {

    private double bonus;
    private double teamBudget;

    Collection<Employee> employees = new ArrayList<>();

    public Manager(String employeeId, String firstName, String lastName, LocalDate birthDate, double bonus) {
        super(employeeId, firstName, lastName, birthDate);
        this.bonus = bonus;
        this.teamBudget = 10000;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getTeamBudget() {
        return teamBudget;
    }

    public void setTeamBudget(double teamBudget) {
        this.teamBudget = teamBudget;
    }

//    Manager class must implement a method called getEmployees() which should return the list of
//    employees that work for this manager (including the employees of employees, etc.)

//    public Employee getEmployees(){
//        Employee e = null;
//        for(Employee emp:employees){
//            e = emp;
//        }
//        return e;
//    }

//    Manager class must implement a method called getTotalSalary() which should return a Double
//    representing the total salary of all employees under this manager plus the manager himself/herself.
    public Double getTotalSalary(){
        Double totalSalary =0.0;
        for(Employee employee:employees){
            totalSalary += employee.getSalary();
        }
        return totalSalary + this.getSalary() + this.getBonus();
    }

//    4) Manager class must implement a method called getTotalAnnualSalary() which should return a Double
//    representing the total annual salary of all employees under this manager plus the manager
//    himself/herself (remember that managers annual salary is 12 * salary + bonus).
//    public Double  getTotalAnnualSalary(){
//        return 12 * getTotalSalary();
//    }

    public Double getAnnualBudget(){
        Double totalBudget =0.0;
        totalBudget+= 12*this.getSalary() + this.getBonus() + this.getTeamBudget();
        for(Employee e:employees){
            if(e instanceof Manager) {
                Manager m = (Manager) e;
                totalBudget += m.getAnnualBudget();
            }
            else{
                totalBudget += 12*e.getSalary();
            }
        }
        return totalBudget;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        employees.forEach(employee -> employee.accept(visitor));
    }

    @Override
    public String toString() {
        return "Manager{" +
                "bonus=" + bonus +
                ", teamBudget=" + teamBudget +
                ", employees=" + employees +
                '}';
    }
}
