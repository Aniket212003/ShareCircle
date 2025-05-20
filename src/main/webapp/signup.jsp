<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ShareCircle - Sign Up</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/signup.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
    <div class="signup-container">
        <div class="signup-header">
            <h2>Create Your Account</h2>
            <p>Join ShareCircle to start sharing resources</p>
        </div>
        <%-- Display error messages from backend --%>
        <% 
        	if(request.getAttribute("error") != null) 
        	{ 
        %>
            <div class="alert alert-danger" role="alert">
                <%= request.getAttribute("error") %>
            </div>
        <% 
        	} 
        %>
        
        <% 
        	if(request.getAttribute("success") != null)
        	{ 
        %>
            <div class="alert alert-success" role="alert">
                <%= request.getAttribute("success") %>
            </div>
        <% 
        	} 
        %>
        <form action="./signupServlet" method="POST" id="signupForm" novalidate>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="firstName" class="form-label">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" required>
                    <div class="error-message" id="firstNameError">Please enter your first name</div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="lastName" class="form-label">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" required>
                    <div class="error-message" id="lastNameError">Please enter your last name</div>
                </div>
            </div>
            
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                    <input type="text" class="form-control" id="username" name="userName" required>
                </div>
                <div class="error-message" id="usernameError">Username must be at least 4 characters</div>
            </div>
            
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-envelope"></i></span>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
                <div class="error-message" id="emailError">Please enter a valid email</div>
            </div>
            
            <div class="mb-3">
                <label for="phone" class="form-label">Phone Number</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-phone"></i></span>
                    <input type="tel" class="form-control" id="phone" name="phone" required>
                </div>
                <div class="error-message" id="phoneError">Please enter a valid phone number</div>
            </div>
            
            <div class="mb-3 position-relative">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
                <i class="fas fa-eye password-toggle" id="togglePassword"></i>
                <div class="error-message" id="passwordError">Password must be at least 8 characters</div>
            </div>
            
            <div class="mb-3 position-relative">
                <label for="confirmPassword" class="form-label">Confirm Password</label>
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
                <div class="error-message" id="confirmPasswordError">Passwords do not match</div>
            </div>
            
            <div class="form-check mb-3">
                <input class="form-check-input" type="checkbox" id="terms" required>
                <label class="form-check-label" for="terms">
                    I agree to the <a href="#" style="color: var(--primary-color);">Terms of Service</a> and <a href="#" style="color: var(--primary-color);">Privacy Policy</a>
                </label>
                <div class="error-message" id="termsError">You must agree to the terms</div>
            </div>
            
            <button type="submit" class="btn btn-signup">Create Account</button>
        </form>
        
        <div class="login-link">
            Already have an account? <a href="login.jsp">Log in</a>
        </div>
    </div>

    <!-- Bootstrap JS Bundle with Popper -->
    <script src="js/signup.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    
</body>
</html>