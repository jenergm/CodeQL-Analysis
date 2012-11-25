package es.android.soap;

import java.util.ArrayList;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class SoapWeather {

	public static final String NAMESPACE = "http://ws.cdyne.com/WeatherWS/";
	public static final String URL = "http://wsf.cdyne.com/WeatherWS/Weather.asmx";
	public static final String METHOD_NAME = "GetWeatherInformation";
	public static final String SOAP_ACTION = "http://ws.cdyne.com/WeatherWS/GetWeatherInformation";

	
	public static List<Weather> getInformation()
	{
		
		List<Weather> lista = new ArrayList<Weather>();
		
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		
		envelope.dotNet= true;
		
		envelope.setOutputSoapObject(request);
		
		try
		{
		HttpTransportSE transporte = new HttpTransportSE(URL);
		
		transporte.call(SOAP_ACTION, envelope);
		
		SoapObject resSoap = (SoapObject) envelope.getResponse();
						
		for (int i = 0; i < resSoap.getPropertyCount(); i++)
		{
		       SoapObject ic = (SoapObject)resSoap.getProperty(i);
		       
		       Weather weather = new Weather();
		       
		       weather.set_id(ic.getProperty(0).toString());
		       weather.setDescription(ic.getProperty(1).toString());
		       weather.setPictureURL(ic.getProperty(2).toString());
		       
		       lista.add(weather);
		       /*Resultado*/
		}
		
		}catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		return lista;
	}
	
}
