package com.github.xenteros.currency.exchange;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

@RestController
@RequestMapping("/api/currency-exchanges")
class CurrencyExchangeController {


    @GetMapping("/to-eur")
    public CurrencyExchange getCurrencyExchangePlnEur(@RequestParam BigDecimal amount) {

        String url = "https://free.currencyconverterapi.com/api/v5/convert?q=PLN_EUR&compact=y";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        Map<String, ExternalCurrencyExchange> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            map = objectMapper.readValue(response.getBody(), new TypeReference<HashMap<String, ExternalCurrencyExchange>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }



        BigDecimal result = amount.multiply(map.get("PLN_EUR").getVal());

        return new CurrencyExchange("PLN", "EUR", amount, result);
    }


    @GetMapping("/{target-currency}")
    public CurrencyExchange getCurrencyExchange(@RequestParam BigDecimal amount,
                                                @PathVariable("target-currency") String targetCurrency) {

        String url = format("https://free.currencyconverterapi.com/api/v5/convert?q=PLN_%s&compact=y", targetCurrency);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        Map<String, ExternalCurrencyExchange> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            map = objectMapper.readValue(response.getBody(), new TypeReference<HashMap<String, ExternalCurrencyExchange>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        BigDecimal result = amount.multiply(map.get("PLN_" + targetCurrency).getVal());

        return new CurrencyExchange("PLN", targetCurrency, amount, result);
    }

}
