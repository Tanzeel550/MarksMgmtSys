package sample.Model;

import sample.Student;
import sample.Students;

import java.sql.*;

public class Model {

    public static final String NAME_COLUMN_NAME = "Name";
    public static final String ENGLISH_COLUMN_NAME = "English";
    public static final String URDU_COLUMN_NAME = "Urdu";
    public static final String PHYSICS_COLUMN_NAME = "Physics";
    public static final String CHEMISTRY_COLUMN_NAME = "Chemistry";
    public static final String BIOLOGY_COLUMN_NAME = "Biology";
    public static final String ISLAMIAT_COLUMN_NAME = "Islamiat";

    public static final int NAME_COLUMN_INDEX = 1;
    public static final int ENGLISH_COLUMN_INDEX = 2;
    public static final int URDU_COLUMN_INDEX = 3;
    public static final int PHYSICS_COLUMN_INDEX = 4;
    public static final int CHEMISTRY_COLUMN_INDEX = 5;
    public static final int BIOLOGY_COLUMN_INDEX = 6;
    public static final int ISLAMIAT_COLUMN_INDEX = 7;


    private static final String DATABASE_NAME = "jdbc:sqlite:\\NPS_Students.db";

    public static final String STUDENTS_MARKS_TABLE_NAME = "studentsMarksTable";

    private Connection connection;

    private final String CREATE_STUDENTS_TABLE_STRING = "CREATE TABLE IF NOT EXISTS " + STUDENTS_MARKS_TABLE_NAME +
            " ( " + NAME_COLUMN_NAME + " TEXT, " + ENGLISH_COLUMN_NAME + " INTEGER, " + URDU_COLUMN_NAME + " INTEGER, "
            + PHYSICS_COLUMN_NAME + " INTEGER, " + CHEMISTRY_COLUMN_NAME + " INTEGER, " + BIOLOGY_COLUMN_NAME +
            " INTEGER, " + ISLAMIAT_COLUMN_NAME + " INTEGER )";

    private Statement CREATE_STUDENTS_TABLE_QUERY;

    //    The SQL INSERT QUERY for inserting the data
    private final String INSERT_STUDENT_MARKS_STRING = "INSERT INTO " + STUDENTS_MARKS_TABLE_NAME + " VALUES( " +
            "?, ?, ?, ?, ?, ?, ?)";
    //    A prepared Statement which is used for inserting the data.
    private PreparedStatement INSERT_STUDENTS_TABLE_QUERY;


    //    The SQL READ QUERY for reading the data
    private final String SELECT_STUDENTS_TABLE_STRING = "SELECT * FROM " + STUDENTS_MARKS_TABLE_NAME;
    private PreparedStatement SELECT_STUDENTS_TABLE_QUERY;


    public Model() {
        open();
    }

    public void open() {
        try {
            connection = DriverManager.getConnection(DATABASE_NAME);

            CREATE_STUDENTS_TABLE_QUERY = connection.createStatement();
            CREATE_STUDENTS_TABLE_QUERY.execute(CREATE_STUDENTS_TABLE_STRING);

            INSERT_STUDENTS_TABLE_QUERY = connection.prepareStatement(INSERT_STUDENT_MARKS_STRING);
            SELECT_STUDENTS_TABLE_QUERY = connection.prepareStatement(SELECT_STUDENTS_TABLE_STRING);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadData() throws SQLException {
        ResultSet resultSet = SELECT_STUDENTS_TABLE_QUERY.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString(NAME_COLUMN_INDEX);
            int englishMarks = resultSet.getInt(ENGLISH_COLUMN_INDEX);
            int urduMarks = resultSet.getInt(URDU_COLUMN_INDEX);
            int physicsMarks = resultSet.getInt(PHYSICS_COLUMN_INDEX);
            int chemistryMarks = resultSet.getInt(CHEMISTRY_COLUMN_INDEX);
            int biologyMarks = resultSet.getInt(BIOLOGY_COLUMN_INDEX);
            int islamiatMarks = resultSet.getInt(ISLAMIAT_COLUMN_INDEX);

            Student student = new Student(name, englishMarks, urduMarks, physicsMarks, chemistryMarks, biologyMarks, islamiatMarks);

            Students.getInstance().add(student);
        }
    }

    public void saveData() throws SQLException {

        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM " + STUDENTS_MARKS_TABLE_NAME);

        for (Student student: Students.getInstance().getStudents()) {
            INSERT_STUDENTS_TABLE_QUERY.setString(1, student.getName());
            INSERT_STUDENTS_TABLE_QUERY.setInt(2, student.getEnglishMarks());
            INSERT_STUDENTS_TABLE_QUERY.setInt(3, student.getUrduMarks());
            INSERT_STUDENTS_TABLE_QUERY.setInt(4, student.getPhysicsMarks());
            INSERT_STUDENTS_TABLE_QUERY.setInt(5, student.getChemistryMarks());
            INSERT_STUDENTS_TABLE_QUERY.setInt(6, student.getBiologyMarks());
            INSERT_STUDENTS_TABLE_QUERY.setInt(7, student.getIslamiatMarks());

            INSERT_STUDENTS_TABLE_QUERY.execute();
        }
    }


    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error Closing the Connection");
        }
    }
}
