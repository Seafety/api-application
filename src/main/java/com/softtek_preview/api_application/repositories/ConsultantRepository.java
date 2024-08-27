package com.softtek_preview.api_application.repositories;

import com.softtek_preview.api_application.domain.consultant.Consultant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant, UUID> {

}
