/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Student;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import Connection.Conn;

public class StudentAdd extends JFrame implements ActionListener {
    
    JTextField tfname, tffname, tfmname, tfaddress, tfphone, tfemail;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox faculty,major;
    JButton submit, cancel;
    
    Random ran = new Random();
    long first5 = Math.abs((ran.nextLong()%800L)+10000L);
    
    public StudentAdd(){
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        
        //Add Student Heading
        JLabel heading = new JLabel("Register as Student");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD,30));
        add(heading);
        
        //Student's Name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        //Student's Father's Name
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        //Student's Mother's Name
        JLabel lblmname = new JLabel("Mother's Name");
        lblmname.setBounds(50, 200, 200, 30);
        lblmname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblmname);
        
        tfmname = new JTextField();
        tfmname.setBounds(200, 200, 150, 30);
        add(tfmname);
        
        //Roll Number
        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(400, 200, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);
        
        labelrollno = new JLabel("65"+first5);
        labelrollno.setBounds(600, 200, 200, 30);
        labelrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(labelrollno);
        
        //DOB
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(50, 250, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 250, 150, 30);
        add(dcdob);
        
        //Address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(400, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(600, 250, 150, 30);
        add(tfaddress);
        
        //Phone
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(50, 300, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200, 300, 150, 30);
        add(tfphone);
        
        //Email
        JLabel lblemail = new JLabel("Email Address");
        lblemail.setBounds(400, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(600, 300, 150, 30);
        add(tfemail);
        
        //Faculty
        JLabel lblcourse = new JLabel("Faculty");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);
        
        String course[] = {"Martin de Tours School of Management and Economics", 
            "Theodore Maria School of Arts", "Louis Nobiron School of Music", 
            "Thomas Aquinas School of Law", "Albert Laurence School of Communication Arts", 
            "Vincent Mary School of Science and Technology", "Montfort del Rosario School of Architecture and Design", 
            "Vincent Mary School of Engineering", "Theophane Venard School of Biotechnology", 
            "Bernadette de Lourdes School of Nursing Science"};
        faculty = new JComboBox(course);
        faculty.setBounds(200, 400, 150, 30);
        faculty.setBackground(Color.WHITE);
        add(faculty);
        
        //Major
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);
        
        String branch[] = {"BBA", "BA(Busniess)", "BA(Music)", "LLB", "BCom", "BS", "BArch", "BEng", "BSc", "BNS"};
        major = new JComboBox(branch);
        major.setBounds(600, 400, 150, 30);
        major.setBackground(Color.WHITE);
        add(major);
        
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String mname = tfmname.getText();
            String rollno = labelrollno.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String aufaculty = (String) faculty.getSelectedItem();
            String aumajor = (String) major.getSelectedItem();
            
            try {
                String query = "insert into student values('"+name+"', '"+fname+"', '"+mname+"','"+rollno+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+aufaculty+"', '"+aumajor+"')";
                
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new StudentAdd();
    }
}
