package Service;

import DTOs.SignUpUserRequestDto;
import Model.User;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Exception.InvalidPassword;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User signUp(SignUpUserRequestDto request) {
        // we want to make sure this is a new user.
        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if (user.isPresent()) {
            throw new RuntimeException();
        }

        User newUser = new User();

        newUser.setEmail(request.getEmail());
        newUser.setName(request.getName());

        newUser.setPassword(request.getPassword());

        return userRepository.save(newUser);
    }

    public boolean login(String email, String password) throws InvalidPassword {

        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (!optionalUser.isPresent()) {
            throw new RuntimeException();
        }

        User user = optionalUser.get();
        // Check if the password matches
        if(!password.equals(user.getPassword())){
            throw new InvalidPassword("Password is invalid");
        }
        return true;
    }
}
