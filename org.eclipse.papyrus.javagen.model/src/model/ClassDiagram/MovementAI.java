// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package model.ClassDiagram;

import model.ClassDiagram.HardwareHandler;
import model.ClassDiagram.LocationManager;
import model.ClassDiagram.MovementManager;
import model.ClassDiagram.Observer;
import model.ClassDiagram.Point;

/************************************************************/
/**
 * 
 */
public class MovementAI implements MovementManager, Observer {
	/**
	 * 
	 */
	private HardwareHandler hardwareHandler;
	/**
	 * 
	 */
	public LocationManager locationmanager;

	/**
	 * 
	 * @param point 
	 */
	public void goToPoint(Point point) {
	}

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
	public void update() {
	}

	/**
	 * 
	 * @param locationManager 
	 */
	public MovementAI(LocationManager locationManager) {
	}

	@Override
	public void update(UpdateEvent updateEvent) {
		// TODO Auto-generated method stub
		
	}
};
