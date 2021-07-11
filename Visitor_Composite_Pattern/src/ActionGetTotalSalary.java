public class ActionGetTotalSalary implements Visitor {
    double totalSalary=0.0;

    @Override
    public void visit(Employee employee) {
        totalSalary += employee.getSalary();
    }

    @Override
    public void visit(Manager manager) {
        totalSalary += manager.getSalary() + manager.getBonus();
    }

    public double getTotalSalary() {
        return totalSalary;
    }
}
