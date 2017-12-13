package com.shine.bean;

import com.alibaba.fastjson.JSON;
import com.shine.util.StringUtil;

public class Product implements Comparable<Product> {

    private String sku;
    private String skuName;
    private String cataType;
    private String brandCode;

    public Product() {
    }

    public Product(Item item) {
        if (item == null) return;
        this.sku = item.getSku();
        this.skuName = item.getSkuName();
        this.cataType = item.getCataType();
        this.brandCode = item.getBrandCode();
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        if (sku != null ? !sku.equals(product.sku) : product.sku != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return sku != null ? sku.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", skuName='" + skuName + '\'' +
                ", cataType='" + cataType + '\'' +
                ", brandCode='" + brandCode + '\'' +
                '}' + "\r\n";
    }

    @Override
    public int compareTo(Product o) {
        if (this == null && o == null) {
            return 0;
        } else if (this != null && o == null) {
            return -1;
        } else if (this == null && o != null) {
            return 1;
        } else {
            int result = StringUtil.strCompare(this.getCataType(), o.getCataType());
            return result != 0 ? result : StringUtil.strCompare(this.getBrandCode(), o.getBrandCode());
        }
    }
}
