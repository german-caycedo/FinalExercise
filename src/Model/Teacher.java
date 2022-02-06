package Model;

import java.util.UUID;

public abstract class Teacher {

    private UUID id;
    private String fullName;
    protected long baseSalary;

    public Teacher(String fullName, long baseSalary){
        this.id = UUID.randomUUID();
        this.fullName = fullName;
        this.baseSalary = baseSalary;
    }

    public String getFullName() {
        return fullName;
    }

    public abstract float getSalary();
}
