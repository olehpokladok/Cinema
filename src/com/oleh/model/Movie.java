package com.oleh.model;

import java.io.Serializable;

public class Movie implements Serializable {

	private String name;
	private int duration;
	private String genre;

	public Movie(String name, int duration, String genre) {
		super();
		this.name = name;
		this.duration = duration;
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}

	public String getGenre() {
		return genre;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", duration=" + duration + ", genre=" + genre + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duration;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Movie other = (Movie) obj;
		if (duration != other.duration)
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
