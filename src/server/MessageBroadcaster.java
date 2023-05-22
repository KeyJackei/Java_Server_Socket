package server;

import model.User;
import model.UserMap;

import java.util.Map;

public class MessageBroadcaster {
    public static void broadcastMessage(UserMap userMap, String message) {
        for (Map.Entry<String, User> entry : userMap.getUsers().entrySet())
            entry.getValue().getSocket().writeLine(message);
    }
}