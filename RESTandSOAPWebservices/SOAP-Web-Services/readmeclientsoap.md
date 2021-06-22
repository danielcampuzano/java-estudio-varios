# ClienteSoapConWsImport

Este ptoyecto implementa un cliente SOAP de forma muy basica haciendo uso de wsimport el cual se encuentra en el mismo jdk de java.
El cliente se crea por consola por medio del siguiente comando

wsimport -keep -s src http://www.learnwebservices.com/services/tempconverter?wsdl

Las clases generadas quedan en una carpeta src y luego se pegan en el proyecto para su uso.

El tutorial visto se encuentra en https://www.youtube.com/watch?v=KFlDdb65w3U&list=PLqq-6Pq4lTTZTYpk_1DOowOGWJMIH5T39&index=4

También se busca un poco de referencia acerca de cuando usar wsimport, axis, cxf, entre otros y se encuentra en stackoverflow lo siguiente

The JAX-WS implementation built into the JDK really is just the basic soap stuff. If you need any of the more complex WS-* things like WS-Security, WS-RM, WS-Policy, etc..., you need to use one of the alternatives like CXF or Metro or Axis2. It can also depend on what you are trying to integrate with. For example, CXF has top notch Spring support as well as very good OSGi support.

CXF also has other things besides just JAX-WS. It has a compliant JAX-RS implementation as well and supports exposing services as both REST and SOAP very well. Has a W3C compliant SOAP/JMS implementation if that type of things is required. Basically, lots of stuff not available from the in-jdk JAX-WS impl.
