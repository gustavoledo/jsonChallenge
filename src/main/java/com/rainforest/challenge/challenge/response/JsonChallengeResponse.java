package com.rainforest.challenge.challenge.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class JsonChallengeResponse {
    String follow;
    String message;
    boolean end;

}
