package game.objects.station.module;

import java.util.LinkedList;
import java.util.List;

import game.physics.Position;

public abstract class StationModuleBase implements IStationModule {


	private List<IStationModule> connectedModules = new LinkedList<>();
	private double powerConsumption;
	private Position pos;
	private double weight;
	private IStationModule parent;
	private double speed = 0.0D;

	
	
	public StationModuleBase(IStationModule parent, Position pos, double weight, double powerConsumption) {
		this.parent = parent;
		this.pos = pos;
		this.weight = weight;
		this.powerConsumption = powerConsumption;
	}

	
	@Override
	public List<IStationModule> getConnectedModules() {
		return connectedModules;
	}

	@Override
	public IStationModule getParent() {
		return parent;
	}

	@Override
	public double getTotalEnergyConsumption() {
		double energy = powerConsumption;
		for (IStationModule module : connectedModules) {
			energy += module.getTotalEnergyConsumption();
		}
		
		return energy;
	}
	
	@Override
	public double getWeight() {
		return weight;
	}

}
