package org.example.service;

import lombok.AllArgsConstructor;
import org.example.UserRepository;
import org.example.entity.User;
import org.example.security.UsersDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersDetailsService implements UserDetailsService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByName(username);
        return user.map(UsersDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }

    public void addUser(User user) {
        String plainPassword = user.getPassword();

        if(!passwordEncoder.matches(plainPassword, user.getPassword())){
            user.setPassword(passwordEncoder.encode(plainPassword));
            repository.save(user);
        }
    }
}