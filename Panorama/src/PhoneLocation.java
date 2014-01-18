import android.location.Location;

// Class representing the current location of the phone
public class PhoneLocation {
	
	// Constructor
	public PhoneLocation(Location loc){
		m_CurrentLocation = loc;
	}

	
	Location m_CurrentLocation;
}
