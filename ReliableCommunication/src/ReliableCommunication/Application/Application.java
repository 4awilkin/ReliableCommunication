package ReliableCommunication.Application;

import ReliableCommunication.Config.Configuration;
import ReliableCommunication.SWocket.Address;
import ReliableCommunication.SWocket.Message;
import ReliableCommunication.SWocket.UnreliableChannel.UnreliableChannel;
import ReliableCommunication.SWocket.UnreliableChannel.InactiveChannelException;

import static java.lang.Thread.sleep;

public class Application {
    public static void main(String args[]){
        System.out.println("Hey there! Again");

        Address add1 = new Address();
        Address add2 = new Address();

        UnreliableChannel channel = new UnreliableChannel(new Address[]{add1, add2});

       /* try {
            String msgToSend = "I Hope This Is Successful!!";
            //channel.send(add1, new Message<String>(msgToSend, msgToSend.length()));
        } catch (InactiveChannelException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        }*/

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Message<String> finalMsg = null;
        /*try {
            finalMsg = channel.recv(add1, Configuration.maxMessageSize);
        } catch (InactiveChannelException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Back to the drawing board...");
        }*/

        System.out.println("Program finished!\nMessage received: " + finalMsg.getMsg());

    }
}
