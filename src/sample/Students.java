package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import sample.Model.Model;

import java.sql.SQLException;

public class Students {
    private final static Students instance = new Students();
    private final Model model;
    ObservableList<Student> students = FXCollections.observableArrayList();

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
        TotalMarks.getInstance().updateTotalMarks(oldStudent, newStudent);
    }

    public boolean add(Student student) {
        for (Student s : students) {
            if (s.getName().equals(student.getName()))
                return false;
        }
        student.setRollNo(students.size());
        students.add(student);
        TotalMarks.getInstance().addTotalMarks(student);
        return true;
    }

    public boolean delete(Student student) {
        TotalMarks.getInstance().deleteTotalMarks(student);
        return students.remove(student);
    }

    public void loadData() {
        try {
            model.loadData();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Error");
            alert.setHeaderText("You have done something wrong with the File System.");
            alert.setContentText("Try To Install The Software Again!");
            alert.getButtonTypes().add(ButtonType.CLOSE);
            alert.showAndWait();
            Platform.exit();
        }
    }

    public void saveData() {
        try {
            model.saveData();
            model.close();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("There was an error saving the Data.");
            alert.setContentText("Try To Install The Software Again!");
            alert.getButtonTypes().add(ButtonType.CLOSE);
            alert.showAndWait();
            Platform.exit();
        }
    }
}