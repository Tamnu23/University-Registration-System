/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import Connection.Conn;

public class InstructorAccounts extends JFrame {
    
    Choice instructorName;
    
    public InstructorAccounts(){
        setSize(1000, 700);
        setLocation(250, 50);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Instructor Accounts");
        heading.setBounds(50, 10, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        JLabel noti = new JLabel("FOR DELETE ONLY");
        noti.setBounds(420, 20, 200, 20);
        add(noti);
        
        instructorName = new Choice();
        instructorName.setBounds(180, 20, 150, 20);
        add(instructorName);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from instructorRegister");
            while(rs.next()) {
                instructorName.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JTable table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from instructorRegister");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 60, 1000, 700);
        add(jsp);
        
        setVisible(true);
    }
    
    public static void main(String[] args){
        new InstructorAccounts();
    }
}
