package org.lessons.java.esao_backoffice.security;

import java.util.Optional;

import org.lessons.java.esao_backoffice.model.User;
import org.lessons.java.esao_backoffice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> userAttempt = userRepository.findByUsername(username);

    if (userAttempt.isEmpty()) {
      throw new UsernameNotFoundException("Username not found");
    }

    return new DatabaseUserDetails(userAttempt.get());
  }
}
