package game.core.server;


import game.core.common.GameRegistry;
import game.entities.capabilities.ITickable;
import lombok.Getter;

import java.util.Arrays;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The server game. Does not do any clientside features like render
 */
public class Server {

    public static final int TICKS_PER_SECOND = 20;
    public static final int MILLIS_DELAY = 1000 / 20;

    @Getter
    private static Server instance;

    //Tick related
    private Timer gameTickTimer;


    //registry related
    private GameRegistry registry;

    public Server() {
        instance = this;

        //initialize registries
        registry = new GameRegistry();



    }

    protected void startTcpInstance(){
        //todo start tcp client
    }

    public void startGameTick(Date startDate){
        gameTickTimer = new Timer(false);
        gameTickTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                //Tick all entities
                Arrays.stream(registry.getEntityRegistrySnapshot()).filter(entity -> entity instanceof ITickable).map(entity -> (ITickable) entity).forEach(ITickable::tick);
            }
        }, startDate, MILLIS_DELAY);
    }


}
