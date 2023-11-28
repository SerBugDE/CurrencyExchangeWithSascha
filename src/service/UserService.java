package service;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import model.User;
import repository.UserRepository;

public class UserService {

    private User activeUser;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
