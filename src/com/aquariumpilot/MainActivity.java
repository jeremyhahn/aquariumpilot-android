package com.aquariumpilot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.client.ClientProtocolException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;

import com.aquariumpilot.arduino.DigitalPinValue;
import com.aquariumpilot.arduino.WeatherStationClient;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "";

	private Timer timer;

	private WeatherStationClient client;

	private ToggleButton outlet1;
	private ToggleButton outlet2;
	private ToggleButton outlet3;
	private ToggleButton outlet4;
	private ToggleButton outlet5;
	private ToggleButton outlet6;
	private ToggleButton outlet7;
	private ToggleButton outlet8;
	private ToggleButton rodiAquarium;
	private ToggleButton rodiReservoir;
	private ToggleButton aquariumDrain;
	
	private UpdateButtonStatesAsyncTask updateButtonStatesAsyncTask;
	
	private ProgressDialog progressDialog;
	private AlertDialog errorDialog;

	@Override
    public void onCreate(Bundle savedInstanceState) {

    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        client = new WeatherStationClient();
        
        outlet1 = ((ToggleButton)findViewById(R.id.outlet1));
        outlet2 = ((ToggleButton)findViewById(R.id.outlet2));
        outlet3 = ((ToggleButton)findViewById(R.id.outlet3));
        outlet4 = ((ToggleButton)findViewById(R.id.outlet4));
        outlet5 = ((ToggleButton)findViewById(R.id.outlet5));
        outlet6 = ((ToggleButton)findViewById(R.id.outlet6));
        outlet7 = ((ToggleButton)findViewById(R.id.outlet7));
        outlet8 = ((ToggleButton)findViewById(R.id.outlet8));
        rodiAquarium = ((ToggleButton)findViewById(R.id.rodiAquarium));
        rodiReservoir = ((ToggleButton)findViewById(R.id.rodiReservoir));
        aquariumDrain = ((ToggleButton)findViewById(R.id.aquariumDrain));

        //updateButtonStatesAsyncTask = new UpdateButtonStatesAsyncTask();
        //updateButtonStatesAsyncTask.execute(this);

        Log.i("MainActivity.onCreate", "Complete");
	}

    @Override
    public void onResume() {
    	
    	super.onResume();

    	Log.i("MainActivity.onResume", "Executed");
    	
    	timer = new Timer();
        timer.schedule(new PollArduinoAndSetButtonStatesTask(), 0,60000); // Every minute
    }

    @Override
    public void onPause() {
    	
    	super.onPause();

    	Log.i("MainActivity.onPause", "Executed");

    	if(timer != null) {
    		
    		timer.cancel();
    		timer = null;
    	}
    }
    
    @Override
    public void onStop() {
    	
    	super.onStop();

    	Log.i("MainActivity.onStop", "Executed");

    	if(timer != null) {
    		
    		timer.cancel();
    		timer = null;
    	}
    }
    
    @Override 
    public void onDestroy() {
    	
    	super.onDestroy();

    	Log.i("MainActivity.onDestroy", "Executed");

    	if(timer != null) {
    		
    		timer.cancel();
    		timer = null;
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

    	try {
    		
    		if(outlet1.isChecked()) {
    			Log.i("Toggle", "Turning socket1 on");
    			client.setSocket1(DigitalPinValue.HIGH);
    		}
    		else {
    			Log.i("Toggle", "Turning socket1 off");
    			client.setSocket1(DigitalPinValue.LOW);
    		}
    	}
    	catch(Exception e) {
    		handleException(e);
    	}
    }
    
    public void onOutlet2Clicked(View view) {

    	try {
    		
    		if(outlet2.isChecked()) {
    			Log.i("Toggle", "Turning socket2 on");
    			client.setSocket2(DigitalPinValue.HIGH);
    		}
    		else {
    			Log.i("Toggle", "Turning socket2 off");
    			client.setSocket2(DigitalPinValue.LOW);
    		}
    	}
    	catch(Exception e) {
    		handleException(e);
    	}
    }

    public void onOutlet3Clicked(View view) {

    	try {

	        if(outlet3.isChecked()) {
	            Log.i("Toggle", "Turning socket3 on");
	            client.setSocket3(DigitalPinValue.HIGH);
	        }
	        else {
	        	Log.i("Toggle", "Turning socket3 off");
	        	client.setSocket3(DigitalPinValue.LOW);
	        }
    	}
    	catch(Exception e) {
    		handleException(e);
    	}
    }
    
    public void onOutlet4Clicked(View view) {

    	try {

	        if(outlet4.isChecked()) {
	            Log.i("Toggle", "Turning socket4 on");
	            client.setSocket4(DigitalPinValue.HIGH);
	        }
	        else {
	        	Log.i("Toggle", "Turning socket4 off");
	        	client.setSocket4(DigitalPinValue.LOW);
	        }
    	}
    	catch(Exception e) {
    		handleException(e);
    	}
    }
    
    public void onOutlet5Clicked(View view) {

    	try {

	        if(outlet5.isChecked()) {
	            Log.i("Toggle", "Turning socket5 on");
	            client.setSocket5(DigitalPinValue.HIGH);
	        }
	        else {
	        	Log.i("Toggle", "Turning socket5 off");
	        	client.setSocket5(DigitalPinValue.LOW);
	        }
    	}
    	catch(Exception e) {
    		handleException(e);
    	}
    }
    
    public void onOutlet6Clicked(View view) {

    	try {

	        if(outlet6.isChecked()) {
	            Log.i("Toggle", "Turning socket6 on");
	            client.setSocket6(DigitalPinValue.HIGH);
	        }
	        else {
	        	Log.i("Toggle", "Turning socket6 off");
	        	client.setSocket6(DigitalPinValue.LOW);
	        }
    	}
    	catch(Exception e) {
    		handleException(e);
    	}
    }
    
    public void onOutlet7Clicked(View view) {

    	try {

	        if(outlet7.isChecked()) {
	            Log.i("Toggle", "Turning socket7 on");
	            client.setSocket7(DigitalPinValue.HIGH);
	        }
	        else {
	        	Log.i("Toggle", "Turning socket7 off");
	        	client.setSocket7(DigitalPinValue.LOW);
	        }
    	}
    	catch(Exception e) {
    		handleException(e);
    	}
    }
    
    public void onOutlet8Clicked(View view) {

    	try {

	        if(outlet8.isChecked()) {
	            Log.i("Toggle", "Turning socket8 on");
	            client.setSocket8(DigitalPinValue.HIGH);
	        }
	        else {
	        	Log.i("Toggle", "Turning socket8 off");
	        	client.setSocket8(DigitalPinValue.LOW);
	        }
    	}
    	catch(Exception e) {
    		handleException(e);
    	}
    }

    public void onRoDiAquariumClicked(View view) {

    	try {
    		
    		if(rodiAquarium.isChecked()) {
    			Log.i("Toggle", "Turning RO/DI -> aquarium solenoid on");
    			client.setRoDiAquariumSolenoid(DigitalPinValue.HIGH);
    		}
    		else {
    			Log.i("Toggle", "Turning RO/DI -> aquarium solenoid off");
    			client.setRoDiAquariumSolenoid(DigitalPinValue.LOW);
    		}
    	}
    	catch(Exception e) {
    		handleException(e);
    	}
    }
    
    public void onRoDiReservoirClicked(View view) {

    	try {
    		
    		if(rodiReservoir.isChecked()) {
    			Log.i("Toggle", "Turning RO/DI -> saltwater reservoir solenoid on");
    			client.setRoDiReservoirSolenoid(DigitalPinValue.HIGH);
    		}
    		else {
    			Log.i("Toggle", "Turning RO/DI -> saltwater reservoir solenoid off");
    			client.setRoDiReservoirSolenoid(DigitalPinValue.LOW);
    		}
    	}
    	catch(Exception e) {
    		handleException(e);
    	}
        
    }
    
    public void onAquariumDrainClicked(View view) {

    	try {

    		if(aquariumDrain.isChecked()) {
	            Log.i("Toggle", "Turning aquarium drain solenoid on");
	            client.setAquariumDrainSolenoid(DigitalPinValue.HIGH);
	        }
	        else {
	        	Log.i("Toggle", "Turning aquarium drain solenoid off");
	        	client.setAquariumDrainSolenoid(DigitalPinValue.LOW);
	        }
    	}
        catch(Exception e) {
        	handleException(e);
        }
    }

    private void handleException(Exception e) {

    	if(progressDialog.isShowing())
    	   progressDialog.cancel();

    	AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
    	.setTitle("Error")
    	.setMessage(e.getMessage())
    	.setPositiveButton("OK", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});

		errorDialog = builder.create();
		errorDialog.show();

		e.printStackTrace();
    }

    class PollArduinoAndSetButtonStatesTask extends TimerTask {

    	@Override
    	public void run() {

    		MainActivity.this.runOnUiThread(new Runnable() {

    			@Override
    			public void run() {

    				Log.i("MainActivity.PollArduinoAndSetButtonStatesTask", "Executing");

    				updateButtonStatesAsyncTask = new UpdateButtonStatesAsyncTask();
    		        updateButtonStatesAsyncTask.execute(this);
    			}
    		});
    	}
    }

    private class UpdateButtonStatesAsyncTask extends AsyncTask<Object, Void, Object> {

    	@Override
    	protected void onPreExecute() {
    		
    		super.onPreExecute();

    		Log.i("UpdateButtonStatesAsyncTask.onPreExecute", "Executing");
    		progressDialog = ProgressDialog.show(MainActivity.this, "", "Loading. Please wait...", true);
    	}

    	@Override
    	protected Object doInBackground(Object... params) {

    		Log.i("MainActivity.UpdateButtonStatesAsyncTask.doInBackground", "Executing");

        	try {

        		ArrayList<Boolean> list = new ArrayList<Boolean>();

        		list.add(client.getSocket1().equals(DigitalPinValue.HIGH));
        		list.add(client.getSocket2().equals(DigitalPinValue.HIGH));
        		list.add(client.getSocket3().equals(DigitalPinValue.HIGH));
        		list.add(client.getSocket4().equals(DigitalPinValue.HIGH));
        		list.add(client.getSocket5().equals(DigitalPinValue.HIGH));
        		list.add(client.getSocket6().equals(DigitalPinValue.HIGH));
        		list.add(client.getSocket7().equals(DigitalPinValue.HIGH));
        		list.add(client.getSocket8().equals(DigitalPinValue.HIGH));
        		list.add(client.getRoDiAquariumSolenoid().equals(DigitalPinValue.HIGH));
        		list.add(client.getRoDiReservoirSolenoid().equals(DigitalPinValue.HIGH));
        		list.add(client.getAquariumDrainSolenoid().equals(DigitalPinValue.HIGH));

        		return list;
        	}
        	catch(ClientProtocolException e) {
				e.printStackTrace();
        		return e;
			}
        	catch(IOException e) {
				e.printStackTrace();
				return e;
			}
    	}

    	@Override
    	protected void onPostExecute(Object result) {

    		super.onPostExecute(result);
    		
    		progressDialog.dismiss();

    		Log.i("UpdateButtonStatesAsyncTask.onPostExecute", result.toString());
    		
    		if(result instanceof Exception) {
    			handleException((Exception) result);
    		}

    		ArrayList<Boolean> pinValues = (ArrayList<Boolean>) result;
			
			outlet1.setChecked(pinValues.get(0));
			outlet2.setChecked(pinValues.get(1));
	        outlet3.setChecked(pinValues.get(2));
	        outlet4.setChecked(pinValues.get(3));
	        outlet5.setChecked(pinValues.get(4));
	        outlet6.setChecked(pinValues.get(5));
	        outlet7.setChecked(pinValues.get(6));
	        outlet8.setChecked(pinValues.get(7));
	        rodiAquarium.setChecked(pinValues.get(8));
	        rodiReservoir.setChecked(pinValues.get(9));
	        aquariumDrain.setChecked(pinValues.get(10));
    	}

    	private void handleException(Exception e) {

    		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

    		if(e.getMessage().contains("timed out")) {

				builder
				  .setTitle("Network Error")
    	    	  .setMessage("Make sure your connected to JJ-WIFI and try running AquariumPilot again.")
    	    	  .setPositiveButton("OK", new DialogInterface.OnClickListener() {

    				@Override
    				public void onClick(DialogInterface dialog, int which) {
    					
    					if(timer != null) {
    					
    						timer.cancel();
    						timer = null;
    					}
    					errorDialog.dismiss();
    					MainActivity.this.finish();
    				}
    			});
			}
			else {

    			builder
    	    	  .setTitle("Error")
    	    	  .setMessage(e.getMessage())
    	    	  .setPositiveButton("OK", new DialogInterface.OnClickListener() {

    				@Override
    				public void onClick(DialogInterface dialog, int which) {
    					
    					if(timer != null) {
        					
    						timer.cancel();
    						timer = null;
    					}
    					errorDialog.dismiss();
    					MainActivity.this.finish();
    				}
    			});
			}

			errorDialog = builder.create();
			errorDialog.show();
    	}
    }
}