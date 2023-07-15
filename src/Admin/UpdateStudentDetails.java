package Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import Connection.Conn;

public class UpdateStudentDetails extends JFrame implements ActionListener{
    
    JTextField tffaculty, tfaddress, tfphone, tfemail, tfmajor;
    JLabel labelrollno;
    JButton submit, cancel;
    Choice crollno;
    
    public UpdateStudentDetails() {
        
        setSize(900, 650);
        setLocation(350, 50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
        add(heading);
        
        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50, 100, 200, 20);
        lblrollnumber.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        add(lblrollnumber);
        
        crollno = new Choice();
        crollno.setBounds(250, 100, 200, 20);
        add(crollno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Student Name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(220, 150, 150, 30);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelname);
        
        
        //Student' Father Name
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(lblfname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(600, 150, 150, 30);
        labelfname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelfname);
        
        //Student's Mother Name
        JLabel lblmname = new JLabel("Mother's Name");
        lblmname.setBounds(50, 200, 200, 30);
        lblmname.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(lblmname);
        
        JLabel labelmname = new JLabel();
        labelmname.setBounds(220, 200, 150, 30);
        labelmname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelmname);
        
        //Roll Number
        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(400, 200, 200, 30);
        lblrollno.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(lblrollno);
        
        labelrollno = new JLabel();
        labelrollno.setBounds(600, 200, 200, 30);
        labelrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelrollno);
        
        //DOB
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(50, 250, 200, 30);
        lbldob.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(lbldob);
        
        JLabel labeldob = new JLabel();
        labeldob.setBounds(220, 250, 150, 30);
        labeldob.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labeldob);
        
        //Address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(400, 250, 200, 30);
        lbladdress.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(600, 250, 150, 30);
        add(tfaddress);
        
        //Phone
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(50, 300, 200, 30);
        lblphone.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200, 300, 150, 30);
        add(tfphone);
        
        //Email
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(400, 300, 200, 30);
        lblemail.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(600, 300, 150, 30);
        add(tfemail);
        
        //Faculty
        JLabel lblcourse = new JLabel("Faculty");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(lblcourse);
        
        tffaculty = new JTextField();
        tffaculty.setBounds(200, 400, 150, 30);
        add(tffaculty);
        
        //Major
        JLabel lblbranch = new JLabel("Major");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        add(lblbranch);
        
        tfmajor = new JTextField();
        tfmajor.setBounds(600, 400, 150, 30);
        add(tfmajor);
        
        try {
            Conn c = new Conn();
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("father_name"));
                labelmname.setText(rs.getString("mother_name"));
                labelrollno.setText(rs.getString("rollno"));
                labeldob.setText(rs.getString("date_of_birth"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tffaculty.setText(rs.getString("faculty"));
                tfmajor.setText(rs.getString("major"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("father_name"));
                        labelmname.setText(rs.getString("mother_name"));
                        labeldob.setText(rs.getString("date_of_birth"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelrollno.setText(rs.getString("rollno"));
                        tffaculty.setText(rs.getString("faculty"));
                        tfmajor.setText(rs.getString("major"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        submit = new JButton("Update");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 30);
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String rollno = labelrollno.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String faculty = tffaculty.getText();
            String major = tfmajor.getText();
            
            try {
                String query = "update student set address='"+address+"', phone='"+phone+"', email='"+email+"', faculty='"+faculty+"', major='"+major+"' where rollno='"+rollno+"'";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new UpdateStudentDetails();
    }
}
