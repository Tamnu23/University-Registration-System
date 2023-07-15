package Admin;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import Connection.Conn;

public class StudentLeave extends JFrame implements ActionListener {

    Choice crollno;
    JDateChooser dcdate;
    JButton submit, cancel;
    JLabel labelname;
    
    public StudentLeave() {
        
        setSize(500, 550);
        setLocation(550, 100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        JLabel lblrollno = new JLabel("Search by Roll Number");
        lblrollno.setBounds(60, 100, 200, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);
        
        crollno = new Choice();
        crollno.setBounds(60, 140, 200, 40);
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
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 200, 200, 20);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(150, 200, 200, 20);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelname);
        
        //Display ID's name
        try {
            Conn c = new Conn();
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Change name on selected ID
        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        labelname.setText(rs.getString("name"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 250, 200, 20);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60, 290, 200, 25);
        add(dcdate);
        
        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 25);
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 25);
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String rollno = crollno.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String name = labelname.getText();
            
            String query = "insert into studentleave values('"+rollno+"', '"+date+"', '"+name+"')";
            
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentLeave();
    }
}
