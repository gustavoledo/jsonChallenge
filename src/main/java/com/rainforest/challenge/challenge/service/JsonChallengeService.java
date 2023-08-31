package com.rainforest.challenge.challenge.service;

import com.rainforest.challenge.challenge.response.JsonChallengeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JsonChallengeService {


    public JsonChallengeResponse getUrl(String url) {
        JsonChallengeResponse jsonUrlResponse = new JsonChallengeResponse();
        boolean end = false;
        String newUrl = url;
        while (!end){

            jsonUrlResponse = getNewResponse(newUrl).getBody();
            if (jsonUrlResponse.getMessage().equals("This is not the end")){
                jsonUrlResponse.setEnd(false);
                newUrl = jsonUrlResponse.getFollow();

            }else {
                jsonUrlResponse.setEnd(true);
                end = true;
            }


        }

        return jsonUrlResponse;
    }

    private ResponseEntity<JsonChallengeResponse> getNewResponse(String url) {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForEntity(url, JsonChallengeResponse.class);

    }
}