package game.entities.modules;

import java.util.LinkedList;
import java.util.List;

import game.entities.Entity;
import game.entities.capabilities.modules.IModule;
import game.entities.components.PhysicsComponent;
import game.entities.components.TransformComponent;
import game.math.Vector;

public class ModuleBase extends Entity implements IModule {

	private List<IModule> connectedModules = new LinkedList<>();
	private IModule parent;
	private double powerConsumption;
	
	public ModuleBase(IModule parent, TransformComponent transform, PhysicsComponent physics, double weight, double powerConsumption) {
		super(transform, physics);
		this.parent = parent;
		this.powerConsumption = powerConsumption;
		if(parent != null) parent.addConnectedModule(this);
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
	public double getEnergyConsumption() {
		double energy = powerConsumption;
		for (IModule module : connectedModules) {
			energy += module.getEnergyConsumption();
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
		double X = getTransform().getPosition().getX1() * getPhyComp().getWeight();
		double Y = getTransform().getPosition().getX2() * getPhyComp().getWeight();
		
		for(IModule module : connectedModules) {
			Vector relPos = module.centerOfGravity();
			double branchMass = module.branchMass();
			X += relPos.getX1() * branchMass;
			Y += relPos.getX2() * branchMass;
		}
		
		return new Vector(X / branchMass(), Y / branchMass());
	}
	
	public double branchMass() {
		
		double toReturn = getPhyComp().getWeight();
		for(IModule module : connectedModules) {
			toReturn += module.branchMass();
		}
		return toReturn;
	}
	
	public void onModuleChange() {
		
		parent.onModuleChange();
	}
	
	@Override
	public void addConnectedModule(IModule toAdd) {
		connectedModules.add(toAdd);
	}
	
	@Override
	public void removeConnectedModule(IModule toRemove) {
		connectedModules.remove(toRemove);
	}
	
	@Override
	public void destroy() {
		parent.removeConnectedModule(this);
		onModuleChange();
	}

	@Override
	public PhysicsComponent getPhyComp() {
		return null;
	}

	@Override
	public void move(Vector impulse) {

	}

	@Override
	public void move(Vector force, double timeInMillis) {

	}

	@Override
	public Vector getImpulse() {
		return null;
	}
}
