package com.sharecircle.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_profile")
public class UserProfile 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="profile_id")
	private Integer profileId;
	
	@OneToOne
	@JoinColumn(name="user_id", referencedColumnName="user_id")
	private User user;
	
	@Column(name="profile_picture_url")
	private String profileURL;
	
	@Column(name="location")
	private String location;
	
	@Column(name="items_sold_count")
	private Integer itemsSoledCount;
	
	@Column(name="items_rented_count")
	private Integer itemsRentedCount;
	
	@Column(name="items_shared_count")
	private Integer itemsSharedCount;
	
	@Column(name="bio")
	private String bio;

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getProfileURL() {
		return profileURL;
	}

	public void setProfileURL(String profileURL) {
		this.profileURL = profileURL;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getItemsSoledCount() {
		return itemsSoledCount;
	}

	public void setItemsSoledCount(Integer itemsSoledCount) {
		this.itemsSoledCount = itemsSoledCount;
	}

	public Integer getItemsRentedCount() {
		return itemsRentedCount;
	}

	public void setItemsRentedCount(Integer itemsRentedCount) {
		this.itemsRentedCount = itemsRentedCount;
	}

	public Integer getItemsSharedCount() {
		return itemsSharedCount;
	}

	public void setItemsSharedCount(Integer itemsSharedCount) {
		this.itemsSharedCount = itemsSharedCount;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
}
