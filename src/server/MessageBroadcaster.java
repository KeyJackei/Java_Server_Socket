/**
 * Класс, отвечающий за передачу сообщений всем пользователям.
 */
package server;

import model.User;
import model.UserMap;

import java.util.Map;

public class MessageBroadcaster {

    /**
     * Отправляет сообщение всем пользователям в коллекции.
     *
     * @param userMap  коллекция пользователей
     * @param message  сообщение для отправки
     */
    public static void broadcastMessage(UserMap userMap, String message) {
        for (Map.Entry<String, User> entry : userMap.getUsers().entrySet())
            entry.getValue().getSocket().writeLine(message);
    }
}
