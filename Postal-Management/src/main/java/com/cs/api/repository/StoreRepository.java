package com.cs.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cs.api.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

	@Query("SELECT s FROM Store s WHERE s.name=:storeName")
	List<Store> findByName(String storeName);

}
