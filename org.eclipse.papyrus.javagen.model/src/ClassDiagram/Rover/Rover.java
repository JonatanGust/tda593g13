// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package ClassDiagram.Rover;

import ClassDiagram.Rover.HardwareHandler;
import ClassDiagram.Rover.MovementAI;
import ClassDiagram.Rover.MovementManager;
import ClassDiagram.Rover.Observer;
import ClassDiagram.Rover.Robot;
import ClassDiagram.Rover.RoverCommunicator;
import ClassDiagram.Rover.SimpleStrategy;
import ClassDiagram.Rover.StrategyHandler;
import ClassDiagram.Types.Environment;
import ClassDiagram.Types.Fault;
import ClassDiagram.Types.Mission;
import ClassDiagram.Types.Position;
import ClassDiagram.Types.UpdateEvent;
import java.awt.Image;

/************************************************************/
/**
 * 
 */
public class Rover implements RoverCommunicator, Observer {
	/**
	 * 
	 */
	private StrategyHandler strategyHandler;
	/**
	 * 
	 */
	private MovementManager movementmanager;
	/**
	 * 
	 */
	private HardwareHandler hardwareHandler;

	/**
	 * 
	 * @param mission 
	 */
	public void changeMission(Mission mission) {
	}

	/**
	 * 
	 * @return 
	 */
	public Position getPosition() {
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
	public boolean getOperationalStatus() {
	}

	/**
	 * 
	 * @return 
	 */
	public Mission getMissionStatus() {
	}

	/**
	 * 
	 */
	public void abortMission() {
	}

	/**
	 * 
	 * @param fault 
	 */
	public void handleFault(Fault fault) {
	}

	/**
	 * 
	 * @param position 
	 * @param name 
	 * @param environment 
	 */
	public void Rover(Position position, String name, Environment environment) {
	}

	/**
	 * 
	 * @param updateEvent 
	 */
	public void update(UpdateEvent updateEvent) {
	}
};
