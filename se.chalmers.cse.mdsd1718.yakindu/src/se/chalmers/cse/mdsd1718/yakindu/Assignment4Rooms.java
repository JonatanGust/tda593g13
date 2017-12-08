package se.chalmers.cse.mdsd1718.yakindu;

import java.util.ArrayList;

// This class implements an array of Area Controllers.
// Trying to acquire access to area covered by controller
// 0 is done by calling tryAcquire(0). Releasing access
// to that area is done by calling release(0), etc.
// The code performs no error checking.
public class Assignment4Rooms {

	// Increast this constant if you need more controllers.
	private boolean locked[] = new boolean[10];
	private ArrayList<Long> indoorPermission = new ArrayList<Long>();
	
	public boolean tryAcquire(long n) {
		int m = (int) n - 1;
		if (locked[m]) {
			return false;
		} else {
			locked[m] = true;
			return true;
		}
	}

	public void release(long n) {
		int m = (int) n - 1;
		locked[m] = false;
	}
	
	public boolean tryIndoorPermission (long n) {
		if (indoorPermission.size() >= 3) {
			return false;			
		} else if (indoorPermission.contains(n)) {
			return true;			
		} else {
			indoorPermission.add(n);
			return true;
		}
	}
	
	public void releaseIndoorPermission(long n) {
		indoorPermission.remove(n);
	}
}
