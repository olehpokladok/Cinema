package com.oleh.control;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.oleh.model.Cinema;
import com.oleh.model.Hall;
import com.oleh.model.Movie;
import org.apache.log4j.Logger;

public class AdminConsol implements Console {
	final static Logger log = Logger.getLogger(AdminConsol.class);
	@Override
	public void printInfo() {
		log.debug("Admin menu: ");
		System.out.println("1. Add movie ");
		System.out.println("2. Add hall ");
		System.out.println("3. Add session to movie");
		System.out.println("4. View session: ");
		System.out.println("5. View movie: ");
		System.out.println("6. View hall: ");
		System.out.println("7. Remowe session: ");
		System.out.println("8. Remowe movie: ");
		System.out.println("9. Remowe hall: ");
		System.out.println("0. Exit and save.");
	}

	@Override
	public void runConsole(Cinema cinema) {

		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy/HH:mm");
		boolean run = true;
		while (run) {
			printInfo();
			switch (sc.nextInt()) {
			case 1: {
				try {
					System.out.println("Entered name of film: ");
					String name = sc.next();
					log.debug("Admin add film: " + name);
					System.out.println("Entered duration: ");
					int duration = sc.nextInt();
					log.debug("Duration " + name + " is" + duration);
					System.out.println("Entered genre: ");
					String genre = sc.next();
					log.debug("Genre of " + name + "is " + genre);
					cinema.addMovie(name, duration, genre);

				} catch (InputMismatchException ex) {
					log.error("Incorrect entry dration. Only integer!");
					sc.next();
				}
			}
				break;
			case 2: {
				try {
					System.out.println("Entered name Hall ");
					String name = sc.next();
					log.debug("Admin add hall: " + name);
					System.out.println("Entered number places ");
					int numPlace = sc.nextInt();
					log.debug("At hall" + name + " number place is - " + numPlace);
					cinema.addHall(name, numPlace);
				} catch (InputMismatchException ex) {
					log.error("Incorrect entry number places. Only integer");
					sc.next();
				}
			}
				break;
			case 3: {
				try {
					cinema.printHallNames();
					System.out.println("Entered hall name:");
					String nameHall = sc.next();
					log.debug("Admin choose: " + nameHall);
					cinema.printMoviesNames();
					System.out.println("Entered movie name:");
					String nameMovie = sc.next();
					log.debug("Admin choose movie: " + nameMovie);
					System.out.println("Entered date and time started(dd/mm/yyyy/hh:mm): ");
					String startDateAndTime = sc.next();
					log.debug("Start movie: " + nameMovie + ", at hall: " + nameHall + ", is: " + startDateAndTime);
					LocalDateTime start = LocalDateTime.parse(startDateAndTime, formatter);
					Hall hall = cinema.getHallByName(nameHall);
					Movie movie = cinema.getMovieByName(nameMovie);
					if (hall != null && movie != null) {
						System.out.println(hall);
						System.out.println(movie);
						System.out.println(start);
						hall.addSession(start, movie);
					}
				} catch (InputMismatchException ex) {
					log.error("Incorrect entry.");
					sc.next();
				} catch (DateTimeParseException ex) {
					log.error("Incorrect entry date/time. Please entry dd/mm/yyyy/hh:mm");
					sc.next();
				}
			}
				break;
			case 4: {
				cinema.printHalls();
				System.out.println("Entered hall name:");
				String nameHall = sc.next();
				log.debug("Admin choose: " + nameHall);
				Hall hall = cinema.getHallByName(nameHall);
				if (hall != null) {
					hall.printSessions();
				}
			}
				break;
			case 5: {
				cinema.printMovies();
			}
				break;
			case 6: {
				log.debug("All halls: ");
				cinema.printHalls();
			}
				break;
			case 7: {
				try {
					System.out.println("Entered hall name: ");
					String nameHall = sc.next();
					log.debug("Admin choose " + nameHall + " to remowe");
					System.out.println("Entered session index: ");
					int index = sc.nextInt();
					log.debug("Session index to remowe is: " + index);
					Hall hall = cinema.getHallByName(nameHall);
					if (hall != null) {
						hall.remoweSession(index);
					}
				} catch (InputMismatchException ex) {
					log.error("Incorrect entry.");
					sc.next();
				} catch (IndexOutOfBoundsException ex) {
					log.error("This index aren't created.");
				}

			}
				break;
			case 8: {
				cinema.printMovies();
				System.out.println("Enter film name: ");
				String name = sc.next();
				log.debug("Admin movie to remowe is: " + name);
				cinema.remoweMovie(name);
			}
				break;
			case 9: {
				cinema.printHalls();
				System.out.println("Enter hall name: ");
				String name = sc.next();
				log.debug("Admin hall to remowe is: " + name);
				cinema.remoweHall(name);
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
