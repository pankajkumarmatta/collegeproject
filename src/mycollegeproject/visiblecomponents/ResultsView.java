package mycollegeproject.visiblecomponents;

import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;
import mycollegeproject.businesscomponents.Implementor;

public class ResultsView extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel pageTitleLabel = null;

    JLabel studentIdLable = new JLabel("Student id :");
    JTextField studentIdField = new JTextField();

    JLabel testIdLabel = new JLabel("Test id :");
    JTextField testIdField = new JTextField();

    JLabel marksLable = new JLabel("Marks :");
    JTextField marksField = new JTextField();

    JButton updateResultButton = new JButton("Update Result");

    Implementor manager = new Implementor();

    ResultsView(String title) {
        this.setBounds(10, 10, 810, 510);
        container.setLayout(null);
        updateResultButton.addActionListener(this);

        pageTitleLabel = new JLabel(title);
        pageTitleLabel.setBounds(20, 10, 500, 50);

        testIdLabel.setBounds(75, 50, 450, 30);
        testIdField.setBounds(350, 50, 250, 30);

        studentIdLable.setBounds(75, 100, 450, 30);
        studentIdField.setBounds(350, 100, 250, 30);

        marksLable.setBounds(75, 150, 450, 30);
        marksField.setBounds(350, 150, 250, 30);

        updateResultButton.setBounds(75, 250, 450, 30);
        container.add(pageTitleLabel);
        container.add(testIdLabel);
        container.add(testIdField);
        container.add(studentIdLable);
        container.add(studentIdField);
        container.add(marksLable);
        container.add(marksField);
        container.add(updateResultButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Updating the results.
        if (e.getActionCommand().equals("Update Result")) {
            manager.createStudentResult(Long.parseLong(testIdField.getText()), Long.parseLong(studentIdField.getText()), Integer.parseInt(marksField.getText()));
            setVisible(false);
        }
    }

}
