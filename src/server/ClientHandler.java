/**
 * @file ClientHandler.java
 * @brief Класс, обрабатывающий подключение клиента к серверу
 */

package server;

import model.Message;
import model.TextMessage;
import model.User;
import model.UserMap;

import java.io.IOException;
import java.net.Socket;

/**
 * @class ClientHandler
 * @brief Класс, обрабатывающий подключение клиента к серверу
 */
public class ClientHandler extends Thread {

    private SocketWrapper socketWrapper;
    private UserMap userMap;

    /**
     * @brief Конструктор класса ClientHandler
     * @param socket  сокет, представляющий подключение клиента
     * @param userMap объект UserMap, хранящий информацию о пользователях
     * @throws IOException если возникает ошибка ввода-вывода
     */
    public ClientHandler(Socket socket, UserMap userMap) throws IOException {
        this.socketWrapper = new SocketWrapper(socket);
        this.userMap = userMap;
    }

    /**
     * @brief Запускает обработку подключения клиента
     */
    @Override
    public void run() {
        try {
            User user = User.fromSocket(socketWrapper);
            userMap.addUser(user);
            MessageBroadcaster.broadcastMessage(userMap, user.getName());

            String message;
            while ((message = socketWrapper.readLine()) != null) {
                TextMessage msg = new TextMessage(message);
                MessageBroadcaster.broadcastMessage(userMap, msg.toString());
            }

            userMap.removeUser(user);
            MessageBroadcaster.broadcastMessage(userMap, "User " + user.getName() + " has left");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
