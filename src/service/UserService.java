package service;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import interfaces.IS_UserService;
import model.User;
import repository.UserRepository;
import validators.exceptions.EmailValidateException;
import validators.exceptions.PasswordValidateException;

import java.util.Optional;

public class UserService implements IS_UserService {


    private final UserRepository userRepository;
    private User activeUser;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<User> createUser(String email, String password) throws PasswordValidateException, EmailValidateException {
        //TODO Serg
    }

    @Override
    public User authorisation(String email, String password) {
        //TODO Sasha
    }

    @Override
    public void logout() {
        activeUser = null;
    }

    public User getActiveUser() {
        return activeUser;
    }
}
