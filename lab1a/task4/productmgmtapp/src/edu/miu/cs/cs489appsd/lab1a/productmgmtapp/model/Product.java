package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import java.time.LocalDate;

public class Product {
    private Long productId;
    private String name;
    private LocalDate dateSupplied;
    private Integer quantityInStock;
    private Double unitPrice;

    public Product(Long productId, String name, LocalDate dateSupplied, Integer quantityInStock, Double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public Product() {
        this(null, null, null, null, null);
    }

    public Product(String name, LocalDate dateSupplied, Integer quantityInStock, Double unitPrice) {
        this(null, name, dateSupplied, quantityInStock, unitPrice);
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("productId=").append(productId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", dateSupplied=").append(dateSupplied);
        sb.append(", quantityInStock=").append(quantityInStock);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append('}');
        return sb.toString();
    }

    public String toJSONString() {
        return String.format("\t{ \"productId\":%d, \"name\":\"%s\", \"dateSupplied\":\"%s\", \"quantityInStock\":%d, \"unitPrice\":%,.2f }",
                productId, name, dateSupplied, quantityInStock, unitPrice);
    }

    public String toXMLString() {
        return String.format("\t<product productId=\"%d\" name=\"%s\" dateSupplied=\"%s\" quantityInStock=\"%d\" unitPrice=\"%,.2f\"  />",
                productId, name, dateSupplied, quantityInStock, unitPrice);
    }

    public String toCSVString() {
        return String.format("%d, %s, %s, %d, %.2f",
                productId, name, dateSupplied, quantityInStock, unitPrice);
    }
}
