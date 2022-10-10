package com.example.springmvc.auth.service;

import com.example.springmvc.auth.domain.UserPrinciple;
import com.example.springmvc.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service class that returns {@link UserPrinciple} object.
 */
@Service
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;

  @Autowired
  UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByUsername(username)
        .map(UserPrinciple::new)
        .orElseThrow(() -> new UsernameNotFoundException("Username Not Found!"));
  }
}
