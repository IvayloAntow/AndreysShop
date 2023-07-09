package com.example.andreysshop.service.impl;

import com.example.andreysshop.model.entity.Category;
import com.example.andreysshop.model.entity.CategoryName;
import com.example.andreysshop.model.service.CategoryServiceModel;
import com.example.andreysshop.repository.CategoryRepository;
import com.example.andreysshop.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initCategories() {
        if (this.categoryRepository.count() == 0){
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        this.categoryRepository
                                .save(new Category(categoryName,
                                        String.format("Description for %s",
                                                categoryName.name())));
                    });
                    }
        }

    @Override
    public CategoryServiceModel findByCategoryName(CategoryName categoryName) {
        return this.categoryRepository
                .findCategoryByCategoryName(categoryName)
                .map(category -> this.modelMapper
                        .map(category, CategoryServiceModel.class))
                .orElse(null);
    }
}

