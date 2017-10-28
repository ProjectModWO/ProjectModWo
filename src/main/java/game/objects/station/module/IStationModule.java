package game.objects.station.module;

import java.util.List;

import game.entities.capabilities.IMovable;
import game.entities.capabilities.IUseEnergy;

public interface IStationModule extends IMovable, IUseEnergy {
	
	public List<IStationModule> getConnectedModules();
	
	public IStationModule getParent();
	
}
