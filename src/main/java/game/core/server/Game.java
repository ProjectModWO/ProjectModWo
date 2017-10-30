package game.core.server;
/*
 * Copyright (C) 2017 Vindalia - All Rights Reserved 
 * 
 * Unauthorized copying of this file, via any medium is strictly prohibited 
 * Proprietary and confidential 
 * 
 * Written by Vindalia <development@vindalia.net>, 2017 
 */

import game.core.common.GameRegistry;
import game.entities.Entity;
import game.entities.capabilities.ITickable;
import lombok.Getter;

import java.util.Arrays;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * The server game. Does not do any clientside features like render
 */
public class Game{

    public static final int TICKS_PER_SECOND = 20;
    public static final int MILLIS_DELAY = 1000 / 20;

    @Getter
    private static Game instance;

    //Tick relalted
    private Timer gameTickTimer;


    //registry related
    private GameRegistry registry;

    public Game() {
        instance = this;

        //initialize registries
        registry = new GameRegistry();

        gameTickTimer = new Timer(false);
        gameTickTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                //Tick all entities
                Arrays.stream(registry.getEntityRegistrySnapshot()).filter(entity -> entity instanceof ITickable).map(entity -> (ITickable) entity).forEach(ITickable::tick);
            }
        }, 20, MILLIS_DELAY);

    }


}
