/**
 * Класс, представляющий пользователя.
 */
package model;

import server.SocketWrapper;

import java.io.IOException;
import java.time.Instant;

public class User {



    /*
    * Добавлен счётчик времени для отслеживания активности пользователя в сети
    *
    *
    * */
    private String name;
    private SocketWrapper socket;
    private volatile long lastActive; // Unix timestamp последней активности

    public User(String name, SocketWrapper socket) {
        this.name = name;
        this.socket = socket;
        this.lastActive = Instant.now().toEpochMilli();
    }


    /**
     * Конструктор класса User.
     *
     * @param name   имя пользователя
     * @param socket сокет для общения с пользователем
     */
    /**
     * Создает объект User на основе сокета.
     *
     * @param socket сокет для общения с пользователем
     * @return объект User
     * @throws IOException при ошибке ввода/вывода
     */

    public long getLastActive() {
        return lastActive;
    }

    public void updateLastActive() {
        this.lastActive = Instant.now().toEpochMilli();
    }
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
