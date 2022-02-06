package Service;

import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniversityService implements University {

    @Override
    public void printAllUniversityClasses(List<UniversityClass> universityClasses) {
        int i = 1;
        for (UniversityClass universityClass : universityClasses){
            System.out.println(i + " " + universityClass.getName());
            i++;
        }
        int option = 1;
        while (option != 0){
            System.out.println("----------------------------------------");
            System.out.println("Digite el numero de la clase si desea ver mas informacion o 0 para salir:  ");
            Scanner scan = new Scanner(System.in);
            option = scan.nextInt();
            if (option != 0){
                i = 1;
                for (UniversityClass universityClass : universityClasses){
                    if (option == i){
                        System.out.println("Nombre de la clase: "+universityClass.getName());
                        System.out.println("Salon: "+universityClass.getClassroom());
                        System.out.println("Profesor: "+universityClass.getTeacher().getFullName());
                        System.out.println("Lista de estudiantes: ");
                        System.out.println("----------------------------------------");
                        for (Student student : universityClass.getStudentList()){
                            System.out.println(student.getFullName());
                        }
                    }
                    i++;
                }
            }
        }
    }

    @Override
    public Student createStudent() {
        System.out.println("----------------------------------------");
        System.out.println("Escriba el nombre del estudiante: ");
        Scanner scan = new Scanner(System.in);
        String fullName = scan.next();
        System.out.println("Escriba el apellido del estudiante: ");
        scan = new Scanner(System.in);
        fullName = fullName + " " + scan.next();
        System.out.println("----------------------------------------");
        System.out.println("Escriba la edad del estudiante: ");
        scan = new Scanner(System.in);
        int age = scan.nextInt();
        return new Student(fullName,age);
    }


    @Override
    public List<UniversityClass> addStudentToClass(List<UniversityClass> universityClasses, Student student) {
        System.out.println("Clases disponibles: ");
        System.out.println("----------------------------------------");
        int i = 0;
        for (UniversityClass universityClass : universityClasses){
            System.out.println(i + " " + universityClass.getName());
            i++;
        }
        System.out.println("Seleccione el numero de la clase a la que desea agregar el estudiante: ");
        System.out.println("----------------------------------------");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        i = 0;
        for (UniversityClass universityClass : universityClasses){
            if (i==option){
                universityClass.addStudent(student);
                for (Student student1 : universityClass.getStudentList()){
                    System.out.println(student1.getFullName());
                }
            }
            i++;
        }
        return universityClasses;
    }

    @Override
    public void listClassesPerStudent(List<UniversityClass> universityClasses) {
        List<UniversityClass> studentClasses = new ArrayList<>();
        System.out.println("Escriba el id del estudiante: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();
        Student studentSelected = new Student("No encontrado",20);
        for (UniversityClass universityClass : universityClasses){
            for (Student student : universityClass.getStudentList()){
                if (student.getUniversityId() == id){
                    studentClasses.add(universityClass);
                    studentSelected = student;
                }
            }
        }
        System.out.println("----------------------------------------");
        System.out.println("Estudiante: "+ studentSelected.getFullName());
        System.out.println("----------------------------------------");
        for (UniversityClass classes : studentClasses){
            System.out.println(classes.getName());
        }
    }

    @Override
    public void printAllTeachers(List<Teacher> teacherList) {
        for (Teacher teacher : teacherList){
            System.out.println(teacher.getFullName());
            System.out.print("Salario: $");
            System.out.printf("%.1f \n",teacher.getSalary());
        }

    }

    @Override
    public List<UniversityClass> createUniversityClass(List<UniversityClass> universityClasses, List<Student> studentList, List<Teacher> teacherList) {
        System.out.println("----------------------------------------");
        System.out.println("digite el nombre de la clase:  ");
        Scanner scan = new Scanner(System.in);
        String className = scan.next();
        System.out.println("----------------------------------------");
        System.out.println("digite el salon asignado de la clase:  ");
        scan = new Scanner(System.in);
        String classClassroom = scan.next();
        System.out.println("----------------------------------------");
        System.out.println("Seleccione los estudiantes a matricular en la clase: ");
        System.out.println("----------------------------------------");
        System.out.println("Estudiantes disponibles: ");
        System.out.println("----------------------------------------");
        int i = 1;
        for (Student student : studentList){
            System.out.println(i + " " + student.getFullName());
            i++;
        }
        int option = 1;
        List<Student> classStudents = new ArrayList<>();
        while (option != 0){
            System.out.println("Seleccione el numero del estudiante a matricular en la clase o 0 para continuar: ");
            System.out.println("----------------------------------------");
            scan = new Scanner(System.in);
            option = scan.nextInt();
            i = 1;
            for (Student student : studentList){
                if (i==option){
                    classStudents.add(student);
                }
                i++;
            }
        }
        System.out.println("Profesores disponibles: ");
        System.out.println("----------------------------------------");
        i = 0;
        for (Teacher teacher : teacherList){
            System.out.println(i + " " + teacher.getFullName());
            i++;
        }
        Teacher classTeacher = null;
        while (classTeacher == null){
            System.out.println("Seleccione el numero del profesor para continuar: ");
            System.out.println("----------------------------------------");
            scan = new Scanner(System.in);
            option = scan.nextInt();
            i = 0;
            for (Teacher teacher : teacherList){
                if (i==option){
                    classTeacher = teacher;
                }
                i++;
            }
        }
        UniversityClass newClass = new UniversityClass(className, classClassroom, classStudents,classTeacher);
        universityClasses.add(newClass);

        return universityClasses;
    }

    @Override
    public List<Teacher> initializeTeachers(List<Teacher> teachersList) {
        FullTimeTeacher fullTimeTeacher = new FullTimeTeacher("Roberto Carlos", 720000,4);
        teachersList.add(fullTimeTeacher);
        fullTimeTeacher = new FullTimeTeacher("Fernando alonso", 1720000,8);
        teachersList.add(fullTimeTeacher);
        PartTimeTeacher partTimeTeacher = new PartTimeTeacher("Juan Jimeno", 60000,88);
        teachersList.add(partTimeTeacher);
        partTimeTeacher = new PartTimeTeacher("Emma Radu", 600000,110);
        teachersList.add(partTimeTeacher);

        return teachersList;
    }

    @Override
    public List<Student> initializeStudents(List<Student> studentsList) {
        Student student = new Student("Elva correa",19);
        studentsList.add(student);
        student = new Student("Camilo Lopez",17);
        studentsList.add(student);
        student = new Student("David Jimenez",21);
        studentsList.add(student);
        student = new Student("Alejandro Leal",22);
        studentsList.add(student);
        student = new Student("Salma Hayek",15);
        studentsList.add(student);
        student = new Student("Luisa Almagro",26);
        studentsList.add(student);

        return studentsList;
    }

    @Override
    public List<UniversityClass> initializeUniversityClasses(List<UniversityClass> universityClassesList, List<Teacher> teachersList, List<Student> studentsList) {
        UniversityClass universityClass = new UniversityClass("Calculo", "alm-1.2",new ArrayList<>(studentsList.subList(0,3)), teachersList.get(0));
        universityClassesList.add(universityClass);
        universityClass = new UniversityClass("Etica", "plm-3.1",new ArrayList<>(studentsList.subList(1,3)),teachersList.get(1));
        universityClassesList.add(universityClass);
        universityClass = new UniversityClass("Genetica", "plm-2.2",new ArrayList<>(studentsList.subList(4,5)),teachersList.get(2));
        universityClassesList.add(universityClass);
        universityClass = new UniversityClass("Asuntos Internos", "scx-A1",new ArrayList<>(studentsList.subList(0,5)),teachersList.get(3));
        universityClassesList.add(universityClass);

        return universityClassesList;
    }

}
