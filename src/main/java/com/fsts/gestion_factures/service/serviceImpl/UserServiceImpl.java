package com.fsts.gestion_factures.service.serviceImpl;

import com.fsts.gestion_factures.entities.User;
import com.fsts.gestion_factures.exceptions.ResourceDuplicatedException;
import com.fsts.gestion_factures.exceptions.ResourceNotFoundException;
import com.fsts.gestion_factures.mappers.UserMapper;
import com.fsts.gestion_factures.model.request.UserRequest;
import com.fsts.gestion_factures.model.response.UserResponse;
import com.fsts.gestion_factures.repository.UserRepository;
import com.fsts.gestion_factures.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse add(UserRequest request) {

        if (request.getEmail() != null && userRepository.findByEmail(request.getEmail()).isPresent())
            throw new ResourceDuplicatedException("user", "email", request.getEmail());
        //        Create the user
        User user = UserMapper.INSTANCE.requestToEntity(request);
        userRepository.save(user);
        return UserMapper.INSTANCE.entityToResponse(user);
    }

    @Override
    public List<UserResponse> get() {
        List<User> employees = userRepository.findAll();
        return UserMapper.INSTANCE.listToResponseList(employees);
    }

    @Override
    public UserResponse update(UserRequest request, Long id) {
        //        Check if the employee exists
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user", "id", id.toString()));
        //      Check unique properties are not duplicated
        if (request.getEmail() != null) {
            Optional<User> userByEmail = userRepository.findByEmail(request.getEmail());
            if (userByEmail.isPresent() && !userByEmail.get().getIdUser().equals(id))
                throw new ResourceDuplicatedException("user", "email", request.getEmail());
        }

        //        Update entity
        UserMapper.INSTANCE.updateEntityFromRequest(request, user);
        //        Save changes
        userRepository.save(user);
        //        Prepare and return the response
        return UserMapper.INSTANCE.entityToResponse(user);
    }

    @Override
    public void delete(Long id) {
        //        Check if the user exists
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user", "id", id.toString()));
        //        Delete entity
        userRepository.delete(user);
    }

    @Override
    public UserResponse get(Long id) {
        //        Check if the user exists
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user", "id", id.toString()));
        //        Prepare and return the response
        return UserMapper.INSTANCE.entityToResponse(user);

    }
}
