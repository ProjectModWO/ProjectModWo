package network;

import java.io.Serializable;

public class Command implements Serializable {

    private static final long serialVersionUID = -7138295070140783847L;
    private Serializable[] args;
    private byte ident;
    private int registryIdent;

    public Command(Serializable[] args, byte ident, int registryIdent) {
        this.args = args;
        this.ident = ident;
        this.registryIdent = registryIdent;
    }

    public void go() {
        //todo get registry obj. and send.
    }


    public static class CommandWrapper implements Serializable {

        int execTick;
        private Command[] cmds;

        public CommandWrapper(int execTick, Command... cmds) {
            this.execTick = execTick;
            this.cmds = cmds;
        }

        public void go() {
            for (Command command : cmds) {
                command.go();
            }
        }
    }


}
