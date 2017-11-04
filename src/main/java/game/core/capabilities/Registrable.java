package game.core.capabilities;/* 
 * Copyright (C) 2017 Vindalia - All Rights Reserved 
 * 
 * Unauthorized copying of this file, via any medium is strictly prohibited 
 * Proprietary and confidential 
 * 
 * Written by Vindalia <development@vindalia.net>, 2017 
 */

import java.io.Serializable;

public interface Registrable {

    int getUID();
    void setUID(int ID);
    void execute(byte ident, Serializable... args);
}
