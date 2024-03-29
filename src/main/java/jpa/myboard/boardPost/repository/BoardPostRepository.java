package jpa.myboard.boardPost.repository;

import jpa.myboard.boardPost.domain.BoardPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BoardPostRepository extends JpaRepository<BoardPost, Long> {
}