// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package model.ClassDiagram;

import model.ClassDiagram.Observer;

/************************************************************/
/**
 * 
 */
public interface Observable {
	/**
	 * 
	 * @param observer 
	 */
	public void addObserver(Observer observer);

	/**
	 * 
	 * @param observer 
	 */
	public void removeObserver(Observer observer);
};