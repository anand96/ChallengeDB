package com.learnspring.ChallengeApp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//CURD
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    Optional<Challenge> findByMonthIgnoreCase(String month);
}
