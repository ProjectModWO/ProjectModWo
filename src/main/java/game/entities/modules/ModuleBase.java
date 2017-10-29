package game.entities.modules;

import java.util.LinkedList;
import java.util.List;

import game.entities.Entity;
import game.entities.capabilities.modules.IModule;
import game.entities.components.PhysicsComponent;
import game.entities.components.TransformComponent;
import game.math.Vector;

public abstract class ModuleBase extends Entity implements IModule {


	private List<IModule> connectedModules = new LinkedList<>();
	private IModule parent;
	private double powerConsumption;
	
	public ModuleBase(IModule parent, TransformComponent transform, PhysicsComponent physics, double weight, double powerConsumption) {
		super(transform, physics);
		this.parent = parent;
		this.powerConsumption = powerConsumption;
	}
	
	@Override
	public List<IModule> getConnectedModules() {
		return connectedModules;
	}

	@Override
	public IModule getParent() {
		return parent;
	}

	@Override
	public double getTotalEnergyConsumption() {
		double energy = powerConsumption;
		for (IModule module : connectedModules) {
			energy += module.getTotalEnergyConsumption();
		}
		return energy;
	}
	
	@Override
	public void applyForce(Vector force) {
		parent.applyForce(force, getTransform().getPosition());
	}
	
	@Override
	public void applyForce(Vector force, Vector pos) {
		parent.applyForce(force, pos);
	}
	
	@Override
	public Vector centerOfGravity() {
		double X = getTransform().getPosition().getX1() * getPhysics().getWeight();
		double Y = getTransform().getPosition().getX2() * getPhysics().getWeight();
		
		for(IModule module : connectedModules) {
			Vector relPos = module.centerOfGravity();
			double branchMass = module.branchMass();
			X += relPos.getX1() * branchMass;
			Y += relPos.getX2() * branchMass;
		}
		
		return new Vector(X / branchMass(), Y / branchMass());
	}
	
	public double branchMass() {
		
		double toReturn = getPhysics().getWeight();
		for(IModule module : connectedModules) {
			toReturn += module.branchMass();
		}
		return toReturn;
	}
	
	public void onModuleChange() {
		
		parent.onModuleChange();
	}
	
}
