package game.entities.capabilities.modules;

import java.util.List;

import game.entities.capabilities.IUseEnergy;
import math.Vector2f;

public interface IModule extends IUseEnergy {
	
	public List<IModule> getConnectedModules();
	
	public IModule getParent();

	void applyForce(Vector2f force, Vector2f pos);
	
	public void applyForce(Vector2f force);
	
	public void onModuleChange();
	
	public Vector2f centerOfGravity();
	
	public double branchMass();
	
	public void addConnectedModule(IModule toAdd);
	
	public void removeConnectedModule(IModule toRemove);
	
}
