package com.TrackThatTrackRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.TrackThatTrackRest.entity.User;

public interface UsersRepository extends JpaRepository<User, Integer> {
  //JpaRepository is where all the built in methods that we are using come from
}
