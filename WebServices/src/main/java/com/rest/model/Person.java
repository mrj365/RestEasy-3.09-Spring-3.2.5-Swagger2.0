package com.rest.model;


import java.io.Serializable;

public class Person implements Serializable {


    private static final long serialVersionUID = 1L;

    private int id;

    private String firstName;
    
    private String lastName;

    public Person() {
    }

    
    public int getId() {
		return id;
	}

	public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return this.firstName;
    }

    public void setName(String name) {
        this.firstName = name;
    }


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



  

}

