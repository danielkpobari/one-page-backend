package com.danitest.kpobaritest.service.impl;

import com.danitest.kpobaritest.dto.request.UserRequest;
import com.danitest.kpobaritest.dto.response.ApiResponse;
import com.danitest.kpobaritest.exception.ResourceNotFoundException;
import com.danitest.kpobaritest.model.Sector;
import com.danitest.kpobaritest.model.User;
import com.danitest.kpobaritest.repository.SectorRepository;
import com.danitest.kpobaritest.repository.UserRepository;
import com.danitest.kpobaritest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final SectorRepository sectorRepository;
    private final UserRepository userRepository;

    @Override
    public ApiResponse<User> create(UserRequest userRequest) {
        Set<Sector> sectors = userRequest.getSectors()
                .stream()
                .map(sectorRequest -> sectorRepository.findById(sectorRequest.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Sector not found"))).collect(Collectors.toSet());

        User user = new User();
        user.setName(userRequest.getName());
        user.setAgreedToTerms(userRequest.isAgreedToTerms());
        user.setSectors(sectors);

        return ApiResponse.success(userRepository.save(user));
    }

    @Override
    public ApiResponse<User> getById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return ApiResponse.success(user);
    }

    @Override
    public ApiResponse<User> update(Long userId, UserRequest userRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Set<Sector> sectors = userRequest.getSectors()
                .stream()
                .map(sectorRequest -> sectorRepository.findById(sectorRequest.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Sector with name "+ sectorRequest.getName()+ " not found"))).collect(Collectors.toSet());

        user.setName(userRequest.getName());
        user.setAgreedToTerms(userRequest.isAgreedToTerms());
        user.setSectors(sectors);

        return ApiResponse.success(userRepository.save(user));
    }


}
