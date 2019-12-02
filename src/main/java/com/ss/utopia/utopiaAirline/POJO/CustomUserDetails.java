package com.ss.utopia.utopiaAirline.POJO;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends User implements UserDetails {
	
	private static final long serialVersionUID = 9041652514501811577L;

	public CustomUserDetails(final User user) {
		super(user);
	}

	//to know what are all roles for this application
	//iterating roles and everything for that user GrantedAuthority
	
	 @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 
		return getRoleId()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getRole()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
