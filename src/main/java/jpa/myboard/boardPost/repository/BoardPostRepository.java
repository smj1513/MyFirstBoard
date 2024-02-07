package jpa.myboard.boardPost.repository;

import jpa.myboard.boardPost.domain.BoardPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardPostRepository extends JpaRepository<BoardPost, Long> {

}
