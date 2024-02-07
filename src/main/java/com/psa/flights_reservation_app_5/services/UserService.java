package com.psa.flights_reservation_app_5.services;

import com.psa.flights_reservation_app_5.entities.User;
import com.psa.flights_reservation_app_5.repository.UserRepoInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepoInf userRepository;
    public boolean isEmailExists(String email) {
        User existingUser = userRepository.findByEmail(email);
        return existingUser != null;
    }
}
