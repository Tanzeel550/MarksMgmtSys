package sample;

public class Student {
    private static int rollCount = 1;

    private int rollNo;
    private String name;

    private int englishMarks;
    private int urduMarks;
    private int physicsMarks;
    private int chemistryMarks;
    private int biologyMarks;
    private int totalMarks;
    private int islamiatMarks;


    public Student(String name, int englishMarks, int urduMarks, int physicsMarks, int chemistryMarks, int biologyMarks, int islamiatMarks) {
        this.name = name;
        this.englishMarks = englishMarks;
        this.urduMarks = urduMarks;
        this.physicsMarks = physicsMarks;
        this.chemistryMarks = chemistryMarks;
        this.biologyMarks = biologyMarks;
        this.islamiatMarks = islamiatMarks;

        this.rollNo = rollCount++;

        totalMarks = englishMarks + urduMarks + physicsMarks + chemistryMarks + biologyMarks;

    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", englishMarks=" + englishMarks +
                ", urduMarks=" + urduMarks +
                ", physicsMarks=" + physicsMarks +
                ", chemistryMarks=" + chemistryMarks +
                ", biologyMarks=" + biologyMarks +
                ", totalMarks=" + totalMarks +
                ", islamiatMarks=" + islamiatMarks +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnglishMarks() {
        return englishMarks;
    }

    public void setEnglishMarks(int englishMarks) {
        this.englishMarks = englishMarks;
    }

    public int getUrduMarks() {
        return urduMarks;
    }

    public void setUrduMarks(int urduMarks) {
        this.urduMarks = urduMarks;
    }

    public int getPhysicsMarks() {
        return physicsMarks;
    }

    public void setPhysicsMarks(int physicsMarks) {
        this.physicsMarks = physicsMarks;
    }

    public int getChemistryMarks() {
        return chemistryMarks;
    }

    public void setChemistryMarks(int chemistryMarks) {
        this.chemistryMarks = chemistryMarks;
    }

    public int getBiologyMarks() {
        return biologyMarks;
    }

    public void setBiologyMarks(int biologyMarks) {
        this.biologyMarks = biologyMarks;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public static int getRollCount() {
        return rollCount;
    }

    public static void setRollCount(int rollCount) {
        Student.rollCount = rollCount;
    }

    public int getIslamiatMarks() {
        return islamiatMarks;
    }

    public void setIslamiatMarks(int islamiatMarks) {
        this.islamiatMarks = islamiatMarks;
    }
}

