public class ActiongetTotalAnnualSalary implements Visitor{
    private double totalAnnualSalary = 0.0;

    @Override
    public void visit(Employee employee) {
        totalAnnualSalary += employee.getSalary() * 12;
    }

    @Override
    public void visit(Manager manager) {
        totalAnnualSalary += (manager.getSalary() * 12) + manager.getBonus();
    }

    public Double getTotalAnnualSalary(){
        return totalAnnualSalary;
    }
}
