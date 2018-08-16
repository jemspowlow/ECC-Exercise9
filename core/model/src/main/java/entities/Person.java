package entities;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Person{
	
	
	private int id;
	private Name name;
	private Date birthDay;
	private Date dateHired;
	private double gwa;
	private Gender gender;
	private boolean employed;
	private String school;
	private Address address;
	private List<Contact> contactInfo;
		
	public Person() {
	}
	
	public int getId() {
		return id;
	 }
	
	public void setId(int id) {
		this.id = id;
	 }

	public Gender getGender() {
		return gender;
	 }
	
	public void setGender(Gender gender) {
		this.gender = gender;
	 }
	 
	public double getGwa() {
		return gwa;
	 }
	
	public void setGwa(double gwa) {
		this.gwa = gwa;
	 }
	
	public boolean isEmployed() {
		return employed;
	 }
	
	public void setEmployed(boolean employed) {
		this.employed = employed;
	 }
	
	public String getSchool() {
		return school;
	 }
	
	public void setSchool(String school) {
		this.school = school;
	 } 
	
	public Address getAddress() {
		return address;
	 }	
	
	public void setAddress(Address address) {
		this.address = address;
	 }
	 
	public List<Contact> getcontactInfo() {
		return contactInfo;
	 }
	
	public void setcontactInfo(List<Contact> contactInfo) {
		this.contactInfo = contactInfo;
	 } 
	
	public Date getBirthDay() {
		return birthDay;
	 }
	 	
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	 }
	 public Date getDateHired() {
		return dateHired;
	 }
	 	
	public void setDateHired(Date dateHired) {
		this.dateHired = dateHired;
	 }
	public Name getName() { 
		return name;
	 } 
	public void setName(Name name) {
		this.name = name;
	 }

	public static class Name {
		private String firstName;
		private String lastName;
		private String middleName;
		public Name() {}
		
		public Name (String firstName, String lastName, String middleName) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.middleName = middleName;
		 }
	
		public String getFirstName() {
			return firstName;
		 }
	
		public String getLastName() {
			return lastName;
		 }
	
		public String getMiddleName() {
			return middleName;
		 } 
	
	 	public void setFirstName(String firstName) {
	 		this.firstName = firstName;
	 	 }
	 	 
	 	public void setLastName(String lastName) {
	 		this.lastName = lastName;
	 	 }
	 	
	 	public void setMiddleName(String middleName) {
	 		this.middleName = middleName;
	 	 }
	 }
}
