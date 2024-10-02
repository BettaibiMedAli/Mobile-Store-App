package com.project.mobileStore.services;

import com.project.mobileStore.models.Mobile;
import com.project.mobileStore.repositories.MobileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MobileServiceImpl implements MobileService{
    @Autowired
    private MobileRepo mobileRepo;

    @Override
    public List<Mobile> getAllMobiles() {
        return mobileRepo.findAll();
    }

    @Override
    public List<Mobile> searchMobiles(String phrase) {
        return mobileRepo.findByNameContaining(phrase);
    }

    @Override
    public Optional<Mobile> getMobileById(Long id) {
        return mobileRepo.findById(id);
    }

    @Override
    public Mobile addMobile(Mobile mobile) {
        return mobileRepo.save(mobile);
    }

    @Override
    public Mobile updateMobile(Long id, Mobile mobile) {
        Mobile existingMobile = getMobileById(id).orElseThrow(() -> new RuntimeException("Mobile does not exist with id : "+id));
        existingMobile.setName(mobile.getName());
        existingMobile.setRam(mobile.getRam());
        existingMobile.setStockage(mobile.getStockage());
        existingMobile.setPrice(mobile.getPrice());
        return mobileRepo.save(existingMobile);
    }

    @Override
    public void deleteMobile(Long id) {
        Mobile existingMobile = getMobileById(id).orElseThrow(() -> new RuntimeException("Mobile does not exist with id : "+id));
        mobileRepo.delete(existingMobile);
    }
}
