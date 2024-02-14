package jpa.myboard.boardPost.service;

import jpa.myboard.boardPost.domain.BoardPost;
import jpa.myboard.boardPost.dto.BoardDTO;
import jpa.myboard.boardPost.dto.BoardListDTO;
import jpa.myboard.boardPost.repository.BoardPostRepository;
import jpa.myboard.boardPost.repository.PaginationPostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardPostService {

	public static final int PAGE_ROW_COUNT = 10;
	private final BoardPostRepository boardPostRepository;
	private final PaginationPostRepository pageRepository;

	public BoardDTO getPageData(Integer pageNumber) {
		Page<BoardPost> posts = pageRepository.findAll(PageRequest.of(pageNumber - 1, PAGE_ROW_COUNT, Sort.by(Sort.Direction.DESC,"createdAt")));
		long count = boardPostRepository.count();
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setPosts(posts.stream().sorted((post1, post2) -> post2.getCreatedAt().compareTo(post1.getCreatedAt()))
				.map((domainPost) -> {
					BoardListDTO boardListDTO = new BoardListDTO();
					boardListDTO.setNumber(domainPost.getId());
					boardListDTO.setId(domainPost.getId());
					boardListDTO.setWriter(domainPost.getWriter().getNickname());
					boardListDTO.setTitle(domainPost.getTitle());
					boardListDTO.setUpVotesCount(domainPost.getUpVotes().size());
					boardListDTO.setCreatedAt(domainPost.getCreatedAt());
					return boardListDTO;
				}).toList()
		);
		log.info(boardDTO.getPosts());
		boardDTO.setPageCount((int) Math.ceil(count / (double) PAGE_ROW_COUNT));
		return boardDTO;
	}

	public List<BoardPost> getAll() {
		return boardPostRepository.findAll();
	}
}
