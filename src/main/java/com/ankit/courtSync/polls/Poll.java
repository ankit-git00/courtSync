package com.ankit.courtSync.polls;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "polls")
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column()
    private String whatsAppPollId;


    @Getter
    @Setter
    @Column(nullable = false)
    private String question;

    @Setter
    @Getter
    @Column(nullable = false)
    private String groupJId;

    @Getter
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Getter
    @Setter
    @Column(nullable = false)
    private PollStatus status;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL)
    private List<PollOption> pollOptions = new ArrayList<>();

    public void addOption(PollOption option) {
        this.pollOptions.add(option);
        option.setPoll(this);

    }

}


//best approach would be use to ai suggestions i.e. autocomplete.