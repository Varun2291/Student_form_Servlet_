// Author: Varun Rajavelu (G00937282)

// This is the core part of this project. 
// 1) It Gets the data from the HTML file and store in the DB
// 2) Calls the DataProcessor to calculate the mean and SD
// 3) Calls SimpleAckowledgement.jsp if mean is less than 90 using Request Dispatcher
// 4) Calls WinnerAckowledgement.jsp if mean is greater than or equal to 90 using Request Dispatcher
// 5) After receiving an id it calls the "RetrieveStudentInformation()" and then it calls the "StudentJSP.jsp" and "NoSuchStudentJSP.jsp"
package Student_Survey;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String StudentId = request.getParameter("id");
		StudentDAO studentObject = new StudentDAO();
		StudentBean StudentBeanObj = new StudentBean();
		 
		System.out.println("Clicked: "+StudentId);
		StudentBeanObj = studentObject.RetrieveStudentInformation(StudentId);
		
		request.setAttribute("StudentBeanObj", StudentBeanObj);
		 
		if(StudentBeanObj != null)
			request.getRequestDispatcher("/StudentJSP.jsp").forward(request, response);
		else
			request.getRequestDispatcher("/NoSuchStudentJSP.jsp").forward(request, response);
	} 
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		StudentBean StudentBeanObj = new StudentBean();
		String data_number = request.getParameter("numbers");
		
		// Get the values entered by the user and store in Student Bean
		StudentBeanObj.setFname(request.getParameter("fname"));
		StudentBeanObj.setLname(request.getParameter("lname"));
		StudentBeanObj.setStudentId(request.getParameter("student_id"));
		StudentBeanObj.setGraduateDate(request.getParameter("months")+ " - " +request.getParameter("year"));
		StudentBeanObj.setAddress(request.getParameter("saddress"));
		StudentBeanObj.setCity(request.getParameter("city"));
		StudentBeanObj.setState(request.getParameter("state"));
		StudentBeanObj.setZip(Integer.parseInt(request.getParameter("zip")));
		StudentBeanObj.setTelePhone(request.getParameter("telenum"));
		StudentBeanObj.setEmailId(request.getParameter("email_id"));
		StudentBeanObj.setURL(request.getParameter("url"));
		StudentBeanObj.setSurveyDate(request.getParameter("dateofsurvey"));
		
		String[] ThingsToLike = request.getParameterValues("thingstolike");
		String ThingsToLike_List = "";
		for(int i = 0; i < ThingsToLike.length; i++){
			if(i == 0)
				ThingsToLike_List = ThingsToLike[i];
			else
				ThingsToLike_List += "," + ThingsToLike[i];
		}
		StudentBeanObj.setThingsToLike(ThingsToLike_List);	
		StudentBeanObj.setIntersts(request.getParameter("interests"));
		StudentBeanObj.setLikelyHood(request.getParameter("likelihood"));
		StudentBeanObj.setAdditionalComments(request.getParameter("comments"));
		
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<h3>Hello World</h3>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<h2>You are currently in a Servlet program</h2>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.println("<br /><p align=\"center\" style=\"font-size:175%\"><b><u>By Varun Rajavelu</u></b></p>");

		StudentDAO studentObject = new StudentDAO();
		studentObject.StoreStudentInformation(StudentBeanObj);
		String res = studentObject.RetrieveAllStudentIds();
	//	System.out.println(res);
		
		// Create an object of Class of DataProcess
		DataProcessor dataObject = new DataProcessor();
		float Mean;					// Variable to store the Mean
		double StandardDeviation;	// Variable to store the SDs
		 
		Mean = dataObject.ComputeMean(data_number);								// Call to compute the Mean
		StandardDeviation = dataObject.ComputeStandardDeviation(data_number);	// Call to compute the SD
		
		// Create an object of Data Bean and call the setter methods
		DataBean dataBeanObject = new DataBean();
		dataBeanObject.setMean(Mean);							// Set the Mean
		dataBeanObject.setStandardDeviation(StandardDeviation);	// Set the SD
		
		// Set the Attribute before the jsp calls
		request.setAttribute("dataBeanObject", dataBeanObject);
		request.setAttribute("StudentIds", res);
		
		// Check if the Mean is less than 90
		// if less than 90 then call SimpleAckowledgement.jsp
		// else call WinnerAcknowledgement.jsp
		if(Mean < 90)
			request.getRequestDispatcher("/SimpleAcknowledgement.jsp").forward(request, response);
		else
			request.getRequestDispatcher("/WinnerAcknowledgement.jsp").forward(request, response);

	}

}
