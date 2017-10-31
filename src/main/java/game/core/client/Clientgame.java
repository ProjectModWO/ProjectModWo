package game.core.client;

import game.core.common.GameRegistry;
import game.entities.Entity;
import lombok.Getter;

/**
 * Used for all clientside features
 */
public class Clientgame {

    public static final int FPS = 20;
    public static final int FPS_DELAY = 1000 / FPS;

    @Getter
    private static Clientgame instance;

    //Registry related
    private GameRegistry registry;

    public Clientgame() {

    
    }

    public Entity[] getEntityRegistrySnapshot() {
        return registry.getEntityRegistrySnapshot();
    }
}
