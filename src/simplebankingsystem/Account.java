package simplebankingsystem;

import java.util.Random;

public class Account {
	private int id = 0;
	private String name = "";
	private String cpf = "";
	private int agency = 0;
	SavingsAcct savingsAcct;
	CheckingAcct checkingAcct = new CheckingAcct();
	Random rand = new Random();
	
	Account (int id, String name, String cpf, int agency){
		this.name = name;
		this.cpf = cpf;
		this.agency = agency;
	}
	
	//getters and setters
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
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf= cpf;
	}
	
	public int getAgency() {
		return agency;
	}
	public void setAgency(int agency) {
		this.agency = agency;
	}
}