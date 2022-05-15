package co.edu.javeriana.as.personapp.api.model.response;

import co.edu.javeriana.as.personapp.api.model.request.PersonaApiRequest;

public class PersonaApiResponse extends PersonaApiRequest {
	
	private String status;
	
	public PersonaApiResponse(String dni, String firstName, String lastName, String age, String sex, String status) {
		super(dni, firstName, lastName, age, sex);
		this.status = status;
	}

	public PersonaApiResponse() {
		super();
		this.status = "";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
