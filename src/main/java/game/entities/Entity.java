package game.entities;

import game.core.capabilities.Registrable;
import game.entities.capabilities.IMovable;
import game.entities.components.PhysicsComponent;
import game.entities.components.TransformComponent;
import lombok.Getter;

import java.io.Serializable;

public abstract class Entity implements IMovable, Serializable, Registrable {

    @Getter
    private TransformComponent transform;

    private PhysicsComponent physics;

    private int UID = 0;

    @Getter
    private double health;

    public Entity(TransformComponent transform, PhysicsComponent physics) {

        this.transform = transform;

        this.physics = physics;
    }

    public void onCrash(IMovable hitter) {

        //Todo calculate impact force from the delta of the kinetic energy

        if (health <= 0D) {
            destroy();
        }
    }

    @Override
    public PhysicsComponent getPhyComp() {
        return physics;
    }

    public abstract void destroy();

    @Override
    public void setUID(int UID) {
        if (UID != 0) {
            throw new RuntimeException("UID Already set!");
        }
        this.UID = UID;
    }

    @Override
    public int getUID() {
        return UID;
    }
}
