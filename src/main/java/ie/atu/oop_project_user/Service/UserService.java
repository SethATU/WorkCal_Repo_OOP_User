package ie.atu.oop_project_user.Service;

import ie.atu.oop_project_user.Model.User;
import ie.atu.oop_project_user.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepository;

    public String register(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        userRepository.save(user);
        return "Successfully registered";
    }

    public Long login(User request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Incorrect password");
        }
        return user.getId();
    }
}
