/**
 * Класс, представляющий текстовое сообщение.
 */
package model;

public class TextMessage extends Message {

    private String content;

    /**
     * Конструктор класса TextMessage.
     *
     * @param content содержимое текстового сообщения
     */
    public TextMessage(String content) {
        this.content = content;
    }

    /**
     * Получает содержимое текстового сообщения.
     *
     * @return содержимое текстового сообщения
     */
    public String getContent() {
        return content;
    }

    /**
     * Переопределенный метод toString.
     * Возвращает строковое представление текстового сообщения.
     *
     * @return строковое представление текстового сообщения
     */
    @Override
    public String toString() {
        return content;
    }
}
