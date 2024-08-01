package vn.tnteco.exceldemo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vn.tnteco.exceldemo.service.CustomerService;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("customers")
public class CustomerController {
    private CustomerService customerService;

    @PostMapping("/upload-customers-data")
    public ResponseEntity<?> uploadCustomersData(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return null;
        }
        customerService.saveCustomersToDatabase(file);

        return ResponseEntity
                .ok(Map.of("Message", " Customers data uploaded and saved to database successfully"));
    }


}
