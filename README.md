# ASD_DesignPatterns
This repository has solution to design pattern problems solved during Advanced Software Development course. It is academic resources.

In this project, I have used two design patterns to solve some practical problem of HRM. We have Manager and Employee. Manager has team.
Therefore, Manager could have employee or manager. Consider the hierarchies of manager of employee. It could have like tree structure.
Then, We can have composite pattern from Manager employee relation. Visitor pattern is applied to visit employee managers, employee of manager, and so on.

Here are the use cases that my design needs to cover:
1) Employee class must implement a method called getManagers() which should return the list of
managers in order (manager, manager of manager, etc.). The list should have at least one Manager in it
(in case of the CEO of the company return an empty list!).
2) Manager class must implement a method called getEmployees() which should return the list of
employees that work for this manager (including the employees of employees, etc.)
3) Manager class must implement a method called getTotalSalary() which should return a Double
representing the total salary of all employees under this manager plus the manager himself/herself.
4) Manager class must implement a method called getTotalAnnualSalary() which should return a Double
representing the total annual salary of all employees under this manager plus the manager
himself/herself (remember that managers annual salary is 12 * salary + bonus).
5) Manager class must implement a method called getTotalAnnualBudget() which should return a
Double representing the total annual salary of all employees under this manager plus the manager
himself/herself plus teamBudget. 

