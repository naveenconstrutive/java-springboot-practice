package com.cloud.vendor.controller;

import com.cloud.vendor.Controller.VendorController;
import com.cloud.vendor.model.Vendor;
import com.cloud.vendor.service.VendorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VendorControllerTest {
    @Autowired
    private VendorController vendorController;
    @MockitoBean
    private VendorService vendorService;


    private static final String VENDOR_NAME = "Vendor Name";
    private static final String VENDOR_PHONE = "7989901529";
    private static final String VENDOR_ADDRESS = "Vendor Address";
    private static final int VENDOR_ID = 123;


    @Test
    public void testVendorControllerGetVendorById() {
        when(vendorService.findByVendorId(VENDOR_ID)).thenReturn(Optional.of(fetchVendor()));
        ResponseEntity<Optional<Vendor>> response  =vendorController.getById(VENDOR_ID);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    private Vendor fetchVendor() {
        Vendor vendor = new Vendor();
        vendor.setVendorName(VENDOR_NAME);
        vendor.setVendorId(VENDOR_ID);
        vendor.setVendorAddress(VENDOR_ADDRESS);
        vendor.setVendorPhoneNumber(VENDOR_PHONE);
        return vendor;
    }

}
