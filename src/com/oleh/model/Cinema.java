package com.oleh.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Cinema implements Serializable {

	private Set<Hall> hallSet = new HashSet<>();
	private Set<Movie> movieSet = new HashSet<>();

	public Cinema() {
		super();
	}

	public boolean addMovie(String name, int duration, String genre) {
		movieSet.add(new Movie(name, duration, genre));
		System.out.println("Movie added!");
		return true;
	}

	public void remoweMovie(String name) {
		Iterator<Movie> movieIter = movieSet.iterator();
		while (movieIter.hasNext()) {
			if (movieIter.next().getName().equalsIgnoreCase(name)) {
				movieIter.remove();
				System.out.println("Movie remowed!");
			} else {
				System.out.println("You entered invalid movie");
			}
		}

	}

	public void printMovies() {
		for (Movie movie : movieSet) {
			System.out.println(movie);
		}
	}

	public void printMoviesNames() {
		for (Movie movie : movieSet) {
			System.out.print(movie.getName() + ", ");
		}
	}

	public Movie getMovieByName(String name) {
		for (Movie m : movieSet) {
			if (m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}

	public void addHall(String name, int numberPlaces) {
		hallSet.add(new Hall(name, numberPlaces));
		System.out.println("Hall added!");
	}

	public void remoweHall(String hallName) {
		Iterator<Hall> hallIter = hallSet.iterator();
		while (hallIter.hasNext()) {
			if (hallIter.next().getName().equalsIgnoreCase(hallName)) {
				hallIter.remove();
			} else {
				System.out.println("You entered invaid hall!");
			}
		}
	}

	public void printHalls() {
		for (Hall hall : hallSet) {
			System.out.println(hall);
		}
	}

	public void printHallNames() {
		for (Hall hall : hallSet) {
			System.out.print(hall.getName() + ", ");
		}
	}

	public Hall getHallByName(String name) {
		for (Hall h : hallSet) {
			if (h.getName().equalsIgnoreCase(name)) {
				return h;
			}
		}
		return null;
	}

	public void printSessionByDate(LocalDate date) {
		for (Hall h : hallSet) {
			for (Session s : h.getSessionList()) {
				if (s.getDtStart().toLocalDate().equals(date)) {
					System.out.println(s +" " + s.getMovie());
				}
			}
		}
	}

	public void printSessionByMovie(String name) {
		for (Hall hall : hallSet) {
			for (Session ses : hall.getSessionList()) {
				if(ses.getMovie().getName().equalsIgnoreCase(name)) {
					System.out.println(ses +"- " +  hall.getName());	
				}
				
			}
		}
	}

	public void printAllSessionDates() {
		for (Hall hall : hallSet) {
			for (Session ses : hall.getSessionList()) {
				System.out.println(ses.getDtStart().toLocalDate() + ", " + hall.getName());
			}
		}
	}

}
