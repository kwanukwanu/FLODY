package com.ssafy.flody.service.users;

import com.ssafy.flody.config.JwtTokenProvider;
import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.UsersRepository;
import com.ssafy.flody.dto.request.users.UserCreateRequestDto;
import com.ssafy.flody.dto.request.users.UserLoginRequestDto;
import com.ssafy.flody.dto.request.users.UserPasswordUpdateRequestDto;
import com.ssafy.flody.dto.request.users.UserUpdateRequestDto;
import com.ssafy.flody.dto.response.users.UserInfoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails findUserForToken(String email) throws UsernameNotFoundException {
        return (UserDetails) usersRepository.findById(email)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }

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
    public UserInfoResponseDto findUserById(String email) {
        return new UserInfoResponseDto(findUser(email));
    }

    @Override
    @Transactional()
    public String addUser(UserCreateRequestDto requestDto) {
        String pw = passwordEncoder.encode(requestDto.getPassword());
        requestDto.setPassword(pw);
        return usersRepository.save(requestDto.toEntity()).getEmail();
    }

    @Override
    public Boolean validateEmail(String email){
        return usersRepository.findById(email).isPresent();
    }

    @Override
    public String modifyUser(String email, UserUpdateRequestDto requestDto) throws Exception {
        Users user = findUser(email);
        user.update(
                requestDto.getProfile(),
                requestDto.getNickname(),
                requestDto.getAddress(),
                requestDto.getPhone(),
                requestDto.getIntroduction()
        );
        return usersRepository.save(user).getEmail();
    }

    @Override
    public String modifyUserPassword(String email, UserPasswordUpdateRequestDto requestDto) throws Exception {
        Users users = findUser(email);
        // 입력한 비밀번호와 입력으로 들어온 새로 요청된 비밀번호가 같고
        // 변경 비밀번호와 재검증 비밀번호가 같을 때 ==> 비밀번호 변경
        if (passwordEncoder.matches(requestDto.getCurrentPassword(),
                users.getPassword()) && requestDto.getCheckNewPassword().equals(requestDto.getNewPassword())) {
            users.changePassword(passwordEncoder.encode(requestDto.getNewPassword()));
            return usersRepository.save(users).getEmail();
        }else {
            return null;
        }
    }

    @Override
    public String removeUser(String email) throws Exception {
        Users users = findUser(email);
        usersRepository.delete(users);
        return users.getEmail();
    }

    @Override
    @Transactional()
    public String loginUser(UserLoginRequestDto requestDto) {
        Users user = usersRepository.findById(requestDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 ID 입니다."));
        if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(user.getEmail());
    }

    private Users findUser(String email) {
        return usersRepository.findById(email)
                .orElseThrow(() -> new IllegalArgumentException(email + "은(는) 존재하지 않는 유저입니다."));
    }
}
