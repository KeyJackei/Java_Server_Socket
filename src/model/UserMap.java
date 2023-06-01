/**
 * Класс, представляющий коллекцию пользователей.
 */
package model;

import java.util.concurrent.ConcurrentHashMap;

public class UserMap {

    private ConcurrentHashMap<String, User> users;

    /**
     * Конструктор класса UserMap.
     * Создает экземпляр ConcurrentHashMap.
     */
    public UserMap() {
        users = new ConcurrentHashMap<>();
    }

    /**
     * Добавляет пользователя в коллекцию.
     *
     * @param user пользователь для добавления
     */
    public void addUser(User user) {
        users.put(user.getName(), user);
    }

    /**
     * Удаляет пользователя из коллекции.
     *
     * @param user пользователь для удаления
     */
    public void removeUser(User user) {
        users.remove(user.getName());
    }

    /**
     * Получает коллекцию пользователей.
     *
     * @return коллекция пользователей
     */
    public ConcurrentHashMap<String, User> getUsers() {
        return users;
    }

}
