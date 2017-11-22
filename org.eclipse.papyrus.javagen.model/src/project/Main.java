package project;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import project.AbstractSimulatorMonitor;
import project.Point;
import simbad.sim.AbstractWall;
import simbad.sim.Boundary;
import simbad.sim.EnvironmentDescription;
import simbad.sim.HorizontalBoundary;
import simbad.sim.HorizontalWall;
import simbad.sim.VerticalBoundary;
import simbad.sim.VerticalWall;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		EnvironmentDescription e = new EnvironmentDescription();

		Color c = Color.GRAY;

		new HorizontalBoundary(-10.0f, -10.0f, 10.0f, e, c);
		new HorizontalBoundary(10.0f, -10.0f, 10.0f, e, c);
		new VerticalBoundary(-10.0f, -10.0f, 10.0f, e, c);
		new VerticalBoundary(10.0f, -10.0f, 10.0f, e, c);


		new HorizontalWall(5f, -5f, 5f, e, c);
		new HorizontalWall(0f, -5f, -3f, e, c);
		new HorizontalWall(0f, -2f, 2f, e, c);
		new HorizontalWall(0f, 3f, 5f, e, c);
		new HorizontalWall(-5f, -5f, 5f, e, c);

		new VerticalWall(-5f, -5f, -3f, e, c);
		new VerticalWall(-5f, -2f, 2f, e, c);
		new VerticalWall(-5f, 3f, 5f, e, c);
		new VerticalWall(0f, -5f, -3f, e, c);
		new VerticalWall(0f, -2f, 2f, e, c);
		new VerticalWall(0f, 3f, 5f, e, c);
		new VerticalWall(5f, -5f, -3f, e, c);
		new VerticalWall(5f, -2f, 2f, e, c);
		new VerticalWall(5f, 3f, 5f, e, c);


		Set<RobotAvatar> robots = new HashSet<>();

		RobotAvatar robot1 = new RobotAvatar(new Point(0, 0), "Robot 1");
		RobotAvatar robot2 = new RobotAvatar(new Point(1, 3), "Robot 2");
		RobotAvatar robot3 = new RobotAvatar(new Point(1, 0), "Robot 3");
		RobotAvatar robot4 = new RobotAvatar(new Point(2, 3), "Robot 4");

		robots.add(robot1);
		robots.add(robot2);
		robots.add(robot3);
		robots.add(robot4);
		AbstractSimulatorMonitor controller = new SimulatorMonitor(robots, e);

	}
	
}
