package lesson_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    // метод переводит студентов на следующий курс
    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if(student.getAverageGrade() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    // метод, который получает список студентов и номер курса
    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты на " + course + " курсе:");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(" - " + student.getName());
            }
        }
    }

    public static void main(String[] args) {
        // задание 1
        Student anna = new Student(
                "Анна",
                "2",
                3,
                new ArrayList<>(Arrays.asList(5, 4, 5, 3, 4))
        );

        Student ivan = new Student(
                "Иван",
                "1",
                4,
                new ArrayList<>(Arrays.asList(2, 3, 2, 1, 2))
        );

        Student maksim = new Student(
                "Максим",
                "3",
                1,
                new ArrayList<>(Arrays.asList(4, 5, 3, 5, 5))
        );

        Student olga = new Student(
                "Ольга",
                "2",
                2,
                new ArrayList<>(Arrays.asList(5, 5, 5, 4, 5))  // отличница
        );

        Student petr = new Student(
                "Петр",
                "1",
                3,
                new ArrayList<>(Arrays.asList(2, 2, 3, 2, 1))  // неуспевающий
        );

        Set<Student> students = new HashSet<>();
        students.add(anna);
        students.add(ivan);
        students.add(maksim);
        students.add(olga);
        students.add(petr);


        System.out.println("До удаления:");
        for (Student s : students) {
            s.printShortInfo();
        }

        students.removeIf(student -> student.getAverageGrade() < 3);

        System.out.println("После удаления:");
        for (Student s : students) {
            s.printShortInfo();
        }

        // переводим студентов на +1 курс
        promoteStudents(students);
        System.out.println("Студенты переведены на следующий курс:");
        for (Student s : students) {
            s.printShortInfo();
        }

        // имена тех студентов, которые обучаются на данном курсе
        printStudents(students, 2);
        printStudents(students, 4);

        // задание 2
        PhoneBook book = new PhoneBook();

        book.add("Иванов", "375292399920");
        book.add("Иванов", "375291111111");
        book.add("Смирнова", "375252344420");
        book.add("Петров", "375202542211");

        System.out.println("Телефоны Иванова: " + book.get("Иванов"));
        System.out.println("Телефоны Смирновой: " + book.get("Смирнова"));
        System.out.println("Телефоны Петрова: " + book.get("Петров"));
    }
}
