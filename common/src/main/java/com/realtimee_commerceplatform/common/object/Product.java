package com.realtimee_commerceplatform.common.object;


import jakarta.persistence.*;

@Entity
@Table(name="products", uniqueConstraints= @UniqueConstraint(columnNames = "productId"))
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	private long productId;
	
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "productPrice")
	private float productPrice;
	
	@Column(name = "productDesc")
	private String productDesc;
	
	@Column(name = "productStock")
	private int productStock;
	
	public Product() {
		this(-1, "default product name", 0.0f, "default product description", 0);
	}

	public Product(long productId, String productName, float productPrice, String productDesc, int productStock) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDesc = productDesc;
		this.productStock = productStock;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDesc=" + productDesc + ", productStock=" + productStock + "]";
	}

}
