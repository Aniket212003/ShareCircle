<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="sessionCheck.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ShareCircle - Dashboard</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="css/dashboard.css">
</head>
<body>
<form method="post">
  <!-- Top Bar -->
    <div class="top-bar mb-5">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-md-6">
                    <h3>Welcome back, <span id="userName"><%=userName%></span>!</h3>
                    <div class="row mt-3">
                        <div class="col-4">
                            <div class="stat-card">
                                <small>Shared</small>
                                <h4 class="mb-0">12</h4>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="stat-card">
                                <small>Rented</small>
                                <h4 class="mb-0">8</h4>
                            </div>
                        </div>
                        <div class="col-4">
                            <div class="stat-card">
                                <small>Sold</small>
                                <h4 class="mb-0">3</h4>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 text-end">
                    <div class="d-inline-block position-relative me-3">
                        <i class="fas fa-bell fa-lg text-white"></i>
                        <span class="notification-badge">3</span>
                    </div>
                    <!-- In the top bar section, replace the user icon div with this: -->
                    <div class="d-inline-block dropdown">
                        <div class="rounded-circle bg-white d-flex align-items-center justify-content-center" 
                            style="width: 40px; height: 40px; cursor: pointer;" 
                            id="userDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="fas fa-user text-primary"></i>
                        </div>
                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                            <li><a class="dropdown-item" href="./ProfileServlet"><i class="fas fa-user me-2"></i>Profile</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item text-danger" href="./LogoutServlet" id="logoutBtn"><i class="fas fa-sign-out-alt me-2"></i>Logout</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Main Content -->
    <div class="container">        
        <!-- Dashboard Sections -->
        <div class="row">
            <!-- Your Listed Items -->
            <div class="col-md-6 mb-4">
                <div class="main-card card h-100">
                    <div class="card-body">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h5 class="card-title mb-0">Your Listed Items</h5>
                            <i class="fas fa-boxes text-primary"></i>
                        </div>
                        <div class="list-group">
                            <a href="#" class="list-group-item list-group-item-action border-0 rounded mb-2">
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <strong>Camera</strong> - Currently rented by Sarah
                                        <div class="text-muted small">$25/day · Returns on May 25</div>
                                    </div>
                                    <span class="badge badge-rented">Rented</span>
                                </div>
                            </a>
                            <a href="#" class="list-group-item list-group-item-action border-0 rounded mb-2">
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <strong>Power Drill</strong> - Available for rent
                                        <div class="text-muted small">$15/day · 2 requests</div>
                                    </div>
                                    <span class="badge badge-available">Available</span>
                                </div>
                            </a>
                            <a href="#" class="list-group-item list-group-item-action border-0 rounded">
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <strong>Bicycle</strong> - Sold to Mike
                                        <div class="text-muted small">$120 · Sold on May 10</div>
                                    </div>
                                    <span class="badge badge-sold">Sold</span>
                                </div>
                            </a>
                        </div>
                        <button class="btn btn-outline-primary w-100 mt-3">Manage All Items</button>
                    </div>
                </div>
            </div>
            
            <!-- Borrow Requests -->
            <div class="col-md-6 mb-4">
                <div class="main-card card h-100">
                    <div class="card-body">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h5 class="card-title mb-0">Borrow Requests</h5>
                            <i class="fas fa-envelope text-primary"></i>
                        </div>
                        <div class="list-group">
                            <a href="#" class="list-group-item list-group-item-action border-0 rounded mb-2">
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <strong>John D.</strong> wants to borrow your ladder
                                        <div class="text-muted small">For home renovation</div>
                                    </div>
                                    <div>
                                        <button class="btn btn-sm btn-success me-1">Approve</button>
                                        <button class="btn btn-sm btn-outline-danger">Decline</button>
                                    </div>
                                </div>
                            </a>
                            <a href="#" class="list-group-item list-group-item-action border-0 rounded">
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <strong>Lisa M.</strong> wants to rent your camera
                                        <div class="text-muted small">For weekend trip</div>
                                    </div>
                                    <div>
                                        <button class="btn btn-sm btn-success me-1">Approve</button>
                                        <button class="btn btn-sm btn-outline-danger">Decline</button>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <button class="btn btn-outline-primary w-100 mt-3">View All Requests</button>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Community Items -->
        <div class="row mb-4">
            <div class="col-12">
                <div class="main-card card">
                    <div class="card-body">
                        <div class="d-flex justify-content-between align-items-center mb-4">
                            <div>
                                <h5 class="card-title mb-1">Explore Community Items</h5>
                                <p class="text-muted mb-0">Find items to borrow or buy from your community</p>
                            </div>
                            <div class="search-container">
                                <div class="input-group">
                                    <input type="text" class="form-control border-0" placeholder="Search items...">
                                    <button class="btn btn-link text-primary"><i class="fas fa-search"></i></button>
                                </div>
                            </div>
                        </div>
                        
                        <!-- Filter Buttons -->
                        <div class="mb-4 text-center">
                            <button class="btn btn-outline-secondary filter-btn">All</button>
                            <button class="btn btn-outline-secondary filter-btn">Books</button>
                            <button class="btn btn-outline-secondary filter-btn">Study Materials</button>
                            <button class="btn btn-outline-secondary filter-btn">Electronics</button>
                            <button class="btn btn-outline-secondary filter-btn">Tools</button>
                            <button class="btn btn-outline-secondary filter-btn">Sports</button>
                            <button class="btn btn-outline-secondary filter-btn">Furniture</button>
                        </div>
                        
                        <!-- Items Grid -->
                        <div class="row">
                            <!-- Item 1 -->
                            <div class="col-md-3 mb-4">
                                <div class="card h-100 item-card">
                                    <img src="https://via.placeholder.com/300x200?text=Textbook" class="card-img-top rounded-top" alt="Textbook">
                                    <div class="card-body">
                                        <h6 class="card-title">Calculus Textbook</h6>
                                        <p class="card-text text-muted small">Advanced mathematics textbook - 3rd edition</p>
                                        <div class="d-flex justify-content-between align-items-center mb-2">
                                            <span class="badge bg-success">Available</span>
                                            <small class="text-primary">$5/day</small>
                                        </div>
                                        <div class="d-flex justify-content-between">
                                            <button class="btn btn-sm btn-primary">Borrow</button>
                                            <button class="btn btn-sm btn-outline-secondary">View Details</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <!-- Item 2 -->
                            <div class="col-md-3 mb-4">
                                <div class="card h-100 item-card">
                                    <img src="https://via.placeholder.com/300x200?text=Power+Drill" class="card-img-top rounded-top" alt="Power Drill">
                                    <div class="card-body">
                                        <h6 class="card-title">Power Drill Set</h6>
                                        <p class="card-text text-muted small">Cordless drill with accessories</p>
                                        <div class="d-flex justify-content-between align-items-center mb-2">
                                            <span class="badge bg-warning">1 Request</span>
                                            <small class="text-primary">$15/day</small>
                                        </div>
                                        <div class="d-flex justify-content-between">
                                            <button class="btn btn-sm btn-primary">Request</button>
                                            <button class="btn btn-sm btn-outline-secondary">View Details</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <!-- Item 3 -->
                            <div class="col-md-3 mb-4">
                                <div class="card h-100 item-card">
                                    <img src="https://via.placeholder.com/300x200?text=Bicycle" class="card-img-top rounded-top" alt="Bicycle">
                                    <div class="card-body">
                                        <h6 class="card-title">Mountain Bike</h6>
                                        <p class="card-text text-muted small">24-speed, excellent condition</p>
                                        <div class="d-flex justify-content-between align-items-center mb-2">
                                            <span class="badge bg-success">Available</span>
                                            <small class="text-primary">$10/day</small>
                                        </div>
                                        <div class="d-flex justify-content-between">
                                            <button class="btn btn-sm btn-primary">Rent</button>
                                            <button class="btn btn-sm btn-outline-secondary">View Details</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <!-- Item 4 -->
                            <div class="col-md-3 mb-4">
                                <div class="card h-100 item-card">
                                    <img src="https://via.placeholder.com/300x200?text=Camera" class="card-img-top rounded-top" alt="Camera">
                                    <div class="card-body">
                                        <h6 class="card-title">DSLR Camera</h6>
                                        <p class="card-text text-muted small">Canon EOS 2000D with lens kit</p>
                                        <div class="d-flex justify-content-between align-items-center mb-2">
                                            <span class="badge bg-danger">Rented</span>
                                            <small class="text-primary">$25/day</small>
                                        </div>
                                        <div class="d-flex justify-content-between">
                                            <button class="btn btn-sm btn-outline-primary" disabled>Notify When Available</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <!-- Item 5 -->
                            <div class="col-md-3 mb-4">
                                <div class="card h-100 item-card">
                                    <img src="https://via.placeholder.com/300x200?text=Study+Notes" class="card-img-top rounded-top" alt="Study Notes">
                                    <div class="card-body">
                                        <h6 class="card-title">Computer Science Notes</h6>
                                        <p class="card-text text-muted small">Complete set for Algorithms course</p>
                                        <div class="d-flex justify-content-between align-items-center mb-2">
                                            <span class="badge bg-success">Available</span>
                                            <small class="text-primary">Free</small>
                                        </div>
                                        <div class="d-flex justify-content-between">
                                            <button class="btn btn-sm btn-primary">Download</button>
                                            <button class="btn btn-sm btn-outline-secondary">View Details</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <!-- Item 6 -->
                            <div class="col-md-3 mb-4">
                                <div class="card h-100 item-card">
                                    <img src="https://via.placeholder.com/300x200?text=Sofa" class="card-img-top rounded-top" alt="Sofa">
                                    <div class="card-body">
                                        <h6 class="card-title">Leather Sofa</h6>
                                        <p class="card-text text-muted small">3-seater, brown leather, good condition</p>
                                        <div class="d-flex justify-content-between align-items-center mb-2">
                                            <span class="badge bg-success">Available</span>
                                            <small class="text-primary">$250</small>
                                        </div>
                                        <div class="d-flex justify-content-between">
                                            <button class="btn btn-sm btn-primary">Buy</button>
                                            <button class="btn btn-sm btn-outline-secondary">View Details</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <!-- Item 7 -->
                            <div class="col-md-3 mb-4">
                                <div class="card h-100 item-card">
                                    <img src="https://via.placeholder.com/300x200?text=Guitar" class="card-img-top rounded-top" alt="Guitar">
                                    <div class="card-body">
                                        <h6 class="card-title">Acoustic Guitar</h6>
                                        <p class="card-text text-muted small">Yamaha FG800, with case</p>
                                        <div class="d-flex justify-content-between align-items-center mb-2">
                                            <span class="badge bg-success">Available</span>
                                            <small class="text-primary">$8/day or $200</small>
                                        </div>
                                        <div class="d-flex justify-content-between">
                                            <button class="btn btn-sm btn-primary">Rent</button>
                                            <button class="btn btn-sm btn-outline-secondary">View Details</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <!-- Item 8 -->
                            <div class="col-md-3 mb-4">
                                <div class="card h-100 item-card">
                                    <img src="https://via.placeholder.com/300x200?text=Camping+Gear" class="card-img-top rounded-top" alt="Camping Gear">
                                    <div class="card-body">
                                        <h6 class="card-title">Camping Equipment Set</h6>
                                        <p class="card-text text-muted small">Tent, sleeping bags, and stove</p>
                                        <div class="d-flex justify-content-between align-items-center mb-2">
                                            <span class="badge bg-success">Available</span>
                                            <small class="text-primary">$20/day</small>
                                        </div>
                                        <div class="d-flex justify-content-between">
                                            <button class="btn btn-sm btn-primary">Rent</button>
                                            <button class="btn btn-sm btn-outline-secondary">View Details</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <!-- Pagination -->
                        <nav aria-label="Page navigation" class="mt-4">
                            <ul class="pagination justify-content-center">
                                <li class="page-item disabled">
                                    <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                                </li>
                                <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item">
                                    <a class="page-link" href="#">Next</a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Quick Action Button -->
    <div class="quick-action">
        <div class="action-btn" id="actionBtn">
            <i class="fas fa-plus"></i>
        </div>
        <div class="action-menu" id="actionMenu">
            <div class="action-item d-flex align-items-center" onclick="window.location.href='addItem.jsp'">
                <i class="fas fa-share-alt me-2 text-primary"></i>
                <span>Share an Item</span>
            </div>
            <div class="action-item d-flex align-items-center" onclick="window.location.href='request-item.html'">
                <i class="fas fa-hand-holding-heart me-2 text-primary"></i>
                <span>Request an Item</span>
            </div>
            <div class="action-item d-flex align-items-center" onclick="window.location.href='sell-item.html'">
                <i class="fas fa-tag me-2 text-primary"></i>
                <span>Sell an Item</span>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-4 mb-4 mb-md-0">
                    <h5>ShareCircle</h5>
                    <p class="small">Building stronger communities through sharing.</p>
                </div>
                <div class="col-md-4 mb-4 mb-md-0">
                    <h6>Help & Support</h6>
                    <ul class="list-unstyled">
                        <li class="mb-2"><a href="#" class="footer-link">FAQ</a></li>
                        <li class="mb-2"><a href="#" class="footer-link">Safety Tips</a></li>
                        <li><a href="#" class="footer-link">Contact Us</a></li>
                    </ul>
                </div>
                <div class="col-md-4">
                    <h6>Legal</h6>
                    <ul class="list-unstyled">
                        <li class="mb-2"><a href="#" class="footer-link">Terms of Use</a></li>
                        <li class="mb-2"><a href="#" class="footer-link">Privacy Policy</a></li>
                        <li><a href="#" class="footer-link">Community Guidelines</a></li>
                    </ul>
                </div>
            </div>
            <hr class="my-4 bg-light">
            <div class="text-center small">
                &copy; 2025 ShareCircle. All rights reserved.
            </div>
        </div>
    </footer>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="js/dashboard.js"></script>
</form>
</body>
</html>