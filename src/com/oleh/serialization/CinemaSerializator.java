package com.oleh.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.oleh.model.Cinema;

public class CinemaSerializator {

	public void serialize(Cinema cinema) {
		try {
			File file = new File("cinema.txt");
			FileOutputStream fileOut = new FileOutputStream("cinema.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(cinema);
			out.close();
			fileOut.close();
			System.out.printf("Saved in cinema.txt");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public Cinema deserialize() {
		try {
	         FileInputStream fileIn = new FileInputStream("cinema.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         Cinema cinema = (Cinema) in.readObject();
	         in.close();
	         fileIn.close();
	         return cinema;
	      } catch (Exception i) {
	    	  i.printStackTrace();
	    	  
	      }
		return new Cinema();
	}
}
