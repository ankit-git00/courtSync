package com.ankit.courtSync.polls.dto;

import java.util.List;

public record CreatePollRequest(
        String groupJid,
        String question,
        List<String> options,
        Integer maxSelected
) {
}