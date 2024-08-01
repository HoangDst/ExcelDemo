package vn.tnteco.exceldemo.repository;


import vn.tnteco.exceldemo.data.Customer;

import java.util.List;

public interface ICustomerRepository {
    void savetoDatabase(List<Customer> customers);
}
