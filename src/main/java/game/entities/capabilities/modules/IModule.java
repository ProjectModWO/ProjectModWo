package game.entities.capabilities.modules;

import java.util.List;

import game.entities.capabilities.IUseEnergy;
import game.math.Vector;

public interface IModule extends IUseEnergy {
	
	public List<IModule> getConnectedModules();
	
	public IModule getParent();

	void applyForce(Vector force, Vector pos);
	
	public void applyForce(Vector force);
	
	public void onModuleChange();
	
	public Vector centerOfGravity();
	
	public double branchMass();
	
	public void addConnectedModule(IModule toAdd);
	
	public void removeConnectedModule(IModule toRemove);
	
}
