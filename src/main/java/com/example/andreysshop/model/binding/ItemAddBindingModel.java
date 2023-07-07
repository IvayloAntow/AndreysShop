package com.example.andreysshop.model.binding;

import com.example.andreysshop.model.entity.CategoryName;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public class ItemAddBindingModel {

    @Length(min = 2, message = "Username length must be more than two characters!")
    private String name;

    @Length(min = 3, message = "Description length must be more than three characters!")
    private String description;

    @NotNull(message = "Enter valid category name!")
    private CategoryName category;

    @Length(min = 2, message = "Enter valid!")
    private String gender;

    @DecimalMin(value = "0", message = "Enter valid price!")
    private BigDecimal price;

    public ItemAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ItemAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryName getCategory() {
        return category;
    }

    public ItemAddBindingModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public ItemAddBindingModel setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
