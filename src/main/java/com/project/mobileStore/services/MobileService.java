package com.project.mobileStore.services;

import com.project.mobileStore.models.Mobile;
import java.util.List;
import java.util.Optional;

public interface MobileService {
    List<Mobile> getAllMobiles();
    List<Mobile> searchMobiles(String phrase);
    Optional<Mobile> getMobileById(Long id);
    Mobile addMobile (Mobile mobile);
    Mobile updateMobile (Long id, Mobile mobile);
    void deleteMobile (Long id);
}
