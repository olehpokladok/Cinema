package com.oleh;

import java.util.Scanner;

import com.oleh.control.ConsolFactory;
import com.oleh.control.Console;
import com.oleh.model.Cinema;
import com.oleh.serialization.CinemaSerializator;

public class Main {

	static Cinema cinema = null;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		CinemaSerializator save = new CinemaSerializator();
		cinema = save.deserialize();
		System.out.println("Enter user type(admin or user): ");
		String userType = sc.next();
		Console console = ConsolFactory.getConsol(userType);
		console.runConsole(cinema);
		save.serialize(cinema);

	}
}
