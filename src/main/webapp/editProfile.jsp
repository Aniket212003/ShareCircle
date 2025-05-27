<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="sessionCheck.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ShareCircle - Edit Profile</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="css/editProfile.css">
</head>
<body>
<form method="post" action="./editProfileUpdateServlet">
    <!-- Top Bar with Navigation -->
    <div class="top-bar">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="top-bar-icons">
                        <!-- Notification Bell -->
                        <div class="position-relative">
                            <i class="fas fa-bell fa-lg text-white" style="cursor: pointer;"></i>
                            <span class="notification-badge">3</span>
                        </div>
                        
                        <!-- User Profile Dropdown -->
                        <div class="dropdown">
                            <div class="rounded-circle bg-white d-flex align-items-center justify-content-center" 
                                style="width: 40px; height: 40px; cursor: pointer;" 
                                id="userDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="fas fa-user text-primary"></i>
                            </div>
                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                                <li><a class="dropdown-item" href="./dashboard.jsp"><i class="fas fa-home me-2"></i> Dashboard</a></li>
                                <li><a class="dropdown-item" href="./ProfileServlet"><i class="fas fa-user me-2"></i> Profile</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#"><i class="fas fa-share-alt me-2"></i> Share Item</a></li>
                                <li><a class="dropdown-item" href="#"><i class="fas fa-hand-holding-heart me-2"></i> Request Item</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item text-danger" href="./LogoutServlet" id="logoutBtn"><i class="fas fa-sign-out-alt me-2"></i> Logout</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Edit Profile Section -->
    <div class="container">
        <!-- Profile Header -->
        <div class="profile-header text-center text-md-start">
            <div class="row align-items-center">
                <div class="col-md-2 text-center">
                    <img src="https://media.licdn.com/dms/image/v2/D4D03AQGM40WC-A2EcQ/profile-displayphoto-shrink_800_800/B4DZSYkN.cGkAc-/0/1737726419317?e=1753315200&v=beta&t=XiyI20btK-syKBFPKdDF3XpbiiUxIzPiKPYD0xubCJc" alt="Profile Picture" class="profile-picture">
                </div>
                <div class="col-md-10 mt-3 mt-md-0">
                    <h2>Edit Profile</h2>
                    <p>Update your personal information</p>
                </div>
            </div>
        </div>
        
        <!-- Edit Profile Form -->
        <div class="row mt-4">
            <div class="col-md-8 mx-auto">
                <div class="profile-card card">
                    <div class="card-body">                            
                            <div class="row mb-4">
                                <div class="col-md-6 mb-3">
                                    <label for="firstName" class="form-label">First Name</label>
                                    <input type="text" class="form-control" id="firstName" name="firstName" 
                                           value="${user.getFirstName()}" required>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label for="lastName" class="form-label">Last Name</label>
                                    <input type="text" class="form-control" id="lastName" name="lastName" 
                                           value="${user.getLastName()}" required>
                                </div>
                            </div>
                            
                            <div class="mb-3">
                                <label for="username" class="form-label">Username</label>
                                <div class="input-group">
                                    <span class="input-group-text">@</span>
                                    <input type="text" class="form-control" id="username" name="username" 
                                           value="${user.getUserName()}" required>
                                </div>
                            </div>
                            
                            <div class="mb-3">
                                <label for="email" class="form-label">Email Address</label>
                                <input type="email" class="form-control" id="email" name="email" 
                                       value="${user.getUserEmail()}" required>
                            </div>
                            
                            <div class="mb-3">
                                <label for="phone" class="form-label">Phone Number</label>
                                <input type="tel" class="form-control" id="phone" name="phone" 
                                       value="${user.getUserPhoneNumber()}">
                            </div>
                            
                            <div class="mb-3">
                                <label for="address" class="form-label">Address</label>
                                <textarea class="form-control" id="address" name="address" rows="2">${user.getLocation()}</textarea>
                            </div>
                            
                            <div class="mb-3">
                                <label for="bio" class="form-label">Bio</label>
                                <textarea class="form-control" id="bio" name="bio" rows="4">${user.getBio()}</textarea>
                                <div class="form-text">Tell the community a bit about yourself</div>
                            </div>
                            
                            <div class="d-flex justify-content-end mt-4">
                                <a href="./ProfileServlet" class="btn btn-cancel me-3">Cancel</a>
                                <button type="submit" class="btn btn-save" name="save">Save Changes</button>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer>
        <div class="container">
            <div class="text-center small">
                &copy; 2025 ShareCircle. All rights reserved.
            </div>
        </div>
    </footer>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</form>
</body>
</html>