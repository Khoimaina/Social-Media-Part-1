package com.tts.TechTalentTwitter.controller;


import javax.servlet.http.HttpServletRequest;

import com.tts.TechTalentTwitter.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.TechTalentTwitter.service.UserService;

import java.util.List;

@Controller
public class FollowController {
    @Autowired
    private UserService userService;



@PostMapping(value = "/follow/{username}")
public String follow(@PathVariable(value="username") String username, 
                     HttpServletRequest request) {
    User loggedInUser = userService.getLoggedInUser();
    User userToFollow = userService.findByUsername(username);
    List<User> followers = (List<User>) userToFollow.getFollowers();

    followers.add(loggedInUser);
    userToFollow.setFollowers((antlr.collections.List) followers);
    userService.save(userToFollow);
    return "redirect:" + request.getHeader("Referer");
}
}
