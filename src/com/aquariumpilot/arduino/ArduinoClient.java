package com.aquariumpilot.arduino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public abstract class ArduinoClient {

	private static InputStream is = null;

	protected String address = null;
	protected String apiKey = null;

	protected ArduinoClient(String address, String apiKey) {

		this.address = address;
		this.apiKey = apiKey;
	}

	protected String digitalRead(int pin) throws ClientProtocolException, IOException {

		String url = new StringBuilder("http://").append(address).append("/").append(apiKey).append("/").append(pin).toString();
    	String json = "";

    	Log.i("ArduinoClient.digitalRead", "Performing HTTP GET request to: " + url);
    	
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);

        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        is = httpEntity.getContent();
 
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        is.close();
        json = sb.toString();
        Log.i("ArduinoClient.digitalRead", "Response: " + json);
        
        return json;
    }

	protected String digitalWrite(int pin, DigitalPinValue value) throws ClientProtocolException, IOException {

		String pinValue = value.equals(DigitalPinValue.HIGH) ? "HIGH" : "LOW";
		String url = new StringBuilder("http://").append(address).append("/").append(apiKey).append("/").append(pin).append("/").append(pinValue).toString();
    	String json = "";

    	Log.i("ArduinoClient.digitalWrite", "Performing HTTP GET request to: " + url);

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);

        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        is = httpEntity.getContent();
 
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        is.close();
        json = sb.toString();
        Log.i("ArduinoClient.digitalWrite", "Response: " + json);
        
        return json;
    }
}
