package jpa.myboard.user.domain;

import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
public enum Gender {
	Male("male"),
	FeMale("female");

	Gender(String gender) {}
}
