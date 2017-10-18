package ReliableCommunication.SWocket;

import ReliableCommunication.SWocket.UnreliableChannel.Packet;

public class ClientSWocket implements SWocket {
    String serverName;
    boolean isTCP;
    Address myAddr;
    //TODO: You will need more fields


    private ClientSWocket() {
        this.isTCP = true;
    }

    public ClientSWocket(int id, int port) {
        this();
        this.myAddr = new Address(id, port);
    }

    public boolean connect(Address serverAddr) {
        return false;
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
