package com.clinic.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appointment 
{
	@Id
	@Column(name="id")
	private long id;
	private String name;
	private String doa;
	private String toa;
	private String symptoms;
	public Appointment() {
		super();
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", doa=" + doa + ", toa=" + toa + ", symptoms=" + symptoms + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDoa() {
		return doa;
	}
	public void setDoa(String doa) {
		this.doa = doa;
	}
	public String getToa() {
		return toa;
	}
	public void setToa(String toa) {
		this.toa = toa;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	
	
	
	
	
}
