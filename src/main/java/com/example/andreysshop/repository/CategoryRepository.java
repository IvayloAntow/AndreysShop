package com.example.andreysshop.repository;

import com.example.andreysshop.model.entity.Category;
import com.example.andreysshop.model.entity.CategoryName;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {

    Optional<Category> findCategoryByCategoryName(CategoryName categoryName);
}
