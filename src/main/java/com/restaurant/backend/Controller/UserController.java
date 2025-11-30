package com.restaurant.backend.Controller;

import com.restaurant.backend.Entity.User;
import com.restaurant.backend.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User created = userService.create(user);

        return ResponseEntity.ok(
                Map.of(
                        "message", "Register successfully",
                        "user", created
                )
        );
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email,
                                   @RequestParam String password) {

        User user = userService.login(email, password);

        return ResponseEntity.ok(
                Map.of(
                        "message", "Login successful",
                        "user", user
                )
        );
    }

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(userService.getAll());
    }
}
