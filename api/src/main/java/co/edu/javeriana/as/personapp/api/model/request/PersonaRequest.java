package co.edu.javeriana.as.personapp.api.model.request;


public class PersonaRequest {
	private String dni;
	private String firstName;
	private String lastName;
	private String age;
	private String sex;
	public PersonaRequest(String dni, String firstName, String lastName, String age, String sex) {
		super();
		this.dni = dni;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.sex = sex;
	}
	public PersonaRequest() {}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	

}
