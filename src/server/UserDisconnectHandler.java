package server;

import model.User;
import model.UserMap;

import java.io.IOException;

public class UserDisconnectHandler extends Thread {
    private User user;
    private UserMap userMap;

    public UserDisconnectHandler(User user, UserMap userMap) {
        this.user = user;
        this.userMap = userMap;
    }

    @Override
    public void run() {
        try {
            user.getSocket().readLine();
        } catch (IOException e) {
            userMap.removeUser(user);
            MessageBroadcaster.broadcastMessage(userMap, "User " + user.getName() + " has left");
        }
    }
}