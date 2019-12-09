package com.bill.learning.controller.index;


import com.bill.learning.service.IndexService;
import com.bill.learning.model.Home;
import com.bill.learning.model.PostMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class IndexController {

    private final IndexService indexService;

    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @ModelAttribute("posts")
    public List<PostMessage> makePosts(){
        return indexService.findPosts();
    }

    @GetMapping(value={"/index","/"})
    public String getIndex(Model model,@ModelAttribute("posts") List<PostMessage> posts,
                           @ModelAttribute("postForm")PostMessage postForm){
        Home home = new Home();
             home.setMessage(indexService.findMessage());
             home .setQuote(indexService.findQuote());
             model.addAttribute("home",home);
        Optional<PostMessage>  optionalPostMessage = posts.stream().findAny();
        if(! optionalPostMessage.isPresent())
            posts = makePosts();

        if(ValidatePost(postForm)){
            postForm.setDatePosted(LocalDateTime.now());
            posts.add(postForm);
        }
        model.addAttribute("posts",posts);
        return "index";
    }

    private boolean  ValidatePost(PostMessage post){
        try {
         if(StringUtils.isEmpty(post.getPostedMsg()) ||
                 StringUtils.isEmpty(post.getSubject()))
             return false;
     } catch (Exception ex) {
         return false;
      }
      return true;
    }
}
