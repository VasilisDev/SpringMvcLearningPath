package com.bill.learning.model;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostMessage {

    private String subject;
    private LocalDateTime datePosted;
    private String postedMsg;

}
