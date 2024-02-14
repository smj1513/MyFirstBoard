package jpa.myboard.boardPost.dto;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BoardListDTO {

	private Long id;

	private Long number;

	private String title;

	private Integer upVotesCount;

	private String writer;

	private LocalDateTime createdAt;

}
