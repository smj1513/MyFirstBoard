package jpa.myboard.user.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jpa.myboard.boardPost.domain.BoardPost;
import jpa.myboard.comment.domain.Comment;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class SiteUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(unique = true)
	private String nickname;

	@Column(unique = true)
	private String userId; // 편의를 위해 PasswordEncoder가 아닌 자바 내장 hashCode로 등록.

	private String password;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(unique = true)
	@Email
	private String email;

	@Column(name = "phone_number", unique = true)
	private String phoneNumber;

	@OneToMany
	private List<BoardPost> posts;

	@OneToMany
	private List<Comment> comments;

	@Column(name = "join_date")
	private LocalDateTime joinDate;

	@Column(name = "birth_date")
	private LocalDate birthDate;


}
