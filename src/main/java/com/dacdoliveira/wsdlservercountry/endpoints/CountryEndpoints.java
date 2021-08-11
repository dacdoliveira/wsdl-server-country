package com.dacdoliveira.wsdlservercountry.endpoints;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.dacdoliveira.wsdlservercountry.assets.GetCountryRequest;
import com.dacdoliveira.wsdlservercountry.assets.GetCountryResponse;
import com.dacdoliveira.wsdlservercountry.repository.CountryRepository;

@Endpoint
public class CountryEndpoints
{
    private static final String NAMESPACE_URI = "http://dacdoliveira.com/wsdlservercountry/assets";

    private final CountryRepository countryRepository;

    public CountryEndpoints(CountryRepository countryRepository)
    {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request)
    {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountryByName(request.getName()));
        return response;
    }

}
