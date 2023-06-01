/**
 * Класс, представляющий обработчик отключения пользователя.
 */
package server;

import model.User;
import model.UserMap;

import java.io.IOException;

public class UserDisconnectHandler extends Thread {

    private User user;
    private UserMap userMap;

    /**
     * Конструктор класса UserDisconnectHandler.
     *
     * @param user    отключаемый пользователь
     * @param userMap коллекция пользователей
     */
    public UserDisconnectHandler(User user, UserMap userMap) {
        this.user = user;
        this.userMap = userMap;
    }

    /**
     * Переопределенный метод run.
     * Обрабатывает отключение пользователя.
     * Если происходит ошибка при чтении, удаляет пользователя из коллекции и сообщает о его отключении.
     */
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
