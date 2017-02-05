package ua.com.schoolnetwork.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by ваня on 05.02.2017.
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService{

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


}
