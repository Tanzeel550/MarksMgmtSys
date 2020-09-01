package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Model.Model;

import java.sql.SQLException;

public class Students {
    ObservableList<Student> students = FXCollections.observableArrayList();

    private final static Students instance = new Students();

    private final Model model;

    private Students() {
        model = new Model();
    }

    public static Students getInstance() {
        return instance;
    }

    public ObservableList<Student> getStudents() {
        return students;
    }

    public void update(Student oldStudent, Student newStudent) {
        newStudent.setRollNo(oldStudent.getRollNo());
        int index = students.indexOf(oldStudent);
        students.remove(index);
        students.add(index, newStudent);
    }

    public boolean add(Student student) {
        for (Student s : students) {
            if (s.getName().equals(student.getName()))
                return false;
        }
        student.setRollNo(students.size());
        students.add(student);
        return true;
    }

    public boolean delete(Student student) {
        return students.remove(student);
    }

    public void loadData() throws SQLException {
        model.loadData();
    }

    public void saveData() throws SQLException{
        model.saveData();
        model.close();
    }

}
