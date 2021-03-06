// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package ClassDiagram.Types;

import ClassDiagram.Types.Boundary;
import ClassDiagram.Types.Position;

/************************************************************/
/**
 * 
 */
public class CircularBoundary extends Boundary {
	/**
	 * 
	 */
	private double radius;

	/**
	 * 
	 * @param position 
	 * @return 
	 */
	public boolean contains(Position position) {
		return this.position.distanceTo(position) <= radius;
	}

	/**
	 * 
	 * @param radius 
	 * @param position 
	 */
	public CircularBoundary(double radius, Position position) {
		super(position);
		this.radius = radius;
	}

	/**
	 * 
	 * @return 
	 */
	public double getRadius() {
		return radius;
	}
};
