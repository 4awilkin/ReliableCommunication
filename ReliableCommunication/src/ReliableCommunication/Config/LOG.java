package ReliableCommunication.Config;

import ReliableCommunication.SWocket.Address;
import ReliableCommunication.SWocket.UnreliableChannel.Packet;

public class LOG {

    public static void logEvent (Address nodeReporting, String event) {}
    public static void logMsgLoss (Address nodeReporting, Packet lostMsg, Address intended) {}
    public static void logMsgToss (Packet lostMsg, Address intended) {}
    public static void logMsgDelay (Address nodeReporting, Packet delayedMsg, Address recipient) {}
    public static void logNodeCrash (Address nodeReporting, Address crashedNode) {}
    public static void logNodeAdd (Address nodeReporting, Address nodeAdded) {}
}
