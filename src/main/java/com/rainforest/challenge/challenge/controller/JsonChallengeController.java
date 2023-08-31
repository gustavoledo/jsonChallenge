package com.rainforest.challenge.challenge.controller;


import com.rainforest.challenge.challenge.request.JsonChallengeRequest;
import com.rainforest.challenge.challenge.response.JsonChallengeResponse;
import com.rainforest.challenge.challenge.service.JsonChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class JsonChallengeController {

    private final JsonChallengeService jsonChallengeService;

    @Autowired
    public JsonChallengeController(JsonChallengeService jsonChallengeService) {
        this.jsonChallengeService = jsonChallengeService;
    }

    @PostMapping
    public JsonChallengeResponse getNewUrl(@RequestBody JsonChallengeRequest testRequest) {
        return jsonChallengeService.getUrl(testRequest.getFollow());
    }

}
