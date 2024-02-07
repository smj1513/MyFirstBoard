package jpa.myboard.security;

public interface PasswordEncoder {
	String encode(String password);
}
