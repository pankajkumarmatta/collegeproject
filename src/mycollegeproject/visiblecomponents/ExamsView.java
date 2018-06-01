package mycollegeproject.visiblecomponents;

import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;
import mycollegeproject.businesscomponents.Implementor;

public class ExamsView extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel pageTitleLabel = null;

    JLabel testTypeLable = new JLabel("Test type (exam or assignment) :");
    JTextField testTypeField = new JTextField();

    JLabel testNameLable = new JLabel("Name :");
    JTextField testNameField = new JTextField();

    JLabel testDescriptionLable = new JLabel("Date :");
    JTextField testDescriptionField = new JTextField();

    JLabel maxMarksLable = new JLabel("Max marks alloted:");
    JTextField maxMarksField = new JTextField();

    JButton createTestButton = new JButton("Create Exam - Assignment");
    JButton showExistedTestsButton = new JButton("Show existed Exams - Assignments");

    Implementor manager = new Implementor();

    ExamsView(String title) {
        this.setBounds(10, 10, 810, 510);
        container.setLayout(null);
        createTestButton.addActionListener(this);
        showExistedTestsButton.addActionListener(this);
        pageTitleLabel = new JLabel(title);
        pageTitleLabel.setBounds(20, 10, 500, 50);

        testTypeLable.setBounds(75, 50, 450, 30);
        testTypeField.setBounds(350, 50, 250, 30);

        testNameLable.setBounds(75, 100, 450, 30);
        testNameField.setBounds(350, 100, 250, 30);

        testDescriptionLable.setBounds(75, 150, 450, 30);
        testDescriptionField.setBounds(350, 150, 250, 30);

        maxMarksLable.setBounds(75, 200, 450, 30);
        maxMarksField.setBounds(350, 200, 250, 30);

        createTestButton.setBounds(75, 250, 450, 30);
        showExistedTestsButton.setBounds(75, 300, 450, 30);

        container.add(pageTitleLabel);
        container.add(testTypeLable);
        container.add(testTypeField);
        container.add(testNameLable);
        container.add(testNameField);
        container.add(testDescriptionLable);
        container.add(testDescriptionField);
        container.add(maxMarksLable);
        container.add(maxMarksField);
        container.add(createTestButton);
        container.add(showExistedTestsButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Create exam or assignment...
        if (e.getActionCommand().equals("Create Exam - Assignment")) {
            boolean isExam = testTypeField.getText().equalsIgnoreCase("exam");
            boolean isAssignment = testTypeField.getText().equalsIgnoreCase("assignment");
            manager.createTest(testNameField.getText(), isAssignment, isExam, testDescriptionField.getText(), Integer.parseInt(maxMarksField.getText()));
            setVisible(false);
        } // List of exams or assignments...
        else if (e.getActionCommand().equals("Show existed Exams - Assignments")) {
            ExamsInfoView testsList = new ExamsInfoView("All available Tests");
            testsList.setVisible(true);
        }
    }

}
