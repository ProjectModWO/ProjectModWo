package game.core.client;

import game.core.common.GameRegistry;
import game.entities.Entity;
import game.visuals.GameFrame;
import lombok.Getter;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Used for all clientside features
 */
public class Clientgame {

    public static final int FPS = 20;
    public static final int FPS_DELAY = 1000 / FPS;

    @Getter
    private static Clientgame instance;

    //Render related
    private Timer renderTimer;
    private GameFrame frame;

    //Registry related
    private GameRegistry registry;

    public Clientgame() {

        instance = this;
        frame = new GameFrame();

        renderTimer = new Timer(false);
        renderTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                frame.getGamePanel().repaint();
            }
        }, 20, FPS_DELAY);

        frame.setVisible(true);
    }

    public Entity[] getEntityRegistrySnapshot() {
        return registry.getEntityRegistrySnapshot();
    }
}
