package com.tts.TechTalentTwitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.TechTalentTwitter.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
	User findByUserName(String username);

}
