<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ShareCircle - Forgot Password</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="css/forgetPassword.css">
</head>
<body>
    <div class="forgot-container">
        <div class="forgot-header">
            <h2>Forgot Password?</h2>
            <p>Enter your username to reset your password</p>
        </div>
        
        <form id="forgotForm" action="./forgetPasswordServlet">
            <div class="mb-3">
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                    <input type="text" class="form-control" id="username" name="username" placeholder="Username" required>
                </div>
            </div>
            
            <button type="submit" class="btn btn-reset" name="reset">Reset Password</button>
        </form>
        
        <div class="forgot-footer">
            Remember your password? <a href="login.jsp">Login here</a>
        </div>
    </div>

    <!-- Bootstrap JS Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<%
    String alert = (String) request.getAttribute("alert");
    String message = (String) request.getAttribute("message");

    System.out.println(alert);
    System.out.println(message);

    if(alert != null && message != null) {
%>
    
<script>
    Swal.fire({
        icon: '<%=alert%>',
        title: '<%=message%>',
        confirmButtonText: 'OK'
    }).then(() => {
        window.location.href = 'forgetPassword.jsp'; // Redirect after OK
    });
</script>

<%
    }
%>	
</body>
</html>