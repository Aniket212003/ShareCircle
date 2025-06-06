document.addEventListener('DOMContentLoaded', function() {
            // Image upload preview functionality
            const itemImagesInput = document.getElementById('itemImages');
            const imagePreviewContainer = document.getElementById('imagePreviewContainer');
            const maxImages = 3;
            let uploadedImages = [];
            
            itemImagesInput.addEventListener('change', function(e) {
                const files = e.target.files;
                imagePreviewContainer.innerHTML = '';
                uploadedImages = [];
                
                if (files.length > maxImages) {
                    alert(`You can upload a maximum of ${maxImages} images.`);
                    this.value = '';
                    return;
                }
                
                for (let i = 0; i < files.length; i++) {
                    const file = files[i];
                    if (!file.type.match('image.*')) {
                        continue;
                    }
                    
                    const reader = new FileReader();
                    reader.onload = function(e) {
                        const previewDiv = document.createElement('div');
                        previewDiv.className = 'image-preview';
                        
                        const img = document.createElement('img');
                        img.src = e.target.result;
                        
                        const removeBtn = document.createElement('span');
                        removeBtn.className = 'remove-image';
                        removeBtn.innerHTML = '&times;';
                        removeBtn.onclick = function() {
                            previewDiv.remove();
                            // Remove the file from the input
                            const newFiles = Array.from(itemImagesInput.files).filter((_, index) => index !== i);
                            const dataTransfer = new DataTransfer();
                            newFiles.forEach(file => dataTransfer.items.add(file));
                            itemImagesInput.files = dataTransfer.files;
                            uploadedImages = uploadedImages.filter((_, index) => index !== i);
                        };
                        
                        previewDiv.appendChild(img);
                        previewDiv.appendChild(removeBtn);
                        imagePreviewContainer.appendChild(previewDiv);
                        
                        uploadedImages.push(file);
                    };
                    reader.readAsDataURL(file);
                }
            });
            
            const today = new Date().toISOString().split('T')[0];
            document.getElementById("startDate").setAttribute("min", today);
            document.getElementById("endDate").setAttribute("min", today);
            // Show/hide price fields based on listing type
            const listingTypes = document.querySelectorAll('.listing-type');
            const rentPriceField = document.getElementById('rentPriceField');
            const sellPriceField = document.getElementById('sellPriceField');
            
            listingTypes.forEach(type => {
                type.addEventListener('change', function() {
                    rentPriceField.classList.add('hidden');
                    sellPriceField.classList.add('hidden');
                    
                    if (this.value === 'rent') {
                        rentPriceField.classList.remove('hidden');
                    } else if (this.value === 'sell') {
                        sellPriceField.classList.remove('hidden');
                    }
                });
            });
            
            // Set minimum end date based on start date
            const startDateInput = document.getElementById('startDate');
            const endDateInput = document.getElementById('endDate');
            
            startDateInput.addEventListener('change', function() {
                endDateInput.min = this.value;
                if (endDateInput.value && endDateInput.value < this.value) {
                    endDateInput.value = this.value;
                }
            });
            
            // Form validation
            const form = document.getElementById('addItemForm');
            form.addEventListener('submit', function(e) {
                // Additional validation can be added here if needed
                if (uploadedImages.length === 0) {
                    e.preventDefault();
                    alert('Please upload at least one image.');
                }
            });
        });