package com.mindtree.insuranceCompanyApp.service.serviceImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.hibernate.service.spi.ServiceException;

import com.mindtree.insuranceCompanyApp.dto.CompanyDto;

public class SerializeObject {

	String filename = "file.txt";

	public boolean serialize(List<CompanyDto> li) {

		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(li);

			out.close();
			file.close();
		} catch (FileNotFoundException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (IOException e) {
			throw new ServiceException(e.getMessage(), e);
		}

		System.out.println("Object has been serialized");

		return true;

	}

	public boolean deserialize() {

		String output = "";
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			output = in.readObject().toString();
			
			in.close();
			file.close();
		} catch (FileNotFoundException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (IOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		System.out.println("Object has been deserialized\n" + "Data after Deserialization.");
		System.out.println(output);
		return true;
	}

}
