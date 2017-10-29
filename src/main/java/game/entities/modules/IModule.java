package game.entities.modules;

import java.util.List;

import game.entities.capabilities.IMovable;
import game.entities.capabilities.IUseEnergy;
import game.math.Position;
import game.math.Vector;

public interface IModule extends IMovable, IUseEnergy {
	
	public List<IModule> getConnectedModules();
	
	public IModule getParent();

	public void applyForce(Vector force, Position pos);
	
	public void applyForce(Vector force);
	
	public void onModuleChange();
	
	public Position centerOfGravity();
	
	public double branchMass();
	
}
