package Main;

import Model.Student;
import Model.Teacher;
import Model.University;
import Model.UniversityClass;
import Service.UniversityService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    private static final University universityRepository = new UniversityService();

    public static void main(String[] args){


        int option = 1;
        List<Student> studentsList = new ArrayList<>();
        List<Teacher> teachersList = new ArrayList<>();
        List<UniversityClass> universityClassesList = new ArrayList<>();
        teachersList = universityRepository.initializeTeachers(teachersList);
        studentsList = universityRepository.initializeStudents(studentsList);
        universityClassesList = universityRepository.initializeUniversityClasses(universityClassesList,teachersList,studentsList);


        while (option != 0) {
            System.out.println("----------------------------------------");
            System.out.println("Bienvenido ");
            System.out.println("Menu: ");
            System.out.println("1. Ver todos los profesores");
            System.out.println("2. Ver todas las clases");
            System.out.println("3. Crear un estudiante y matricularlo a una clase");
            System.out.println("4. Crear una nueva clase");
            System.out.println("5. Ver todas las clases de un estudiante");
            System.out.println("Ingresa 0 para salir");
            Scanner scan = new Scanner(System.in);
            option = scan.nextInt();
            System.out.println("----------------------------------------");

            if (option == 1){
                System.out.println("Profesores: ");
                universityRepository.printAllTeachers(teachersList);
            }
            if (option == 2){
                System.out.println("Clases: ");
                universityRepository.printAllUniversityClasses(universityClassesList);
            }
            if (option == 3){
                Student student = universityRepository.createStudent();
                studentsList.add(student);
                universityClassesList = universityRepository.addStudentToClass(universityClassesList,student);
            }
            if (option == 4){
                universityClassesList = universityRepository.createUniversityClass(universityClassesList,studentsList,teachersList);
            }
            if (option == 5){
                universityRepository.listClassesPerStudent(universityClassesList);
            }
        }
    }
}
