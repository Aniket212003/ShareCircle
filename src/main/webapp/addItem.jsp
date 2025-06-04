<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="sessionCheck.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Item - ShareCircle</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
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

    <div class="container">
        <!-- Success Message (Hidden Initially) -->
        <div class="success-message" id="successMessage">
            <div class="d-flex justify-content-between align-items-center">
                <div>
                    <h4 class="mb-1"><i class="fas fa-check-circle text-success me-2"></i> Your item has been added successfully!</h4>
                    <p class="mb-0">Your item is now visible to the community based on your visibility settings.</p>
                </div>
                <button class="btn btn-primary">Add another item</button>
            </div>
        </div>

        <!-- Main Form -->
        <form id="addItemForm">
            <!-- 2. Basic Item Details -->
            <section class="form-section">
                <h2 class="section-title">Basic Item Details</h2>
                
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="itemName" class="form-label">Item Name *</label>
                        <input type="text" class="form-control" id="itemName" required maxlength="100">
                    </div>
                    
                    <div class="col-md-3 mb-3">
                        <label for="category" class="form-label">Category *</label>
                        <select class="form-select" id="category" required>
                            <option value="" selected disabled>Select category</option>
                            <option value="Electronics">Electronics</option>
                            <option value="Books">Books</option>
                            <option value="Furniture">Furniture</option>
                            <option value="Clothing">Clothing</option>
                            <option value="Tools">Tools</option>
                        </select>
                    </div>
                    
                    <div class="col-md-3 mb-3">
                        <label for="condition" class="form-label">Condition</label>
                        <select class="form-select" id="condition">
                            <option value="" selected disabled>Select condition</option>
                            <option value="New">New</option>
                            <option value="Like New">Like New</option>
                            <option value="Good">Good</option>
                            <option value="Acceptable">Acceptable</option>
                        </select>
                    </div>
                </div>
                
                 <div class="mb-3">
        				<label for="itemImages" class="form-label">Item Images *</label>
        				<input type="file" class="form-control" id="itemImages" name="itemImages" accept="image/jpeg, image/png" multiple required>
        				<small class="text-muted">Upload up to 5 images (JPEG or PNG)</small>
        				<div class="image-preview-container" id="imagePreview"></div>
    			</div>
                
                <div class="mb-3">
                    <label for="shortDescription" class="form-label">Short Description *</label>
                    <textarea class="form-control" id="shortDescription" rows="3" required maxlength="250"></textarea>
                    <small class="text-muted">Max 250 characters</small>
                </div>
                
                <div class="mb-3">
                    <label class="form-label">Detailed Description</label>
                    <div class="rich-text-editor" contenteditable="true" id="detailedDescription"></div>
                </div>
            </section>

            <!-- 3. Availability & Listing Type -->
            <section class="form-section">
                <h2 class="section-title">Availability & Listing Type</h2>
                
                <div class="mb-3">
                    <label class="form-label">Listing Type *</label>
                    <div class="d-flex flex-wrap gap-3">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="listingType" id="share" value="Share" checked>
                            <label class="form-check-label" for="share">
                                <i class="fas fa-share-alt me-1"></i> Share (Free)
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="listingType" id="rent" value="Rent">
                            <label class="form-check-label" for="rent">
                                <i class="fas fa-money-bill-wave me-1"></i> Rent
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="listingType" id="sell" value="Sell">
                            <label class="form-check-label" for="sell">
                                <i class="fas fa-tag me-1"></i> Sell
                            </label>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="startDate" class="form-label">Availability Start Date *</label>
                        <input type="date" min="" class="form-control" id="startDate" required>
                        <script>
                                // Get today's date in YYYY-MM-DD format
                                const today = new Date().toISOString().split('T')[0];
                                document.getElementById("startDate").setAttribute("min", today);
                         </script>
                    </div>
                    
                    <div class="col-md-6 mb-3">
                        <label for="endDate" class="form-label">Availability End Date</label>
                        <input type="date" class="form-control" id="endDate">
                    </div>
                </div>
                
                <div class="mb-3">
                    <label class="form-label">Pickup/Delivery Options *</label>
                    <div class="d-flex flex-wrap gap-3">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="pickupOptions" id="pickupOnly" value="Pickup Only">
                            <label class="form-check-label" for="pickupOnly">Pickup Only</label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="pickupOptions" id="deliveryAvailable" value="Delivery Available">
                            <label class="form-check-label" for="deliveryAvailable">Delivery Available</label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="pickupOptions" id="both" value="Both" checked>
                            <label class="form-check-label" for="both">Both</label>
                        </div>
                    </div>
                </div>
            </section>

            <!-- 4. Pricing (Conditional) -->
            <section class="form-section" id="pricingSection" style="display: none;">
                <h2 class="section-title">Pricing Details</h2>
                
                <div id="rentFields" style="display: none;">
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="rentPrice" class="form-label">Rent Price/Day (₹) *</label>
                            <input type="number" class="form-control" id="rentPrice" min="0" step="10">
                        </div>
                        
                        <div class="col-md-6 mb-3">
                            <label for="securityDeposit" class="form-label">Security Deposit (₹)</label>
                            <input type="number" class="form-control" id="securityDeposit" min="0" step="10">
                        </div>
                    </div>
                </div>
                
                <div id="sellFields" style="display: none;">
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="sellPrice" class="form-label">Sell Price (₹) *</label>
                            <input type="number" class="form-control" id="sellPrice" min="0" step="10">
                        </div>
                    </div>
                </div>
            </section>

            <!-- 5. Location Details -->
            <section class="form-section">
                <h2 class="section-title">Location Details</h2>
                
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="pincode" class="form-label">Pincode / Area *</label>
                        <select class="form-select" id="pincode" required>
                            <option value="" selected disabled>Select your area</option>
                            <option value="560001">560001 - Bangalore Central</option>
                            <option value="560002">560002 - Shivajinagar</option>
                            <option value="560003">560003 - Richmond Town</option>
                        </select>
                    </div>
                </div>
                
                <div class="mb-3">
                    <label for="exactAddress" class="form-label">Exact Address</label>
                    <textarea class="form-control" id="exactAddress" rows="3"></textarea>
                    <small class="text-muted">This will only be shared after a request is accepted</small>
                </div>
            </section>
            <!-- 6. Submit Section -->
            <section class="form-section">
                <div class="d-flex justify-content-between">
                    <button type="button" class="btn btn-outline-secondary" id="previewBtn">
                        <i class="fas fa-eye me-1"></i> Preview
                    </button>
                    
                    <div>
                        <button type="button" class="btn btn-outline-danger me-2" id="cancelBtn">
                            Cancel
                        </button>
                        <button type="submit" class="btn btn-primary">
                            <i class="fas fa-plus-circle me-1"></i> Add Item
                        </button>
                    </div>
                </div>
            </section>
        </form>
    </div>

    <!-- Bootstrap JS Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="js/addItem.js"></script>
</body>
</html>