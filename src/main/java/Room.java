import java.io.Serializable;

public class Room implements Serializable {
    int RoomNo;
    boolean available;
    boolean reserved;
    String freeon;
    public Room(int rn)
    {
        RoomNo=rn;
        available=true;
        reserved=false;
        String freeon="";
    }
}

