package com.ntreddy.dd.ecommerce.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sku;
    private String SupplierProductID;
    private @NotNull String productName;
    private @NotNull String productDescription;
    private @NotNull Integer supplierID;
    private @NotNull Integer categoryID;
    private @NotNull Integer quantityPerUnit;
    private @NotNull String unitSize;
    private @NotNull Double unitPrice;
    private @NotNull Double msrp;
    private @NotNull String availableSize;
    private @NotNull String availableColors;
    private @NotNull Integer sizeID;
    private @NotNull Integer colorID;
    private Double discount;
    private String unitWeight;
    private Integer unitsInStock;
    private Integer unitsOnOrder;
    private Integer reorderLevel;
    private char productAvailable;
    private char discountAvailable;
    private char currentOrder;
    private byte[] picture;
    private int ranking;
    private String note;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    Category category;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<WishList> wishListList;


    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Cart> carts;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getSku() {
		return sku;
	}


	public void setSku(String sku) {
		this.sku = sku;
	}


	public String getSupplierProductID() {
		return SupplierProductID;
	}


	public void setSupplierProductID(String supplierProductID) {
		SupplierProductID = supplierProductID;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public Integer getSupplierID() {
		return supplierID;
	}


	public void setSupplierID(Integer supplierID) {
		this.supplierID = supplierID;
	}


	public Integer getCategoryID() {
		return categoryID;
	}


	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}


	public Integer getQuantityPerUnit() {
		return quantityPerUnit;
	}


	public void setQuantityPerUnit(Integer quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}


	public String getUnitSize() {
		return unitSize;
	}


	public void setUnitSize(String unitSize) {
		this.unitSize = unitSize;
	}


	public Double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}


	public Double getMsrp() {
		return msrp;
	}


	public void setMsrp(Double msrp) {
		this.msrp = msrp;
	}


	public String getAvailableSize() {
		return availableSize;
	}


	public void setAvailableSize(String availableSize) {
		this.availableSize = availableSize;
	}


	public String getAvailableColors() {
		return availableColors;
	}


	public void setAvailableColors(String availableColors) {
		this.availableColors = availableColors;
	}


	public Integer getSizeID() {
		return sizeID;
	}


	public void setSizeID(Integer sizeID) {
		this.sizeID = sizeID;
	}


	public Integer getColorID() {
		return colorID;
	}


	public void setColorID(Integer colorID) {
		this.colorID = colorID;
	}


	public Double getDiscount() {
		return discount;
	}


	public void setDiscount(Double discount) {
		this.discount = discount;
	}


	public String getUnitWeight() {
		return unitWeight;
	}


	public void setUnitWeight(String unitWeight) {
		this.unitWeight = unitWeight;
	}


	public Integer getUnitsInStock() {
		return unitsInStock;
	}


	public void setUnitsInStock(Integer unitsInStock) {
		this.unitsInStock = unitsInStock;
	}


	public Integer getUnitsOnOrder() {
		return unitsOnOrder;
	}


	public void setUnitsOnOrder(Integer unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}


	public Integer getReorderLevel() {
		return reorderLevel;
	}


	public void setReorderLevel(Integer reorderLevel) {
		this.reorderLevel = reorderLevel;
	}


	public char getProductAvailable() {
		return productAvailable;
	}


	public void setProductAvailable(char productAvailable) {
		this.productAvailable = productAvailable;
	}


	public char getDiscountAvailable() {
		return discountAvailable;
	}


	public void setDiscountAvailable(char discountAvailable) {
		this.discountAvailable = discountAvailable;
	}


	public char getCurrentOrder() {
		return currentOrder;
	}


	public void setCurrentOrder(char currentOrder) {
		this.currentOrder = currentOrder;
	}


	public byte[] getPicture() {
		return picture;
	}


	public void setPicture(byte[] picture) {
		this.picture = picture;
	}


	public int getRanking() {
		return ranking;
	}


	public void setRanking(int ranking) {
		this.ranking = ranking;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public List<WishList> getWishListList() {
		return wishListList;
	}


	public void setWishListList(List<WishList> wishListList) {
		this.wishListList = wishListList;
	}


	public List<Cart> getCarts() {
		return carts;
	}


	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
   
}
