package com.learning.leraning_spring;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/challenges")
public class ChallengeController {
    private final ChallengeService challengeService;


    @Autowired
    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public ResponseEntity<List<Challenge>> getAllChallenges(){
       return  new ResponseEntity<>(challengeService.getAllChallenges(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge){
        boolean isChallengeAdded = challengeService.addChallenge(challenge);
        if (isChallengeAdded){
          return new ResponseEntity<>("Challenge Added Successfully", HttpStatus.CREATED) ;
        }
        else{
            return new ResponseEntity<>("Challenge Not Added Successfully", HttpStatus.BAD_REQUEST) ;
        }
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable  String month){
        Challenge challenge =   challengeService.getChallenge(month);
        if(challenge != null){
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody  Challenge updateChallengeData) {
        boolean isUpdated = challengeService.updateChallenge(id, updateChallengeData);
        if (isUpdated) {
            return new ResponseEntity<>("Challenge updated Successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Challenge Not updated Successfully", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isDeleted = challengeService.deleteChallenge(id);
        if(isDeleted){
            return new ResponseEntity<>("Challenge Deleted Successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Challenge Not Deleted Successfully, Challenge " +
                    "doesn't exists", HttpStatus.NOT_FOUND);
        }
    }

}
