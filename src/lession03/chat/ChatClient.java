package lession03.chat;

public class ChatClient {
    public static void main(String[] args) {
        new Thread(new ChatSender(6666,"localhost", 8888)).start();
        new Thread(new ChatReceiver(9999)).start();
    }
}
