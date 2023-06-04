package simplebankingsystem.model;

public class Account {
    private int id;
    private String name;
    private String cpf;
    private int agency;
    CheckingAcct checkingAcct;
    SavingsAcct savingsAcct;

    public Account() {
        checkingAcct = new CheckingAcct();
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