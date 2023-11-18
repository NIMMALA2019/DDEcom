package com.ntreddy.dd.ecommerce.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.ntreddy.dd.ecommerce.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

//	@Query("SELECT category_name FROM categories ORDER BY id ASC")
//	Page<Category> findAllByOrderByIdAsc(Pageable pageable);

//    List<Order> findAllByOrderByIdAsc();
//
//	@Query("SELECT c.id,c.category_name,c.description FROM ddcloud.categories c ORDER BY id ASC")
    Page<Category> findAllByOrderByIdAsc(Pageable pageable);
//
//    List<Order> findOrderByEmail(String email);
//
//    Page<Order> findOrderByEmail(String email, Pageable pageable);
}
