package net.ilyane.matiere.models;

import java.io.Serializable;

public class Devoir implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1 ;
    private int id;
    private String name;
    private int note;
    private int eleve;
    private int matiere;
    
    



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public int getEleve() {
		return eleve;
	}

	public void setEleve(int eleve) {
		this.eleve = eleve;
	}

	public int getMatiere() {
		return matiere;
	}

	public void setMatiere(int matiere) {
		this.matiere = matiere;
	}


}