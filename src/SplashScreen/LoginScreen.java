/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SplashScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Student.StudentLogin;
import Instructor.InstructorLogin;

public class LoginScreen extends JFrame implements ActionListener{
    JButton student,instructor;
    LoginScreen(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        student = new JButton("Login as Student");
        student.setBounds(138, 200, 300, 200);
        student.setBackground(Color.WHITE);
        student.setForeground(Color.BLACK);
        student.addActionListener(this);
        student.setFont(new Font("Tahoma",Font.BOLD,15));
        add(student);
        
        instructor = new JButton("Login as Instructor");
        instructor.setBounds(138,400,300,200);
        instructor.setBackground(Color.WHITE);
        instructor.setForeground(Color.BLACK);
        instructor.addActionListener(this);
        instructor.setFont(new Font("Tahoma",Font.BOLD,15));
        add(instructor);
        
        setSize(600,900);
        setLocation(500,250);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == student){
            new StudentLogin();
        }else if(ae.getSource() == instructor){
            new InstructorLogin();
        }
    }
    
    public static void main(String[] args){
        new LoginScreen();
    }
}
