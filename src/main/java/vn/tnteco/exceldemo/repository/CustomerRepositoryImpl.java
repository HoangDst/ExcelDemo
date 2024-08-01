package vn.tnteco.exceldemo.repository;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.tnteco.exceldemo.data.Customer;

import java.util.List;

import static vn.tnteco.excel2database.tables.Customers.CUSTOMERS;


@Repository
public class CustomerRepositoryImpl implements ICustomerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

   private final DSLContext dslContext;

    public CustomerRepositoryImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

//    @Override
//    public void savetoDatabase(List<Customer> customers) {
//        String sql = "INSERT INTO customers (customer_id, first_name, last_name,country,telephone) VALUES (?, ?, ?,?,?)";
//        for (Customer customer : customers) {
//            jdbcTemplate.update(sql, customer.getCustomerId(), customer.getFirstName(), customer.getLastName(), customer.getCountry(), customer.getTelephone());
//        }
//    }
    public void savetoDatabase(List<Customer> customers) {
        for (Customer customer : customers) {
            dslContext.insertInto(CUSTOMERS)
                    .set(CUSTOMERS.CUSTOMER_ID, customer.getCustomerId())
                    .set(CUSTOMERS.FIRST_NAME, customer.getFirstName())
                    .set(CUSTOMERS.LAST_NAME, customer.getLastName())
                    .set(CUSTOMERS.COUNTRY, customer.getCountry())
                    .set(CUSTOMERS.TELEPHONE, customer.getTelephone())
                    .execute();
        }
    }
}
