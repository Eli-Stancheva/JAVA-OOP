package OOP.LAB_1_WorkingWithAbstraction.P3_StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repository;

    public StudentSystem() {
        this.repository = new HashMap<>();
    }

    public Map<String, Student> getRepository() {
        return this.repository;
    }

    public void executeCommand(String[] commandsList) {
        String command = commandsList[0];
        if (command.equals("Create")) {
            createStudent(commandsList);
        } else if (command.equals("Show")) {
            showStudent(commandsList[1]);
        }
    }

    private void showStudent(String name) {
        if (repository.containsKey(name)) {
            Student student = repository.get(name);
            StringBuilder builder = new StringBuilder();
            builder.append(student.toString());

            if (student.getGrade() >= 5.00) {
                builder.append(" Excellent student.");
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                builder.append(" Average student.");
            } else {
                builder.append(" Very nice person.");
            }
            System.out.println(builder);
        }
    }

    private void createStudent(String[] commandsList) {
        String name = commandsList[1];
        int age = Integer.parseInt(commandsList[2]);
        double grade = Double.parseDouble(commandsList[3]);
        Student student = new Student(name, age, grade);
        repository.putIfAbsent(name, student);
    }
}
