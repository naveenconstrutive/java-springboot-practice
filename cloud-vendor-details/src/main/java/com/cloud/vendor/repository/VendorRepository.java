package com.cloud.vendor.repository;

import com.cloud.vendor.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VendorRepository extends JpaRepository<Vendor,Integer> {
}
