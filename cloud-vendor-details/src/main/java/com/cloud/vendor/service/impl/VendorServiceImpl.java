package com.cloud.vendor.service.impl;

import com.cloud.vendor.exception.CloudVendorNotFoundException;
import com.cloud.vendor.repository.VendorRepository;
import com.cloud.vendor.service.VendorService;
import com.cloud.vendor.model.Vendor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService {

    private static final Logger log = LoggerFactory.getLogger(VendorServiceImpl.class);

    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public Optional<Vendor> findByVendorId(int vendorId) throws CloudVendorNotFoundException {
        if(vendorRepository.existsById(vendorId)) {
            log.info("Vendor with id {} found", vendorId);
            log.debug("Vendor with id {} found in debug level", vendorId);
            return vendorRepository.findById(vendorId);
        }
        log.error("Vendor with id {} not found", vendorId);
        throw new CloudVendorNotFoundException("vendor not found");

    }


    @Override
    public Optional<Vendor> save(Vendor vendor) {
        return Optional.of(vendorRepository.save(vendor));
    }

    @Override
    public String delete(int vendorId) {
        vendorRepository.deleteById(vendorId);
        return "Vendor has deleted successfully..!";
    }

    @Override
    public Optional<Vendor> update(int vendorId) {
        Vendor vendor = null;
        if (vendorRepository.findById(vendorId).isPresent()) {
            vendor = vendorRepository.findById(vendorId).get();
            vendor.setVendorName("Patch call updated by vendor");
        }
        return Optional.ofNullable(vendor);
    }

    @Override
    public Optional<List<Vendor>> findAll() {
        return Optional.of(vendorRepository.findAll());
    }

}
