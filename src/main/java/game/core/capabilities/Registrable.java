package game.core.capabilities;

import java.io.Serializable;

public interface Registrable {

    int getUID();

    void setUID(int ID);

    void execute(byte ident, Serializable... args);
}
