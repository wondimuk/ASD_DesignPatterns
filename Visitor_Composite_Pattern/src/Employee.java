import java.time.LocalDate;
import java.util.function.Consumer;

public class Employee implements Consumer<Visitor> {

    private String employeeId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate startDate;
    private Double salary;
    private String position;
    private Manager manager;

    public Employee(String employeeId, String firstName, String lastName, LocalDate birthDate) {
        super();
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
//        Default Values
        this.startDate = LocalDate.now();
        this.salary = 4500.0;
        this.position = "Employee";
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    /*1) Employee class must implement a method called getManagers() which should return the list of
    managers in order (manager, manager of manager, etc.). The list should have at least one Manager in it
            (in case of the CEO of the company return an empty list!).
 */

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", startDate=" + startDate +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /*This accept will check employee managers, if manager of employee has a manager it will traverse upward
     * It returns empty list if ceo only who has no manager
     * */
    public void accept1(Visitor visitor) {
        if (manager != null) {
            manager.accept(visitor);
        }
    }
}