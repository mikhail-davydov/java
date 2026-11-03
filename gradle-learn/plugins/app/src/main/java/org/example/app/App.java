package org.example.app;

import org.example.Greeter;

public class App {

    public static void main(String[] args) {
        var greeter = new Greeter();
        System.out.println(greeter.greet("John Doe"));
    }

}
