import java.util.ArrayList;
import java.util.Collection;

public class ActionGetManagerEmployee implements Visitor {
    Collection<Employee> employees = new ArrayList<>();

    @Override
    public void visit(Employee employee) {
            employees.add(employee);
    }

    @Override
    public void visit(Manager manager) {
//        employees.add(manager);
    }

    public Collection<Employee> getManagerEmployees() {
        return employees;
    }
}
