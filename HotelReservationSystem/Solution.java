import java.util.ArrayList;
import java.util.Scanner;

class reservation{
    String name;
    int room;
    public reservation(String name, int room){
        this.name = name;
        this.room = room;
    }
    public reservation(String name){
        this.name = name;
        this.room = 0;
    }
    public void setRoom(int room){
        this.room = room;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getRoom(){
        return this.room;
    }
    public String getName(){
        return this.name;
    }
    public String toString(){
        return this.name + " - Room " + this.room;
    }
}


class Hotel{

    ArrayList<reservation> rooms = new ArrayList<reservation>();
    int numberOfrooms = 0;
    public Hotel(){
        this.numberOfrooms = 5;
        for(int i = 0; i < this.numberOfrooms; i++){
            rooms.add(new reservation("",i));
        }
        
    }
    
    public Hotel(int numberOfrooms){
        this.numberOfrooms = numberOfrooms;
        for(int i = 0; i < this.numberOfrooms; i++){
            rooms.add(new reservation("",i));
        }
    }

    public void addRooms(int numberOfrooms){
        System.out.printf("Added %d more rooms.\n", numberOfrooms);
        for(int i = 0; i < numberOfrooms; i++){
            rooms.add(new reservation("",this.numberOfrooms));
            this.numberOfrooms++;
        }
    }
    public void reserveRoom(String person){
        if(availableRooms() == 0){
            System.out.printf("Hotel is full. No room available for %s\n", person);
            // System.out.println(rooms.toString());
            return;
        }
        for(reservation r: rooms){
                if(r.getName().equals("")){
                    r.setName(person);
                    System.out.printf("%s reserved Room %d\n", r.name ,r.room+1);
                    // System.out.println(rooms.toString());
                    return;
                
            }
        }
          
    }
        
    

    public void reserveRoom(String person, int room){
            for(reservation r: rooms){
                // System.out.println(r.getRoom()+" "+room);
                if(r.getRoom() == room-1){
                    r.setName(person);
                    System.out.printf("%s reserved Room %d\n", r.name ,r.room+1);
                    // System.out.println(rooms.toString());
                    return;
                }
            }
        }
          
    
    
    private int availableRooms(){
        int count = 0;
        for(reservation r: rooms){
            if(r.getName().equals("")){
                count++;
            }
        }
        return count;
    }

    public void cancelReservation(String person){
        for(reservation r: rooms){
            if(r.getName().equals(person)){
                r.setName("");
                System.out.printf("Cancelled reservations for %s\n", person);
                return;
            }
        }
    }
     public void printReservations(){
        System.out.println("Current Reservations:");
        int CurrentReservations = 0;
        for(reservation r: rooms){
            if(!r.getName().equals("")){
                CurrentReservations++;
                System.out.printf("%s - Room %d\n", r.name ,r.room+1);
            }
        }
        System.out.printf("Total Reservations: %d\n" , CurrentReservations);
        System.out.printf("Available Rooms: %d" , availableRooms());
     }
}

public class Solution {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(input.toCharArray().length == 1){
            Hotel hotel = new Hotel(Integer.parseInt(input));
            while(sc.hasNext()){
                String[] command = sc.nextLine().split(" ");
                if(command[0].equals("reserve")){
                    if(command.length == 2){
                        hotel.reserveRoom(command[1]);
                    }
                    else{
                        hotel.reserveRoom(command[1], Integer.parseInt(command[2]));
                    }
                }
                else if(command[0].equals("build")){
                    hotel.addRooms(Integer.parseInt(command[1]));
                }
                else if(command[0].equals("cancel")){
                    hotel.cancelReservation(command[1]);
                }
                else if(command[0].equals("print")){
                    hotel.printReservations();
                }
            }
           
        }
        else{

            Hotel hotel = new Hotel();
            while (sc.hasNext()) {
                String[] command = sc.nextLine().split(" ");
                if (command[0].equals("reserve")) {
                    if (command.length == 2) {
                        System.out.println(898989);
                        hotel.reserveRoom(command[1]);
                    } else {
                        hotel.reserveRoom(command[1], Integer.parseInt(command[2]));
                    }
                } else if (command[0].equals("cancel")) {
                    hotel.cancelReservation(command[1]);
                } else if (command[0].equals("print")) {
                    hotel.printReservations();
                }
                
            }
        }






        sc.close();
    }
}