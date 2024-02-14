package jpa.myboard;

import jpa.myboard.boardPost.domain.BoardPost;
import jpa.myboard.boardPost.repository.BoardPostRepository;
import jpa.myboard.comment.domain.Comment;
import jpa.myboard.user.domain.Gender;
import jpa.myboard.user.domain.SiteUser;
import jpa.myboard.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class MyboardApplicationTests {

}
