/**
 * Класс, представляющий пользователя.
 */
package model;

import server.SocketWrapper;

import java.io.IOException;

public class User {
    private String name;
    private SocketWrapper socket;

    /**
     * Конструктор класса User.
     *
     * @param name   имя пользователя
     * @param socket сокет для общения с пользователем
     */
    public User(String name, SocketWrapper socket) {
        this.name = name;
        this.socket = socket;
    }

    /**
     * Создает объект User на основе сокета.
     *
     * @param socket сокет для общения с пользователем
     * @return объект User
     * @throws IOException при ошибке ввода/вывода
     */
    public static User fromSocket(SocketWrapper socket) throws IOException {
        String name = socket.readLine();
        return new User(name, socket);
    }

    /**
     * Получает имя пользователя.
     *
     * @return имя пользователя
     */
    public String getName() {
        return name;
    }

    /**
     * Получает сокет пользователя.
     *
     * @return сокет пользователя
     */
    public SocketWrapper getSocket() {
        return socket;
    }
}
