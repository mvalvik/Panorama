package com.example.panorama;

import android.os.Bundle;
import android.app.Activity;
import android.hardware.Camera;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class PanoramaActivity extends Activity {

	private Camera mCamera;
	private CameraPreview mPreview;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panorama);
        
        mCamera = getCameraInstance();
        mPreview = new CameraPreview(this, mCamera);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.camera_preview);
        frameLayout.addView(mPreview);
        
        RelativeLayout relativeLayoutControl = (RelativeLayout) findViewById(R.id.controls_layout);
        relativeLayoutControl.bringToFront();
        
        RelativeLayout relativeLayoutSensorsData = (RelativeLayout) findViewById(R.id.sensors_data_layout);
        relativeLayoutSensorsData.bringToFront();
        
    }

    private Camera getCameraInstance() {
		Camera c = null;
		try{
			c = Camera.open();
		}
		catch(Exception e){
			
		}
		return c;
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_panorama, menu);
        return true;
    }
	
	public void logSensorData(View view){
		Toast.makeText(getApplicationContext(), "Logged", Toast.LENGTH_SHORT).show();
	}
    
}
