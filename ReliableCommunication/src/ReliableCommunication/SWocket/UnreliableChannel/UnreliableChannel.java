package ReliableCommunication.SWocket.UnreliableChannel;

import ReliableCommunication.Config.Configuration;
import ReliableCommunication.Config.LOG;
import ReliableCommunication.SWocket.Message;
import ReliableCommunication.SWocket.Address;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class UnreliableChannel {
    private Address[] endpoint;
    private Queue[] channelBuffer;
    private boolean isActive;
    private static final int NUM_NODES = Configuration.maxNodesInChannel;

    public UnreliableChannel(Address adds[]) {
        channelBuffer = new Queue[NUM_NODES];
        endpoint = new Address[NUM_NODES];

        Arrays.sort(adds, new Comparator<Address>()
        {
            @Override
            public int compare(Address a, Address b)
            {
                return a.getID() - b.getID();
            }
        } );

        for(int i = 0; i < NUM_NODES; i++) {
            endpoint[i] = adds[i];
            channelBuffer[i] = new ConcurrentLinkedQueue<Packet>();
        }
        isActive = true;
    }

    private int getAddrIndex(Address input) {
        for(int i = 0; i < NUM_NODES; i++) {
            if (input.getID() == endpoint[i].getID())
                return i;
        }

        return -1;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void killChannel() {
        this.isActive = false;
    }

    public void resurrectChannel() {
        this.isActive = true;
    }

    public void flipChannelStatus() {
        this.isActive = !this.isActive;
    }

    public boolean send(Address to, Packet packet) throws InactiveChannelException {
        if(!this.isActive)
            throw new InactiveChannelException("UnreliableChannel inactive! Cannot send to Address " + to.getID() + ".0.0.0.\n");

        int ind = getAddrIndex(to);

        boolean added = false;
        if(Configuration.allowMessageLoss) {
            double num = Math.random() * 100.0;
            if (num >= (100 * Configuration.lossProbability)) {
                added = channelBuffer[ind].add(packet);
            } else { // throw away message
                LOG.logMsgToss(packet, to);
                added = true;  //act like a loss...
            }
        } else {
            added = channelBuffer[ind].add(packet);
        }
        return added;
    }

    public Packet recv(Address recipient, int maxSize) throws InactiveChannelException{
        if(!this.isActive)
            throw new InactiveChannelException("UnreliableChannel inactive! Cannot send to Address " + recipient.getID() + ".0.0.0.\n");

        int recInd = getAddrIndex(recipient);
        Packet packet = null;

        do {
            if (channelBuffer[recInd].isEmpty())
                return null;

            packet = (Packet) channelBuffer[recInd].remove();

            if (!Configuration.allowMessageLoss)
                return packet;
            else if (Math.random() < Configuration.lossProbability) {
                LOG.logMsgToss(packet, recipient);
                packet = null; //throw away message...
            } else {
                if(Math.random() < Configuration.delayProbability &&
                        channelBuffer[recInd].size() > 1) {
                    channelBuffer[recInd].add(packet);  //put it BACK in the queue for later...
                    packet = null;
                } else {
                    return packet;
                }
            }
        } while (packet == null);

        return packet;
    }

    public boolean isCorrectChannel(Address a1, Address a2) {
        int minID = (a1.getID() < a2.getID()) ? a1.getID() : a2.getID();
        int nextID = (a1.getID() < a2.getID()) ? a2.getID() : a1.getID();

        if (endpoint[0].getID() == minID && endpoint[1].getID() == nextID)
            return true;

        return false;
    }
}
