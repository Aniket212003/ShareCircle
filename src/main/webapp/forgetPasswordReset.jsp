<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="sessionCheck.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ShareCircle - Reset Password</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="css/forgetPasswordReset.css">
</head>
<body>
    <div class="reset-container">
        <div class="reset-header">
            <h2>Reset Password</h2>
            <p>Create a new password for your account</p>
        </div>
        
        <form id="resetForm" action="./resetPasswordServlet" method="post">
            
            <div class="mb-3">
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-lock"></i></span>
                    <input type="password" class="form-control" id="newPassword" name="newPassword" placeholder="New Password" required>
                </div>
                <div class="password-strength">
                    <div class="strength-meter" id="strengthMeter"></div>
                </div>
                <div class="password-requirements">
                    <p>Password must contain:</p>
                    <ul>
                        <li id="lengthReq" class="requirement-not-met">At least 8 characters</li>
                        <li id="upperReq" class="requirement-not-met">At least one uppercase letter</li>
                        <li id="lowerReq" class="requirement-not-met">At least one lowercase letter</li>
                        <li id="numberReq" class="requirement-not-met">At least one number</li>
                        <li id="specialReq" class="requirement-not-met">At least one special character</li>
                    </ul>
                </div>
            </div>
            
            <div class="mb-3">
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-lock"></i></span>
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm New Password" required>
                </div>
                <div class="password-mismatch" id="passwordMismatch">
                    <i class="fas fa-exclamation-circle"></i> Passwords do not match
                </div>
            </div>
            
            <button type="submit" class="btn btn-reset" id="resetBtn" disabled>Reset Password</button>
        </form>
        
        <div class="reset-footer">
            Remember your password? <a href="login.jsp">Login here</a>
        </div>
    </div>

    <!-- Bootstrap JS Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="js/forgetPasswordReset.js"></script>	
    
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
        window.location.href = './LogoutServlet'; // Redirect after OK
    });
</script>

<%
    }
%>
</body>
</html>