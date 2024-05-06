package dto.models.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public Geo geo;
}
