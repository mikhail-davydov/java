package sample.mkhldvdv.demo.service;

import sample.mkhldvdv.demo.dto.DemoAppUserDto;
import sample.mkhldvdv.demo.mapper.DemoAppUsersMapper;
import sample.mkhldvdv.demo.model.DemoAppUser;
import sample.mkhldvdv.demo.repository.DemoAppRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class DemoAppService {

    private final DemoAppUsersMapper demoAppUsersMapper;
    private final DemoAppRepository demoAppRepository;

    @Transactional(readOnly = true)
    public DemoAppUserDto getUserById(UUID userId) {
        log.info("Get user: [{}]", userId);
        var user = demoAppRepository.findById(userId).orElseThrow(() -> new RuntimeException("No user found"));
        return demoAppUsersMapper.toDto(user);
    }

    @Transactional(readOnly = true)
    public List<DemoAppUserDto> getUsers() {
        log.info("Get users");
        var users = demoAppRepository.findAll();
        return demoAppUsersMapper.toDtoList(users);
    }

    @Transactional
    public DemoAppUserDto createOrUpdateUser(DemoAppUser user) {
        log.info("CreateOrUpdate user: {}", user);

        var saved = Objects.isNull(user.getUserId()) ?
                new DemoAppUser() :
                demoAppRepository.findById(user.getUserId()).orElseThrow(() -> new RuntimeException("No user found"));

        saved.setUsername(user.getUsername());
        saved.setFirstname(user.getFirstname());
        saved.setLastname(user.getLastname());

        return demoAppUsersMapper.toDto(demoAppRepository.save(saved));
    }

    @Transactional
    public void deleteUserById(UUID userId) {
        log.info("Delete user: [{}]", userId);
        demoAppRepository.deleteById(userId);
    }

}