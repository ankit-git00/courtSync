package com.ankit.courtSync.polls;

import com.ankit.courtSync.polls.dto.CreatePollRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/polls")
public class PollController {

    private final PollService pollService;
    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping
    public ResponseEntity<Poll> createPoll(@RequestBody CreatePollRequest request){

        Poll poll = pollService.createPoll(request);
        return ResponseEntity.ok().body(poll);
    }
}
