package mediator.message;

public class Message {
    private String sender;
    private String receiver;
    private String content;

    public Message(String sender, String receiver, String content) {
        this.sender = sender;
        this.content = content;
        this.receiver = receiver;
    }

    /**
     * Is converting special format string to Message object.
     * Expected format is sender@gmail.com:Check was failed.:receiver@gmail.com
     * @return Message object representation
     * @throws IllegalArgumentException when String is not in proper format
     */
    public static Message fromString(String message) throws IllegalArgumentException {
        if (message != null && message.split(":").length == 3 ) {
            String[] messageArray = message.split(":");
            return new Message(messageArray[0], messageArray[1], messageArray[2]);
        }
        throw new IllegalArgumentException("Wrong String format. Expected is <senderMail:message:receiverMail>");
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public String getReceiver() {
        return receiver;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
