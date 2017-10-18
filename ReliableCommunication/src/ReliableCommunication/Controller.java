package ReliableCommunication;

import ReliableCommunication.SWocket.Address;
import ReliableCommunication.SWocket.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class Controller {
    private ArrayList<Address> group;
    private ArrayList<Address> failed;
    private Queue<Message> buffer;
    private HashMap<Address, Message> msgMap;
}
