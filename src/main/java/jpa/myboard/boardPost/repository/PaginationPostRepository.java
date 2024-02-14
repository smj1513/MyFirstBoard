package jpa.myboard.boardPost.repository;

import jpa.myboard.boardPost.domain.BoardPost;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaginationPostRepository extends PagingAndSortingRepository<BoardPost, Long> {
}
