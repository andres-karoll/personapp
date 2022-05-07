package co.edu.javeriana.as.personapp.api.model.response;

import co.edu.javeriana.as.personapp.api.model.request.CrearPersonaRequest;

public class CrearPersonaResponse extends CrearPersonaRequest{
	
	private String status;
	
	public CrearPersonaResponse(String dni, String firstName, String lastName, String age, String sex, String status) {
		super(dni, firstName, lastName, age, sex);
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	

}
