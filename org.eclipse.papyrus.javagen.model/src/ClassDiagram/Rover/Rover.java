// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package ClassDiagram.Rover;

import ClassDiagram.Rover.HardwareHandler;
import ClassDiagram.Rover.MovementAI;
import ClassDiagram.Rover.MovementManager;
import ClassDiagram.Rover.Observer;
import ClassDiagram.Rover.RoverCommunicator;
import ClassDiagram.Rover.StrategyHandler;
import ClassDiagram.Types.Environment;
import ClassDiagram.Types.Fault;
import ClassDiagram.Types.Mission;
import ClassDiagram.Types.Position;
import ClassDiagram.Types.Point;
import ClassDiagram.Types.UpdateEvent;
import ClassDiagram.Types.UpdateEventType;
import java.awt.Image;

/************************************************************/
/**
 * 
 */
public class Rover implements RoverCommunicator, Observer {

	private StrategyHandler strategyHandler;

	private MovementManager movementManager;

	private HardwareHandler hardwareHandler;

	private Mission mission;
	
	private Environment environment;
	
	private boolean operational = true;
	
	/**
	 * Chooses strategy for and sets the mission as active
	 * @param mission 
	 */
	public void changeMission(Mission mission) {
		strategyHandler.chooseStrategy(mission, hardwareHandler.getCurrentPosition(), environment);
		this.mission = mission;
		movementManager.goToPoint(mission.getRemainingPoints().get(0));
	}

	/**
	 * @return Current position of the rover
	 */
	public Position getPosition() { return hardwareHandler.getCurrentPosition(); }

	/**
	 * @return Image from rover
	 */
	public Image getImage() { return hardwareHandler.getImage(); }

	/**
	 * @return 
	 */
	public boolean getOperationalStatus() {
		return operational;
	}

	/**
	 * 
	 * @return 
	 */
	public Mission getMissionStatus() {
		return mission;
	}

	/**
	 * 
	 */
	public void abortMission() {
		mission = null; 
		//TODO movementManager.stop(); ?
		movementManager.goToPoint(new Point(hardwareHandler.getCurrentPosition()));
	}

	/**
	 * 
	 * @param fault 
	 */
	private void handleFault(Fault fault) {
		operational = false;
		//TODO movementManager.stop(); ?
		movementManager.goToPoint(new Point(hardwareHandler.getCurrentPosition()));
	}

	/**
	 * 
	 * @param position 
	 * @param name 
	 * @param environment 
	 */
	public Rover( HardwareHandler hardwareHandler, Environment environment, StrategyHandler strategy) {
		this.hardwareHandler = hardwareHandler;
		hardwareHandler.addObserver(this);
		this.environment = environment;
		movementManager = new MovementAI(environment, hardwareHandler);
		movementManager.addObserver(this);
		strategyHandler = strategy;
	}

	/**
	 * 
	 * @param updateEvent 
	 */
	public void update(UpdateEvent updateEvent) {
		if(updateEvent == null){}
		else if(updateEvent.type == UpdateEventType.PointReachedUpdate){
			if(updateEvent.data != null) {
				mission.setPointFinished((Point)updateEvent.data);//casting is fine
				if(!mission.isFinished()) {
					movementManager.goToPoint(mission.getRemainingPoints().get(0));
				}
			}
		} else if(updateEvent.type == UpdateEventType.FaultUpdate) {
			if(updateEvent.data != null) {
				handleFault((Fault)updateEvent.data);
			}
		}
		//TODO add more handlings
	}
};
