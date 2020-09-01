package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML
    private TableColumn<String, Student> nameCol;

    @FXML
    private TableColumn<Integer, Student> rollNoCol, englishCol, urduCol, physicsCol, chemistryCol, biologyCol,
            totalCol, islamiatCol;

    @FXML
    private TextField nameTextField, englishTextField, urduTextField, physicsTextField, chemistryTextField,
            biologyTextField, islamiatTextField, totalTextField;

    @FXML
    private TableView<Student> tableView;

    public void initialize() {

//        Make table columns
        rollNoCol.setCellValueFactory(new PropertyValueFactory<>("rollNo"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        englishCol.setCellValueFactory(new PropertyValueFactory<>("englishMarks"));
        urduCol.setCellValueFactory(new PropertyValueFactory<>("urduMarks"));
        physicsCol.setCellValueFactory(new PropertyValueFactory<>("physicsMarks"));
        chemistryCol.setCellValueFactory(new PropertyValueFactory<>("chemistryMarks"));
        biologyCol.setCellValueFactory(new PropertyValueFactory<>("biologyMarks"));
        islamiatCol.setCellValueFactory(new PropertyValueFactory<>("islamiatMarks"));
        totalCol.setCellValueFactory(new PropertyValueFactory<>("totalMarks"));

        tableView.setItems(Students.getInstance().getStudents());

        tableView.getSelectionModel().selectedItemProperty().addListener(((observableList, newStudent, oldStudent) -> {
            nameTextField.setText(oldStudent.getName());
            englishTextField.setText(String.valueOf(oldStudent.getEnglishMarks()));
            urduTextField.setText(String.valueOf(oldStudent.getUrduMarks()));
            physicsTextField.setText(String.valueOf(oldStudent.getPhysicsMarks()));
            chemistryTextField.setText(String.valueOf(oldStudent.getChemistryMarks()));
            biologyTextField.setText(String.valueOf(oldStudent.getBiologyMarks()));
            islamiatTextField.setText(String.valueOf(oldStudent.getIslamiatMarks()));
            totalTextField.setText(String.valueOf(oldStudent.getTotalMarks()));
        }));

        tableView.getSelectionModel().selectFirst();
    }

    public void clearData() {
        nameTextField.setText(" ");
        englishTextField.setText(" ");
        urduTextField.setText(" ");
        physicsTextField.setText(" ");
        chemistryTextField.setText(" ");
        biologyTextField.setText(" ");
        islamiatTextField.setText(" ");
        totalTextField.setText(" ");
    }

    public void deleteData() {
        Student student = tableView.getSelectionModel().getSelectedItem();

        if (!Students.getInstance().delete(student)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "We have got some Error here. Please Retry!", ButtonType.CLOSE);
            alert.setTitle("Error");
            alert.showAndWait();
        }
        tableView.getSelectionModel().selectLast();
    }

    public void updateData() {
//        Getting the currently selected Cell Data -> Student Data
        Student oldStudent = tableView.getSelectionModel().getSelectedItem();
//        Getting the
        Student newStudent = getStudentForCreateAndUpdate();
//        We are checking that if the user has typed String inplace of Integer, then we are checking that if the method returned Null
//        Because when the the user has got some typo mistake, then the method getStudentForCreateAndUpdate() will return us an error.
        if (newStudent != null) {
            Students.getInstance().update(oldStudent, newStudent);
            clearData();
        }
        tableView.getSelectionModel().select(newStudent);
    }

    public void addData() {
//      Retrieving the data from the UI
        Student student = getStudentForCreateAndUpdate();

//        If the user has not typed String in place of integer, otherwise an alert will show up to the user, and we will get a null Student
//        In order to tackle this, we have added the following line to the code.
        if (student != null) {
//            If the name of the student which you are going to add, already exist in the record, Then it will be a problem for you!.
            if (!Students.getInstance().add(student)) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "The name " + student.getName() + " already exists in the Table", ButtonType.CLOSE);
                alert.setTitle("Error");
                alert.showAndWait();
            } else {
                clearData();
            }
        }

    }

    private Student getStudentForCreateAndUpdate() {

        try {
            String name = nameTextField.getText();
            int englishMarks = Integer.parseInt(englishTextField.getText());
            int urduMarks = Integer.parseInt(urduTextField.getText());
            int physicsMarks = Integer.parseInt(physicsTextField.getText());
            int chemistryMarks = Integer.parseInt(chemistryTextField.getText());
            int biologyMarks = Integer.parseInt(biologyTextField.getText());
            int islamiatMarks = Integer.parseInt(islamiatTextField.getText());

            return new Student(name, englishMarks, urduMarks, physicsMarks, chemistryMarks, biologyMarks, islamiatMarks);

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "One of your fields are containig Text Data Instead of Numeric Data", ButtonType.CLOSE);
            alert.setHeaderText("Error");
            alert.showAndWait();
            return null;
        }
    }

}
