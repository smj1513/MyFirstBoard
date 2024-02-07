package jpa.myboard.comment.domain;

import jakarta.persistence.*;
import jpa.myboard.boardPost.domain.BoardPost;

import jpa.myboard.user.domain.SiteUser;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String content;

	@ManyToOne
	private SiteUser writer;

	@ManyToOne
	private BoardPost boardPost;

	private LocalDateTime createdAt;

	private LocalDateTime modifiedAt;

}
