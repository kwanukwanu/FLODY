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

import java.util.*;

@Service
@RequiredArgsConstructor
@SuppressWarnings("unchecked") // type unchecked error 발생하는거 안보여줌. 좋은 방법은 아님.
public class UGoalServiceImpl implements UGoalService {
    private final UGoalsRepository userGoalRepository;
    private final UsersRepository userRepository;

    @Transactional
    public List<UserGoalResponseDto> findUserGoals(String email) throws Exception {
        Users user = findUser(email);
        List<UGoals> entityList = userGoalRepository.findAllByUser(user);
        List<UserGoalResponseDto> list = new ArrayList<>();
        for (UGoals uGoals : entityList) {
            list.add(new UserGoalResponseDto(uGoals));
        }
        return list;
    };

    public List<UserGoalResponseDto> findUserDayGoals(String email, Date date) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        cal.setTime(date);
        cal.add(Calendar.DATE, -1);
        Date dueDate = cal.getTime();
        List<UGoals> entityList = userGoalRepository.findAllByUserAndDueDateAfter(findUser(email), dueDate);
        List<UserGoalResponseDto> list = new ArrayList<>();
        for (UGoals goal : entityList) {
            list.add(new UserGoalResponseDto(goal));
        }
        return list;
    }

    public List<UserGoalResponseDto> findUserMonthGoals(String email, Date date) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        cal.setTime(date);
        cal.add(Calendar.DATE, -1);
        Date dueDate = cal.getTime();
        List<UGoals> entityList = userGoalRepository.findAllByUserAndDueDateAfter(findUser(email), dueDate);
        List<UserGoalResponseDto> list = new ArrayList<>();
        for (UGoals goal : entityList) {
            list.add(new UserGoalResponseDto(goal));
        }
        return list;
    }

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
                requestDto.getDueDate()
        );
        return userGoalRepository.save(uGoals).getUgNo();
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
