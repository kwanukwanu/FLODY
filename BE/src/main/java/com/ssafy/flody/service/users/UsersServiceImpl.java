package com.ssafy.flody.service.users;

import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.UsersRepository;
import com.ssafy.flody.dto.request.Users.UserCreateRequestDto;
import com.ssafy.flody.dto.response.Users.UserInfoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService{
    private final UsersRepository usersRepository;
    @Override
    public List<UserInfoResponseDto> findUsers() {
        List<Users> entityList = usersRepository.findAll();
        List<UserInfoResponseDto> list = new ArrayList<>();
        for (Users user: entityList) {
            list.add(new UserInfoResponseDto(user));
        }
        return list;
    }

    @Override
    @Transactional()
    public Long addUser(UserCreateRequestDto requestDto) {
        return usersRepository.save(requestDto.toEntity()).getUseNo();
    }
}
