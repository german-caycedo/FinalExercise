package Model;

import java.util.List;
import java.util.UUID;

public class UniversityClass {

    private UUID id;
    private String name;
    private String classroom;
    private List<Student> studentList;
    private Teacher teacher;

    public UniversityClass(String name, String classroom, List<Student> studentList, Teacher teacher) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.classroom = classroom;
        this.studentList = studentList;
        this.teacher = teacher;
    }

    public String getName() {
        return this.name;
    }

    public void addStudent(Student student){
        this.studentList.add(student);
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public String getClassroom() {
        return classroom;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
