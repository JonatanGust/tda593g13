package project;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import project.AbstractSimulatorMonitor;
import project.Point;
import ClassDiagram.CentralStation.RoverLord;
import ClassDiagram.Types.*;
import ClassDiagram.Rover.RoverCommunicator;

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


		new VerticalWall(5f, -5f, 5f, e, c);
		new VerticalWall(0f, -5f, -3f, e, c);
		new VerticalWall(0f, -2f, 2f, e, c);
		new VerticalWall(0f, 3f, 5f, e, c);
		new VerticalWall(-5f, -5f, 5f, e, c);
		
		new HorizontalWall(-5f, -5f, -3f, e, c);
		new HorizontalWall(-5f, -2f, 2f, e, c);
		new HorizontalWall(-5f, 3f, 5f, e, c);
		new HorizontalWall(0f, -5f, -3f, e, c);
		new HorizontalWall(0f, -2f, 2f, e, c);
		new HorizontalWall(0f, 3f, 5f, e, c);
		new HorizontalWall(5f, -5f, -3f, e, c);
		new HorizontalWall(5f, -2f, 2f, e, c);
		new HorizontalWall(5f, 3f, 5f, e, c);
		
		Area[] areas = new Area[4];

		areas[0] = new Area(
				new Boundary(5, 5, new Position(0, 0)), 
				true, 
				new LocationController(new Point(2.5, 2.5), 2.5, e)
			);
		areas[1] = new Area(
				new Boundary(5, -5, new Position(0, 0)), 
				true, 
				new LocationController(new Point(2.5, -2.5), 2.5, e)
			);
		areas[2] = new Area(
				new Boundary(-5, -5, new Position(0, 0)), 
				true, 
				new LocationController(new Point(-2.5, -2.5), 2.5, e)
			);
		areas[3] = new Area(
				new Boundary(-5, 5, new Position(0, 0)), 
				true, 
				new LocationController(new Point(-2.5, 2.5), 2.5, e)
			);

		Environment env = new Environment(areas);

		Set<RobotAvatar> robots = new HashSet<>();

		RobotAvatar robot1 = new RobotAvatar(new Point(7, -1.5), "Robot 1");
		RobotAvatar robot2 = new RobotAvatar(new Point(7, -0.5), "Robot 2");
		RobotAvatar robot3 = new RobotAvatar(new Point(7, 0.5), "Robot 3");
		RobotAvatar robot4 = new RobotAvatar(new Point(7, 1.5), "Robot 4");

		robots.add(robot1);
		robots.add(robot2);
		robots.add(robot3);
		robots.add(robot4);
		AbstractSimulatorMonitor controller = new SimulatorMonitor(robots, e);
		
		RoverLord roverLord = new RoverLord(env, robots.toArray(new RoverCommunicator[robots.size()]));
	}
	
}
