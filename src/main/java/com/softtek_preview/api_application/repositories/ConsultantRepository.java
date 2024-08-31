package com.softtek_preview.api_application.repositories;

import com.softtek_preview.api_application.domain.consultant.Consultant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant, UUID> {
    List<Consultant> findByIdIn(Set<UUID> ids);
}
