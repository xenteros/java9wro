package com.github.xenteros.security;

import com.github.xenteros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findOneByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new UserDetailsImpl(user.getLogin(), user.getPassword());
    }
}
