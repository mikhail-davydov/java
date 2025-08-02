package sample.mkhldvdv.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemoAppUserDto {

    private UUID userId;
    private String username;
    private String firstname;
    private String lastname;

}