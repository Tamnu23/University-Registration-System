package Instructor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Admin.About;
import Admin.FeeStructure;

public class InstructorMain extends JFrame implements ActionListener{
   
    public InstructorMain(){
        setSize(1540, 850);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("photos/AU.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        
        //Add Students and Instructors
        JMenu newInformation = new JMenu("Register");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);
        
        JMenuItem facultyInfo = new JMenuItem("Register as Instructor");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        
//        // fee
//        JMenu fee = new JMenu("Fee Details");
//        fee.setForeground(Color.BLUE);
//        mb.add(fee);
//        
//        JMenuItem feestructure = new JMenuItem("Fee Structure");
//        feestructure.setBackground(Color.WHITE);
//        feestructure.addActionListener(this);
//        fee.add(feestructure);
        
        // about
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        mb.add(about);
        
        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);
        
        // exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        mb.add(exit);
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
        
        setJMenuBar(mb);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        
        if (msg.equals("Exit")){
            setVisible(false);
        }else if(msg.equals("Register as Student")){
            new InstructorAdd();
        }else if(msg.equals("About")){
            new About();
        }
    }
    
    public static void main(String[] args){
        new InstructorMain();
    }
    
}