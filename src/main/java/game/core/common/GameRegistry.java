package game.core.common;

import game.entities.Entity;

import java.io.Serializable;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class GameRegistry implements Serializable{

    private volatile Map<Integer, Entity> entityRegistry;
    private int counter;

    public GameRegistry() {

        entityRegistry = new ConcurrentHashMap<>();
    }

    public void registerEntity(Entity entity){
        int i = getCounter();
        entity.setUID(i);

        entityRegistry.put(i,entity);
    }

    private int getCounter(){
        while(entityRegistry.containsKey(counter) || counter == 0){
            counter++;
        }
        return counter++;

    }

    public void removeEntity(Entity entity){
        int UID = entity.getUID();
        entityRegistry.remove(UID);
    }

    public Entity[] getEntityRegistrySnapshot() {
        return (Entity[]) entityRegistry.values().toArray();
    }
}
