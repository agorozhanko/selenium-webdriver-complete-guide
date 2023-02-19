package model;

import utilities.Utilities;

public class Product {
    String name;
    String code;
    String image;
    String manufacturer;
    String keywords;
    String shortDescription;
    String description;
    String headTitle;
    String metaDescription;
    String purchasePrice;
    String purchasePriceCurrency;
    String price;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Product setCode(String code) {
        this.code = code;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Product setImage(String image) {
        this.image = Utilities.buildPathToFile(image);
        return this;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Product setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public String getKeywords() {
        return keywords;
    }

    public Product setKeywords(String keywords) {
        this.keywords = keywords;
        return this;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public Product setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getHeadTitle() {
        return headTitle;
    }

    public Product setHeadTitle(String headTitle) {
        this.headTitle = headTitle;
        return this;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public Product setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
        return this;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public Product setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    public String getPurchasePriceCurrency() {
        return purchasePriceCurrency;
    }

    public Product setPurchasePriceCurrency(String purchasePriceCurrency) {
        this.purchasePriceCurrency = purchasePriceCurrency;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public Product setPrice(String price) {
        this.price = price;
        return this;
    }
}
