package com.oleh.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hall implements Serializable {

	private String name;
	private int numberPlaces;
	private List<Session> sessionList = new ArrayList<>();

	public Hall(String name, int numberPlaces) {
		super();
		this.name = name;
		this.numberPlaces = numberPlaces;
	}

	public boolean addSession(LocalDateTime dtStart,  Movie movie) {
		LocalDateTime end = dtStart.plusMinutes(movie.getDuration());
		sessionList.add(new Session(dtStart, end, movie));
		System.out.println("Session added: ");
		return true;
	}

	public void remoweSession(int index) {
		sessionList.remove(index);
		System.out.println("Session deleted!");
	}

	public void printSessions() {
		for(Session s : sessionList) {
			System.out.println(s + " " + sessionList.indexOf(s));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberPlaces() {
		return numberPlaces;
	}

	public void setNumberPlaces(int numberPlaces) {
		this.numberPlaces = numberPlaces;
	}
	
	public List<Session> getSessionList(){
		return sessionList;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberPlaces;
		result = prime * result + ((sessionList == null) ? 0 : sessionList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hall other = (Hall) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberPlaces != other.numberPlaces)
			return false;
		if (sessionList == null) {
			if (other.sessionList != null)
				return false;
		} else if (!sessionList.equals(other.sessionList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hall [name=" + name + ", numberPlaces=" + numberPlaces + "]";
	}
	
	
}
