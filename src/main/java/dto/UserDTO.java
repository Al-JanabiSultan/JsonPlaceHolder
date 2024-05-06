package dto;

import dto.models.user.Address;
import dto.models.user.Company;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    public int id;
    public String name;
    public String username;
    public String email;
    public Address address;
    public String phone;
    public String website;
    public Company company;
}
