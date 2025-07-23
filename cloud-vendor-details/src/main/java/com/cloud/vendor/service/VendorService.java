package com.cloud.vendor.service;

import com.cloud.vendor.model.Vendor;

import java.util.List;
import java.util.Optional;

public interface VendorService {

    Optional<Vendor> findByVendorId(int vendorId);


    Optional<Vendor> save(Vendor vendor);

    String delete(int vendorId);

    Optional<Vendor> update(int vendorId);

    Optional<List<Vendor>> findAll();


}
