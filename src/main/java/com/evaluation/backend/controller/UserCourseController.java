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

    @PostMapping("/suscribe")
    ResponseEntity<ResponseDTO> subscribe(@RequestBody SubscribeRequestDTO subscribeRequestDTO){
        return subscriptionService.subscribe(subscribeRequestDTO);
    }

    @PostMapping("/unsubscribe")
    ResponseEntity<ResponseDTO> unsubscribe(@RequestBody SubscribeRequestDTO subscribeRequestDTO){
        return subscriptionService.unsubscribe(subscribeRequestDTO);
    }
}
