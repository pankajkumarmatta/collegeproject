package mycollegeproject.businesscomponents;

public class BranchPojo {

    Long id;
    String name;
    String details;

    public BranchPojo(Long id, String name, String details) {
        this.id = id;
        this.name = name;
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public String getName() {
        return name;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toString() {
        return "( branch id : " + getId() + " ) " + this.getName() + " , details : " + this.getDetails();
    }
}
