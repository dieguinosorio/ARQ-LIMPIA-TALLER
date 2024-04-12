package com.cleanone.clean_one.infraestructure.entrypoints;

import com.cleanone.clean_one.domain.model.User;
import com.cleanone.clean_one.domain.usecase.impl.CreateUserUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {

    private final CreateUserUseCaseImpl createUserUseCase;

    @Autowired
    public UserController(CreateUserUseCaseImpl createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = createUserUseCase.execute(user.getName(), user.getEmail(), user.getPassword());
        return ResponseEntity.ok(newUser);
    }
}
