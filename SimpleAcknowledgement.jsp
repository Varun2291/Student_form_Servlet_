<!-- Author: Varun Rajavelu (G00937282) -->

<!-- This file is to used to display 
1) successful submission
2) Mean and Standard Deviation
3) All the student IDs   -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Submission Successful</title>
</head>
<body>
<h3>Thank you. Your Survey has been successfully submitted..</h3>
<br />
<h4>Mean: ${dataBeanObject.getMean()}</h4>
<h4>Standard Deviation: ${dataBeanObject.getStandardDeviation()}</h4>
<div>
<table align="center">
<tr><td><h3><b><u>The Student IDs are:</u></b></h3></td></tr>
<ul>
	<% String IdString = (String)request.getAttribute("StudentIds");
		String[] Ids = IdString.split(",");
		int totalIds = Ids.length;
		
		String displayId;
		for(int i = 0; i < totalIds; i++){
			displayId = null;
			displayId = Ids[i];
			System.out.println(displayId);
	%>
	<tr>
		<td><li><a href="/Swe642_Assignment/MainServlet?id=<%=displayId%>"><%=displayId%></a></li></td>
	</tr> 
	<%}%>
</ul>
</table>
</div>
<br /><p align="center" style="font-size:175%"><b><u>By Varun Rajavelu</u></b></p>
</body>
</html>