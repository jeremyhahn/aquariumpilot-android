package com.aquariumpilot;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;

import com.aquariumpilot.arduino.DigitalPinValue;
import com.aquariumpilot.arduino.WeatherStationClient;

public class MainActivity extends Activity {

	Timer timer;
	public final static String EXTRA_MESSAGE = "";
	private WeatherStationClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {

    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

	        client = new WeatherStationClient();
	        pollArduinoAndSetButtonStates();
	
	        timer = new Timer();
	        timer.schedule(new PollArduinoAndSetButtonStatesTask(new WeatherStationClient()), 0,60000); // Every minute
        }
        catch(Exception e) {

        	AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        	alertDialog.setTitle("Error");
        	alertDialog.setMessage("Could not connect to the AquariumPilot system at the house.");
        	//alertDialog.setIcon(R.drawable.icon);
        	alertDialog.show();
        }
    }

    /*
    public void sendMessage(View view) {

    	Intent intent = new Intent(this, DisplayMessageActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);

        DigitalPinValue pin = client.getSocket1();
        String status = pin.equals(DigitalPinValue.HIGH) ? "ON" : "OFF";
        intent.putExtra(EXTRA_MESSAGE, status);

        startActivity(intent);
    }*/

    public void onOutlet1Clicked(View view) {

        ToggleButton button = (ToggleButton)findViewById(R.id.outlet1);

        if(button.isChecked()) {
            Log.i("Toggle", "Turning socket1 on");
            client.setSocket1(DigitalPinValue.HIGH);
        }
        else {
        	Log.i("Toggle", "Turning socket1 off");
        	client.setSocket1(DigitalPinValue.LOW);
        }
    }
    
    public void onOutlet2Clicked(View view) {

        ToggleButton button = (ToggleButton)findViewById(R.id.outlet2);

        if(button.isChecked()) {
            Log.i("Toggle", "Turning socket2 on");
            client.setSocket2(DigitalPinValue.HIGH);
        }
        else {
        	Log.i("Toggle", "Turning socket2 off");
        	client.setSocket2(DigitalPinValue.LOW);
        }
    }

    public void onOutlet3Clicked(View view) {

        ToggleButton button = (ToggleButton)findViewById(R.id.outlet3);

        if(button.isChecked()) {
            Log.i("Toggle", "Turning socket3 on");
            client.setSocket3(DigitalPinValue.HIGH);
        }
        else {
        	Log.i("Toggle", "Turning socket3 off");
        	client.setSocket3(DigitalPinValue.LOW);
        }
    }
    
    public void onOutlet4Clicked(View view) {

        ToggleButton button = (ToggleButton)findViewById(R.id.outlet4);

        if(button.isChecked()) {
            Log.i("Toggle", "Turning socket4 on");
            client.setSocket4(DigitalPinValue.HIGH);
        }
        else {
        	Log.i("Toggle", "Turning socket4 off");
        	client.setSocket4(DigitalPinValue.LOW);
        }
    }
    
    public void onOutlet5Clicked(View view) {

        ToggleButton button = (ToggleButton)findViewById(R.id.outlet5);

        if(button.isChecked()) {
            Log.i("Toggle", "Turning socket5 on");
            client.setSocket5(DigitalPinValue.HIGH);
        }
        else {
        	Log.i("Toggle", "Turning socket5 off");
        	client.setSocket5(DigitalPinValue.LOW);
        }
    }
    
    public void onOutlet6Clicked(View view) {

        ToggleButton button = (ToggleButton)findViewById(R.id.outlet6);

        if(button.isChecked()) {
            Log.i("Toggle", "Turning socket6 on");
            client.setSocket6(DigitalPinValue.HIGH);
        }
        else {
        	Log.i("Toggle", "Turning socket6 off");
        	client.setSocket6(DigitalPinValue.LOW);
        }
    }
    
    public void onOutlet7Clicked(View view) {

        ToggleButton button = (ToggleButton)findViewById(R.id.outlet7);

        if(button.isChecked()) {
            Log.i("Toggle", "Turning socket7 on");
            client.setSocket7(DigitalPinValue.HIGH);
        }
        else {
        	Log.i("Toggle", "Turning socket7 off");
        	client.setSocket7(DigitalPinValue.LOW);
        }
    }
    
    public void onOutlet8Clicked(View view) {

        ToggleButton button = (ToggleButton)findViewById(R.id.outlet8);

        if(button.isChecked()) {
            Log.i("Toggle", "Turning socket8 on");
            client.setSocket8(DigitalPinValue.HIGH);
        }
        else {
        	Log.i("Toggle", "Turning socket8 off");
        	client.setSocket8(DigitalPinValue.LOW);
        }
    }

    public void onRoDiAquariumClicked(View view) {

        ToggleButton button = (ToggleButton)findViewById(R.id.rodiAquarium);

        if(button.isChecked()) {
            Log.i("Toggle", "Turning RO/DI -> aquarium solenoid on");
            client.setRoDiAquariumSolenoid(DigitalPinValue.HIGH);
        }
        else {
        	Log.i("Toggle", "Turning RO/DI -> aquarium solenoid off");
        	client.setRoDiAquariumSolenoid(DigitalPinValue.LOW);
        }
    }
    
    public void onRoDiReservoirClicked(View view) {

        ToggleButton button = (ToggleButton)findViewById(R.id.rodiReservoir);

        if(button.isChecked()) {
            Log.i("Toggle", "Turning RO/DI -> saltwater reservoir solenoid on");
            client.setRoDiReservoirSolenoid(DigitalPinValue.HIGH);
        }
        else {
        	Log.i("Toggle", "Turning RO/DI -> saltwater reservoir solenoid off");
        	client.setRoDiReservoirSolenoid(DigitalPinValue.LOW);
        }
    }
    
    public void onAquariumDrainClicked(View view) {

        ToggleButton button = (ToggleButton)findViewById(R.id.aquariumDrain);

        if(button.isChecked()) {
            Log.i("Toggle", "Turning aquarium drain solenoid on");
            client.setAquariumDrainSolenoid(DigitalPinValue.HIGH);
        }
        else {
        	Log.i("Toggle", "Turning aquarium drain solenoid off");
        	client.setAquariumDrainSolenoid(DigitalPinValue.LOW);
        }
    }

    private void pollArduinoAndSetButtonStates() {
    	
    	if(client.getSocket1().equals(DigitalPinValue.HIGH))
        	((ToggleButton)findViewById(R.id.outlet1)).toggle();
        
        if(client.getSocket2().equals(DigitalPinValue.HIGH))
        	((ToggleButton)findViewById(R.id.outlet2)).toggle();
        
        if(client.getSocket3().equals(DigitalPinValue.HIGH))
        	((ToggleButton)findViewById(R.id.outlet3)).toggle();
        
        if(client.getSocket4().equals(DigitalPinValue.HIGH))
        	((ToggleButton)findViewById(R.id.outlet4)).toggle();
        
        if(client.getSocket5().equals(DigitalPinValue.HIGH))
        	((ToggleButton)findViewById(R.id.outlet5)).toggle();
        
        if(client.getSocket6().equals(DigitalPinValue.HIGH))
        	((ToggleButton)findViewById(R.id.outlet6)).toggle();
        
        if(client.getSocket7().equals(DigitalPinValue.HIGH))
        	((ToggleButton)findViewById(R.id.outlet7)).toggle();
        
        if(client.getSocket8().equals(DigitalPinValue.HIGH))
        	((ToggleButton)findViewById(R.id.outlet8)).toggle();
        
        if(client.getRoDiAquariumSolenoid().equals(DigitalPinValue.HIGH))
        	((ToggleButton)findViewById(R.id.rodiAquarium)).toggle();

        if(client.getRoDiReservoirSolenoid().equals(DigitalPinValue.HIGH))
        	((ToggleButton)findViewById(R.id.rodiReservoir)).toggle();

        if(client.getAquariumDrainSolenoid().equals(DigitalPinValue.HIGH))
        	((ToggleButton)findViewById(R.id.aquariumDrain)).toggle();
    }

    class PollArduinoAndSetButtonStatesTask extends TimerTask {

    	private WeatherStationClient client;

    	public PollArduinoAndSetButtonStatesTask(WeatherStationClient client) {
    		this.client = client;
    	}

    	@Override
    	public void run() {

    		MainActivity.this.runOnUiThread(new Runnable() {

    			@Override
    			public void run() {

		        	((ToggleButton)findViewById(R.id.outlet1)).setChecked(client.getSocket1().equals(DigitalPinValue.HIGH));
		        	((ToggleButton)findViewById(R.id.outlet2)).setChecked(client.getSocket2().equals(DigitalPinValue.HIGH));
		        	((ToggleButton)findViewById(R.id.outlet3)).setChecked(client.getSocket3().equals(DigitalPinValue.HIGH));
		        	((ToggleButton)findViewById(R.id.outlet4)).setChecked(client.getSocket4().equals(DigitalPinValue.HIGH));
		        	((ToggleButton)findViewById(R.id.outlet5)).setChecked(client.getSocket5().equals(DigitalPinValue.HIGH));
		        	((ToggleButton)findViewById(R.id.outlet6)).setChecked(client.getSocket6().equals(DigitalPinValue.HIGH));
		        	((ToggleButton)findViewById(R.id.outlet7)).setChecked(client.getSocket7().equals(DigitalPinValue.HIGH));
		        	((ToggleButton)findViewById(R.id.outlet8)).setChecked(client.getSocket8().equals(DigitalPinValue.HIGH));
		        	((ToggleButton)findViewById(R.id.rodiAquarium)).setChecked(client.getRoDiAquariumSolenoid().equals(DigitalPinValue.HIGH));
		        	((ToggleButton)findViewById(R.id.rodiReservoir)).setChecked(client.getRoDiReservoirSolenoid().equals(DigitalPinValue.HIGH));
		        	((ToggleButton)findViewById(R.id.aquariumDrain)).setChecked(client.getAquariumDrainSolenoid().equals(DigitalPinValue.HIGH));
    			}
    		});
    	}
    }
}