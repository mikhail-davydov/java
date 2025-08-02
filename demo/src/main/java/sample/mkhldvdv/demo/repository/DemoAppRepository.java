package sample.mkhldvdv.demo.repository;

import sample.mkhldvdv.demo.model.DemoAppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DemoAppRepository extends JpaRepository<DemoAppUser, UUID> {

}