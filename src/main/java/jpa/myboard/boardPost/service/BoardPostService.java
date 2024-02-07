package jpa.myboard.boardPost.service;

import jpa.myboard.boardPost.domain.BoardPost;
import jpa.myboard.boardPost.repository.BoardPostRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardPostService {

	private final BoardPostRepository boardPostRepository;

	public List<BoardPost> getAll(){
		return boardPostRepository.findAll();
	}
}
