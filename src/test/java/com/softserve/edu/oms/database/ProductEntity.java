package com.softserve.edu.oms.database;

public class ProductEntity {
    private String name;
    private String description;
    private String price;

    public ProductEntity (Builder productEntityBuilder){
        this.name = productEntityBuilder.name;
        this.description = productEntityBuilder.description;
        this.price = productEntityBuilder.price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public static class Builder {
        private String name;
        private String description;
        private String price;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPrice(String price) {
            this.price = price;
            return this;
        }

        public ProductEntity build () {
            return new ProductEntity(this);
        }
    }

}
