package test.GroupCommunication; 

import ReliableCommunication.Application.Client;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** 
* Server Tester. 
* 
* @author <Authors name> 
* @since <pre>Oct 9, 2017</pre> 
* @version 1.0 
*/ 
public class ServerTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: start(int port) 
* 
*/ 
@Test
public void testStart() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: stop() 
* 
*/ 
@Test
public void testStop() throws Exception { 
//TODO: Test goes here... 
}

    @org.junit.jupiter.api.Test
    public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() {
        Client client = new Client();
        client.startConnection("127.0.0.1", 6666);
        String response = client.sendMessage("hello server");
        assertEquals("hello client", response);
    }

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here... 
} 


} 
