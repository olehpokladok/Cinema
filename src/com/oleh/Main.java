package com.oleh;

import com.oleh.control.ConsolFactory;
import com.oleh.control.Console;
import com.oleh.model.Cinema;
import com.oleh.serialization.CinemaSerializator;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Main {

    static Cinema cinema = null;
    static Scanner sc = new Scanner(System.in);
    final static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        log.debug("New session!");
        CinemaSerializator save = new CinemaSerializator();
        cinema = save.deserialize();
        System.out.println("Enter user type(admin or user): ");
        String userType = sc.next();
        Console console = ConsolFactory.getConsol(userType);
        console.runConsole(cinema);
        save.serialize(cinema);

    }
}
