package com.notter.rest.auth;

import com.notter.config.security.CustomUserDetails;
import com.notter.config.security.jwt.JwtProvider;
import com.notter.db.entity.UserEntity;
import com.notter.exception.UserNotFoundException;
import com.notter.rest.auth.model.AuthSigninRequest;
import com.notter.rest.auth.model.AuthSigninResponse;
import com.notter.rest.auth.model.AuthSignupRequest;
import com.notter.rest.auth.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController()
@Validated
public class AuthController {
    private final UserService userService;
    private final JwtProvider jwtProvider;

    public AuthController(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("auth/sign-up")
    public User registerUser(@Valid @RequestBody AuthSignupRequest request) {
        var u = new UserEntity();
        u.setPassword(request.getPassword());
        u.setEmail(request.getEmail());
        u.setName(request.getName());

        return userService.create(u);
    }

    @PostMapping("auth/sign-in")
    public AuthSigninResponse auth(@Valid @RequestBody AuthSigninRequest request) {
        var userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());

        if (userEntity == null) {
            throw new UserNotFoundException();
        }

        var token = jwtProvider.generateToken(userEntity.getEmail());

        var u = User.toModel(userEntity);
        return new AuthSigninResponse(token, u);
    }

    @GetMapping("api/v1/profile")
    public User getProfile(
            @AuthenticationPrincipal CustomUserDetails user
    ) {
        return User.toModel(user.getUserEntity());
    }
}
