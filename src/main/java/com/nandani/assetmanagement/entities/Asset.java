package com.nandani.assetmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Asset {

	@Id
	private int assetId;
	private String assetName;
	private String assetType;
	private String assetSerialNo;
	private Date assetPurchaseDate;
	
	public  int getAssetId(){
		return assetId;
	}
	
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getAssetSerialNo() {
		return assetSerialNo;
	}

	public void setAssetSerialNo(String assetSerialNo) {
		this.assetSerialNo = assetSerialNo;
	}

	public Date getAssetPurchaseDate() {
		return assetPurchaseDate;
	}

	public void setAssetPurchaseDate(Date assetPurchaseDate) {
		this.assetPurchaseDate = assetPurchaseDate;
	}

@Override
public String toString() {
	return "Asset [assetId=" + assetId + ", assetName=" + assetName + ", assetType=" + assetType + ", assetSerialNo="
			+ assetSerialNo + ", assetPurchaseDate="+ assetPurchaseDate +"]";
}
//
//public static void main(String[] args) {
//	Asset asset =new Asset();
//	System.out.println(asset.toString());
//}
}
