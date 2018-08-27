package io.github.julianjupiter.addressbook;

import io.github.julianjupiter.addressbook.server.TomcatServer;
import java.io.IOException;

public class AddressBookApp {
    
    public static void main(String[] args) throws IOException {
        TomcatServer.run(args);
    }
    
}
