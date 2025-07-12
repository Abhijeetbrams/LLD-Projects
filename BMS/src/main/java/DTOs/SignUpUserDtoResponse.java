package DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpUserDtoResponse {
    private Long userId;
    private ResponseStatus responseStatus;
}
