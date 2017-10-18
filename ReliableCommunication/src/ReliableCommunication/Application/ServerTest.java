package ReliableCommunication.Application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServerTest {
    @Test
    public void givenGreetingClient_whenServerRespondsWhenStarted_thenCorrect() {
        Client client = new Client();
        client.startConnection("127.0.0.1", 6666);
        String response = client.sendMessage("hello server");
        assertEquals("hello client", response);
    }
}
