package Model;

public class FullTimeTeacher extends Teacher {

    private int experienceYears;
    private float salary;


    public FullTimeTeacher(String fullName, long baseSalary, int experienceYears) {
        super(fullName, baseSalary);
        this.experienceYears = experienceYears;
        this.salary = super.baseSalary * this.experienceYears;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public float getSalary() {
        return salary;
    }
}
