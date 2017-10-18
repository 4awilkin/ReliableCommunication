package ReliableCommunication.SWocket.UnreliableChannel;

import ReliableCommunication.SWocket.Address;

public class Datagram {

    class Header {
        short version;
        short IHL;
        short totalLength;
        short identification;
        short fragOffset;
        short TTL;
        short headerChecksum;
        Address sourceAddress;
        Address destinationAddress;
        int options;
    }

    Packet packet;
}
