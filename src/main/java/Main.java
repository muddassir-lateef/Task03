import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main {
    public static void main(String[] args)
    {
        HMS hotel=new HMS();
        try {

            // 6. Create a FileOutputStream Object by passing text file
            // name which will be used to store the object state

            FileOutputStream fos = new FileOutputStream("hotel.txt");

            // 7. Create a ObjectOutputStream object which wraps
            // object of FileOutputStream thus helping to pass object
            // to a text file.
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            FileInputStream fis = new FileInputStream("hotel.txt");

            // 13. Create a ObjectInputStream object which wraps
            // object of FileInputStream thus helping to pass object
            // state from text file to Object

            ObjectInputStream ois = new ObjectInputStream(fis);

            int op=-1;

            while(op!=0)
            {
                System.out.println("1.Add Room");
                System.out.println("2.Show Available Rooms");
                System.out.println("3.Load Data");
                System.out.println("4.Book Room");
                System.out.println("5.Reserve Room");
                System.out.println("6.Search customer by roomnumber");
                System.out.println("Press 0 to Exit!");
                Scanner sc= new Scanner(System.in);
                op= sc.nextInt();
                if(op==1)
                {
                    hotel.Addroom();
                }
                if(op==2)
                {
                    hotel.getAvRooms();
                }
                if(op==3)
                {
                    hotel=null;
                    hotel = (HMS) ois.readObject();
                }
                if(op==4)
                {
                    System.out.println("Enter Customer Name:");
                    String s=sc.nextLine();
                    try {
                        hotel.bookroom(s);
                    }
                    catch (NoRoomException e) {
                        System.out.println(e);
                    }

                }
                if(op==5)
                {
                    System.out.println("Enter Customer Name:");
                    String s=sc.nextLine();
                    System.out.println("Enter time to reserve till:");
                    String t=sc.nextLine();
                    try {
                        hotel.reserveroom(s,t);
                    }
                    catch (NoRoomException e) {
                        System.out.println(e);
                    }

                }
                if(op==6)
                {
                    System.out.println("Enter Room no:");
                    int n=sc.nextInt();
                    hotel.search(n);

                }
                if(op==0)
                {
                    oos.writeObject(hotel);
                    oos.flush();
                    oos.close();
                }
            }




            ois.close();
        }
        catch (EOFException e) {
            System.out.println("");
            System.out.println("End of file reached");

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

}
