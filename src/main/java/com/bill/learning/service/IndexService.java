package com.bill.learning.service;

import com.bill.learning.model.PostMessage;

import java.time.LocalDateTime;
import java.util.*;

public interface IndexService {

    default String findMessage() {
        return "";
    }
    default List<PostMessage> findPosts() {
        return Collections.singletonList(new PostMessage("No subject found", LocalDateTime.now(), "No message found"));
    }
    default String findQuote(){
        return "";
    }
}
