package SplashScreen;

import Instructor.InstructorMain;
import Student.StudentMain;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Student.StudentRegister;
import Instructor.InstructorRegister;

public class Registration extends JFrame implements ActionListener{
    
    JButton student,instructor, already;
    
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
        
        already = new JButton("Already have an account? Login Here");
        already.setBounds(138, 600, 200, 60);
        already.setBackground(Color.WHITE);
        already.setForeground(Color.BLACK);
        already.addActionListener(this);
        already.setFont(new Font("Tahoma",Font.BOLD,15));
        add(already);
        
        setSize(600,900);
        setLocation(500,250);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == student){
            new StudentRegister();
        }else if(ae.getSource() == instructor){
            new InstructorRegister();
        }else if(ae.getSource() == already){
            new LoginScreen();
        }
    }
    
    public static void main(String[] args){
        new Registration();
    }
}
