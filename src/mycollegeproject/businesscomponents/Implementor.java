package mycollegeproject.businesscomponents;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Implementor {

    public Implementor() {
    }

    public List<BranchPojo> getAllBranches() {
        List<BranchPojo> list = new ArrayList<BranchPojo>();
        ResultSet rs = DBOperations.getTableResultSet("branch");
        try {
            while (rs.next()) {
                BranchPojo branch = new BranchPojo(rs.getLong("idbranch"), rs.getString("name"), rs.getString("details"));
                System.out.println(branch);
                list.add(branch);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<CoursePojo> getAllCourses() {
        List<CoursePojo> list = new ArrayList<CoursePojo>();
        ResultSet rs = DBOperations.getTableResultSet("course");
        try {
            while (rs.next()) {
                CoursePojo course = new CoursePojo(rs.getString("name"), rs.getString("details"));
                System.out.println(course);
                list.add(course);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<ExamPojo> getAllTests() {
        List<ExamPojo> list = new ArrayList<ExamPojo>();
        ResultSet rs = DBOperations.getTableResultSet("test");
        try {
            while (rs.next()) {
                ExamPojo test = new ExamPojo(rs.getLong("testid"), rs.getString("name"), rs.getInt("isExam") == 1, rs.getInt("isAssignment") == 1, rs.getString("testdetails"), rs.getInt("maxmarkalloted"));
                System.out.println(test);
                list.add(test);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean createTest(String testName, boolean assignment, boolean exam, String description, int maxMarksAlloted) {
        return DBOperations.createTest(testName, assignment, exam, description, maxMarksAlloted);
    }

    public boolean createBranch(String branchName, String description) {
        return DBOperations.createBranch(branchName, description);
    }

    public boolean createStudentResult(Long testId, Long studentid, int marks) {
        return DBOperations.createStudentResult(testId, studentid, marks);
    }

    public boolean createFee(String feePurpose, Long studentId, int amount, String paidDate) {
        return DBOperations.createFee(feePurpose, studentId, amount, paidDate);
    }

    public void addSuperAdmin(String firstName, String lastName, String password) {
        DBOperations.registerSuperAdmin(firstName, lastName, password);
    }

    public void addFacultY(String firstName, String lastName, String password) {
        DBOperations.registerFaculty(firstName, lastName, password);
    }

    public void addStudent(String firstName, String lastName, String password) {
        DBOperations.registerStudent(firstName, lastName, password);
    }

    public UserPojo getUser(String username, String password) {
        if (DBOperations.getAvailableRows("superadmin", "username = '" + username + "' and password = '" + password + "'") == 1) {
            ResultSet rs = DBOperations.getTableResultSet("superadmin", "username = '" + username + "' and password = '" + password + "'");
            try {
                while (rs.next()) {
                    try {
                        return new UserPojo(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), true, false, false);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (DBOperations.getAvailableRows("faculty", "username = '" + username + "' and password = '" + password + "'") == 1) {
            ResultSet rs = DBOperations.getTableResultSet("faculty", "username = '" + username + "' and password = '" + password + "'");
            try {
                while (rs.next()) {
                    try {
                        return new UserPojo(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"), false, true, false);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (DBOperations.getAvailableRows("student", "username = '" + username + "' and password = '" + password + "'") == 1) {
            ResultSet rs = DBOperations.getTableResultSet("student", "username = '" + username + "' and password = '" + password + "'");
            try {
                while (rs.next()) {
                    try {
                        return new UserPojo(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"), false, false, true);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
