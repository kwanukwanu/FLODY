package com.ssafy.flody.service.users.follows;

import com.ssafy.flody.domain.users.Users;
import com.ssafy.flody.domain.users.UsersRepository;
import com.ssafy.flody.domain.users.follows.Follows;
import com.ssafy.flody.domain.users.follows.FollowsRepository;
import com.ssafy.flody.domain.users.schedules.USchedules;
import com.ssafy.flody.dto.request.users.UserFollowRequestDto;
import com.ssafy.flody.dto.response.users.UserFollowResponseDto;
import com.ssafy.flody.dto.response.users.UserScheduleListResponseDto;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@SuppressWarnings("unchecked") // type unchecked error 발생하는거 안보여줌. 좋은 방법은 아님.
public class UFollowServiceImpl implements UFollowService {
    private final UsersRepository usersRepository;
    private final FollowsRepository followRepository;
    public List<UserFollowResponseDto> findUserFollowings(String email) throws Exception {
        Users follower = findUser(email);
        List<Follows> entityList = followRepository.findAllByFollower(follower);
        List<UserFollowResponseDto> list = new ArrayList<>();
        for (Follows follows : entityList) {
            list.add(new UserFollowResponseDto(follows));
        }
        return list;
    }
    public Long addUserFollow(String followerEmail, String followingEmail) throws Exception {
        Users follower = findUser(followerEmail);
        Users following = findUser(followingEmail);
        return followRepository.save(new UserFollowRequestDto().toEntity(follower, following)).getFolNo();
    }

    public String removeUserFollow(String email) {
        Follows follow = followRepository.findByFollowing(findUser(email))
                .orElseThrow(() -> new IllegalArgumentException("Relation Not Found"));
        followRepository.delete(follow);
        return email;
    }

    public Users findUser(String email) {
        return usersRepository.findById(email)
                .orElseThrow(() -> new IllegalArgumentException("User Not Found"));
    }
}
