package javaapplication17;
import java.sql.*;
import java.util.Date;

public class BookingDao {
 
  
    public int getBooking(int busno,Date date){
        try{
            String query="select count(pname) from booking where busno=? and bdate=?";
            Connection con=JdbcConnection.getConnection();
            PreparedStatement pst=con.prepareStatement(query);
            pst.setInt(1, busno);
            java.sql.Date sqlDate=new java.sql.Date(date.getTime());
            pst.setDate(2, sqlDate);
            ResultSet rst=pst.executeQuery();
            rst.next();
            
            return rst.getInt(1);
        }catch(Exception e){
            System.out.println(e);
        }
        return 0;
    }

    public int addBooking(Booking booking){
        try{
            String query="insert into booking(busno,pname,bdate) values(?,?,?)";
            Connection con=JdbcConnection.getConnection();
            PreparedStatement pst=con.prepareStatement(query);
            pst.setInt(1, booking.getBusNo());
            pst.setString(2, booking.getName());
            java.sql.Date sqlDate=new java.sql.Date(booking.getDate().getTime());
            pst.setDate(3, sqlDate);
            pst.executeUpdate();
            
            
           return BookingDao.getBookingId(booking);
        }catch(Exception e){
            System.out.println(e);
        }
        return 0;
    }
    
    public static int getBookingId(Booking booking){
        try{
            String query="select id from booking where busno=? and pname=? and bdate=?";
            Connection con=JdbcConnection.getConnection();
            PreparedStatement pst=con.prepareStatement(query);
            pst.setInt(1, booking.getBusNo());
            pst.setString(2, booking.getName());
            java.sql.Date sqlDate=new java.sql.Date(booking.getDate().getTime());
            pst.setDate(3, sqlDate);
            ResultSet rst=pst.executeQuery();
            rst.next();
            return rst.getInt(1);
            
        }       
        catch(Exception e){
            System.out.println(e);
        }
        return 0;
    }
    
    public static boolean deleteBooking(int deleteID){
        try{
            String query="delete from booking where id="+deleteID;
            Connection con=JdbcConnection.getConnection();
            PreparedStatement pst=con.prepareStatement(query);
            pst.execute();
            
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
}
