package mycollegeproject.visiblecomponents;

import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;
import mycollegeproject.businesscomponents.Implementor;

public class NetworkManagementPage extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel pageTitleLabel = null;

    JLabel branchNameLabel = new JLabel("Name :");
    JTextField branchNameField = new JTextField();

    JLabel branchDescriptionLabel = new JLabel("Description :");
    JTextField branchDescriptionField = new JTextField();

    JButton createTestButton = new JButton("Create Branch");
    JButton showExistedTestsButton = new JButton("Show existed Branches");

    Implementor manager = new Implementor();

    NetworkManagementPage(String title) {
        this.setBounds(10, 10, 810, 510);
        container.setLayout(null);
        createTestButton.addActionListener(this);
        showExistedTestsButton.addActionListener(this);
        pageTitleLabel = new JLabel(title);
        pageTitleLabel.setBounds(20, 10, 500, 50);

        branchNameLabel.setBounds(75, 50, 450, 30);
        branchNameField.setBounds(350, 50, 250, 30);

        branchDescriptionLabel.setBounds(75, 100, 450, 30);
        branchDescriptionField.setBounds(350, 100, 250, 30);

        createTestButton.setBounds(75, 200, 450, 30);
        showExistedTestsButton.setBounds(75, 250, 450, 30);

        container.add(pageTitleLabel);
        container.add(branchNameLabel);
        container.add(branchNameField);
        container.add(branchDescriptionLabel);
        container.add(branchDescriptionField);
        container.add(createTestButton);
        container.add(showExistedTestsButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Create exam or assignment...
        if (e.getActionCommand().equals("Create Branch")) {
            manager.createBranch(branchNameField.getText(), branchDescriptionField.getText());
            setVisible(false);
        } // List of exams or assignments...
        else if (e.getActionCommand().equals("Show existed Branches")) {
            BranchesInfoView branchesList = new BranchesInfoView("All available Branches");
            branchesList.setVisible(true);
        }
    }

}
