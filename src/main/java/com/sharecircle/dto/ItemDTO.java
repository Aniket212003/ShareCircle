package com.sharecircle.dto;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import com.sharecircle.enums.Category;
import com.sharecircle.enums.ListingType;
import com.sharecircle.enums.PickupOptions;

import jakarta.servlet.http.Part;

public class ItemDTO 
{
	private Integer userId;
    private String itemName;
    private Category category;
    private String shortDescription;
    private String detailedDescription;
    private LocalDate startDate;
    private LocalDate endDate;
    private ListingType listingType;
    private Double rentPrice;
    private Double rentDeposit;
    private Double sellPrice;
    private PickupOptions pickupOptions;
    private Boolean isAvailable;
    private String pincode;
    private String address;
    private Collection<Part> FileParts;
    private List<String> imageNames;
    private UserProfileDTO owner;
    
    
   
	public UserProfileDTO getOwner() {
		return owner;
	}
	public void setOwner(UserProfileDTO owner) {
		this.owner = owner;
	}
	public List<String> getImageNames() {
		return imageNames;
	}
	public void setImageNames(List<String> imageNames) {
		this.imageNames = imageNames;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public ListingType getListingType() {
		return listingType;
	}
	public void setListingType(ListingType listingType) {
		this.listingType = listingType;
	}
	public PickupOptions getPickupOptions() {
		return pickupOptions;
	}
	public void setPickupOptions(PickupOptions pickupOptions) {
		this.pickupOptions = pickupOptions;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getDetailedDescription() {
		return detailedDescription;
	}
	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public Double getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}
	public Double getRentDeposit() {
		return rentDeposit;
	}
	public void setRentDeposit(Double rentDeposit) {
		this.rentDeposit = rentDeposit;
	}
	public Double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}
	
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Collection<Part> getFileParts() {
		return FileParts;
	}
	public void setFileParts(Collection<Part> fileParts) {
		FileParts = fileParts;
	}
	
}
