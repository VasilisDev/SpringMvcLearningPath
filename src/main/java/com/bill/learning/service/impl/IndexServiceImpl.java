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
        return "Courage is found in unlikely places.\n" +
                "\n" +
                "J. R. R. Tolkien";
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
