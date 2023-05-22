package model;

public class TextMessage extends Message {
    private String content;

    public TextMessage(String content) {

        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }

}
