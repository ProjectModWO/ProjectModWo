package game.entities;

import game.entities.capabilities.ITickable;
import game.entities.components.PhysicsComponent;
import game.entities.components.TransformComponent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Entity implements ITickable {

    private TransformComponent transform;
    
    private PhysicsComponent physics;
    
    public Entity(TransformComponent transform, PhysicsComponent physics) {
    	
		this.transform = transform;
		
		this.physics = physics;
    }
}
