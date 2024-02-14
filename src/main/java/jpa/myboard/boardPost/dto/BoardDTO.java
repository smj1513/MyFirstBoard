package jpa.myboard.boardPost.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
public class BoardDTO {
	private List<BoardListDTO> posts;
	private Integer pageCount;
}
