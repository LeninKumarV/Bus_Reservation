package javaapplication17;

public class Bus {
    private int busno;
    private boolean ac;
    private int capacity;

    public Bus(int busno,boolean ac,int capacity) {
        this.busno=busno;
        this.ac=ac;
        this.capacity=capacity;
    }
    
    public int getBusNo(){
        return busno;
    }
    public void setBusNo(int busno){
        this.busno=busno;
    }
    public boolean getAc(){
        return ac;
    }
    public void setAc(boolean ac){
        this.ac=ac;
    }
    public int getCapacity(){
        return busno;
    }
    public void setCapacity(int capacity){
        this.capacity=capacity;
    }
    
    public void display(){
        System.out.println("Busno"+busno+" "+"Ac"+ac+" "+"Capacity"+capacity);
    }
}

