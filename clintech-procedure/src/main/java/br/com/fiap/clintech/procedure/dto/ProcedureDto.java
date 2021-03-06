package br.com.fiap.clintech.procedure.dto;

public class ProcedureDto {

	private Long id;
	private String name;
	private String decription;
	private boolean isAuthorizationM;
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public boolean isAuthorizationM() {
		return isAuthorizationM;
	}
	public void setAuthorizationM(boolean isAuthorizationM) {
		this.isAuthorizationM = isAuthorizationM;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("**** PROCEDURE DTO **** \n");
		sb.append("ID: ").append(this.getId()).append("\n");
		sb.append("Name: ").append(this.getName()).append("\n");
		sb.append("Description: ").append(this.getDecription()).append("\n");
		sb.append("Is authorization Mandatory: ").append(this.isAuthorizationM()).append("\n");
				
		return sb.toString();
	}
}
