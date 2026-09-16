package com.ankit.courtSync.polls;

import jakarta.persistence.*;

@Entity
@Table(name = "pollOptions")
public class PollOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
