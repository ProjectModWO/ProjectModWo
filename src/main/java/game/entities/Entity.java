package game.entities;

import game.entities.components.PhysicsComponent;
import game.entities.components.TransformComponent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Entity {

    private TransformComponent transform;
    
    private PhysicsComponent physics;
    
    public Entity(TransformComponent transform, PhysicsComponent physics) {
    	
		this.transform = transform;
		
		this.physics = physics;
    }
    
}
