package com.ankit.courtSync.whatsapp.dto;

import java.util.List;

public record CreateWhatsAppPollRequest(
        String groupJid,
        String question,
        List<String> options,
        Integer maxSelected
) {
}