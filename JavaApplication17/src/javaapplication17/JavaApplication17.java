package javaapplication17;

import java.util.*;
import java.sql.*;

public class JavaApplication17 {

    public static void main(String[] args) {
        BusDao busDao=new BusDao();
        busDao.getBusInfo();
       
        int userInput = 1;

        while (userInput == 1) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter 1 for booking, 2 for delete booking and 3 for exit ");
            userInput = scanner.nextInt();

            if (userInput == 1) {
                Booking booking=new Booking();
                if(booking.isAvailable()){
                    BookingDao bookingDao=new BookingDao();
                    int bookingId=bookingDao.addBooking(booking);
                    System.out.println("Booked, and the ticket booking id is "+bookingId);
                }
                else{
                    System.out.println("Bus is Full ,Try another bus or date");
                }
            }
            else if(userInput == 2){
                Scanner delete=new Scanner(System.in);
                System.out.println("Enter your ticket booking id for delete purpose ");
                int deleteID=delete.nextInt();
                
                boolean del=BookingDao.deleteBooking(deleteID);
                
                if(del==true){
                    System.out.println("Successfully delete your booking");
                }
                else{
                    System.out.println("Sorry for our Interruption, can't delete your booking.Pls check your booking id");
                }
            }
            else {
                System.out.println("Nice to meet you !");
            }
        }
    }

}
