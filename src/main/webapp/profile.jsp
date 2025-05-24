<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="sessionCheck.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ShareCircle - User Profile</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="css/profile.css">
</head>
<body>
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

    <!-- Profile Section -->
    <div class="container">
        <!-- Profile Header -->
        <div class="profile-header text-center text-md-start">
            <div class="row align-items-center">
                <div class="col-md-2 text-center">
                    <img src="${userProfileURL}" alt="Profile Picture" class="profile-picture">
                </div>
                <div class="col-md-6 mt-3 mt-md-0">
                    <h2>${userFullName}</h2>
                    <p class="mb-2">${userName}</p>
                    <p><i class="fas fa-map-marker-alt me-2"></i>${userLocation}</p>
                </div>
                <div class="col-md-4 text-center text-md-end mt-3 mt-md-0">
                    <button class="btn btn-edit"><i class="fas fa-pencil-alt me-2"></i> Edit Profile</button>
                </div>
            </div>
            
            <!-- Stats -->
            <div class="row justify-content-center mt-4">
                <div class="col-md-10">
                    <div class="row profile-stats text-center">
                        <div class="col-4">
                            <h4 class="mb-0">${userItemShared}</h4>
                            <small>Items Shared</small>
                        </div>
                        <div class="col-4">
                            <h4 class="mb-0">${userItemRented}</h4>
                            <small>Items Rented</small>
                        </div>
                        <div class="col-4">
                            <h4 class="mb-0">${userItemSold}</h4>
                            <small>Items Sold</small>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Profile Details -->
        <div class="row mt-4">
            <div class="col-md-8">
                <div class="profile-card card">
                    <div class="card-body">
                        <h5 class="card-title"><i class="fas fa-info-circle me-2 text-primary"></i> About Me</h5>
                        <div class="info-item">
                            <div class="info-label">Bio</div>
                            <p>${userBio}</p>
                        </div>
                        <div class="info-item">
                            <div class="info-label">Interests</div>
                            <p>DIY Projects, Photography, Sustainable Living, Community Building</p>
                        </div>
                    </div>
                </div>
                
                <div class="profile-card card mt-4">
                    <div class="card-body">
                        <h5 class="card-title"><i class="fas fa-star me-2 text-primary"></i> Community Reputation</h5>
                        <div class="d-flex align-items-center mb-3">
                            <div class="me-3">
                                <i class="fas fa-shield-alt fa-2x text-primary"></i>
                            </div>
                            <div>
                                <h6 class="mb-0">Verified Member</h6>
                                <small class="text-muted">Identity verified, Payment method added</small>
                            </div>
                        </div>
                        <div class="d-flex align-items-center">
                            <div class="me-3">
                                <i class="fas fa-thumbs-up fa-2x text-primary"></i>
                            </div>
                            <div>
                                <h6 class="mb-0">4.9/5.0 Rating</h6>
                                <small class="text-muted">From 47 reviews</small>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="col-md-4">
                <div class="profile-card card">
                    <div class="card-body">
                        <h5 class="card-title"><i class="fas fa-id-card me-2 text-primary"></i> Contact Information</h5>
                        <div class="info-item">
                            <div class="info-label">Email</div>
                            <p>${userEmail}</p>
                        </div>
                        <div class="info-item">
                            <div class="info-label">Phone</div>
                            <p>+91 ${userContact}</p>
                        </div>
                        <div class="info-item">
                            <div class="info-label">Address</div>
                            <p>${userLocation}</p>
                        </div>
                        <div class="info-item">
                            <div class="info-label">Member Since</div>
                            <p>${userJoined}</p>
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
    
    <script>
        // Simple script for any interactive elements
        document.addEventListener('DOMContentLoaded', function() {
            // You can add any profile-specific JavaScript here
            console.log('Profile page loaded');
        });
    </script>
</body>
</html>