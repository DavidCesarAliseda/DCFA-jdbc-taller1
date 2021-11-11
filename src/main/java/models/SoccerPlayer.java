package models;

import java.util.Date;

/**
 * Esta clase define el objeto soccerPlayer el cual representa un futbolista.
 * @author David César Fernández Aliseda
 * @version 11/11/21/A
 */

public class SoccerPlayer {
	//Campos de clase
	private int id;
	private String name;
	private Date birthDate;
	private String firstRol;
	private String secondRol;
	private int idTeam;
	
	/**
     * Constructor para soccerPlayer
     */
	public SoccerPlayer() {
		super();
	}
	
	//ID
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//Name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//BirthDate
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	//FirstRol
	public String getFirstRol() {
		return firstRol;
	}
	public void setFirstRol(String firstRol) {
		this.firstRol = firstRol;
	}
	
	//SecondRol
	public String getSecondRol() {
		return secondRol;
	}
	public void setSecondRol(String secondRol) {
		this.secondRol = secondRol;
	}
	
	//IdTeam
	public int getIdTeam() {
		return idTeam;
	}
	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}
	/**
     * Método para construir una cadena con el nombre y el primer rol del objeto.
     */
	//toString
	@Override
	public String toString() {
		return "SoccerPlayer: " + name + ", " + firstRol+".";
	}
	
	
	
}
