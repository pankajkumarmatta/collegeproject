package mycollegeproject.visiblecomponents;

import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

class UnAuthroizedView extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel errorMessageLabel = null;

    UnAuthroizedView(String errorMessage) {
        errorMessageLabel = new JLabel(errorMessage);
        this.setBounds(10, 10, 810, 510);
        container.setLayout(null);

        errorMessageLabel.setBounds(100, 100, 500, 50);
        JButton loginAgain = new JButton("Login again");
        loginAgain.addActionListener(this);

        loginAgain.setBounds(250, 250, 150, 50);

        container.add(errorMessageLabel);
        container.add(loginAgain);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

}
