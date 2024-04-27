package javaapplication17;
import java.util.*;
import java.text.SimpleDateFormat;

public class Booking {


    private String  name;
    private int busno;
    private Date date;

    public Booking() {
      Scanner scanner=new Scanner(System.in);
      System.out.println("Enter Your Name ");
      name=scanner.next();
      System.out.println("Enter Your BusNo");
      busno=scanner.nextInt();
      System.out.println("Enter Yur Boking date (e.g) dd-mm-yyyy");
      String dateRes=scanner.next();
      SimpleDateFormat dformat=new SimpleDateFormat("dd-mm-yyyy");
      try{
           date=dformat.parse(dateRes);        
      }
      catch(Exception e){
           e.printStackTrace();
      }
    }    
    
    public String getName(){
        return name;
    }
    public int getBusNo(){
        return busno;
    }
    public Date getDate(){
        return date;
    }
    public boolean isAvailable(){
        BusDao busDao=new BusDao();
        BookingDao bookingDao=new BookingDao();
                
        int capacity=busDao.getCapacity(busno);
        
        int booked=bookingDao.getBooking(busno,date);
        
        return capacity>booked ? true : false;
    }
}
