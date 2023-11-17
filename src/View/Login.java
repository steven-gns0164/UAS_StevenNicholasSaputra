/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class Login {
    
    public Login() {
        newLogin();
    }
    private void newLogin(){
        Controller con = new Controller();
        //=============BAGIAN CONTAINER================
        JFrame formLogin = new JFrame("Login Menu");
        formLogin.setSize(320, 350);
        formLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formLogin.setLocationRelativeTo(null);
        formLogin.setLayout(null);
        //================END CONTAINER=================
        
        JLabel labelLogin = new JLabel("Hi, Welcome to Menu Login");
        labelLogin.setBounds(10, 10, 250, 30);
        formLogin.add(labelLogin);
        
        JLabel labelUsername = new JLabel("Username : ");
        labelUsername.setBounds(10, 45, 80, 30);
        formLogin.add(labelUsername);
        
        JTextField textUsername = new JTextField();
        textUsername.setBounds(90, 45, 150, 30);
        formLogin.add(textUsername);
        
        JLabel labelPassword = new JLabel("Password : ");
        labelPassword.setBounds(10, 80, 80, 30);
        formLogin.add(labelPassword);
        
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(90, 80, 150, 30);
        formLogin.add(passwordField);
        
        JButton buttonLogin = new JButton("Login");
        buttonLogin.setBounds(90, 115, 100, 30);
        formLogin.add(buttonLogin);
        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = String.valueOf(passwordField.getPassword());
                boolean found = con.getUser(textUsername.getText(), password);
                if (found) {
                    int id = con.getID(textUsername.getText());
                    formLogin.dispose();
                    new GameList(id);
                } else {
                    JOptionPane.showMessageDialog(formLogin, "Users not Found", "Error Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        
        formLogin.setVisible(true);
    }
}
