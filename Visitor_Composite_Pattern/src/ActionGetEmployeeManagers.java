import java.util.ArrayList;
import java.util.Collection;

public class ActionGetEmployeeManagers implements Visitor {
    Collection<Manager> managers = new ArrayList<>();

    @Override
    public void visit(Employee employee) {
        if (employee.getManager() != null) {
            managers.add(employee.getManager());
        }
    }

    @Override
    public void visit(Manager manager) {
        visit((Employee) manager);
    }

    public Collection<Manager> getManagers() {
        return managers;
    }
}
