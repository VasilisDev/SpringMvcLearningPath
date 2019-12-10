package com.bill.learning.service.impl;

import com.bill.learning.service.IndexService;
import com.bill.learning.model.PostMessage;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Component
public class IndexServiceImpl implements IndexService {

    @Override
    public String findMessage() {

    return  "I love programming!";
     }

    @Override
    public String findQuote() {
        return "Lorem ipsum dolor sit amet, rebum causae adversarium eu vim, altera oblique hendrerit his id, in vis sapientem argumentum. Mel nonumy eloquentiam ut, eirmod eleifend mandamus an eam. Vis summo delicata adversarium an, sea assum movet in, quis dicunt latine in eum. An per iisque inermis, sumo vidit vis ut. Case expetenda principes at qui. Ei graece propriae percipit pri, eam ea natum nostro virtute.";
    }

    @Override
    public List<PostMessage> findPosts() {
        PostMessage post = new PostMessage();
        post.setSubject("Welcome to my portfolio");
        post.setPostedMsg("This is the welcome page !");
        post.setDatePosted(LocalDateTime.now());
        return Collections.singletonList(post);
    }
}
