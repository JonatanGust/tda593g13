package project;

import project.AbstractRobotSimulator;
import project.Point;

public class RobotAvatar extends AbstractRobotSimulator {

	
	public RobotAvatar(Point position, String name) {
		super(position, name);
	}
	
	public void update() {
		
	}
	
	@Override
	public String toString() {
		return "Robot " + this.getName();
	}

}
