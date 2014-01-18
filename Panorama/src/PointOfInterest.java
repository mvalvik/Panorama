import android.location.Location;

// Class representing a point of interest
public class PointOfInterest {
	
	// Constructor
	public PointOfInterest(Location loc){
		m_Location = loc;
	}
	
	// Is visible from camera location
	public Boolean IsVisible(PhoneLocation PhoneLoc, 
			                 HeightCurve HCurve){
		
		Boolean bRetVal = false;
		
		// Obtain the current height
		double PhoneHeight = PhoneLoc.m_CurrentLocation.getAltitude();
		
		// Check if phone and poi is too far from each other
		float [] dist = new float[1];
		Location.distanceBetween(m_Location.getLatitude(), 
				                 m_Location.getLongitude(), 
				                 PhoneLoc.m_CurrentLocation.getLatitude(), 
				                 PhoneLoc.m_CurrentLocation.getLongitude(), 
				                 dist);
		
		
		// Check for collision with height curve
		for (int i=0; i<HCurve.NumberOfElements; i++){
			if (HCurve.Heights[i]>PhoneHeight){
				bRetVal = true;
			}
		}
		
		return bRetVal;
	}
	
	// Members
	Location m_Location;
	POISource m_Source;
	
	
}
