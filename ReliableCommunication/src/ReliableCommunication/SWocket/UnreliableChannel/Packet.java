package ReliableCommunication.SWocket.UnreliableChannel;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class Packet {
    class Header {
        short sourcePort;
        short destinationPort;
        int seqNum;
        int ackNum;
        //byte flags; //each bit is a flag
        boolean URG;
        boolean ACK;
        boolean PSH;
        boolean RST;
        boolean SYN;
        boolean FIN;
        short windowSize;
        short checksum;

        Header() {
            sourcePort = destinationPort = 0;
            seqNum = ackNum = 0;
            URG = ACK = PSH = RST = SYN = FIN = false;
            windowSize = checksum = 0;
        }
    }

    private Header header;
    private ArrayList<Byte> data;

    public Packet() {
        header = new Header();
        data = new ArrayList<Byte>();
    }

    public Packet(ArrayList<Byte> dataSomethin) {
        header = new Header();
        this.data = dataSomethin;
    }

    public Packet(Header header, ArrayList<Byte> data) {
        this.header = header;
        this.data = data;
    }

    public void addData(String data) {
        for(byte b : data.getBytes())
            this.data.add(b);
    }

    public void addData(Object data) {
        for(byte b : data.toString().getBytes())
            this.data.add(b);
    }

    public void addData(int data) {
        for(byte b : ByteBuffer.allocate(Integer.BYTES).putInt(data).array())
            this.data.add(b);
    }

    public void addData(short data) {
        for(byte b : ByteBuffer.allocate(Short.BYTES).putShort(data).array())
            this.data.add(b);
    }

    public void addData(long data) {
        for(byte b : ByteBuffer.allocate(Long.BYTES).putLong(data).array())
            this.data.add(b);
    }

    public void addData(byte data) {
        this.data.add(data);
    }

    public ArrayList<Byte> getData() {
        return data;
    }

    public void setData(ArrayList<Byte> data) {
        this.data = data;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }
}
