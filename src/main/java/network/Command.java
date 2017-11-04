package network;
import java.io.Serializable;

public class Command implements Serializable{

    private static final long serialVersionUID = -7138295070140783847L;
    private Serializable[] args;
    private byte ident;

    public Command(byte ident, Serializable... args) {
        this.args = args;
        this.ident = ident;
    }

    public void go(){
        //ToDo implement ALL of the commands!!!!!!!!!!!!!!!!!!!!!!!

    }


}
