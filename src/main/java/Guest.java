import java.io.Serializable;

public class Guest  implements Serializable {
    public int roomNo;
    public String name;
    public Guest(String n,int r)
    {
        roomNo=r;
        name=n;
    }
}
