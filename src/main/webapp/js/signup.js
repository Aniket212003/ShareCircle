// Password toggle visibility
        document.getElementById('togglePassword').addEventListener('click', function() {
            const password = document.getElementById('password');
            const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
            password.setAttribute('type', type);
            this.classList.toggle('fa-eye-slash');
        });
        
        // Form validation
        document.getElementById('signupForm').addEventListener('submit', function(e) {
            let isValid = true;
            
            // Validate First Name
            const firstName = document.getElementById('firstName');
            if(firstName.value.trim() === '') {
                showError(firstName, 'firstNameError', 'Please enter your first name');
                isValid = false;
            } else {
                hideError(firstName, 'firstNameError');
            }
            
            // Validate Last Name
            const lastName = document.getElementById('lastName');
            if(lastName.value.trim() === '') {
                showError(lastName, 'lastNameError', 'Please enter your last name');
                isValid = false;
            } else {
                hideError(lastName, 'lastNameError');
            }
            
            // Validate Username
            const username = document.getElementById('username');
            if(username.value.trim().length < 4) {
                showError(username, 'usernameError', 'Username must be at least 4 characters');
                isValid = false;
            } else {
                hideError(username, 'usernameError');
            }
            
            // Validate Email
            const email = document.getElementById('email');
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if(!emailRegex.test(email.value.trim())) {
                showError(email, 'emailError', 'Please enter a valid email');
                isValid = false;
            } else {
                hideError(email, 'emailError');
            }
            
            // Validate Phone
            const phone = document.getElementById('phone');
            const phoneRegex = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/;
            if(!phoneRegex.test(phone.value.trim())) {
                showError(phone, 'phoneError', 'Please enter a valid phone number');
                isValid = false;
            } else {
                hideError(phone, 'phoneError');
            }
            
            // Validate Password
            const password = document.getElementById('password');
            if(password.value.length < 8) {
                showError(password, 'passwordError', 'Password must be at least 8 characters');
                isValid = false;
            } else {
                hideError(password, 'passwordError');
            }
            
            // Validate Confirm Password
            const confirmPassword = document.getElementById('confirmPassword');
            if(confirmPassword.value !== password.value) {
                showError(confirmPassword, 'confirmPasswordError', 'Passwords do not match');
                isValid = false;
            } else {
                hideError(confirmPassword, 'confirmPasswordError');
            }
            
            // Validate Terms
            const terms = document.getElementById('terms');
            if(!terms.checked) {
                document.getElementById('termsError').style.display = 'block';
                isValid = false;
            } else {
                document.getElementById('termsError').style.display = 'none';
            }
            
            if(!isValid) {
                e.preventDefault();
            }
        });
        
        function showError(input, errorId, message) {
            input.classList.add('is-invalid');
            const errorElement = document.getElementById(errorId);
            errorElement.textContent = message;
            errorElement.style.display = 'block';
        }
        
        function hideError(input, errorId) {
            input.classList.remove('is-invalid');
            document.getElementById(errorId).style.display = 'none';
        }