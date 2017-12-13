package com.shine.bean;

public class Item {
    private String sku;
    private String skuName;
    private String cataType;
    private String brandCode;

    public Item() {
    }

    public Item(String sku, String skuName, String cataType, String brandCode) {
        this.sku = sku;
        this.skuName = skuName;
        this.cataType = cataType;
        this.brandCode = brandCode;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getCataType() {
        return cataType;
    }

    public void setCataType(String cataType) {
        this.cataType = cataType;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    @Override
    public String toString() {
        return "Item{" +
                "sku='" + sku + '\'' +
                ", skuName='" + skuName + '\'' +
                ", cataType='" + cataType + '\'' +
                ", brandCode='" + brandCode + '\'' +
                '}' + "\r\n";
    }
}
