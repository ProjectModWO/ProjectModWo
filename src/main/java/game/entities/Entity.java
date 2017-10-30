package game.entities;

import game.entities.capabilities.IMovable;
import game.entities.components.PhysicsComponent;
import game.entities.components.TransformComponent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Entity implements IMovable{

    private TransformComponent transform;
    
    private PhysicsComponent physics;
    
    private double health;
    
    public Entity(TransformComponent transform, PhysicsComponent physics) {
    	
		this.transform = transform;
		
		this.physics = physics;
    }
    
    public void onCrash(IMovable hitter) {

        //Todo calculate impact force from the delta of the kinetic energy

    	if(health <= 0D){
    	    destroy();
        }
    }
    
    public abstract void destroy();
    
}
