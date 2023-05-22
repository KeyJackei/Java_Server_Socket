package model;

import java.util.concurrent.ConcurrentHashMap;

public class UserMap {
    private ConcurrentHashMap<String, User> users;

    public UserMap() {
        users = new ConcurrentHashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getName(), user);
    }

    public void removeUser(User user) {
        users.remove(user.getName());
    }

    public ConcurrentHashMap<String, User> getUsers() {
        return users;
    }

}
