<!-- Author: Varun Rajavelu (G00937282) -->

<!-- This file is used to display the end result after retrieving 
the student information from the database -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Information</title>
<style>
	h2 {font-family:vendana;color:black;}
	p {}
		
	span.jquery {
		text-align: center;
	}
	
	div::after {
		content: "";
		background: url(GMU_Background.jpg);
		opacity: 0.5;
		top: 0;
		left: 0;
		bottom: 0;
		right: 0;
		position: absolute;
		z-index: -1;   
	}
	</style>
</head>
<body>

<div>
	<h2><u>The Retrieved Student details:</u></h2>
	<table style="padding: 10px;">
	<h3>	<tr><td>First Name</td><td>:&nbsp;${StudentBeanObj.getFname()}</td></tr>
		<tr><td>Last Name</td><td>:&nbsp;${StudentBeanObj.getLname()}</td></tr>
		<tr><td>Student Id</td><td>:&nbsp;${StudentBeanObj.getStudentId()}</td></tr>
		<tr><td>Graduated Date</td><td>:&nbsp;${StudentBeanObj.getGraduateDate()}</td></tr>
		<tr><td>Address</td><td>:&nbsp;${StudentBeanObj.getAddress()}</td></tr>
		<tr><td>City</td><td>:&nbsp;${StudentBeanObj.getCity()}</td></tr>
		<tr><td>State</td><td>:&nbsp;${StudentBeanObj.getState()}</td></tr>
		<tr><td>Zip</td><td>:&nbsp;${StudentBeanObj.getZip()}</td></tr>
		<tr><td>Telephone</td><td>:&nbsp;${StudentBeanObj.getTelePhone()}</td></tr>
		<tr><td>Email Id</td><td>:&nbsp;${StudentBeanObj.getEmailId()}</td></tr>
		<tr><td>URL</td><td>:&nbsp;${StudentBeanObj.getURL()}</td></tr>
		<tr><td>Survey Date</td><td>:&nbsp;${StudentBeanObj.getSurveyDate()}</td></tr>
		<tr><td>What did you like most about the campus?</td><td>:&nbsp;${StudentBeanObj.getThingsToLike()}</td></tr>
		<tr><td>As a prospective student what interested you most in the university?</td><td>:&nbsp;${StudentBeanObj.getIntersts()}</td></tr>
		<tr><td>What is the likelihood of you recommending this school to other prospective students?</td><td>:&nbsp;${StudentBeanObj.getLikelyHood()}</td></tr>
		<tr><td>Additional Comments</td><td>:&nbsp;${StudentBeanObj.getAdditionalComments()}</td></tr></h3>
	</table>
	<a href="https://www2.gmu.edu/">
		<img src="GMU_logo.jpg" style="width:150px;height:100px;" align="right" title="Please visit http://www.gmu.edu for more information.">
	</a>
	<br /><p align="center" style="font-size:175%"><b><u>By Varun Rajavelu</u></b></p>
</div>
</body>
</html>