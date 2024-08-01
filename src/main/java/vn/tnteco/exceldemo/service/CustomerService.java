package vn.tnteco.exceldemo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.tnteco.exceldemo.data.Customer;
import vn.tnteco.exceldemo.repository.ICustomerRepository;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private ICustomerRepository customerRepository;

    public void saveCustomersToDatabase(MultipartFile file) {
        if (ExcelUploadService.isValidExcelFile(file)) {
            try {
                List<Customer> customers = ExcelUploadService.getCustomersDataFromExcel(file.getInputStream());
                customerRepository.savetoDatabase(customers);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }
}
