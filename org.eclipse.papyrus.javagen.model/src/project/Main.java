package project;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import project.AbstractSimulatorMonitor;
import ClassDiagram.CentralStation.RoverLord;
import ClassDiagram.Types.*;
import ClassDiagram.Ui.RoverView;
import ClassDiagram.Rover.Robot;
import ClassDiagram.Rover.Rover;
import ClassDiagram.Rover.SimplestStrategy;
import simbad.sim.EnvironmentDescription;
import simbad.sim.HorizontalBoundary;
import simbad.sim.HorizontalWall;
import simbad.sim.VerticalBoundary;
import simbad.sim.VerticalWall;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		mission2();
	}
	public static void mission1() {
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
				new LocationController(new Point(2.5, 2.5), 2.75, e), "Office", false, 1
			);
		areas[1] = new Area(
				new Boundary(5, 5, new Position(0, -5)), 
				new LocationController(new Point(2.5, -2.5), 2.75, e), "Office", false, 1
			);
		areas[2] = new Area(
				new Boundary(5, 5, new Position(-5, -5)), 
				new LocationController(new Point(-2.5, -2.5), 2.75, e), "Office", false, 1
			);
		areas[3] = new Area(
				new Boundary(5, 5, new Position(-5, 0)), 
				new LocationController(new Point(-2.5, 2.5), 2.75, e), "Office", false, 1
			);

		Environment env = new Environment(areas);

		ArrayList<Robot> robots = new ArrayList<>();

		Robot robot1 = new Robot(new Position(-7.5, -2.5), "Robot 1");
		Robot robot2 = new Robot(new Position(7.5, -2.5), "Robot 2");
		Robot robot3 = new Robot(new Position(7.5, 2.5), "Robot 3");
		Robot robot4 = new Robot(new Position(-7.5, 2.5), "Robot 4");

		robots.add(robot1);
		robots.add(robot2);
		robots.add(robot3);
		robots.add(robot4);

		
				
		ArrayList<Rover> rovers = new ArrayList<Rover>(4);
		
		for (Robot r : robots) {
			rovers.add(new Rover(r, env, SimplestStrategy.getInstance()));
		}
		RoverLord roverLord = new RoverLord(env, rovers.toArray( new Rover[4] ));
		
		RoverView roverView = new RoverView(roverLord, roverLord);
		
		
		AbstractSimulatorMonitor controller = new SimulatorMonitor(new HashSet<Robot>(robots), e, roverLord);
		
		ArrayList<ClassDiagram.Types.Point> misP1 = new ArrayList<ClassDiagram.Types.Point>();
		misP1.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(-2.5, -2.5)));
		misP1.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(2.5, -2.5)));
		misP1.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(7.5, -2.5)));
		
		ArrayList<ClassDiagram.Types.Point> misP2 = new ArrayList<ClassDiagram.Types.Point>();
		misP2.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(2.5, -2.5)));
		misP2.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(2.5, 2.5)));
		misP2.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(7.5, 2.5)));
		
		
		ArrayList<ClassDiagram.Types.Point> misP3 = new ArrayList<ClassDiagram.Types.Point>();
		misP3.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(2.5, 2.5)));
		misP3.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(-2.5, 2.5)));
		misP3.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(-7.5, 2.5)));
		
		ArrayList<ClassDiagram.Types.Point> misP4 = new ArrayList<ClassDiagram.Types.Point>();
		misP4.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(-2.5, 2.5)));
		misP4.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(-2.5, -2.5)));
		misP4.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(-7.5, -2.5)));
		
		rovers.get(0).changeMission(new Mission(misP1));
		rovers.get(1).changeMission(new Mission(misP2));
		rovers.get(2).changeMission(new Mission(misP3));
		rovers.get(3).changeMission(new Mission(misP4));
	}

	public static void mission2() {

		EnvironmentDescription e = new EnvironmentDescription();
		
		Color blue = Color.BLUE;
		Color red = Color.RED;
		Color gray = Color.GRAY;

		new HorizontalBoundary(-10.0f, -10.0f, 10.0f, e, gray);
		new HorizontalBoundary(10.0f, -10.0f, 10.0f, e, gray);
		new VerticalBoundary(-10.0f, -10.0f, 10.0f, e, gray);
		new VerticalBoundary(10.0f, -10.0f, 10.0f, e, gray);


		new VerticalWall(-7.5f, -10.0f, 10.0f, e, red);
		new VerticalWall(-2.5f, -10.0f, -8.5f, e, red);
		new VerticalWall(-2.5f, -6.5f, -3.5f, e, red);
		new VerticalWall(-2.5f, -1.5f, 1.5f, e, red);
		new VerticalWall(-2.5f, 3.5f, 6.5f, e, red);
		new VerticalWall(-2.5f, 8.5f, 10.0f, e, red);

		new HorizontalWall(-5.0f, -7.5f, -2.5f, e, red);
		new HorizontalWall(0.0f, -7.5f, -2.5f, e, red);
		new HorizontalWall(5.0f, -7.5f, -2.5f, e, red);

		new VerticalWall(2.5f, -5.15f, -3.5f, e, blue);
		new VerticalWall(2.5f, -1.5f, 0.15f, e, blue);
		new VerticalWall(7.5f, -5.15f, -3.5f, e, blue);
		new VerticalWall(7.5f, -1.5f, 0.15f, e, blue);

		new HorizontalWall(-5.0f, 2.4f, 4.0f, e, blue);
		new HorizontalWall(-5.0f, 6.0f, 7.6f, e, blue);
		new HorizontalWall(0.0f, 2.4f, 4.0f, e, blue);
		new HorizontalWall(0.0f, 6.0f, 7.6f, e, blue);

		Area[] areas = new Area[5];

		areas[0] = new Area(
				new Boundary(5, 5, new Position(-10.0, -7.5)),
				new LocationController(new Point(-7.5, -5.0), 2.75, e), "Surgery", false, 2
			);

		areas[1] = new Area(
				new Boundary(5, 5, new Position(-5.0, -7.5)),
				new LocationController(new Point(-2.5, -5.0), 2.75, e), "Surgery", false, 2
			);

		areas[2] = new Area(
				new Boundary(5, 5, new Position(0.0, -7.5)),
				new LocationController(new Point(2.5, -5.0), 2.75, e), "Surgery", false, 2
			);

		areas[3] = new Area(
				new Boundary(5, 5, new Position(5.0, -7.5)),
				new LocationController(new Point(7.5, -5.0), 2.75, e), "Surgery", false, 2
			);

		areas[4] = new Area(
				new Boundary(5, 5, new Position(-5.0, 2.5)),
				new LocationController(new Point(-2.5, 5.0), 2.75, e), "Surgery", false, 2
			);


		Environment env = new Environment(areas);

		ArrayList<Robot> robots = new ArrayList<>();

		Robot robot1 = new Robot(new Position(-7.5, -5.0), "Robot 1");
		Robot robot2 = new Robot(new Position(-2.5, -5.0), "Robot 2");
		Robot robot3 = new Robot(new Position(2.5, -5.0), "Robot 3");
		Robot robot4 = new Robot(new Position(7.5, -5.0), "Robot 4");

		robots.add(robot1);
		robots.add(robot2);
		robots.add(robot3);
		robots.add(robot4);



		ArrayList<Rover> rovers = new ArrayList<Rover>(4);

		for (Robot r : robots) {
			rovers.add(new Rover(r, env, SimplestStrategy.getInstance()));
		}
		RoverLord roverLord = new RoverLord(env, rovers.toArray( new Rover[4] ));

		RoverView roverView = new RoverView(roverLord, roverLord);


		AbstractSimulatorMonitor controller = new SimulatorMonitor(new HashSet<Robot>(robots), e, roverLord);

		ArrayList<ClassDiagram.Types.Point> misP1 = new ArrayList<ClassDiagram.Types.Point>();
		misP1.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(-7.5, 5.0)));
		misP1.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(-2.5, 5.0)));
		misP1.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(-2.5, 0.0)));
		misP1.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(-7.5, 0.0)));
		misP1.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(-7.5, -5.0)));

		ArrayList<ClassDiagram.Types.Point> misP2 = new ArrayList<ClassDiagram.Types.Point>();
		misP2.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(-2.5, 5.0)));
		misP2.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(-2.5, -5.0)));


		ArrayList<ClassDiagram.Types.Point> misP3 = new ArrayList<ClassDiagram.Types.Point>();
		misP3.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(2.5, 5.0)));
		misP3.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(-2.5, 5.0)));
		misP3.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(-2.5, 0.0)));
		misP3.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(2.5, 0.0)));
		misP3.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(2.5, -5.0)));

		ArrayList<ClassDiagram.Types.Point> misP4 = new ArrayList<ClassDiagram.Types.Point>();
		misP4.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(7.5, 5.0)));
		misP4.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(-2.5, 5.0)));
		misP4.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(7.5, 5.0)));
		misP4.add(new ClassDiagram.Types.Point(new ClassDiagram.Types.Position(7.5, -5.0)));

		rovers.get(0).changeMission(new Mission(misP1));
		rovers.get(1).changeMission(new Mission(misP2));
		rovers.get(2).changeMission(new Mission(misP3));
		rovers.get(3).changeMission(new Mission(misP4));
	}
}
