// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package ClassDiagram.Rover;

import ClassDiagram.Rover.HardwareHandler;
import ClassDiagram.Rover.Observer;
import ClassDiagram.Types.Position;
import ClassDiagram.Types.SensorData;
import ClassDiagram.Types.UpdateEvent;
import ClassDiagram.Types.UpdateEventType;

import java.awt.Image;
import java.io.Console;
import java.util.LinkedList;

import project.Point;
import project.RobotAvatar;
import simbad.sim.RangeSensorBelt;

/************************************************************/
/**
 * 
 */
public class Robot extends RobotAvatar implements HardwareHandler {
	private RangeSensorBelt sonars;
	private LinkedList<Observer> observers;
	
	private SensorData lastSensorData;
	private Position lastPosition;
	
	/**
	 * 
	 * @param observer 
	 */
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	/**
	 * 
	 * @param observer 
	 */
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	/**
	 * 
	 */
	public void stop() {
		setDestination(getPosition());
	}

	/**
	 * 
	 * @param position 
	 */
	public void setDestination(Position position) {
		setDestination(new Point(position.x, position.z));
	}

	/**
	 * 
	 * @return 
	 */
	public Image getImage() {
		return null;
	}

	/**
	 * 
	 * @return 
	 */
	public Position getCurrentPosition() {
		return new Position(getPosition().getX(), getPosition().getZ());
	}

	/**
	 * 
	 * @return 
	 */
	public SensorData getSensorData() {
		
		SensorData sensorData = new SensorData(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,
				Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		if (sonars.getFrontQuadrantHits() > 0) {
			// Front quadrant measurement has a flawed implementation, needs special case:
			double rightPortion = sonars.getQuadrantMeasurement(0, Math.PI / 4);
			double leftPortion = sonars.getQuadrantMeasurement(7*Math.PI / 4, Math.PI * 2);

			int validValues = 
					(Double.isInfinite(rightPortion) ? 0 : 1) +
					(Double.isInfinite(leftPortion) ? 0 : 1);
					
			if(validValues == 0) 
			{
				sensorData.frontDistance = Double.POSITIVE_INFINITY;
			}
			
			else
			{
				double avg = 
						(Double.isInfinite(rightPortion) ? 0 : rightPortion) +
						(Double.isInfinite(leftPortion) ? 0 : leftPortion);
				
				sensorData.frontDistance = avg / validValues;
			}
		}
		if (sonars.getRightQuadrantHits() > 0) {
			sensorData.rightDistance = sonars.getRightQuadrantMeasurement();
		}
		if (sonars.getBackQuadrantHits() > 0) {
			sensorData.backDistance = sonars.getBackQuadrantMeasurement();
		}
		if (sonars.getLeftQuadrantHits() > 0) {
			sensorData.leftDistance = sonars.getLeftQuadrantMeasurement();
		}
		
		return sensorData;
	}

	/**
	 * 
	 * @param position 
	 * @param name 
	 */
	public Robot(Position position, String name) {
		super(new Point(position.x, position.z), name);
		
		this.observers = new LinkedList<Observer>();
		
		for (Object o : this.getAgent().getSensorList()) {
			RangeSensorBelt b = (RangeSensorBelt)o;
			
			if (b.getName().equals("sonars")) {
				this.sonars = b;
				this.sonars.setUpdateOnEachFrame(true);
			}
		}
	}
	
	@Override
	public void update() {
		super.update();
		
		SensorData currentSensorData = getSensorData();
		Position currentPosition = getCurrentPosition();
		
		//if (!currentPosition.equals(lastPosition)) {
			for (Observer obs : observers) {
				obs.update(new UpdateEvent(UpdateEventType.PositionUpdate, currentPosition));
			}
			lastPosition = currentPosition;
		//}
		
		if (!currentSensorData.equals(lastSensorData)) {
			for (Observer obs : observers) {
				obs.update(new UpdateEvent(UpdateEventType.SensorUpdate, currentSensorData));
			}
			lastSensorData = currentSensorData;
		}
	}
};
