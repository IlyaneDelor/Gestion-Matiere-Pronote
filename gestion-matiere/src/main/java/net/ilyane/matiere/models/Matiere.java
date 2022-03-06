package net.ilyane.matiere.models;

import java.io.Serializable;

public class Matiere implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1 ;
    private int id;
    private String name;
    private int coef;
   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



}