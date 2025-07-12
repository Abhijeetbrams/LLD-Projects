package Controller;

import DTOs.ResponseStatus;
import DTOs.SignUpUserDtoResponse;
import DTOs.SignUpUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {
    @Autowired
    private UserService userService;

    public SignUpUserDtoResponse signUp(SignUpUserRequestDto request){
        User user = userService.signUp(request);
        return new SignUpUserDtoResponse(user.getId(),
                ResponseStatus.SUCCESS);
    }

    public boolean login(String email, String password) throws InvalidPassword {
        return userService.login(email, password);
    }
}
