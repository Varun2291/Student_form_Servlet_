// Author: Varun Rajavelu (G00937282)

// It contains all the setter and getters for the student
package Student_Survey;

import java.io.Serializable;

public class StudentBean implements Serializable {
	private String Fname;
	private String Lname;
	private String StudentId;
	private String GraduateDate;
	private String Address;
	private String City;
	private String State;
	private int Zip;
	private String TelePhone;
	private String EmailId;
	private String URL;
	private String SurveyDate;
	private String ThingsToLike;
	private String Intersts;
	private String LikelyHood;
	private String AdditionalComments;
	
	public StudentBean(){
		
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		this.Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		this.Lname = lname;
	}

	public String getStudentId() {
		return StudentId;
	}

	public void setStudentId(String studentId) {
		this.StudentId = studentId;
	}

	public String getGraduateDate() {
		return GraduateDate;
	}

	public void setGraduateDate(String graduateDate) {
		this.GraduateDate = graduateDate;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		this.City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		this.State = state;
	}

	public int getZip() {
		return Zip;
	}

	public void setZip(int zip) {
		this.Zip = zip;
	}

	public String getTelePhone() {
		return TelePhone;
	}

	public void setTelePhone(String telePhone) {
		this.TelePhone = telePhone;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		this.EmailId = emailId;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		this.URL = uRL;
	}

	public String getSurveyDate() {
		return SurveyDate;
	}

	public void setSurveyDate(String surveyDate) {
		this.SurveyDate = surveyDate;
	}
	
	public String getThingsToLike() {
		return ThingsToLike;
	}

	public void setThingsToLike(String thingsToLike) {
		this.ThingsToLike = thingsToLike;
	}

	public String getIntersts() {
		return Intersts;
	}

	public void setIntersts(String intersts) {
		this.Intersts = intersts;
	}

	public String getLikelyHood() {
		return LikelyHood;
	}

	public void setLikelyHood(String likelyHood) {
		this.LikelyHood = likelyHood;
	}

	public String getAdditionalComments() {
		return AdditionalComments;
	}

	public void setAdditionalComments(String additionalComments) {
		this.AdditionalComments = additionalComments;
	}
}
