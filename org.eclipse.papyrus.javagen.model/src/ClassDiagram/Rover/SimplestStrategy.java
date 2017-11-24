// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package ClassDiagram.Rover;

import ClassDiagram.Rover.StrategyHandler;
import ClassDiagram.Types.Environment;
import ClassDiagram.Types.Mission;
import ClassDiagram.Types.Position;

/************************************************************/
/**
 * 
 */
public class SimplestStrategy implements StrategyHandler {
	
	private static SimplestStrategy myInstance = new SimplestStrategy();
	/**
	 * 
	 */
	private SimplestStrategy() {
	}
	
	public static SimplestStrategy getInstance() {
		return myInstance;
	}
	
	/**
	 * This strategy keeps the order of the points the same.
	 */
	public void chooseStrategy(Mission mission, Position position, Environment enviroment) {}
};
