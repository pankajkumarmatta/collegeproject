package mycollegeproject.visiblecomponents;

import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

public class FacultyMenuView extends JFrame implements ActionListener {

    Container container = getContentPane();

    JLabel pageTitleLabel = new JLabel("Faculty Home page");

    JButton studentRegistrationButton = new JButton("Student Registration");
    JButton branchesViewButton = new JButton("Show Available Branches");
    JButton examsViewButton = new JButton("Show all Exams Details");

    FacultyMenuView() {
        container.setLayout(null);
        this.setBounds(10, 10, 810, 510);
        pageTitleLabel.setBounds(20, 10, 500, 50);

        studentRegistrationButton.addActionListener(this);
        branchesViewButton.addActionListener(this);
        examsViewButton.addActionListener(this);

        studentRegistrationButton.setBounds(75, 50, 250, 30);

        branchesViewButton.setBounds(75, 100, 250, 30);
        examsViewButton.setBounds(75, 150, 250, 30);

        container.add(pageTitleLabel);
        container.add(studentRegistrationButton);
        container.add(branchesViewButton);
        container.add(examsViewButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Student Registration")) {
            RegisterView registrationPage = new RegisterView("Student Registration", "student");
            registrationPage.setVisible(true);
        } else if (e.getActionCommand().equals("Show Available Branches")) {
            BranchesInfoView branchesList = new BranchesInfoView("All available Branches");
            branchesList.setVisible(true);
        } else if (e.getActionCommand().equals("Show all Exams Details")) {
            ExamsInfoView testsList = new ExamsInfoView("Show all Exams Details");
            testsList.setVisible(true);
        }
    }
}
