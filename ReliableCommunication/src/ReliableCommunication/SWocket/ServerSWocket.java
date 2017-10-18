package ReliableCommunication.SWocket;
import ReliableCommunication.Config.Configuration;
import ReliableCommunication.SWocket.UnreliableChannel.Packet;


public class ServerSWocket implements SWocket {
    String clientName;
    boolean isTCP;
    private Address serverAddr;
    //TODO: You will need more fields


    private ServerSWocket() {
        this.isTCP = true;
        //...
    }

    public ServerSWocket(int id, int port) {
        this();
        this.serverAddr = new Address(id, port);
        this.bind(this.serverAddr);
        this.listen(Configuration.maxServerConnections);
    }

    public boolean bind(Address servAddr) {
        return false;
    }


    public boolean listen(int maxConnections) {
        return false;
    }


    public ClientSWocket accept() {
        return null;
    }

    @Override
    public int send(Packet packet, int sizeOfData) {
        return 0;
    }

    @Override
    public Packet recv(int maxSizeBuffSize) {
        return null;
    }

    @Override
    public void close() {

    }
}
