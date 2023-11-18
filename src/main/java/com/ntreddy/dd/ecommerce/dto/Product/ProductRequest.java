package com.ntreddy.dd.ecommerce.dto.Product;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.FILL_IN_THE_INPUT_FIELD;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductRequest {

	private @NotNull Integer id;
	private String sku;
	private String SupplierProductID;

	@NotBlank(message = FILL_IN_THE_INPUT_FIELD)
	@Length(max = 255)
	private @NotNull String productName;
	@NotBlank(message = FILL_IN_THE_INPUT_FIELD)
	@Length(max = 1000)
    private @NotNull String productDescription;
	@NotBlank(message = FILL_IN_THE_INPUT_FIELD)
	@Length(max = 20)
    private @NotNull Integer supplierID;
	@NotBlank(message = FILL_IN_THE_INPUT_FIELD)
	@Length(max = 15)
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
}
