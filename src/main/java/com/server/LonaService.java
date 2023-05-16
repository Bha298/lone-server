package com.server;

import com.dtos.InterestRate;
import com.entity.Lone;
import com.rep.LoanRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class LonaService {

    private static final String RATE_SERVICE_URL =  "http://localhost:2627/api/rates/";
    @Autowired
    private LoanRep loanRep;

    @Autowired
    private RestTemplate restTemplate;

    public List<Lone> getAllLoansByType(String type) {
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<InterestRate> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<InterestRate> response = restTemplate.exchange(
                (RATE_SERVICE_URL + type),
                HttpMethod.GET, entity,
                InterestRate.class
        );
        InterestRate rate = response.getBody();
        List<Lone> loanList = new ArrayList<>();
        if (rate != null) {
            loanList = loanRep.findByType(type);
            for (Lone loan : loanList) {
                loan.setInterest(loan.getAmount() * (rate.getRateValue() / 100));
            }
        }
        return loanList;
    }
    public List<Lone> getDefaultLoans(Exception e) {
        return new ArrayList<>();
    }
    }

