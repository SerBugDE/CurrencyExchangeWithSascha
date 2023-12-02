package repository;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import interfaces.IR_UserRepo;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        System.out.println(users);
        System.out.println(authorisation("1", "1"));
    }

    @Override
    public User addUser(String email, String password) {

        User user = new User(currentUserId.getAndIncrement(), email, password);
        users.add(user);
        return user;
    }

    @Override
    public User getUserById(int id) {
        return users.stream()
                .filter(Objects::nonNull)
                .filter(user -> user.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public boolean isEmailExist(String email) {
        return users.stream()
                .anyMatch(user -> user != null && Objects.equals(user.getEmail(), email));
    }

    @Override
    public Optional<User> authorisation(String email, String password) {
        Optional<User> activUser = users.stream()
                .filter(user -> user != null && user.getEmail().equals(email))
                .filter(user -> user.getPassword().equals(password))
                .findFirst();
        if (activUser.isPresent()) {
            System.out.println("Авторизация успешна. Приветствуем, юзер с адресом " + activUser.get().getEmail());
            return activUser;
        }
        else {
            System.out.println("Авторизация неудачна, спробуй ще");
            return null;
        }

        //TODO Sasha
    }
}
