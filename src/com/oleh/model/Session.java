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
		public void setDtStart(LocalDateTime dtStart) {
			this.dtStart = dtStart;
		}
		public LocalDateTime getDtEnd() {
			return dtEnd;
		}
		public void setDtEnd(LocalDateTime dtEnd) {
			this.dtEnd = dtEnd;
		}
		public Movie getMovie() {
			return movie;
		}
		public void setMovie(Movie movie) {
			this.movie = movie;
		}
		@Override
		public String toString() {
			return "Session [dtStart=" + dtStart + ", dtEnd=" + dtEnd + "]";
		}
		
		

}
