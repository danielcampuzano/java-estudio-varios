package com.co.campu;

import com.learnwebservices.services.tempconverter.CelsiusToFahrenheitRequest;
import com.learnwebservices.services.tempconverter.CelsiusToFahrenheitResponse;
import com.learnwebservices.services.tempconverter.TempConverterEndpoint;
import com.learnwebservices.services.tempconverter.TempConverterEndpointService;
/**
 * Web service client creado con wsimport que es una herramienta del java segun
 * entiendo
 * @author user
 *
 */
public class TempConverter {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("You need to pass the ip temperature in celsius");
		}else {
			String tempInput = args[0];
			double tempCelsius = Double.parseDouble(tempInput);
			
			//Se usa la clase que tiene el mismo nombre que
			//el campo service en el wsdl
			TempConverterEndpointService tempService = new TempConverterEndpointService();
			
			//Se obtiene la clase que tenga el nombre en el port en el wsdl
			//Este es el stub
			TempConverterEndpoint tempConverterPort = tempService.getTempConverterEndpointPort();
			
			//Se crea el request
			CelsiusToFahrenheitRequest request = new CelsiusToFahrenheitRequest();
			request.setTemperatureInCelsius(tempCelsius);
			
			//Se instancia un response para esperar el resultado
			
			CelsiusToFahrenheitResponse response = new CelsiusToFahrenheitResponse();
			
			response = tempConverterPort.celsiusToFahrenheit(request);
			
			System.out.println("La temperatura en Farenheit es: "
								+response.getTemperatureInFahrenheit());
		}
	}
}
