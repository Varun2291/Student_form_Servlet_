// Author: Varun Rajavelu (G00937282)

// 1) This file is used to connect to the database base
// 2) Store student information provided by the user
// 3) Retrieve the student ids
// 4) Retrieve the student information based on the given id
package Student_Survey;

import java.sql.*;
import java.io.IOException;

public class StudentDAO {
	public void StoreStudentInformation(StudentBean StudentObj){
		
		try {
			// Establish the Database connection with Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g", "vrajavel", "oackac");
  
            Statement stmt = connection.createStatement();     
            
            // ----------------------------------------------------------
            // Create a new Table, execute this code only once
            // Since Oracle throws an exception if a table is not present
            // if not viable to first check if the table is present
            // So commenting the create table code.
            // Use it only the first time while creating the table
       // 	stmt.executeUpdate("CREATE TABLE STUDENT_INFORMATION" +
    	//	"(FNAME VARCHAR(32), LNAME VARCHAR(32), STUDENT_ID VARCHAR(15), GRADUATED VARCHAR(15),"
    	//	+ "ADDRESS VARCHAR(32), CITY VARCHAR(15), STATE VARCHAR(15), ZIP INTEGER, TELEPHONE VARCHAR(15),"
    	//	+ "EMAIL VARCHAR(25), URL VARCHAR(25), DATE_OF_SURVEY VARCHAR(15), THINGS_TO_LIKE VARCHAR(55), INTERESTS VARCHAR(15),"
    	//	+ "LIKELIHOOD VARCHAR(15), ADDITIONAL_COMMENTS VARCHAR(150))");
 			// ----------------------------------------------------------
            // ----------------------------------------------------------
            
            stmt.executeUpdate("INSERT INTO vrajavel.STUDENT_INFORMATION(FNAME, LNAME, STUDENT_ID, GRADUATED, ADDRESS, CITY, STATE, ZIP, TELEPHONE, EMAIL, URL, DATE_OF_SURVEY, THINGS_TO_LIKE, INTERESTS, LIKELIHOOD, ADDITIONAL_COMMENTS)" +
            "VALUES('" + StudentObj.getFname() + "','" + StudentObj.getLname()+ "','" +StudentObj.getStudentId()+ "','" +StudentObj.getGraduateDate()+ "','" +StudentObj.getAddress()+ "','" +StudentObj.getCity()+ "','" +StudentObj.getState()+ "','" +StudentObj.getZip()+ "','" +StudentObj.getTelePhone()+ "','" +StudentObj.getEmailId()+ "','" +StudentObj.getURL()+ "','" +StudentObj.getSurveyDate()+ "','" +StudentObj.getThingsToLike()+ "','" +StudentObj.getIntersts()+ "','" +StudentObj.getLikelyHood()+ "','" +StudentObj.getAdditionalComments()+"')");
           
        //    stmt.executeUpdate("DROP TABLE vrajavel.STUDENT_INFORMATION");
           
		}catch (Exception e) {
        	System.out.println(e);
        }
	}
	
	public StudentBean RetrieveStudentInformation(String StuId){
		StudentBean StudentBeanObj = new StudentBean();
		try {
			// Establish the Database connection with Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g", "vrajavel", "oackac");
  
            Statement stmt = connection.createStatement();
            ResultSet rs;
            
            rs = stmt.executeQuery("SELECT * FROM STUDENT_INFORMATION WHERE STUDENT_ID = '" + StuId + "'");
            while(rs.next())
            {
            	// Get the values entered by the user and store in Student Bean
        		StudentBeanObj.setFname(rs.getString("FNAME"));
        		StudentBeanObj.setLname(rs.getString("LNAME"));
        		StudentBeanObj.setStudentId(rs.getString("STUDENT_ID"));
        		StudentBeanObj.setGraduateDate(rs.getString("GRADUATED"));
        		StudentBeanObj.setAddress(rs.getString("ADDRESS"));
        		StudentBeanObj.setCity(rs.getString("CITY"));
        		StudentBeanObj.setState(rs.getString("STATE"));
        		StudentBeanObj.setZip(Integer.parseInt(rs.getString("ZIP")));
        		StudentBeanObj.setTelePhone(rs.getString("TELEPHONE"));
        		StudentBeanObj.setEmailId(rs.getString("EMAIL"));
        		StudentBeanObj.setURL(rs.getString("URL"));
        		StudentBeanObj.setSurveyDate(rs.getString("DATE_OF_SURVEY"));	
        		StudentBeanObj.setThingsToLike(rs.getString("THINGS_TO_LIKE"));
        		StudentBeanObj.setIntersts(rs.getString("INTERESTS"));
        		StudentBeanObj.setLikelyHood(rs.getString("LIKELIHOOD"));
        		StudentBeanObj.setAdditionalComments(rs.getString("ADDITIONAL_COMMENTS"));
        	
            }
            
		}catch (Exception e) {
        	System.out.println(e);
        }
		return StudentBeanObj;
	}
	
	public String RetrieveAllStudentIds(){
		String ListOfIds = "";
		try {
			// Establish the Database connection with Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@apollo.ite.gmu.edu:1521:ite10g", "vrajavel", "oackac");
  
            Statement stmt = connection.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM STUDENT_INFORMATION");
            int count = 0;
            while(rs.next()) 
            {            	
            	// Get the Student Id
            	String id = rs.getString("STUDENT_ID");
            
            	// Do not use comma if its the first value
            	// Convert the values into a string delimited with commas
            	if(count == 0){
            		ListOfIds = "" + id;
            		count++;
            	}
            	else
            		ListOfIds += "," + id;
            }
            
		}catch (Exception e) {
        	System.out.println(e);
        }
		return ListOfIds;
	}
}
