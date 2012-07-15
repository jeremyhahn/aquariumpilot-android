package com.aquariumpilot.arduino;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public class WeatherStationClient extends ArduinoClient {

	public static final String apiKey = "ABC123";
	//public static final String address = "aquariumpilot.bostonsaltwater.com:8081";
	public static final String address = "192.168.11.51";

	public static final int outlet1 = 24;
	public static final int outlet2 = 25;
	public static final int outlet3 = 26;
	public static final int outlet4 = 27;
	public static final int outlet5 = 28;
	public static final int outlet6 = 29;
	public static final int outlet7 = 30;
	public static final int outlet8 = 31;

	public static final int roDiAquariumSolenoid = 32;
	public static final int roDiReservoirSolenoid = 33;
	public static final int aquariumDrainSolenoid = 36;

	public WeatherStationClient() {
		super(address, apiKey);
	}

	public void setSocket1(DigitalPinValue value) throws ClientProtocolException, IOException {
		digitalWrite(outlet1, value);
	}

	public DigitalPinValue getSocket1() throws ClientProtocolException, IOException {
		return digitalRead(outlet1).contains(":\"HIGH\"") ? DigitalPinValue.HIGH : DigitalPinValue.LOW;
	}
	
	public void setSocket2(DigitalPinValue value) throws ClientProtocolException, IOException {
		digitalWrite(outlet2, value);
	}

	public DigitalPinValue getSocket2() throws ClientProtocolException, IOException {
		return digitalRead(outlet2).contains(":\"HIGH\"") ? DigitalPinValue.HIGH : DigitalPinValue.LOW;
	}
	
	public void setSocket3(DigitalPinValue value) throws ClientProtocolException, IOException {
		digitalWrite(outlet3, value);
	}

	public DigitalPinValue getSocket3() throws ClientProtocolException, IOException {
		return digitalRead(outlet3).contains(":\"HIGH\"") ? DigitalPinValue.HIGH : DigitalPinValue.LOW;
	}

	public void setSocket4(DigitalPinValue value) throws ClientProtocolException, IOException {
		digitalWrite(outlet4, value);
	}

	public DigitalPinValue getSocket4() throws ClientProtocolException, IOException {
		return digitalRead(outlet4).contains(":\"HIGH\"") ? DigitalPinValue.HIGH : DigitalPinValue.LOW;
	}

	public void setSocket5(DigitalPinValue value) throws ClientProtocolException, IOException {
		digitalWrite(outlet5, value);
	}

	public DigitalPinValue getSocket5() throws ClientProtocolException, IOException {
		return digitalRead(outlet5).contains(":\"HIGH\"") ? DigitalPinValue.HIGH : DigitalPinValue.LOW;
	}

	public void setSocket6(DigitalPinValue value) throws ClientProtocolException, IOException {
		digitalWrite(outlet6, value);
	}

	public DigitalPinValue getSocket6() throws ClientProtocolException, IOException {
		return digitalRead(outlet6).contains(":\"HIGH\"") ? DigitalPinValue.HIGH : DigitalPinValue.LOW;
	}

	public void setSocket7(DigitalPinValue value) throws ClientProtocolException, IOException {
		digitalWrite(outlet7, value);
	}

	public DigitalPinValue getSocket7() throws ClientProtocolException, IOException {
		return digitalRead(outlet7).contains(":\"HIGH\"") ? DigitalPinValue.HIGH : DigitalPinValue.LOW;
	}

	public void setSocket8(DigitalPinValue value) throws ClientProtocolException, IOException {
		digitalWrite(outlet8, value);
	}

	public DigitalPinValue getSocket8() throws ClientProtocolException, IOException {
		return digitalRead(outlet8).contains(":\"HIGH\"") ? DigitalPinValue.HIGH : DigitalPinValue.LOW;
	}
	
	public void setRoDiAquariumSolenoid(DigitalPinValue value) throws ClientProtocolException, IOException {
		digitalWrite(roDiAquariumSolenoid, value);
	}

	public DigitalPinValue getRoDiAquariumSolenoid() throws ClientProtocolException, IOException {
		return digitalRead(roDiAquariumSolenoid).contains(":\"HIGH\"") ? DigitalPinValue.HIGH : DigitalPinValue.LOW;
	}

	public void setRoDiReservoirSolenoid(DigitalPinValue value) throws ClientProtocolException, IOException {
		digitalWrite(roDiReservoirSolenoid, value);
	}

	public DigitalPinValue getRoDiReservoirSolenoid() throws ClientProtocolException, IOException {
		return digitalRead(roDiReservoirSolenoid).contains(":\"HIGH\"") ? DigitalPinValue.HIGH : DigitalPinValue.LOW;
	}
	
	public void setAquariumDrainSolenoid(DigitalPinValue value) throws ClientProtocolException, IOException {
		digitalWrite(aquariumDrainSolenoid, value);
	}

	public DigitalPinValue getAquariumDrainSolenoid() throws ClientProtocolException, IOException {
		return digitalRead(aquariumDrainSolenoid).contains(":\"HIGH\"") ? DigitalPinValue.HIGH : DigitalPinValue.LOW;
	}
}
