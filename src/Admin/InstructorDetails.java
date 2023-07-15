package Admin;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import Connection.Conn;

public class InstructorDetails extends JFrame implements ActionListener {

    Choice cEmpId;
    JTable table;
    JButton search, print, update, add, cancel;
    
    public InstructorDetails() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Instructor Id");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        cEmpId = new Choice();
        cEmpId.setBounds(180, 20, 150, 20);
        add(cEmpId);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from instructor");
            while(rs.next()) {
                cEmpId.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from instructor");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        add = new JButton("Add");
        add.setBounds(120, 70, 80, 20);
        add.addActionListener(this);
        add(add);
        
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(320, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from instructor where id = '"+cEmpId.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == add) {
            setVisible(false);
            new AddInstructor();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateInstructorDetails();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new InstructorDetails();
    }
}
