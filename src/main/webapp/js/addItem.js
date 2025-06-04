// Get today's date in YYYY-MM-DD format
const today = new Date().toISOString().split('T')[0];
document.getElementById("startDate").setAttribute("min", today);


document.getElementById('itemImages').addEventListener('change', function(event) {
    const files = event.target.files;
    const previewContainer = document.getElementById('imagePreview');
    const maxFiles = 5;
    
    // Clear previous previews
    previewContainer.innerHTML = '';
    
    // Validate number of files
    if (files.length > maxFiles) {
        alert(`You can upload a maximum of ${maxFiles} files.`);
        event.target.value = ''; // Clear the input
        return;
    }
    
    // Create preview for each selected file
    for (let i = 0; i < files.length; i++) {
        const file = files[i];
        
        // Validate file type
        if (!file.type.match('image/jpeg') && !file.type.match('image/png')) {
            alert('Only JPEG and PNG images are allowed.');
            event.target.value = ''; // Clear the input
            previewContainer.innerHTML = '';
            return;
        }
        
        // Validate file size (optional - 2MB limit example)
        if (file.size > 2 * 1024 * 1024) {
            alert('File size should not exceed 2MB.');
            event.target.value = ''; // Clear the input
            previewContainer.innerHTML = '';
            return;
        }
        
        // Create preview element
        const reader = new FileReader();
        reader.onload = function(e) {
            const previewDiv = document.createElement('div');
            previewDiv.className = 'image-preview-item';
            previewDiv.innerHTML = `
                <img src="${e.target.result}" alt="Preview" class="img-thumbnail" style="height: 100px;">
                <span class="remove-image" data-index="${i}">×</span>
            `;
            previewContainer.appendChild(previewDiv);
        };
        reader.readAsDataURL(file);
    }
});

// Handle image removal
document.getElementById('imagePreview').addEventListener('click', function(e) {
    if (e.target.classList.contains('remove-image')) {
        const index = e.target.getAttribute('data-index');
        const input = document.getElementById('itemImages');
        
        // Create new FileList without the removed file
        const files = Array.from(input.files);
        files.splice(index, 1);
        
        // Create a new DataTransfer to update the input files
        const dataTransfer = new DataTransfer();
        files.forEach(file => dataTransfer.items.add(file));
        
        // Update the input files
        input.files = dataTransfer.files;
        
        // Trigger change event to update preview
        const event = new Event('change');
        input.dispatchEvent(event);
    }
});