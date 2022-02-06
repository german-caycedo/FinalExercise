package Model;

import java.util.UUID;

public class Student {

    private UUID id;
    private String fullName;
    private int universityId;
    private int age;
    public static int counter = 0;

    public Student(String fullName, int age) {
        this.id = UUID.randomUUID();
        this.fullName = fullName;
        this.age = age;
        this.universityId = counter;
        this.counter++;
    }

    public int getUniversityId() {
        return universityId;
    }

    public String getFullName() {
        return fullName;
    }
}
