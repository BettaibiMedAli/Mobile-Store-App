package com.project.mobileStore.repositories;

import com.project.mobileStore.models.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MobileRepo extends JpaRepository<Mobile, Long> {
    List<Mobile> findByNameContaining(String name);
}
