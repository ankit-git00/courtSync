package com.ankit.courtSync.whatsapp;

import org.hibernate.validator.spi.tracking.ProcessedBeansTrackingVoter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/whatsapp")
public class WhatsappContorller {


    @PostMapping("webhooks/poll-vote")
    public ResponseEntity<String> pollVote(@RequestBody String request) {

        System.out.println("Received request: " + request);
        return ResponseEntity.ok().build();
    }

}
