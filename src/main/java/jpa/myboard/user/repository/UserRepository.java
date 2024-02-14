package jpa.myboard.user.repository;

import jpa.myboard.user.domain.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SiteUser, Long> {

	Optional<SiteUser> findByUserId(String userId);

}
