package com.evaluation.backend.controller;

import com.evaluation.backend.dto.ResponseDTO;
import com.evaluation.backend.dto.SubscribeRequestDTO;
import com.evaluation.backend.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserCourseController {

    private SubscriptionService subscriptionService;
    public UserCourseController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    /*
     Subscribe a user on a course based in its ids
    */
    @PostMapping("/suscribe")
    ResponseEntity<ResponseDTO> subscribe(@RequestBody SubscribeRequestDTO subscribeRequestDTO){
        return subscriptionService.subscribe(subscribeRequestDTO);
    }

    /*
     Unsubscribe a user on a course based in its ids
    */
    @PostMapping("/unsubscribe")
    ResponseEntity<ResponseDTO> unsubscribe(@RequestBody SubscribeRequestDTO subscribeRequestDTO){
        return subscriptionService.unsubscribe(subscribeRequestDTO);
    }
}
