package com.capgemini.asset.dto;

public class Asset {

	@Override
	public String toString() {
		return "Asset [assetName=" + assetName + ", assetId=" + assetId
				+ ", assetDes=" + assetDes + ", quantity=" + quantity
				+ ", status=" + status + "]";
	}
	private String assetName;
	private int assetId;
	private String assetDes;
	private int quantity;
	private String status;
	
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public String getAssetDes() {
		return assetDes;
	}
	public void setAssetDes(String assetDes) {
		this.assetDes = assetDes;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
