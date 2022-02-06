package Model;

public class PartTimeTeacher extends Teacher{

    private int activeHoursPerWeek;
    private float salary;


    public PartTimeTeacher(String fullName, long baseSalary, int activeHoursPerWeek) {
        super(fullName, baseSalary);
        this.activeHoursPerWeek = activeHoursPerWeek;
        this.salary = super.baseSalary * this.activeHoursPerWeek;
    }


    public int getActiveHoursPerWeek() {
        return activeHoursPerWeek;
    }

    @Override
    public float getSalary() {
        return salary;
    }
}
