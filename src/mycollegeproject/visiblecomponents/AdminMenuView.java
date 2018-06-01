package mycollegeproject.visiblecomponents;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminMenuView extends JFrame implements ActionListener {

    Container container = getContentPane();

    JLabel pageTitleLabel = new JLabel("Super Admin Home page");

    JButton facultyRegistrationButton = new JButton("Faculty Registration");
    JButton superAdminRegistrationButton = new JButton("SuperAdmin Registration");
    JButton academicCalenderManagementButton = new JButton("Academic Calender Management");
    JButton examsManagementButton = new JButton("Exams Management");
    JButton networkManagementButton = new JButton("Network Management");
    JButton feesManagementButton = new JButton("Fees Management");

    AdminMenuView() {
        container.setLayout(null);
        this.setBounds(10, 10, 810, 510);
        pageTitleLabel.setBounds(20, 10, 500, 50);

        facultyRegistrationButton.addActionListener(this);
        superAdminRegistrationButton.addActionListener(this);
        academicCalenderManagementButton.addActionListener(this);
        examsManagementButton.addActionListener(this);
        networkManagementButton.addActionListener(this);
        feesManagementButton.addActionListener(this);

        facultyRegistrationButton.setBounds(75, 50, 250, 30);
        superAdminRegistrationButton.setBounds(350, 50, 250, 30);

        academicCalenderManagementButton.setBounds(75, 100, 250, 30);
        examsManagementButton.setBounds(75, 150, 250, 30);
        networkManagementButton.setBounds(75, 200, 250, 30);
        feesManagementButton.setBounds(75, 250, 250, 30);

        container.add(pageTitleLabel);
        container.add(facultyRegistrationButton);
        container.add(superAdminRegistrationButton);
        container.add(academicCalenderManagementButton);
        container.add(examsManagementButton);
        container.add(networkManagementButton);
        container.add(feesManagementButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Register faculty and other superadmin users.
        if (e.getActionCommand().equals("Faculty Registration")) {
            RegisterView registrationPage = new RegisterView("Faculty Registration", "faculty");
            registrationPage.setVisible(true);
        } else if (e.getActionCommand().equals("SuperAdmin Registration")) {
            RegisterView registrationPage = new RegisterView("SuperAdmin Registration", "superAdmin");
            registrationPage.setVisible(true);
        } // 1.Manage Academic Calendar (Exam dates, assignment dates)
        else if (e.getActionCommand().equals("Academic Calender Management")) {
            ExamsView calendarPage = new ExamsView("Academic Calendar Management");
            calendarPage.setVisible(true);
        } //2.Manage Exams, Assignments and Results.
        else if (e.getActionCommand().equals("Exams Management")) {
            ResultsView examPage = new ResultsView("Exam Mangement");
            examPage.setVisible(true);
        } //4.Manage Network – Adding more branches.
        else if (e.getActionCommand().equals("Network Management")) {
            NetworkManagementPage networkPage = new NetworkManagementPage("Network Management");
            networkPage.setVisible(true);
        } //7.Management of fees paid
        else if (e.getActionCommand().equals("Fees Management")) {
            FeesView feesPage = new FeesView("Fees Management");
            feesPage.setVisible(true);
        }
    }
}
