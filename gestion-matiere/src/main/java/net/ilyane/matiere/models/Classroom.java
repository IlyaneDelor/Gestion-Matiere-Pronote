package net.ilyane.matiere.models;

import java.io.Serializable;

public class Classroom implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1 ;
    private int id;
    private int numberClass;
    private String eleve;
    private int prof;
    private int matiere;
    



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberClass() {
		return numberClass;
	}

	public void setNumberClass(int numberClass) {
		this.numberClass = numberClass;
	}

	public String getEleve() {
		return eleve;
	}

	public void setEleve(String eleve) {
		this.eleve = eleve;
	}

	public int getProf() {
		return prof;
	}

	public void setProf(int prof) {
		this.prof = prof;
	}

	public int getMatiere() {
		return matiere;
	}

	public void setMatiere(int matiere) {
		this.matiere = matiere;
	}

}