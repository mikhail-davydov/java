package org.example.greeter;

import org.example.repository.User;

public class Greeter implements IGreeter {

    @Override
    public void greet(User user) {
        System.out.println("Hello, %s!".formatted(user.name()));
    }

}
