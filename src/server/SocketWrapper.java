/**
 * Класс, обертывающий сокет для упрощенной работы с вводом/выводом.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketWrapper {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    /**
     * Конструктор класса SocketWrapper.
     *
     * @param socket сокет для обертывания
     * @throws IOException при ошибке ввода/вывода
     */
    public SocketWrapper(Socket socket) throws IOException {
        this.socket = socket;
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream(), true);
    }

    /**
     * Отправляет строку через сокет.
     *
     * @param message строка для отправки
     */
    public void writeLine(String message) {
        writer.println(message);
    }

    /**
     * Читает строку из сокета.
     *
     * @return прочитанная строка
     * @throws IOException при ошибке ввода/вывода
     */
    public String readLine() throws IOException {
        return reader.readLine();
    }

    /**
     * Закрывает сокет, входной и выходной потоки.
     *
     * @throws IOException при ошибке ввода/вывода
     */
    public void close() throws IOException {
        reader.close();
        writer.close();
        socket.close();
    }
}
