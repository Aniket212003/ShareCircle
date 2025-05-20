<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ShareCircle - Community Resource Sharing</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
<form action="./mainPageServlet" method="post">
    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg navbar-light sticky-top">
        <div class="container">
            <a class="navbar-brand" href="#">ShareCircle</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Categories</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">How It Works</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contact</a>
                    </li>
                </ul>
                <div class="d-flex">
                    <button class="btn btn-outline-primary me-2" name="action" value="login">Login</button>
                    <button class="btn btn-primary" name="action" value="signup">Sign Up</button>
                </div>
            </div>
        </div>
    </nav>

    <!-- Hero Section -->
    <section class="hero-section">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-6">
                    <h1 class="hero-title">Share More. Waste Less.</h1>
                    <p class="hero-subtitle">Join your local resource sharing community and access items you need while helping others do the same.</p>
                    <button class="btn btn-secondary btn-lg" name="action" value="signup">Get Started</button>
                </div>
                
            </div>
        </div>
    </section>

    <!-- Main Content -->
    <div class="container">
        <!-- Categories Section -->
        <section class="mb-5">
            <h2 class="section-title">Browse Categories</h2>
            <div class="row">
                <div class="col-md-3 col-sm-6 mb-4">
                    <div class="category-card text-center p-4">
                        <div class="category-icon mx-auto">
                            <i class="fas fa-book"></i>
                        </div>
                        <h5>Books</h5>
                        <p class="text-muted">Textbooks, novels, and more</p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 mb-4">
                    <div class="category-card text-center p-4">
                        <div class="category-icon mx-auto">
                            <i class="fas fa-tools"></i>
                        </div>
                        <h5>Tools</h5>
                        <p class="text-muted">DIY and home improvement</p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 mb-4">
                    <div class="category-card text-center p-4">
                        <div class="category-icon mx-auto">
                            <i class="fas fa-laptop"></i>
                        </div>
                        <h5>Devices</h5>
                        <p class="text-muted">Electronics and gadgets</p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 mb-4">
                    <div class="category-card text-center p-4">
                        <div class="category-icon mx-auto">
                            <i class="fas fa-chair"></i>
                        </div>
                        <h5>Workspaces</h5>
                        <p class="text-muted">Shared offices and studios</p>
                    </div>
                </div>
            </div>
        </section>

        <!-- Featured Items -->
        <section class="mb-5">
            <div class="d-flex justify-content-between align-items-center mb-3">
                <h2 class="section-title">Featured Items</h2>
                <a href="#" class="btn btn-outline-primary">View All</a>
            </div>
            <div class="row">
                <!-- Item 1 -->
                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="item-card">
                        <img src="https://rukminim2.flixcart.com/image/850/1000/ki7qw7k0-0/book/z/u/s/design-patterns-original-imafy26zpt4xfuqz.jpeg?q=20&crop=false" alt="Book" class="item-img">
                        <div class="p-3">
                            <h5 class="item-title">Design Patterns Book</h5>
                            <p class="item-owner">By Aniket Belgaonkar</p>
                            <span class="item-status status-available">Available</span>
                            <div class="d-flex justify-content-between mt-3">
                                <button class="btn btn-sm btn-outline-primary">View Details</button>
                                <button class="btn btn-sm btn-primary">Borrow</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Item 2 -->
                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="item-card">
                        <img src="https://www.sitaramstationers.com/wp-content/uploads/2022/10/CASIO-FX-82ES-PLUS-2ND-EDITION-1.jpg" alt="Drill" class="item-img">
                        <div class="p-3">
                            <h5 class="item-title">Scientific Calculator</h5>
                            <p class="item-owner">By Aniket Belgaonkar</p>
                            <span class="item-status status-available">Available</span>
                            <div class="d-flex justify-content-between mt-3">
                                <button class="btn btn-sm btn-outline-primary">View Details</button>
                                <button class="btn btn-sm btn-primary">Borrow</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Item 3 -->
                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="item-card">
                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuUBtDNAb7SLh5AhynTH1B3et5ujb7cxYoXLc6w7rMYvydk60c1JjNR-urK4ZSYAKSgU4&usqp=CAU" alt="Camera" class="item-img">
                        <div class="p-3">
                            <h5 class="item-title">DSLR Camera</h5>
                            <p class="item-owner">By Nikhil Jagtap</p>
                            <span class="item-status status-rented">Rented until 06/15</span>
                            <div class="d-flex justify-content-between mt-3">
                                <button class="btn btn-sm btn-outline-primary">View Details</button>
                                <button class="btn btn-sm btn-primary" disabled>Borrow</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Item 4 -->
                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="item-card">
                        <img src="https://images.unsplash.com/photo-1556740738-b6a63e27c4df?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80" alt="Workspace" class="item-img">
                        <div class="p-3">
                            <h5 class="item-title">Co-working Space</h5>
                            <p class="item-owner">By Siddhi More</p>
                            <span class="item-status status-pending">Pending approval</span>
                            <div class="d-flex justify-content-between mt-3">
                                <button class="btn btn-sm btn-outline-primary">View Details</button>
                                <button class="btn btn-sm btn-primary" disabled>Borrow</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Top Users Section -->
        <section class="mb-5">
            <h2 class="section-title">Top Community Members</h2>
            <div class="row">
                <div class="col-md-3 col-sm-6 mb-4">
                    <div class="user-card text-center p-4">
                        <img src="https://media.licdn.com/dms/image/v2/D4D03AQGM40WC-A2EcQ/profile-displayphoto-shrink_400_400/B4DZSYkN.cGkAg-/0/1737726419296?e=1750896000&v=beta&t=qbssGebSUJMt7icuQJaoJfRutdewn9-3TUVq9CatMyI" alt="User" class="user-avatar">
                        <h5>Aniket Belgaonkar</h5>
                        <p class="text-muted small">Shared 24 items</p>
                        <p class="small">"Love sharing my book collection!"</p>
                        <button class="btn btn-sm btn-outline-primary mt-2">View Profile</button>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 mb-4">
                    <div class="user-card text-center p-4">
                        <img src="https://media.licdn.com/dms/image/v2/D4D03AQGpblwJ5H9wKQ/profile-displayphoto-shrink_400_400/profile-displayphoto-shrink_400_400/0/1728383053353?e=1750896000&v=beta&t=Smrxdywcezcx-SqBFAmUnqNY6nwuoiABKUvoU8vojwk" alt="User" class="user-avatar">
                        <h5>Vaishnavi Jadhav</h5>
                        <p class="text-muted small">Shared 18 items</p>
                        <p class="small">"DIY enthusiast with tools to share"</p>
                        <button class="btn btn-sm btn-outline-primary mt-2">View Profile</button>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 mb-4">
                    <div class="user-card text-center p-4">
                        <img src="https://media.licdn.com/dms/image/v2/D5635AQGlh3gPu4HEWQ/profile-framedphoto-shrink_800_800/profile-framedphoto-shrink_800_800/0/1687158630149?e=1746954000&v=beta&t=37PMp2RhpfHyYA-V28dPndTsnSx061HqH27QRfnHAgc" alt="User" class="user-avatar">
                        <h5>Siddhi More</h5>
                        <p class="text-muted small">Shared 15 items</p>
                        <p class="small">"Love Sharing kitchen appliances and Cloths"</p>
                        <button class="btn btn-sm btn-outline-primary mt-2">View Profile</button>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 mb-4">
                    <div class="user-card text-center p-4">
                        <img src="https://media.licdn.com/dms/image/v2/D4D03AQFaN4L_8h_Xuw/profile-displayphoto-shrink_400_400/profile-displayphoto-shrink_400_400/0/1688892552867?e=1750896000&v=beta&t=XfXMKk1HWUNh0e0K7i0UpSvNOUebRD-tqhqOst_3hIQ" alt="User" class="user-avatar">
                        <h5>Nikhil Jagtap</h5>
                        <p class="text-muted small">Shared 12 items</p>
                        <p class="small">"Love's Tea and sharing Co-working Spaces"</p>
                        <button class="btn btn-sm btn-outline-primary mt-2">View Profile</button>
                    </div>
                </div>
            </div>
        </section>

        <!-- Map View Section -->
        <section class="mb-5">
            <div class="d-flex justify-content-between align-items-center mb-3">
                <h2 class="section-title">Items Near You</h2>
                <div>
                    <button class="btn btn-outline-primary me-2 active">List View</button>
                    <button class="btn btn-outline-primary">Map View</button>
                </div>
            </div>
            <div class="map-container">
                <!-- Map would be implemented with Google Maps or similar API -->
                <div class="d-flex align-items-center justify-content-center h-100">
                    <div class="text-center">
                        <i class="fas fa-map-marker-alt fa-3x text-primary mb-3"></i>
                        <h4>Map View</h4>
                        <p class="text-muted">Browse items based on proximity</p>
                    </div>
                </div>
            </div>
        </section>

        <!-- Announcements Section -->
        <section class="mb-5">
            <h2 class="section-title">Community Announcements</h2>
            <div class="announcement-card">
                <h5 class="announcement-title">New Category Added: Sports Equipment</h5>
                <p class="announcement-date">Posted on June 1, 2023</p>
                <p>We've added a new category for sports equipment. Now you can share and borrow items like bicycles, tennis rackets, and more!</p>
            </div>
            <div class="announcement-card">
                <h5 class="announcement-title">Platform Maintenance</h5>
                <p class="announcement-date">Posted on May 25, 2023</p>
                <p>We'll be performing scheduled maintenance on June 5 from 2:00 AM to 4:00 AM. The platform may be temporarily unavailable during this time.</p>
            </div>
        </section>
    </div>

    <!-- Footer -->
    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 mb-4">
                    <h5 class="footer-title">ShareCircle</h5>
                    <p>Building sustainable communities through resource sharing. Join us in reducing waste and strengthening local connections.</p>
                    <div class="social-icons">
                        <a href="#"><i class="fab fa-facebook-f"></i></a>
                        <a href="#"><i class="fab fa-twitter"></i></a>
                        <a href="#"><i class="fab fa-instagram"></i></a>
                        <a href="#"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                </div>
                <div class="col-lg-2 col-md-6 mb-4">
                    <h5 class="footer-title">Quick Links</h5>
                    <ul class="footer-links">
                        <li><a href="#">Home</a></li>
                        <li><a href="#">About</a></li>
                        <li><a href="#">Categories</a></li>
                        <li><a href="#">How It Works</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                </div>
                <div class="col-lg-2 col-md-6 mb-4">
                    <h5 class="footer-title">Legal</h5>
                    <ul class="footer-links">
                        <li><a href="#">Privacy Policy</a></li>
                        <li><a href="#">Terms of Service</a></li>
                        <li><a href="#">Community Guidelines</a></li>
                        <li><a href="#">Safety Tips</a></li>
                    </ul>
                </div>
<!--                 <div class="col-lg-4 col-md-6 mb-4"> -->
<!--                     <h5 class="footer-title">Newsletter</h5> -->
<!--                     <p>Subscribe to get updates on new features and community events.</p> -->
<!--                     <div class="input-group mb-3"> -->
<!--                         <input type="email" class="form-control" placeholder="Your email"> -->
<!--                         <button class="btn btn-primary" type="button">Subscribe</button> -->
<!--                     </div> -->
<!--                 </div> -->
            </div>
            <hr class="mt-0 mb-4" style="border-color: rgba(255,255,255,0.1);">
            <div class="row">
                <div class="col-md-6 text-center text-md-start">
                    <p class="small mb-0">&copy; 2025 ShareCircle. All rights reserved.</p>
                </div>
                <div class="col-md-6 text-center text-md-end">
                    <p class="small mb-0">Made with <i class="fas fa-heart text-danger"></i> for sustainable communities</p>
                </div>
            </div>
        </div>
    </footer>

    <!-- Bootstrap JS Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</form>   
</body>
</html>
