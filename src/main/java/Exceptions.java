class NoRoomException  extends Exception
{
    public NoRoomException (String str)
    {
        // calling the constructor of parent Exception  
        super(str);
    }
}  