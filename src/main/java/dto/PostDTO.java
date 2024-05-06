package dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {

    private Integer userId;
    private Integer id;
    private String title;
    private String body;

}
