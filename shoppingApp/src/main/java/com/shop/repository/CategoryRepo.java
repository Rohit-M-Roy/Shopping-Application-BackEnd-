package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.model.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
