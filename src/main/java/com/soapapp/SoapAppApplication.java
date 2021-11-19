package com.soapapp;

import com.soapapp.wsdl.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapAppApplication {

    private static final Logger log = LoggerFactory.getLogger(SoapAppApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SoapAppApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(CountryClient quoteClient) {
        return args -> {
            String country = "Spain";

            if (args.length > 0) {
                country = args[0];
            }
            GetCountryResponse response = quoteClient.getCountry(country);
            log.info("************************************");
            log.info("Capital: " + response.getCountry().getCapital());
            log.info("População: " + response.getCountry().getPopulation());
            log.info("Moeda: " + response.getCountry().getCurrency().toString());
            log.info("************************************");
        };
    }
}
