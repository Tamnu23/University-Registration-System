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

public class InstructorLogin extends JFrame implements ActionListener {
    
    JButton login, cancel;
    JTextField tfusername, tfpassword;
    
    public InstructorLogin(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username : ");
        lblusername.setBounds(40,20,100,20);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password : ");
        lblpassword.setBounds(40,70,100,20);
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.WHITE);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma",Font.BOLD,15));
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("photos/AULogo.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
        
        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            String query = "select * from instructorRegister where email='"+username+"' and password='"+password+"'";
            
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new InstructorMain();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(true);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel){
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new InstructorLogin();
    }
}
