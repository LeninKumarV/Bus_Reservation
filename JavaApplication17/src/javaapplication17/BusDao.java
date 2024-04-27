package javaapplication17;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class BusDao {
    public void getBusInfo(){
        try {   
            String query="select * from bus";
            //This JdbcConnection is a class
            Connection con= JdbcConnection.getConnection();
            Statement st=con.createStatement();
            ResultSet rst=st.executeQuery(query);
            
            while(rst.next()){
                System.out.println("Bus No : "+rst.getInt(1));
                if(rst.getInt(2)==0){
                    System.out.println("Ac : False");
                }
                else{
                    System.out.println("Ac : True");
                }
                System.out.println("Capacity : "+rst.getInt(3));
                System.out.println("------------------------------");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BusDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public int getCapacity(int busno){      
        try{
            String query="select capacity from bus where id="+busno;
            Connection con=JdbcConnection.getConnection();
            Statement st=con.createStatement();
            ResultSet rst=st.executeQuery(query);
            rst.next();
            return rst.getInt(1);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return 0;
    }
  
}
