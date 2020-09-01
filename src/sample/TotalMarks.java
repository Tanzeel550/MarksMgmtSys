package sample;

public class TotalMarks {

    private static final TotalMarks instance = new TotalMarks();

    private int totalEnglishMarks;
    private int totalUrduMarks;
    private int totalPhysicsMarks;
    private int totalChemistryMarks;
    private int totalBiologyMarks;
    private int totalIslamiatMarks;
    private int totalTotalMarks;

    private TotalMarks() {
        totalEnglishMarks = 0;
        totalUrduMarks = 0;
        totalPhysicsMarks = 0;
        totalChemistryMarks = 0;
        totalBiologyMarks = 0;
        totalIslamiatMarks = 0;
        totalTotalMarks = 0;
    }

    public static TotalMarks getInstance() {
        return instance;
    }

    private void addIntoMarks(Student student) {
        totalEnglishMarks += student.getEnglishMarks();
        totalUrduMarks += student.getUrduMarks();
        totalPhysicsMarks += student.getPhysicsMarks();
        totalChemistryMarks += student.getChemistryMarks();
        totalBiologyMarks += student.getBiologyMarks();
        totalIslamiatMarks += student.getIslamiatMarks();
        totalTotalMarks += student.getTotalMarks();
    }

    private void subtractIntoMarks(Student student) {
        totalEnglishMarks -= student.getEnglishMarks();
        totalUrduMarks -= student.getUrduMarks();
        totalPhysicsMarks -= student.getPhysicsMarks();
        totalChemistryMarks -= student.getChemistryMarks();
        totalBiologyMarks -= student.getBiologyMarks();
        totalIslamiatMarks -= student.getIslamiatMarks();
        totalTotalMarks -= student.getTotalMarks();
    }

    public void updateTotalMarks(Student oldStudent, Student newStudent) {
        subtractIntoMarks(oldStudent);
        addIntoMarks(newStudent);
    }

    public void addTotalMarks(Student student) {
        addIntoMarks(student);
    }

    public void deleteTotalMarks(Student student) {
        subtractIntoMarks(student);
    }

    public int getTotalEnglishMarks() {
        return totalEnglishMarks;
    }

    public int getTotalUrduMarks() {
        return totalUrduMarks;
    }

    public int getTotalPhysicsMarks() {
        return totalPhysicsMarks;
    }

    public int getTotalChemistryMarks() {
        return totalChemistryMarks;
    }

    public int getTotalBiologyMarks() {
        return totalBiologyMarks;
    }

    public int getTotalIslamiatMarks() {
        return totalIslamiatMarks;
    }

    public int getTotalTotalMarks() {
        return totalTotalMarks;
    }
}
