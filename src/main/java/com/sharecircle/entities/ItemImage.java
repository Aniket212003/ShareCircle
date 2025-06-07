package com.sharecircle.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item_image")
public class ItemImage 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="image_id")
	private Integer image_id;
	
	@Column(name="image_name", nullable = false)
	private String imageName;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id",nullable=false)
    private Item item;

	public void setItem(Item item) 
	{
		this.item = item;
	}

	public Integer getImage_id() {
		return image_id;
	}

	public void setImage_id(Integer image_id) {
		this.image_id = image_id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Item getItem() {
		return item;
	}
}
