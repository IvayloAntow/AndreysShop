package com.example.andreysshop.service;

import com.example.andreysshop.model.entity.CategoryName;
import com.example.andreysshop.model.service.CategoryServiceModel;

public interface CategoryService {
    void initCategories();

    CategoryServiceModel findByCategoryName(CategoryName categoryName);
}
