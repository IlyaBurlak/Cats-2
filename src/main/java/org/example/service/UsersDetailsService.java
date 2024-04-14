package org.example.service;

import lombok.AllArgsConstructor;
import org.example.UserRepository;
import org.example.entity.User;
import org.example.security.UsersDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UsersDetailsService implements UserDetailsService {
    @Autowired
    private static UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = repository.findByName(username);
        return user.map(UsersDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username + "not found"));
    }

    public static void addUser(User user){
        repository.save(user);
    }
}
