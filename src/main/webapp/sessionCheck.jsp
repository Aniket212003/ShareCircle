<%@ page session="false" %>
<%
    // Get session without creating a new one
    HttpSession session = request.getSession(false);
	if(session == null || session.getAttribute("userName") == null)
	{
		response.sendRedirect("login.jsp");
		return;
	}
	
    String userName = (String) session.getAttribute("userName");	
   	
%>