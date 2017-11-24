package project;

import java.util.Set;

import project.AbstractSimulatorMonitor;
import simbad.sim.EnvironmentDescription;

public class SimulatorMonitor extends AbstractSimulatorMonitor<RobotAvatar> {

	public SimulatorMonitor( Set<? extends RobotAvatar> robots, EnvironmentDescription e) {
		super((Set<RobotAvatar>)robots, e);
	}

	@Override
	public void update(RobotAvatar robot) {
		robot.update();
	}

}
