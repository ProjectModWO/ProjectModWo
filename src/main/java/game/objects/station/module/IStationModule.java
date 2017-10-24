package game.objects.station.module;

import java.util.List;

import game.entities.capabilities.IMovable;

public interface IStationModule extends IMovable {
	
	public List<IStationModule> getConnectedModules();
	
	public IStationModule getParent();
	
}
