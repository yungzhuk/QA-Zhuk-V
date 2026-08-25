package lesson_6;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new ArrayList<>(grades);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public void addGrade(int grade) {
        if (grade >= 1 && grade <= 5) {
            grades.add(grade);
        } else {
            System.out.println("Оценка должна быть от 1 до 5");
        }
    }

    public void removeGrade(int index) {
        if (index >= 0 && index < grades.size()) {
            grades.remove(index);
        }
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public void printInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Группа: " + group);
        System.out.println("Курс: " + course);
        System.out.println("Оценки: " + grades);
        System.out.printf("Средний балл: %.2f\n", getAverageGrade());
        System.out.println("------------------------");
    }

    // для вывода короткого тексте
    public void printShortInfo() {
        System.out.printf("%s (группа %s, курс %d, ср.балл: %.2f)%n",
                name, group, course, getAverageGrade());
    }

    @Override
    public String toString() {
        return String.format("Student{name='%s', group='%s', course=%d, grades=%s, avg=%.2f}",
                name, group, course, grades, getAverageGrade());
    }
}
