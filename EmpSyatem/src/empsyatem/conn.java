package empsyatem;

import java.sql.*;





public class conn {
    Connection c;
    Statement s;
    conn()
    {
        try{
                  
        c=DriverManager.getConnection("jdbc:mysql:///ems","root","");
        s=c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}


