package com.oleh.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Session implements Serializable {

	private LocalDateTime dtStart;
	private LocalDateTime dtEnd;
	private Movie movie;

	public Session(LocalDateTime dtStart, LocalDateTime dtEnd, Movie movie) {
		this.dtStart = dtStart;
		this.dtEnd = dtEnd;
		this.movie = movie;
	}

	public LocalDateTime getDtStart() {
		return dtStart;
	}

	public LocalDateTime getDtEnd() {
		return dtEnd;
	}

	public Movie getMovie() {
		return movie;
	}

	@Override
	public String toString() {
		return "Session [dtStart=" + dtStart + ", dtEnd=" + dtEnd + "]";
	}

}
