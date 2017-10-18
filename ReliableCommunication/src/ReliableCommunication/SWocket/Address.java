package ReliableCommunication.SWocket;

public class Address {
    private static int counter = 1;
    int id;
    int port;

    public Address() {
        this.id = counter++;
        this.port = 5555;
    }

    public Address(int justID) {
        this.id = justID;
        this.port = 5555;
    }

    public Address(int justID, int port) {
        this.id = justID;
        this.port = port;
    }

    public int getID() {
        return this.id;
    }

    public int getPort() {
        return this.port;
    }

    public String getAddrFromID() {
        return String.format("%d.0.0.0:%d", this.id, this.port);
    }

    public static String getAddrFromID(Address addr) {
        return addr.getAddrFromID();
    }

    public void setPort(int port) {
        this.port = port;
    }
}
