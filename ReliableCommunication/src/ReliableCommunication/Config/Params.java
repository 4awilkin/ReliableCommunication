package ReliableCommunication.Config;

public class Params {
    public Configuration localConfig;
    public static int curGlobalTime;

    public Params(){
        curGlobalTime = 0;
        localConfig = new Configuration();
    }
    public static void tick() {curGlobalTime++;}
    public static int getCurrentTime() {return curGlobalTime;}
}
