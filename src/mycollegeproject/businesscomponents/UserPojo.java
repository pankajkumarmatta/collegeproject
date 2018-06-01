package mycollegeproject.businesscomponents;

public class UserPojo {

    private long id;
    private String firstName;
    private String lastName;
    private boolean superAdmin;
    private boolean faculty;
    private boolean student;

    public UserPojo(long id, String firstName, String lastName, boolean superAdmin, boolean faculty, boolean student) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.superAdmin = superAdmin;
        this.faculty = faculty;
        this.student = student;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFaculty(boolean faculty) {
        this.faculty = faculty;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public void setSuperAdmin(boolean superAdmin) {
        this.superAdmin = superAdmin;
    }

    public boolean isFaculty() {
        return faculty;
    }

    public boolean isStudent() {
        return student;
    }

    public boolean isSuperAdmin() {
        return superAdmin;
    }

    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + "; User type : " + (isSuperAdmin() ? "Super admin." : (isFaculty() ? "faculty." : "student."));
    }

}
