package com.learnspring.ChallengeApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//JPA Converts class to DB table


@Service
public class ChallengeService {
    //private List<Challenge> challenges= new ArrayList<>();

    private Long nextid = 1l;
    @Autowired
    ChallengeRepository challengeRepository;

    public ChallengeService(){
    }

    public List<Challenge> getAllChallenges(){
        return challengeRepository.findAll();
    }

    public boolean addChallenge(Challenge challenge){
        if(challenge!=null)
        {
            challenge.setId(nextid++);
            challengeRepository.save(challenge);
            return true;
        }
        else{
            return false;
        }
    }


    public Challenge getChallenge(String month) {
        Optional<Challenge> challenge = challengeRepository.findByMonthIgnoreCase(month);
        return challenge.orElse(null);
    }

    public boolean updateChallenge(Long id, Challenge updatedChallenge){
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if (challenge.isPresent())
        {
            Challenge challengeTOUpdate = challenge.get();
            challengeTOUpdate.setMonth(updatedChallenge.getMonth());
            challengeTOUpdate.setDescription(updatedChallenge.getDescription());
            challengeRepository.save(challengeTOUpdate);
            return true;
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if(challenge.isPresent())
        {
            challengeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
