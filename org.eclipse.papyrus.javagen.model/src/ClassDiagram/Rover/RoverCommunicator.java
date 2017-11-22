// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package ClassDiagram.Rover;

import ClassDiagram.Types.Mission;
import ClassDiagram.Types.Position;
import java.awt.Image;

/************************************************************/
/**
 * 
 */
public interface RoverCommunicator {
	/**
	 * 
	 * @param mission 
	 */
	public void changeMission(Mission mission);

	/**
	 * 
	 */
	public void abortMission();

	/**
	 * 
	 * @return 
	 */
	public Position getPosition();

	/**
	 * 
	 * @return 
	 */
	public Image getImage();

	/**
	 * 
	 * @return 
	 */
	public boolean getOperationalStatus();

	/**
	 * 
	 * @return 
	 */
	public Mission getMissionStatus();
};
