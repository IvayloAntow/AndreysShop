package com.example.andreysshop.model.service;

import com.example.andreysshop.model.entity.CategoryName;

public class CategoryServiceModel extends BaseServiceModel{

    private CategoryName categoryName;

    private String description;

    public CategoryServiceModel() {
    }

    public CategoryName getCategoryName() {
        return categoryName;
    }

    public CategoryServiceModel setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
