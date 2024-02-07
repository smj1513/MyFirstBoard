package jpa.myboard.boardPost.domain;

import jakarta.persistence.*;
import jpa.myboard.comment.domain.Comment;

import jpa.myboard.user.domain.SiteUser;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;



@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class BoardPost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String content;

	private LocalDateTime createdAt;

	private LocalDateTime modifiedAt;

	@ManyToOne
	private SiteUser writer;

	@OneToMany
	private List<Comment> comments;

	@ManyToMany
	private Set<SiteUser> upVotes;

	@ManyToMany
	private Set<SiteUser> downVotes;

}
