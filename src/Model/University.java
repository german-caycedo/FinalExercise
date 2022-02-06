package Model;

import java.util.List;

public interface University {

    public void printAllUniversityClasses(List<UniversityClass> universityClasses);

    public Student createStudent();

    public List<UniversityClass> addStudentToClass(List<UniversityClass> universityClasses, Student student);

    public void listClassesPerStudent(List<UniversityClass> universityClasses);

    public void printAllTeachers(List<Teacher> teacherList);

    public List<UniversityClass> createUniversityClass(List<UniversityClass> universityClasses, List<Student> studentList, List<Teacher> teacherList);

    public List<Teacher> initializeTeachers(List<Teacher> teachersList);

    public List<Student> initializeStudents(List<Student> studentsList);

    public List<UniversityClass> initializeUniversityClasses(List<UniversityClass> universityClassesList, List<Teacher> teachersList, List<Student> studentsList);

}
