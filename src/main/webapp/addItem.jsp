<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="sessionCheck.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ShareCircle - Add Item</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="css/addItem.css">
</head>
<body>
    <!-- 1. Header Section -->
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
    <div class="container py-2">
        <div class="row justify-content-center">
            <div class="col-lg-8">
                <div class="card shadow">
                    <div class="card-header text-white">
                        <h4 class="mb-0">Add New Item</h4>
                    </div>
                    <div class="card-body">
                        <form id="addItemForm" action="./AddItemServlet" method="post" enctype="multipart/form-data">
                            <!-- Basic Item Details -->
                            <div class="mb-3">
                                <label for="itemName" class="form-label">Item Name *</label>
                                <input type="text" class="form-control" id="itemName" name="itemName" required>
                            </div>
                            
                            <div class="mb-3">
                                <label for="category" class="form-label">Category *</label>
                                <select class="form-select" id="category" name="category" required>
                                    <option value="" selected disabled>Select Category</option>
                                    <option value="BOOKS">Books</option>
                                    <option value="ELECTRONICS">Electronics</option>
                                    <option value="TOOLS">Tools</option>
                                    <option value="STUDY_MATERIALS">Study Materials</option>
                                    <option value="FURNITURE">Furniture</option>
                                    <option value="SPORTS">Sports Equipment</option>
                                    <option value="OTHER">Other</option>
                                </select>
                            </div>
                            
                            <!-- Image Upload -->
                            <div class="mb-3">
                                <label for="itemImages" class="form-label">Upload Images (Max 3) *</label>
                                <input type="file" class="form-control" id="itemImages" name="itemImages" accept="image/*" multiple required>
                                <small class="text-muted">First image will be used as the main image</small>
                                
                                <div class="preview-container" id="imagePreviewContainer">
                                    <!-- Preview images will appear here -->
                                </div>
                            </div>
                            
                            <!-- Descriptions -->
                            <div class="mb-3">
                                <label for="shortDescription" class="form-label">Short Description *</label>
                                <textarea class="form-control" id="shortDescription" name="shortDescription" rows="2" maxlength="100" required></textarea>
                                <small class="text-muted">Max 100 characters</small>
                            </div>
                            
                            <div class="mb-3">
                                <label for="detailedDescription" class="form-label">Detailed Description</label>
                                <textarea class="form-control" id="detailedDescription" name="detailedDescription" rows="4"></textarea>
                            </div>
                            
                            <!-- Availability Dates -->
                            <div class="row mb-3">
                                <div class="col-md-6">
                                    <label for="startDate" class="form-label">Available From *</label>
                                    <input type="date" class="form-control" id="startDate" name="startDate" required>
                                </div>
                                <div class="col-md-6">
                                    <label for="endDate" class="form-label">Available Until *</label>
                                    <input type="date" class="form-control" id="endDate" name="endDate">
                                </div>
                            </div>
                            
                            <!-- Listing Type -->
                            <div class="mb-3">
                                <label class="form-label">Listing Type *</label>
                                <div class="form-check">
                                    <input class="form-check-input listing-type" type="radio" name="listingType" id="share" value="SHARE" checked>
                                    <label class="form-check-label" for="share">
                                        Share (Free)
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input listing-type" type="radio" name="listingType" id="rent" value="RENT">
                                    <label class="form-check-label" for="rent">
                                        Rent
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input listing-type" type="radio" name="listingType" id="sell" value="SALE">
                                    <label class="form-check-label" for="sell">
                                        Sell
                                    </label>
                                </div>
                                <div class="col-md-4">
							        <label for="rentPrice" class="form-label">Rent Price per Day(&#8377;)</label>
							        <input type="text" class="form-control" id="rentPrice" name="rentPrice">
							    </div>
							    <div class="col-md-4">
							        <label for="rentDeposit" class="form-label">Security Deposit(&#8377;)</label>
							        <input type="text" class="form-control" id="rentDeposit" name="rentDeposit">
							    </div>
							    <div class="col-md-4">
							    	<label for="sellPrice" class="form-label">Selling Price(&#8377;)</label>
							    	<input type="text" class="form-control" id="sellPrice" name="sellPrice">
								</div>
                            </div>
                            
                            <!-- Price Fields (now visible by default)
							<div class="mb-3 price-field" id="rentPriceField">
							    <div class="col-md-6">
							        <label for="rentPrice" class="form-label">Rent Price per Day (₹)</label>
							        <input type="text" class="form-control" id="rentPrice" name="rentPrice">
							    </div>
							    <div class="col-md-6">
							        <label for="rentDeposit" class="form-label">Security Deposit (₹)</label>
							        <input type="text" class="form-control" id="rentDeposit" name="rentDeposit">
							    </div>
							</div>
							
							<div class="mb-3 price-field" id="sellPriceField">
							    <label for="sellPrice" class="form-label">Selling Price (₹)</label>
							    <input type="text" class="form-control" id="sellPrice" name="sellPrice">
							</div>
							 -->
							
                            <!-- Pickup Options -->
                            <div class="mb-3">
                                <label class="form-label">Pickup Options *</label>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="pickupOptions" id="pickup" value="PICK_UP" checked>
                                    <label class="form-check-label" for="pickup">
                                        Pickup from my location
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="pickupOptions" id="mutualLocation" value="MUTUAL_LOACTION">
                                    <label class="form-check-label" for="mutualLocation">
                                        Meet at mutual location
                                    </label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="pickupOptions" id="delivery" value="DELIVERY">
                                    <label class="form-check-label" for="delivery">
                                        Delivery (charges may apply)
                                    </label>
                                </div>
                            </div>
                            
                            <!-- Location Details -->
                            <div class="mb-3">
                                <label for="pincode" class="form-label">Pincode *</label>
                                <input type="text" class="form-control" id="pincode" name="pincode" pattern="[0-9]{6}" required>
                            </div>
                            
                            <div class="mb-3">
                                <label for="address" class="form-label">Full Address *</label>
                                <textarea class="form-control" id="address" name="address" rows="3" required></textarea>
                            </div>
                            
                            <div class="d-grid gap-2">
                                <button type="submit" class="btn">Submit</button>
                            </div>
                        </form>
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="js/addItem.js"></script>
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
        window.location.href = 'addItem.jsp'; // Redirect after OK
    });
</script>

<%
    }
%>
</body>
</html>