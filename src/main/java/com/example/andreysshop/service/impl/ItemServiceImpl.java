package com.example.andreysshop.service.impl;

import com.example.andreysshop.model.entity.Item;
import com.example.andreysshop.model.service.CategoryServiceModel;
import com.example.andreysshop.model.service.ItemServiceModel;
import com.example.andreysshop.repository.ItemRepository;
import com.example.andreysshop.service.CategoryService;
import com.example.andreysshop.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ItemServiceImpl(ItemRepository itemRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addItem(ItemServiceModel itemServiceModel) {
        CategoryServiceModel categoryServiceModel = this.categoryService
                .findByCategoryName(itemServiceModel
                        .getCategoryServiceModel().getCategoryName());

        itemServiceModel.setCategoryServiceModel(categoryServiceModel);

        this.itemRepository.saveAndFlush(this.modelMapper
                .map(itemServiceModel, Item.class));

    }
}
