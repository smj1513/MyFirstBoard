package jpa.myboard.security;

public class MyPasswordEncoder implements PasswordEncoder{
	@Override
	public String encode(String password) {
		return String.valueOf(password.hashCode());
	}
}
