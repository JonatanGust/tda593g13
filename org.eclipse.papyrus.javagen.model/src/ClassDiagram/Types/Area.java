// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package ClassDiagram.Types;

import ClassDiagram.Types.Boundary;
import ClassDiagram.Types.RoomType;
import project.LocationController;

/************************************************************/
/**
 * 
 */
public class Area {
	/**
	 * 
	 */
	private Boundary boundary;
	/**
	 * 
	 */
	public LocationController locationController;
	/**
	 * 
	 */
	public RoomType roomtype;

	/**
	 * 
	 * @param boundary 
	 * @param restricted 
	 * @param locationController 
	 * @param type 
	 * @param isPhysical 
	 */
	public void Area(Boundary boundary, boolean restricted, LocationController locationController, RoomType type,
			boolean isPhysical) {
	}

	/**
	 * 
	 * @return 
	 */
	public Boundary getBoundary() {
	}

	/**
	 * 
	 * @return 
	 */
	public LocationController getLocationController() {
	}

	/**
	 * 
	 * @return 
	 */
	public boolean isPhysical() {
	}

	/**
	 * 
	 * @return 
	 */
	public int getRewardPoint() {
	}
};
