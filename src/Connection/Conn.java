package Connection;

import java.sql.*;

public class Conn {
    
    public Connection c;
    public Statement s;
    public String username = "root";
    public String password = "123456";
    public String url = "jdbc:mysql://localhost:3306/universityregistrationsystem";
    
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url,username,password);
            s = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
