package ie.atu.oop_project_user.Controller;

import ie.atu.oop_project_user.Model.User;
import ie.atu.oop_project_user.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService UserService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam String username, @RequestParam String password) {
        return ResponseEntity.ok(UserService.register(username,password));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User login) {
        return ResponseEntity.ok(UserService.login(login));
    }
}