package sample.mkhldvdv.demo.controller;

import sample.mkhldvdv.demo.dto.DemoAppUserDto;
import sample.mkhldvdv.demo.model.DemoAppUser;
import sample.mkhldvdv.demo.service.DemoAppService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class DemoAppUsersController {

    private final DemoAppService demoAppService;

    @GetMapping("/{userId}")
    public ResponseEntity<DemoAppUserDto> getUserById(@PathVariable("userId") UUID userId) {
        log.info("Call to getUserById, request: [{}]", userId);
        return ResponseEntity.ok(demoAppService.getUserById(userId));
    }

    @GetMapping
    public ResponseEntity<List<DemoAppUserDto>> getUsers() {
        log.info("Call to getUsers");
        return ResponseEntity.ok(demoAppService.getUsers());
    }

    @PostMapping
    public ResponseEntity<DemoAppUserDto> createOrUpdateUser(@RequestBody DemoAppUser user) {
        log.info("Call to createOrUpdateUser, request: {}", user);
        return ResponseEntity.ok(demoAppService.createOrUpdateUser(user));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("userId") UUID userId) {
        log.info("Call to deleteUserById, request: [{}]", userId);
        demoAppService.deleteUserById(userId);
        return ResponseEntity.ok().build();
    }

}