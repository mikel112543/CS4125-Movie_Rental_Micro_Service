package com.example.movierental.service;

import com.example.movierental.contants.Error;
import com.example.movierental.exception.ServiceException;
import com.example.movierental.logger.AbstractLogger;
import com.example.movierental.logger.RequesterClient;
import com.example.movierental.model.ServiceError;
import com.example.movierental.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static AbstractLogger chainLogger = RequesterClient.getChaining();

    UserRepoServiceImpl userRepoService;

    @Autowired
    public UserDetailsServiceImpl(@Qualifier("users")UserRepoServiceImpl userRepoService) {
        this.userRepoService = userRepoService;
    }

    @Override
    public User loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepoService.findByUserName(userName);
        if (user != null) {
            return user;
        } else {
            chainLogger.logMessage(AbstractLogger.OUTPUT_INFO, "Could not load User");
            throw new ServiceException(new ServiceError(Error.USER_LOAD_FAILURE));
        }
    }

}
