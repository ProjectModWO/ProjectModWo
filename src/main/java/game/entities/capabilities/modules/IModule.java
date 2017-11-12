package game.entities.capabilities.modules;

import java.util.List;

import game.entities.capabilities.IUseEnergy;
import math.Vector2d;

public interface IModule extends IUseEnergy {
	
	public List<IModule> getConnectedModules();
	
	public IModule getParent();

	void applyForce(Vector2d force, Vector2d pos);
	
	public void applyForce(Vector2d force);
	
	public void onModuleChange();
	
	public Vector2d centerOfGravity();
	
	public double branchMass();
	
	public void addConnectedModule(IModule toAdd);
	
	public void removeConnectedModule(IModule toRemove);
	
}
