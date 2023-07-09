package com.example.andreysshop.model.service;

public class ItemServiceModel extends BaseServiceModel{

      private String name;

      private String description;

      private String gender;
      private CategoryServiceModel categoryServiceModel;


      public ItemServiceModel() {
    }

    public String getName() {
        return name;
    }

    public ItemServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public ItemServiceModel setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public CategoryServiceModel getCategoryServiceModel() {
        return categoryServiceModel;
    }

    public ItemServiceModel setCategoryServiceModel(CategoryServiceModel categoryServiceModel) {
        this.categoryServiceModel = categoryServiceModel;
        return this;
    }
}
