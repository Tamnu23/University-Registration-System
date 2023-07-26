/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instructor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import Connection.Conn;

public class InstructorRegister extends JFrame implements ActionListener{
    
    JButton register, cancel;
    JTextField tfname, tfemail;
    JPasswordField tfpassword;
    
    public InstructorRegister(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Register as Student");
        heading.setBounds(170,20,500,50);
        heading.setFont(new Font("serif", Font.BOLD,30));
        add(heading);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 80, 100, 20);
        add(lblusername);
        
        tfname = new JTextField();
        tfname.setBounds(150,80,150,20);
        add(tfname);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(40,130,100,20);
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(150, 130, 150, 20);
        add(tfemail);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 190, 100, 20);
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 190, 150, 20);
        add(tfpassword);
        
        System.out.println();
        
        register = new JButton("Register");
        register.setBounds(40, 250, 120, 30);
        register.setBackground(Color.WHITE);
        register.setForeground(Color.BLACK);
        register.addActionListener(this);
        register.setFont(new Font("Tahoma",Font.BOLD,15));
        add(register);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 250, 120, 30);
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        
        setSize(600,450);
        setLocation(500,250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == register){
            String name = tfname.getText();
            String email = tfemail.getText();
            String password = tfpassword.getText();
            
            try{
                String query = "insert into instructorRegister values('"+name+"', '"+email+"', '"+password+"')";
                Conn con = new Conn();
                con.s.execute(query);
                
                JOptionPane.showMessageDialog(null, "Registered Successfully");
                setVisible(false);
                new InstructorLogin();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    
    
    public static void main(String[] args){
        new InstructorRegister();
    }
}
