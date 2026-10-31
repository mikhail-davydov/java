package org.example.app;

import org.example.greeter.Greeter;
import org.example.greeter.IGreeter;
import org.example.repository.User;

public class Main {

    public static void main(String[] args) {
        var user = new User("John Doe");
        IGreeter greeter = new Greeter();
        greeter.greet(user);
    }

}
