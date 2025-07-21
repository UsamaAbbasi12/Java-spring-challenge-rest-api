package com.learning.leraning_spring;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;
import com.learning.leraning_spring.Challenge;
@RestController
public class ChallengeController {
    private final ChallengeService challengeService;


    @Autowired
    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges(){
       return  challengeService.getAllChallenges();
    }

    @PostMapping("/challenges/create")
    public String addChallenge(@RequestBody Challenge challenge){
        boolean isChallengeAdded = challengeService.addChallenge(challenge);
        if (isChallengeAdded){
          return "Success";
        }
        else{
            return "Failure";
        }
    }

    @GetMapping("/challenge/{month}")
    public Challenge getChallenge(@PathVariable  String month){
        Challenge challenge =   challengeService.getChallenge(month);
        if(challenge != null){
            return challenge;
        }
        else{
            return null;
        }
    }

}
