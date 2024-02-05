package ru.job4j.ex;

import ru.job4j.tracker.Item;

import java.util.Arrays;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (int index = 0; index < users.length; index++) {
            User user = users[index];
            if (login.equals(user.getUsername())) {
                users[index] = user;
                return user;
            } else {
                throw new UserNotFoundException("There is no such user.");
            }
        }
        return null;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("The user is not valid");
        } else if (user.getUsername().length() < 3) {
            throw new UserInvalidException("Username less than 3 letters.");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        User user = null;
        try {
            user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}
