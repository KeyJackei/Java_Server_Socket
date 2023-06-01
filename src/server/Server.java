/**
 * @file Server.java
 * @brief Класс, представляющий сервер
 */

package server;

import model.UserMap;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @class Server
 * @brief Класс, представляющий сервер
 */
public class Server {

    private static final int SERVER_PORT = 8080;
    private UserMap userMap;
    private PingClient pingClient;

    /**
     * @brief Конструктор класса Server
     */
    public Server() {
        userMap = new UserMap();
        long timeout = 5000; // устанавливаем время таймаута
        this.pingClient = new PingClient(userMap, timeout);
    }

    /**
     * @brief Запускает сервер и ожидает подключения клиентов
     */
    public void start() {
        this.pingClient.start(); // запускаем PingClient
        try (var listener = new ServerSocket(SERVER_PORT)) {
            while (true) {
                Socket socket = listener.accept();
                ClientHandler client = new ClientHandler(socket, userMap);
                client.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}





















///**
// * @file Server.java
// * @brief Класс, представляющий сервер
// */
//
//package server;
//
//import model.UserMap;
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//
///**
// * @class Server
// * @brief Класс, представляющий сервер
// */
//public class Server {
//
//    private static final int SERVER_PORT = 8080;
//    private UserMap userMap;
//
//    /**
//     * @brief Конструктор класса Server
//     */
//    public Server() {
//        userMap = new UserMap();
//    }
//
//    /**
//     * @brief Запускает сервер и ожидает подключения клиентов
//     */
//    public void start() {
//        try (var listener = new ServerSocket(SERVER_PORT)) {
//            while (true) {
//                Socket socket = listener.accept();
//                ClientHandler client = new ClientHandler(socket, userMap);
//                client.start();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
