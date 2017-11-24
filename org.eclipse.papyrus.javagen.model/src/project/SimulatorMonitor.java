package project;

import java.util.Set;

import ClassDiagram.CentralStation.RoverLord;
import project.AbstractSimulatorMonitor;
import simbad.sim.EnvironmentDescription;

public class SimulatorMonitor extends AbstractSimulatorMonitor<RobotAvatar> {

	RoverLord roverLord;
	
	public SimulatorMonitor( Set<? extends RobotAvatar> robots, EnvironmentDescription e, RoverLord roverLord) {
		super((Set<RobotAvatar>)robots, e);
		this.roverLord = roverLord;
	}

	@Override
	public void update(RobotAvatar robot) {
		robot.update();
		roverLord.update();
		
	}
	

}
