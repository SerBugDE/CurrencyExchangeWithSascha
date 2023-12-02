package repository;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import interfaces.IR_UserRepo;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class UserRepository implements IR_UserRepo {
    private final AtomicInteger currentUserId = new AtomicInteger(1);
    private final List<User> users; // может хранить в мапе?

    public UserRepository() {
        this.users = new ArrayList<>();
        initUsersTestData();
    }

    private void initUsersTestData() {
        users.addAll(new ArrayList<>(List.of(
                new User(currentUserId.getAndIncrement(), "test@email.net", "qwerty!Q1"),
                new User(currentUserId.getAndIncrement(), "admin@email.net", "admin!Q1"),
                new User(currentUserId.getAndIncrement(), "user2@email.net", "qwerty!Q1"),
                new User(currentUserId.getAndIncrement(), "user3@email.net", "qwerty!Q1"),
                new User(currentUserId.getAndIncrement(), "1", "1")
        )));
    }

    @Override
    public User addUser(String email, String password) {
         //TODO Serg
    }

    @Override
    public User getUserById(int id) {
        //TODO Sasha
    }

    @Override
    public boolean isEmailExist(String email) {
        //TODO Sasha
    }

    @Override
    public Optional<User> authorisation(String email, String password) {
        //TODO Sasha
    }
}
