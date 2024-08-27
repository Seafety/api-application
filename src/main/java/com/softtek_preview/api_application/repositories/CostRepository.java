package com.softtek_preview.api_application.repositories;

import com.softtek_preview.api_application.domain.cost.Cost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostRepository extends JpaRepository<Cost, String> {

}