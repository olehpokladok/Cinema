package com.oleh.control;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import com.oleh.model.Cinema;
import org.apache.log4j.Logger;

public class UserConsol implements Console {

	final static Logger log = Logger.getLogger(UserConsol.class);
	@Override
	public void printInfo() {
		log.debug("User menu");
		System.out.println("1. Session for day");
		System.out.println("2. Session by movie");
		System.out.println("3. List movie");
		System.out.println("0. Exit");
	}

	@Override
	public void runConsole(Cinema cinema) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		boolean run = true;
		while (run) {
			printInfo();
			switch (sc.nextInt()) {
			case 1: {
				try {
					cinema.printAllSessionDates();
					System.out.println("Enter daytes(dd/MM/yyyy)");
					String date = sc.next();
					log.debug("Users choose date: " + date);
					LocalDate d = LocalDate.parse(date, formatter);
					cinema.printSessionByDate(d);
				} catch (DateTimeParseException ex) {
					log.error("Please enter date how in example!");
				}
			}
				break;
			case 2: {
				cinema.printMoviesNames();
				System.out.println("Entere movie: ");
				String name = sc.next();
				log.debug("User choose movie: " + name);
				cinema.printSessionByMovie(name);
			}
				break;
			case 3: {
				log.debug("All movies.");
				cinema.printMovies();
			}
				break;
			case 0: {
				run = false;
				break;
			}

			}
		}
	}
}
