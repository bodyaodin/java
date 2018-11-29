package com.webservice.config;

import org.oorsprong.websamples.CountryInfoServiceSoapType;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Create connection to WSDL
 */
public class Connection {

    // URL to WSDL description
    private URL url;
    private QName qName;
    private Service service;
    private CountryInfoServiceSoapType info;

    public Connection() {

        try {
            url = new URL("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // first argument - look in WSDL attribute targetNamespace
        // second argument - look in WSDL attribute name
        qName = new QName("http://www.oorsprong.org/websamples.countryinfo", "CountryInfoService");

        service = Service.create(url, qName);

        info = service.getPort(CountryInfoServiceSoapType.class);
    }

    /**
     * @return object of remote web service object
     */
    public CountryInfoServiceSoapType getInfo() {
        return info;
    }
}
