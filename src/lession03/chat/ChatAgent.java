package lession03.chat;

public class ChatAgent {

    public static void main(String[] args) {
        new Thread(new ChatSender(7777,"localhost", 9999)).start();
        new Thread(new ChatReceiver(8888)).start();
    }
}
