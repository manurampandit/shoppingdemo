package com.control.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Items")
public class Items implements Serializable{

	private static final long serialVersionUID = -8383414096346063090L;

	@Id
	@GeneratedValue
	@Column(name = "itemId")
	private Integer itemId;

	@Column(name="itemName")
	private String itemName;
	
	@Column(name="price")
	private BigDecimal price;

	@Column(name="imagePath")
	private String imagePath;

	@Column(name="productCategoryId")
	private Integer productCategoryId;
	
	@Column(name="subProductCategoryId")
	private Integer subProductCategoryId;

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Integer getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Integer productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public Integer getSubProductCategoryId() {
		return subProductCategoryId;
	}

	public void setSubProductCategoryId(Integer subProductCategoryId) {
		this.subProductCategoryId = subProductCategoryId;
	}

}
