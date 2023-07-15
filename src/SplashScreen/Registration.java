package SplashScreen;

import Instructor.InstructorMain;
import Student.StudentMain;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Registration extends JFrame implements ActionListener{
    
    JButton student,instructor;
    
    public Registration(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        student = new JButton("Register as Student");
        student.setBounds(138, 200, 300, 200);
        student.setBackground(Color.WHITE);
        student.setForeground(Color.BLACK);
        student.addActionListener(this);
        student.setFont(new Font("Tahoma",Font.BOLD,15));
        add(student);
        
        instructor = new JButton("Register as Instructor");
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
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == student){
            new StudentMain();
        }else if(ae.getSource() == instructor){
            new InstructorMain();
        }
    }
    
    public static void main(String[] args){
        new Registration();
    }
}
