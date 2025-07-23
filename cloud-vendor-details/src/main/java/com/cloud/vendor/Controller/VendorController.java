package com.cloud.vendor.Controller;

import com.cloud.vendor.response.ResponseHandler;
import com.cloud.vendor.service.VendorService;
import com.cloud.vendor.model.Vendor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    VendorService  vendorService;

    @GetMapping("{vendorId}")
    @Operation(summary = "get the vendor details based on the id", description = "return the vendor details",
    responses = {
                @ApiResponse(responseCode = "200", description ="vendor is found based on the id"),
                @ApiResponse(responseCode = "404", description = "vendor not found")
    })
    public ResponseEntity<Optional<Vendor>> getById(@PathVariable int vendorId) {
        return new ResponseEntity<>(vendorService.findByVendorId(vendorId), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Vendor vendor) {
       return ResponseHandler.getResponseEntity("vendor saved", HttpStatus.CREATED, vendorService.save(vendor));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int vendorId) {
        vendorService.delete(vendorId);
        String response = "Deleted vendor with id: " + vendorId;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("update/{vendorId}")
    public ResponseEntity<Optional<Vendor>> update(@PathVariable int vendorId) {
        return new  ResponseEntity<>(vendorService.update(vendorId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Optional<List<Vendor>>> findAll() {
        return new ResponseEntity<>(vendorService.findAll(), HttpStatus.OK);
    }
}
