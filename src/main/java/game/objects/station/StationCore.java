package game.objects.station;

import game.objects.station.module.StationModuleBase;

import game.physics.Position;
import game.utils.Vector;

public class StationCore extends StationModuleBase{

	private static final double WEIGHT = 1.0D;
	private static final double BASE_POWER_CONSUMPTION = 1.0D;
	
	private static Position pos;
	
	public StationCore(Position pos) {
		super(null, pos, WEIGHT, BASE_POWER_CONSUMPTION);
	}
	
	

}
