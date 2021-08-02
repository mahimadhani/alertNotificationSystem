package com.demo.sender;

import com.demo.model.AlertPayload;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SendSms {

    private static final String URL="https://run.mocky.io/v3/";
    private static final String tokenId="fd99c100-f88a-4d70-aaf7-393dbbd5d99f";
    public String sendSms(String phoneNumber){
        String requestUrl=URL+tokenId;
        RestTemplate template=new RestTemplate();
        AlertPayload alertPayload=new AlertPayload(phoneNumber);
        HttpEntity<AlertPayload> request = new HttpEntity<>(alertPayload);
        ResponseEntity<String> response=template.postForEntity(requestUrl,request,String.class);
        if(response.getStatusCode()==HttpStatus.OK){
            return response.getBody();
        }
        
        return "{\n" +
                "    \"failure\": \"alert not sent\"\n" +
                "}";
    }
}
