// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package ClassDiagram.CentralStation;

import ClassDiagram.Rover.RoverCommunicator;
import ClassDiagram.Types.Area;
import ClassDiagram.Types.Environment;

/************************************************************/
/**
 * 
 */
public class RewardPointsCalculator {
	/**
	 * 
	 */
	private int rewardPoints = 0;
	private boolean wasProcedureA = true;

	/**
	 * 
	 * @param environment 
	 * @param roverCommunicators 
	 */
	public void calculateRewardPoints(Environment environment, RoverCommunicator[] roverCommunicators) {
		boolean inPhysical = false;
		boolean inLogical = false;
		int physicalPoints = 0;
		int logicalPoints = 0;
		for (RoverCommunicator rc : roverCommunicators) {
			for (Area a : environment.getAreas()) {
				if (a.isPhysical() && a.getBoundary().contains(rc.getPosition())) {
					physicalPoints += a.getRewardPoint();
					inPhysical = true;		
				}
				if (!a.isPhysical() && a.getBoundary().contains(rc.getPosition())) {
					logicalPoints += a.getRewardPoint();
					inLogical = true;		
				}
			}
		}
		if ((wasProcedureA && inLogical) || (!wasProcedureA && !inPhysical)) {
			rewardPoints += logicalPoints;
			wasProcedureA = false;
		} else {
			rewardPoints += physicalPoints;
			wasProcedureA = true;
		}
	}

	/**
	 * 
	 * @return 
	 */
	public int getRewardPoints() {
		return rewardPoints;
	}

	/**
	 * 
	 */
	public RewardPointsCalculator() {
	}
};
