package com.backend.backend.business;

import com.backend.backend.core.GenericServiceImpl;
import com.backend.backend.entity.User;
import com.backend.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserBusiness extends GenericServiceImpl<User, UUID, UserRepository> {

    public UserBusiness(UserRepository repository) {
        super(repository);
    }

}
