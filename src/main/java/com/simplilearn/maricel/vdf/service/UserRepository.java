package com.simplilearn.maricel.vdf.service;

import com.simplilearn.maricel.vdf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
