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
    
    private double health;
    
    public Entity(TransformComponent transform, PhysicsComponent physics) {
    	
		this.transform = transform;
		
		this.physics = physics;
    }
    
    public void onHit(PhysicsComponent hitter) {
    	//TODO does this make sense???
    	health -= (physics.getImpulse() - hitter.getImpulse()).abs();
    	if(health <= 0D) onDestroy();
    }
    
    public abstract void onDestroy();
    
}
