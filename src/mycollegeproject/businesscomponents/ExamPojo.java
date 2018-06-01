package mycollegeproject.businesscomponents;

public class ExamPojo {

    private long id;
    private String name;
    private boolean exam;
    private boolean assignment;
    private String description;
    private int maxMarksAlloted;

    public ExamPojo(long id, String name, boolean exam, boolean assignment, String description, int maxMarksAlloted) {
        this.id = id;
        this.name = name;
        this.exam = exam;
        this.assignment = assignment;
        this.description = description;
        this.maxMarksAlloted = maxMarksAlloted;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAssignment() {
        return assignment;
    }

    public boolean isExam() {
        return exam;
    }

    public int getMaxMarksAlloted() {
        return maxMarksAlloted;
    }

    public void setAssignment(boolean assignment) {
        this.assignment = assignment;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExam(boolean exam) {
        this.exam = exam;
    }

    public void setMaxMarksAlloted(int maxMarksAlloted) {
        this.maxMarksAlloted = maxMarksAlloted;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String toString() {
        return "( id : " + this.getId() + " ) " + (this.isExam() ? "Exam " : "Assignment : ") + this.getName() + "on" + this.getDescription() + " held for " + this.getMaxMarksAlloted() + "; ";
    }
}
