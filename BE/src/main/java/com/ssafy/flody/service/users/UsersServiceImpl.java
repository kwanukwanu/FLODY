package com.ssafy.flody.service.users;

import com.ssafy.flody.config.JwtTokenProvider;
import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.UsersRepository;
import com.ssafy.flody.dto.request.Users.UserCreateRequestDto;
import com.ssafy.flody.dto.request.Users.UserLoginRequestDto;
import com.ssafy.flody.dto.request.Users.UserPasswordUpdateRequestDto;
import com.ssafy.flody.dto.request.Users.UserUpdateRequestDto;
import com.ssafy.flody.dto.response.Users.UserInfoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService{
    private final UsersRepository usersRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
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
    public UserInfoResponseDto findUser(Long id){
        Users entity = usersRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("해당 유저가 없습니다. id = " + id));

        return new UserInfoResponseDto(entity);
    }

    @Override
    public Boolean findUserEmail(String email){
        if (!usersRepository.findById(email).isPresent()){
            return true;
        }else{
            return false;
        }
    }
    @Override
    @Transactional()
    public Long addUser(UserCreateRequestDto requestDto) {
        String pw = passwordEncoder.encode(requestDto.getPassword());
        requestDto.setPassword(pw);
        return usersRepository.save(requestDto.toEntity()).getUseNo();
    }

    @Override
    public UserDetails loadUserByUserid(String id) throws UsernameNotFoundException {
        return (UserDetails) usersRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }

    @Override
    @Transactional()
    public String loginUser(UserLoginRequestDto requestDto) {
        Users member = usersRepository.findById(requestDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 ID 입니다."));
        if (!passwordEncoder.matches(requestDto.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getId());
    }

    @Override
    public Users modifyUser(String token, UserUpdateRequestDto requestDto) throws Exception {
        String UserEmail = jwtTokenProvider.decodeToken(token);
        Users users = usersRepository.findById(UserEmail)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. email = " + UserEmail));

        users.update(
                requestDto.getProfile(),
                requestDto.getNickname(),
                requestDto.getAddress(),
                requestDto.getPhone()
        );
        usersRepository.save(users);
        return users;
    }

    @Override
    public Users modifyUserPassword(String token, UserPasswordUpdateRequestDto requestDto) throws Exception {
        String UserEmail = jwtTokenProvider.decodeToken(token);
        Users users = usersRepository.findById(UserEmail)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. email = " + UserEmail));
        // 입력한 비밀번호와 입력으로 들어온 새로 요청된 비밀번호가 같고
        // 변경 비밀번호와 재검증 비밀번호가 같을 때 ==> 비밀번호 변경
        if (passwordEncoder.matches(requestDto.getCurrentPassword(), users.getPassword()) && requestDto.getCheckNewPassword().equals(requestDto.getNewPassword()))
        {
            users.changePassword(passwordEncoder.encode(requestDto.getNewPassword()));
            usersRepository.save(users);
            return users;
        }else {
            return null;
        }
    }

    @Override
    public String removeUser(String token) throws Exception {
        String UserEmail = jwtTokenProvider.decodeToken(token);
        Users users = usersRepository.findById(UserEmail)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다. email = " + UserEmail));

        usersRepository.delete(users);
        return users.getId();
    }
}
