public class ActionAnnualBudget implements Visitor{
    private double annualbudget = 0.0;

    @Override
    public void visit(Employee employee) {
        annualbudget += employee.getSalary()*12;
    }

    @Override
    public void visit(Manager manager) {
        annualbudget += manager.getSalary()*12 + manager.getBonus() + manager.getTeamBudget();
    }

    public Double getTotalAnnualBudget(){
        return annualbudget;
    }
}
