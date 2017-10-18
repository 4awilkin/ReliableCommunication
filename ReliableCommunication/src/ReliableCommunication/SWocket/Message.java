package ReliableCommunication.SWocket;

public class Message<T> {
    int sizeOfAMessage;
    T msg;

    public Message() {
        msg = (T)new String("Default String");
    }

    public Message(T t, int s) {
        this.msg = t;
        this.sizeOfAMessage = s;
    }

    public T getMsg() {
        return this.msg;
    }
}
