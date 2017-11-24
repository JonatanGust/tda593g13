// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package ClassDiagram.Types;

import java.util.HashMap;

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
	public RoomType roomType;

	private boolean physical;
	
	static private HashMap<RoomType, Integer> rewardPointsPerType = null;
	
	/**
	 * 
	 * @param boundary 
	 * @param restricted 
	 * @param locationController 
	 * @param type 
	 * @param isPhysical 
	 */
	public Area(Boundary boundary, LocationController locationController, RoomType type,
			boolean isPhysical) {
		this.boundary = boundary;
		this.locationController = locationController;
		this.roomType = type;
		this.physical = isPhysical;
		
		if (rewardPointsPerType == null) {
			rewardPointsPerType = new HashMap<RoomType, Integer>();
			rewardPointsPerType.put(RoomType.Office, 1);
			rewardPointsPerType.put(RoomType.EatingSpace, 1);
			rewardPointsPerType.put(RoomType.TeacherRoom, 1);
			rewardPointsPerType.put(RoomType.WifiZone, 1);
		}
	}

	/**
	 * 
	 * @return 
	 */
	public Boundary getBoundary() {
		return boundary;
	}

	/**
	 * 
	 * @return 
	 */
	public LocationController getLocationController() {
		return locationController;
	}

	/**
	 * 
	 * @return 
	 */
	public boolean isPhysical() {
		return physical;
	}

	/**
	 * 
	 * @return 
	 */
	public int getRewardPoint() {
		return rewardPointsPerType.get(roomType);
	}
};
