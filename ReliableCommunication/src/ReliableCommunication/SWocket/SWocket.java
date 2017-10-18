package ReliableCommunication.SWocket;

import ReliableCommunication.SWocket.UnreliableChannel.Packet;

public interface SWocket {
    boolean connected = false;

    int send(Packet packet, int sizeOfData); //TODO: Add parmeters as needed
    Packet recv(int maxSizeBuffSize); //TODO: Add parmeters as needed

    void close();

    @Override
    String toString();
}
