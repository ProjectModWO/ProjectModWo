package game.entities.modules;

import java.util.LinkedList;
import java.util.List;

import game.math.Position;
import game.math.Vector;

public abstract class ModuleBase implements IModule {


	private List<IModule> connectedModules = new LinkedList<>();
	private IModule parent;
	private double powerConsumption;
	private Position pos;
	private double weight;
	private double speed = 0.0D;
	
	public ModuleBase(IModule parent, Position pos, double weight, double powerConsumption) {
		this.parent = parent;
		this.pos = pos;
		this.weight = weight;
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
	public double getWeight() {
		return weight;
	}
	
	@Override
	public void applyForce(Vector force) {
		parent.applyForce(force, this.pos);
	}
	
	@Override
	public void applyForce(Vector force, Position pos) {
		parent.applyForce(force, pos);
	}
	
	/*
	@Override
	public void onUpdate() {
		
	}
	*/
	@Override
	public Position centerOfGravity() {
		
		double X = pos.getX() * weight;
		double Y = pos.getY() * weight;
		
		for(IModule module : connectedModules) {
			Position relPos = module.centerOfGravity();
			double branchMass = module.branchMass();
			X += relPos.getX() * branchMass;
			Y += relPos.getY() * branchMass;
		}
		
		return new Position(X / branchMass(), Y / branchMass(), 0);
	}
	
	public double branchMass() {
		
		double toReturn = weight;
		for(IModule module : connectedModules) {
			toReturn += module.branchMass();
		}
		return toReturn;
	}
	
	
	
	

}
