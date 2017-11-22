// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package model.ClassDiagram;

import model.ClassDiagram.Image;
import model.ClassDiagram.Mission;
import model.ClassDiagram.Position;

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
