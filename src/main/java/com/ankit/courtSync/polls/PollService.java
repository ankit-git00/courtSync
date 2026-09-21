package com.ankit.courtSync.polls;

import com.ankit.courtSync.polls.dto.CreatePollRequest;
import com.ankit.courtSync.whatsapp.WhatsAppService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {

    private final PollRepository pollRepository;
    private final WhatsAppService whatsAppService;

    public PollService(PollRepository pollRespository, WhatsAppService whatsAppService) {
        this.pollRepository = pollRespository;
        this.whatsAppService = whatsAppService;
    }

    public List<Poll> findAll() {
        return pollRepository.findAll();
    }

    public Poll createPoll(CreatePollRequest request){

        Poll poll = new Poll();
        poll.setQuestion(request.question());
        poll.setGroupJId(request.groupJid());
        poll.setStatus(PollStatus.CREATING);


        for (String optionText : request.options()) {
            PollOption option = new PollOption();
            option.setText(optionText);

            poll.addOption(option);
        }

        // 3. Persist locally
        pollRepository.save(poll);


        try {

            // 4. Ask Go/WhatsApp to create actual poll
            String whatsappPollId =
                    whatsAppService.createPoll(
                            request.groupJid(),
                            request.question(),
                            request.options(),
                            request.maxSelected()
                    );

            // 5. Store WhatsApp poll ID
            poll.setWhatsAppPollId(whatsappPollId);
            poll.setStatus(PollStatus.CREATED);

            return pollRepository.save(poll);

        } catch (Exception e) {

            poll.setStatus(PollStatus.FAILED);
            pollRepository.save(poll);

            throw e;
        }
    }
    }

