package com.sharecircle.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sharecircle.enums.Category;
import com.sharecircle.enums.ListingType;
import com.sharecircle.enums.PickupOptions;


@Entity
@Table(name="sharecircle_item")
public class Item 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="item_id")
	private Integer itemId;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="owner_id",nullable=false)
	private User owner;
	
	@Column(name="item_name")
	private String itemName;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, columnDefinition = "category_enum")
	private Category category;
    
	@Column(name = "short_description", length = 255)
	private String shortDescription;
	
	@Column(name = "deatil_description",columnDefinition = "TEXT")
	private String DetailedDescription;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "listing_type", nullable = false, columnDefinition = "listing_type_enum")
	private ListingType listingType;
	
	@Column(name="rent_price")
	private Double rentPrice;
	
	@Column(name="rent_deposit")
	private Double rentDeposit;
	
	@Column(name="sell_price")
	private Double sellPrice;
	
	@Column(name="is_available")
	private Boolean isAvailable;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "pickup_options", nullable = false, columnDefinition = "availability_enum")
	private PickupOptions pickupOptions;
	
	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pincode", referencedColumnName = "pincode")
	private Pincode pincode;
	
	@Column(name = "address", length = 255)
	private String address;
	
	@Column(name = "created_at", nullable = false, updatable = false,
            columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT now()")
	private String createdAt;
	
	@OneToMany(
	        mappedBy = "item",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true,
	        fetch = FetchType.LAZY
	    )
	private List<ItemImage> images = new ArrayList<>();
	
	public void setOwner(User user)
	{
		this.owner = user;
	}
	
	public void addImages(ItemImage image)
	{
		images.add(image);
		image.setItem(this);
	}
	
	public void removeImages(ItemImage image)
	{
		images.remove(image);
		image.setItem(null);
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
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

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDetailedDescription() {
		return DetailedDescription;
	}

	public void setDetailedDescription(String detailedDescription) {
		DetailedDescription = detailedDescription;
	}

	public ListingType getListingType() {
		return listingType;
	}

	public void setListingType(ListingType listingType) {
		this.listingType = listingType;
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

	public PickupOptions getPickupOptions() {
		return pickupOptions;
	}

	public void setPickupOptions(PickupOptions pickupOptions) {
		this.pickupOptions = pickupOptions;
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

	public Pincode getPincode() {
		return pincode;
	}

	public void setPincode(Pincode pincode) {
		this.pincode = pincode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public List<ItemImage> getImages() {
		return images;
	}

	public void setImages(List<ItemImage> images) {
		this.images = images;
	}

	public User getOwner() {
		return owner;
	}
	
	
}
