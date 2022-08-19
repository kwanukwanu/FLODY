package com.ssafy.flody.service.users.goals;

import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.UsersRepository;
import com.ssafy.flody.domain.users.goals.UGoals;
import com.ssafy.flody.domain.users.goals.UGoalsRepository;
import com.ssafy.flody.dto.request.users.UserGoalCreateRequestDto;
import com.ssafy.flody.dto.request.users.UserGoalUpdateRequestDto;
import com.ssafy.flody.dto.response.users.UserGoalResponseDto;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@SuppressWarnings("unchecked") // type unchecked error 발생하는거 안보여줌. 좋은 방법은 아님.
public class UGoalServiceImpl implements UGoalService {
    private UGoalsRepository userGoalRepository;
    private UsersRepository userRepository;

    @Transactional
    public List<UserGoalResponseDto> findUserGoals(String email) throws Exception{
        Users user = findUser(email);
        List<UGoals> entityList = (List<UGoals>) userGoalRepository.findByUser(user)
                .orElseThrow(() -> new NotFoundException("Goal Not Found"));
        List<UserGoalResponseDto> list = new ArrayList<>();
        for (UGoals uGoals : entityList) {
            list.add(new UserGoalResponseDto(uGoals));
        }
        return list;
    };

    public UserGoalResponseDto findUserGoal(Long ugNo) {
        return new UserGoalResponseDto(userGoalRepository.findById(ugNo)
                .orElseThrow(() -> new IllegalArgumentException("Goal Not Found")));
    };

    public Long addUserGoal(String email, UserGoalCreateRequestDto requestDto) {
        return userGoalRepository.save(requestDto.toEntity(findUser(email))).getUgNo();
    };

    public Long modifyUserGoal(Long ugNo, UserGoalUpdateRequestDto requestDto) {
        UGoals uGoals = userGoalRepository.findById(ugNo)
                .orElseThrow(() -> new IllegalArgumentException("Schedule Not Found"));
        uGoals.update(requestDto.getName(),
                requestDto.getRegistDate(),
                requestDto.getDueDate()
        );
        return ugNo;
    };

    public Long removeUserGoal(Long ugNo) {
        userGoalRepository.delete(userGoalRepository.findById(ugNo)
                .orElseThrow(() -> new IllegalArgumentException("Schedule Not Found")));
        return ugNo;
    };

    public Users findUser(String email) {
        return userRepository.findById(email)
                .orElseThrow(() -> new IllegalArgumentException("User Not Found"));
    }
}
