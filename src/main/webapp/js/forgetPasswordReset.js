document.addEventListener('DOMContentLoaded', function() {
            const newPassword = document.getElementById('newPassword');
            const confirmPassword = document.getElementById('confirmPassword');
            const passwordMismatch = document.getElementById('passwordMismatch');
            const resetBtn = document.getElementById('resetBtn');
            const strengthMeter = document.getElementById('strengthMeter');
            
            const requirements = {
                length: document.getElementById('lengthReq'),
                upper: document.getElementById('upperReq'),
                lower: document.getElementById('lowerReq'),
                number: document.getElementById('numberReq'),
                special: document.getElementById('specialReq')
            };
            
            // Check password strength and requirements
            newPassword.addEventListener('input', function() {
                const password = this.value;
                let strength = 0;
                let meetsRequirements = 0;
                const totalRequirements = 5;
                
                // Check length
                if (password.length >= 8) {
                    requirements.length.classList.remove('requirement-not-met');
                    requirements.length.classList.add('requirement-met');
                    strength += 20;
                    meetsRequirements++;
                } else {
                    requirements.length.classList.remove('requirement-met');
                    requirements.length.classList.add('requirement-not-met');
                }
                
                // Check uppercase letters
                if (/[A-Z]/.test(password)) {
                    requirements.upper.classList.remove('requirement-not-met');
                    requirements.upper.classList.add('requirement-met');
                    strength += 20;
                    meetsRequirements++;
                } else {
                    requirements.upper.classList.remove('requirement-met');
                    requirements.upper.classList.add('requirement-not-met');
                }
                
                // Check lowercase letters
                if (/[a-z]/.test(password)) {
                    requirements.lower.classList.remove('requirement-not-met');
                    requirements.lower.classList.add('requirement-met');
                    strength += 20;
                    meetsRequirements++;
                } else {
                    requirements.lower.classList.remove('requirement-met');
                    requirements.lower.classList.add('requirement-not-met');
                }
                
                // Check numbers
                if (/[0-9]/.test(password)) {
                    requirements.number.classList.remove('requirement-not-met');
                    requirements.number.classList.add('requirement-met');
                    strength += 20;
                    meetsRequirements++;
                } else {
                    requirements.number.classList.remove('requirement-met');
                    requirements.number.classList.add('requirement-not-met');
                }
                
                // Check special characters
                if (/[^A-Za-z0-9]/.test(password)) {
                    requirements.special.classList.remove('requirement-not-met');
                    requirements.special.classList.add('requirement-met');
                    strength += 20;
                    meetsRequirements++;
                } else {
                    requirements.special.classList.remove('requirement-met');
                    requirements.special.classList.add('requirement-not-met');
                }
                
                // Update strength meter
                strengthMeter.style.width = strength + '%';
                
                if (strength < 40) {
                    strengthMeter.style.backgroundColor = '#dc3545'; // Red
                } else if (strength < 80) {
                    strengthMeter.style.backgroundColor = '#fd7e14'; // Orange
                } else {
                    strengthMeter.style.backgroundColor = '#28a745'; // Green
                }
                
                // Check if passwords match and requirements are met
                checkPasswords();
            });
            
            // Check if passwords match
            confirmPassword.addEventListener('input', function() {
                checkPasswords();
            });
            
            function checkPasswords() {
                const password = newPassword.value;
                const confirm = confirmPassword.value;
                
                if (password && confirm) {
                    if (password !== confirm) {
                        passwordMismatch.style.display = 'block';
                        resetBtn.disabled = true;
                    } else {
                        passwordMismatch.style.display = 'none';
                        
                        // Check if all requirements are met
                        const allMet = Array.from(document.querySelectorAll('.password-requirements li')).every(
                            li => li.classList.contains('requirement-met')
                        );
                        
                        resetBtn.disabled = !allMet;
                    }
                } else {
                    passwordMismatch.style.display = 'none';
                    resetBtn.disabled = true;
                }
            }
            
            // Form submission
            document.getElementById('resetForm').addEventListener('submit', function(e) {
                if (resetBtn.disabled) {
                    e.preventDefault();
                    Swal.fire({
                        icon: 'error',
                        title: 'Password Requirements Not Met',
                        text: 'Please ensure your password meets all requirements and matches the confirmation.',
                        confirmButtonText: 'OK'
                    });
                }
            });
        });