package com.psa.flights_reservation_app_5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psa.flights_reservation_app_5.entities.User;

public interface UserRepoInf extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
