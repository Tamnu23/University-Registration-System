package Admin;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import Connection.Conn;

public class InstructorLeave extends JFrame implements ActionListener {

    Choice cid, ctime;
    JDateChooser dcdate;
    JButton submit, cancel;
    JLabel labelname;
    
    public InstructorLeave() {
        
        setSize(500, 550);
        setLocation(550, 100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Apply Leave (Instructor)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        JLabel lblrollno = new JLabel("Search by Instructor ID");
        lblrollno.setBounds(60, 100, 200, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);
        
        cid = new Choice();
        cid.setBounds(60, 140, 200, 40);
        add(cid);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from instructor");
            while(rs.next()) {
                cid.add(rs.getString("id"));
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
            String query = "select * from instructor where id='"+cid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Change name on selected ID
        cid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from instructor where id='"+cid.getSelectedItem()+"'";
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
        
        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60, 340, 200, 20);
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbltime);
        
        ctime = new Choice();
        ctime.setBounds(60, 390, 200, 20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        submit = new JButton("Submit");
        submit.setBounds(60, 450, 100, 25);
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 450, 100, 25);
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String rollno = cid.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            String name = labelname.getText();
            
            String query = "insert into instructorleave values('"+rollno+"', '"+date+"', '"+duration+"', '"+name+"')";
            
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
        new InstructorLeave();
    }
}
