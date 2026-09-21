package com.ankit.courtSync.whatsapp;

import com.ankit.courtSync.whatsapp.dto.CreateWhatsAppPollRequest;
import com.ankit.courtSync.whatsapp.dto.CreateWhatsAppPollResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WhatsAppService {

    private final RestClient restClient;
    public WhatsAppService( @Valuex("${whatsappmeow.base-url}") String baseUrl) {
        this.restClient = RestClient.builder().baseUrl(baseUrl).build();
    }


    public String createPoll(
            String groupJid,
            String question,
            java.util.List<String> options,
            Integer maxSelected) {

        CreateWhatsAppPollRequest request =
                new CreateWhatsAppPollRequest(
                        groupJid,
                        question,
                        options,
                        maxSelected
                );

        CreateWhatsAppPollResponse response = restClient
                .post()
                .uri("/send-poll")
                .body(request)
                .retrieve()
                .body(CreateWhatsAppPollResponse.class);

        return response.pollId();
    }
}
