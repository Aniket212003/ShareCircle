document.getElementById('actionBtn').addEventListener('click', function() {
            document.getElementById('actionMenu').classList.toggle('show');
        });
        
        // Close menu when clicking outside
        document.addEventListener('click', function(event) {
            const actionBtn = document.getElementById('actionBtn');
            const actionMenu = document.getElementById('actionMenu');
            
            if (!actionBtn.contains(event.target) && !actionMenu.contains(event.target)) {
                actionMenu.classList.remove('show');
            }
        });
        
        // Filter functionality
        document.querySelectorAll('.filter-btn').forEach(btn => {
            btn.addEventListener('click', function() {
                // Remove active class from all buttons
                document.querySelectorAll('.filter-btn').forEach(b => {
                    b.classList.remove('active');
                    b.classList.remove('btn-primary');
                    b.classList.add('btn-outline-secondary');
                });
                
                // Add active class to clicked button
                this.classList.add('active');
                this.classList.remove('btn-outline-secondary');
                this.classList.add('btn-primary');
                
                // Here you would typically filter the items
                // For this example, we'll just log the filter
                console.log(`Filtering by: ${this.textContent}`);
            });
        });