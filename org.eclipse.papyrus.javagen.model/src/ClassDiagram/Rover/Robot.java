// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package ClassDiagram.Rover;

import ClassDiagram.Rover.HardwareHandler;
import ClassDiagram.Rover.Observer;
import ClassDiagram.Types.Position;
import ClassDiagram.Types.SensorData;
import java.awt.Image;
import project.RobotAvatar;

/************************************************************/
/**
 * 
 */
public class Robot extends RobotAvatar implements HardwareHandler {
	/**
	 * 
	 * @param observer 
	 */
	public void addObserver(Observer observer) {
	}

	/**
	 * 
	 * @param observer 
	 */
	public void removeObserver(Observer observer) {
	}

	/**
	 * 
	 */
	public void stop() {
	}

	/**
	 * 
	 * @param position 
	 */
	public void setDestination(Position position) {
	}

	/**
	 * 
	 * @return 
	 */
	public Image getImage() {
	}

	/**
	 * 
	 * @return 
	 */
	public Position getCurrentPosition() {
	}

	/**
	 * 
	 * @return 
	 */
	public SensorData getSensorData() {
	}

	/**
	 * 
	 * @param position 
	 * @param name 
	 */
	public void Robot(Position position, String name) {
	}
};
