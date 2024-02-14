package jpa.myboard.boardPost.controller;

import jpa.myboard.boardPost.domain.BoardPost;
import jpa.myboard.boardPost.dto.BoardDTO;
import jpa.myboard.boardPost.dto.BoardListDTO;
import jpa.myboard.boardPost.service.BoardPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/boardPost")
@RequiredArgsConstructor
@Log4j2
public class BoardPostController {


	private final BoardPostService boardPostService;

	@GetMapping
	public String redirection() {
		return "redirect:/list";
	}

	@GetMapping("/list")
	@ResponseStatus(HttpStatus.OK)
	public BoardDTO list(@RequestParam(name = "page") Integer pageNumber) {
		return boardPostService.getPageData(pageNumber);
	}
}
