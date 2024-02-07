package jpa.myboard.boardPost.controller;

import jpa.myboard.boardPost.domain.BoardPost;
import jpa.myboard.boardPost.service.BoardPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController("/boardPost")
@RequiredArgsConstructor
public class BoardPostController {

	private final BoardPostService boardPostService;

	@GetMapping
	public String redirection(){
		return "redirect:/list";
	}

	@GetMapping("/list")
	@ResponseStatus(HttpStatus.OK)
	public List<BoardPost> list(){
		List<BoardPost> posts = boardPostService.getAll();
		posts.sort((post1, post2)-> post2.getCreatedAt().compareTo(post1.getCreatedAt()));
		return posts;
	}
}
