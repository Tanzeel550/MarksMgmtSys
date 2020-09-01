package sample;

public class Student {
    private static int rollCount = 1;

    private int rollNo;
    private final String name;

    private final int englishMarks;
    private final int urduMarks;
    private final int physicsMarks;
    private final int chemistryMarks;
    private final int biologyMarks;
    private final int totalMarks;
    private final int islamiatMarks;


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

    public int getEnglishMarks() {
        return englishMarks;
    }

    public int getUrduMarks() {
        return urduMarks;
    }

    public int getPhysicsMarks() {
        return physicsMarks;
    }

    public int getChemistryMarks() {
        return chemistryMarks;
    }

    public int getBiologyMarks() {
        return biologyMarks;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getIslamiatMarks() {
        return islamiatMarks;
    }
}

