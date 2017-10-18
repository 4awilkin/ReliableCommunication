package ReliableCommunication.Config;

public class Configuration {
    public static int numNodes = 2;
    public static int maxNodesInChannel = 2;
    public static int maxNodesInSocket = 2;
    public static int maxMessageSize = 10000;
    public static int maxServerConnections = 1;
    public static double lossProbability = 0.25f;
    public static double delayProbability = 0.35f;
    public static double maxDelay = 100.0;
    public static boolean testTCP = false;
    public static boolean allowMessageLoss = false;
    public static boolean allowDelay = true;
    public static boolean allowMesgSplit = false;
    public static boolean testGroup = false;
}

