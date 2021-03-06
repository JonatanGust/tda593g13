// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package ClassDiagram.Types;

/**
 * 
 */
public enum UpdateEventType {
	/**
	 * The data will be a Position object
	 */
	PositionUpdate,
	/**
	 * The data will be a SensorData object
	 */
	SensorUpdate,
	/**
	 * Will be used by MovementManager(s) to report a job well done to it's rover
	 */
	PointReachedUpdate,
	/**
	 *  The data will be a Fault object
	 */
	FaultUpdate;
};
