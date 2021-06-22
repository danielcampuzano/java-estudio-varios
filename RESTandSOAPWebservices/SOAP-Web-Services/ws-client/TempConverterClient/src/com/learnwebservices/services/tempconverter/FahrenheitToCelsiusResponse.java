
package com.learnwebservices.services.tempconverter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fahrenheitToCelsiusResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fahrenheitToCelsiusResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TemperatureInCelsius" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fahrenheitToCelsiusResponse", propOrder = {
    "temperatureInCelsius"
})
public class FahrenheitToCelsiusResponse {

    @XmlElement(name = "TemperatureInCelsius")
    protected double temperatureInCelsius;

    /**
     * Gets the value of the temperatureInCelsius property.
     * 
     */
    public double getTemperatureInCelsius() {
        return temperatureInCelsius;
    }

    /**
     * Sets the value of the temperatureInCelsius property.
     * 
     */
    public void setTemperatureInCelsius(double value) {
        this.temperatureInCelsius = value;
    }

}
