package vn.tnteco.exceldemo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Customer {

    private Integer customerId;
    private String firstName;
    private String lastName;
    private String country;
    private Integer telephone;

}
