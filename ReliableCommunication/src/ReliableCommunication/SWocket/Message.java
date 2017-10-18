package ReliableCommunication.SWocket;

public class Message<T> {
    int sizeOfMessage;
    T msg;

    public Message() {
        msg = (T)new String("Default String");
    }

    public Message(T t, int s) {
        this.msg = t;
        this.sizeOfMessage = s;
    }

    public T getMsg() {
        return this.msg;
    }
}
