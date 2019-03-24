package com.in28minutes.springboot.microservice.example.forex.springbootmicroserviceforexservice;

import com.in28minutes.springboot.microservice.example.forex.springbootmicroserviceforexservice.ExchangeValue;
import com.in28minutes.springboot.microservice.example.forex.springbootmicroserviceforexservice.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository repository;

    @RequestMapping("/currency-exchange" +
            "/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue
            (@PathVariable String from, @PathVariable String to){

        ExchangeValue exchangeValue =
                repository.findByFromAndTo(from, to);

        exchangeValue.setPort(
                Integer.parseInt(environment.getProperty("local.server.port")));

        return exchangeValue;
    }
}
