import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class HMS implements Serializable {
    int lastRoom;
    ArrayList<Room> rooms=null;
    ArrayList<Guest> guests=null;

    public HMS()
    {
        rooms= new ArrayList<Room>();
        guests= new ArrayList<Guest>();

        lastRoom=0;
    }
    public boolean bookroom(String c) throws NoRoomException
    {
        boolean av=false;
        int rn=-1;
        for(int i=0;i<rooms.size();i++)
        {
            if(rooms.get(i).available==true)
            {
                av=true;
                rn=i;

            }

        }
        if(av==false)
        {
            throw new NoRoomException("No room is empty!");

        }
        else
        {
            guests.add(new Guest(c,rn));
            rooms.get(rn).available=false;
        }
        return true;
    }
    public boolean reserveroom(String c,String time) throws NoRoomException
    {
        boolean av=false;
        int rn=-1;
        for(int i=0;i<rooms.size();i++)
        {
            if(rooms.get(i).available==true)
            {
                av=true;
                rn=i;

            }

        }
        if(av==false)
        {
            throw new NoRoomException("No room is empty!");

        }
        else
        {
            guests.add(new Guest(c,rn));
            rooms.get(rn).available=false;
            rooms.get(rn).reserved=true;
            rooms.get(rn).freeon=time;

        }
        return true;
    }

    public void search(int rn)
    {
        System.out.println("Guests in the specified room:");

        for(int i=0;i<guests.size();i++)
        {

            if(guests.get(i).roomNo==rn)
            {
                System.out.println(guests.get(i).name);

            }

        }

    }
    public boolean Addroom()
    {
        rooms.add(new Room(lastRoom));

        lastRoom++;
        return true;
    }
    public void getAvRooms()
    {
        System.out.println("Available Rooms:- ");

        for(int i=0;i<rooms.size();i++)
        {

            if(rooms.get(i).available==true)
            {
                System.out.println("Room No. "+i+" ");
            }

        }

    }

}
