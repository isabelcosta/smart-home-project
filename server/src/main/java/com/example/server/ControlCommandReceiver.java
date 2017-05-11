package com.example.server;

import java.util.Scanner;

/**
 * Created by isabelcosta on 10-May-17.
 */

public class ControlCommandReceiver {

    private String initialOptions = "\n" + "Execute one of these commands:"
            + "\n" + "{1} INIT -D <deviceX> -v <valueX> -> set a device's initial value"
            + "\n" + "{2} SET -D <deviceX> -v <valueX> -> set a device's value"
            + "\n" + "{3} GET -D <deviceX> -> get info from a device"
            + "\n" + "{4} GET -R <deviceX> -> get info from a division/room"
            + "\n" + "{5} GET -D -> get all devices {id :: name}"
            + "\n" ;



    public void start() {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println(initialOptions);
        int n = reader.nextInt(); // Scans the next token of the input as an int.
        System.out.println("thanks!");
    }
}
