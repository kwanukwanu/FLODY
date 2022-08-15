package com.ssafy.flody.controller;

import com.ssafy.flody.domain.groups.Groups;
import com.ssafy.flody.dto.request.posts.PostCreateRequestDto;
import com.ssafy.flody.dto.request.comments.CommentCreateRequestDto;
import com.ssafy.flody.dto.request.comments.CommentUpdateRequestDto;
import com.ssafy.flody.dto.request.groups.*;
import com.ssafy.flody.dto.request.posts.PostUpdateRequestDto;
import com.ssafy.flody.dto.request.users.*;
import com.ssafy.flody.dto.response.groups.GroupDetailResponseDto;
import com.ssafy.flody.dto.response.groups.GroupMemberDetailResponseDto;
import com.ssafy.flody.dto.response.groups.MyGroupMemberListResponseDto;
import com.ssafy.flody.dto.response.posts.PostDetailResponseDto;
import com.ssafy.flody.dto.response.users.UserFollowResponseDto;
import com.ssafy.flody.dto.response.users.UserGoalResponseDto;
import com.ssafy.flody.dto.response.users.UserScheduleListResponseDto;
import com.ssafy.flody.service.JWTService;
import com.ssafy.flody.service.groups.GroupService;
import com.ssafy.flody.service.groups.members.GroupMemberService;
import com.ssafy.flody.service.posts.PostService;
import com.ssafy.flody.service.users.UserService;
import com.ssafy.flody.service.users.follows.UFollowService;
import com.ssafy.flody.service.users.goals.UGoalService;
import com.ssafy.flody.service.users.schedules.UScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080/**")
public class ApiController {
    private static final String SUCCESS = "SUCCESS";
    private static final String FAIL = "FAIL";
    private static final String ERROR = "ERROR";
    private final String HEADER_AUTH = "token";

    private final JWTService jwtService;
    private final UserService userService;
    private final UFollowService uFollowService;
    private final UScheduleService uScheduleService;
    private final UGoalService uGoalService;
    private final GroupService groupService;
    private final GroupMemberService groupMemberService;
    private final PostService postService;

    // USER
    @GetMapping("/users")
    public ResponseEntity<Map<String, Object>> UserList() {
        return getResponseEntity(userService.findUsers());
    }

    // 유저 단일 조회
    @GetMapping("/user")
    public ResponseEntity<Map<String, Object>> UserDetails(@RequestParam String email) {
        return getResponseEntity(userService.findUserById(email));
    }

    @GetMapping("/user/checkEmail")
    public ResponseEntity<Map<String, Object>> UserEmailCheck(@RequestParam String email) {
        //Email 중복 체크
        HashMap<String, Object> result = new HashMap<>();
        if (userService.validateEmail(email)) {
            result.put("msg", FAIL);
        } else {
            result.put("msg", SUCCESS);
        }
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }

    //회원 가입
    @PostMapping("/user")
    public ResponseEntity<Map<String, Object>> UserAdd(@RequestBody UserCreateRequestDto requestDto) {
        return getResponseEntity(userService.addUser(requestDto));
    }

    //회원 정보 수정
    @PutMapping("/user")
    public ResponseEntity<Map<String, Object>> UserModify(@RequestHeader(value = HEADER_AUTH) String token, @RequestBody UserUpdateRequestDto requestDto) throws Exception {
        return getResponseEntity(userService.modifyUser(jwtService.decodeToken(token), requestDto));
    }

    //회원 비밀번호 수정
    @PutMapping("/user/password")
    public ResponseEntity<Map<String, Object>> UserModify(@RequestHeader(value = HEADER_AUTH) String token, @RequestBody UserPasswordUpdateRequestDto requestDto) throws Exception{
        return getResponseEntity(userService.modifyUserPassword(jwtService.decodeToken(token), requestDto));
    }

    //회원 탈퇴
    @DeleteMapping("/user") // 회원탈퇴도 내 계정만 탈퇴 가능
    public ResponseEntity<Map<String, Object>> UserRemove(@RequestHeader(value = HEADER_AUTH) String token) throws Exception {
        return getResponseEntity(userService.removeUser(jwtService.decodeToken(token)));
    }

    //로그인
    @PostMapping("/user/login")
    public ResponseEntity<Map<String, Object>> UserLogin(@RequestBody UserLoginRequestDto requestDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("token", userService.loginUser(requestDto));
            result.put("msg", SUCCESS);
        } catch (Exception e) {
            result.put("msg", FAIL);
        }
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }

    @GetMapping("/user/follows")
    public ResponseEntity<Map<String, Object>> UserFollowList(@RequestHeader(value = HEADER_AUTH) String token) throws Exception {
        return getResponseEntity(uFollowService.findUserFollows(jwtService.decodeToken(token)));
    }

    @GetMapping("/user/follow")
    public ResponseEntity<Map<String, Object>> UserFollow(@RequestHeader(value = HEADER_AUTH) String token, @RequestParam String following) throws Exception {
        return getResponseEntity(uFollowService.addUserFollow(jwtService.decodeToken(token), following));
    }

    @GetMapping("/user/unfollow")
    public ResponseEntity<Map<String, Object>> UserUnfollow(@RequestParam Long folNo) {
        return getResponseEntity(uFollowService.removeUserFollow(folNo));
    }

    @GetMapping("/user/likes")
    public ResponseEntity<Map<String, Object>> UserLikeList(@RequestParam Long id) {
        return getMapResponseEntity(id);
    }

    @GetMapping("/user/scraps")
    public ResponseEntity<Map<String, Object>> UserScrapList(@RequestParam Long id) {
        return getMapResponseEntity(id);
    }

    @GetMapping("/user/schedules") // 내 스케줄만 궁금하잖아
    public ResponseEntity<Map<String, Object>> UserScheduleList(@RequestHeader(value = HEADER_AUTH) String token) throws Exception {
        return getResponseEntity(uScheduleService.findUserSchedules(jwtService.decodeToken(token)));
    }

    @GetMapping("/user/schedule") // 내 스케줄 하나, 근데 스케줄 Id가 어차피 주어짐
    public ResponseEntity<Map<String, Object>> UserScheduleDetails(@RequestParam Long usNo) {
        return getResponseEntity(uScheduleService.findUserSchedule(usNo));
    }

    @PostMapping("/user/schedule")
    public ResponseEntity<Map<String, Object>> UserScheduleAdd(@RequestHeader(value = HEADER_AUTH) String token, @RequestBody UserScheduleCreateRequestDto requestDto) throws Exception {
        return getResponseEntity(uScheduleService.addUserSchedule(jwtService.decodeToken(token), requestDto));
    }

    @PutMapping("/user/schedule")
    public ResponseEntity<Map<String, Object>> UserScheduleModify(@RequestParam Long usNo, @RequestBody UserScheduleUpdateRequestDto requestDto) {
        return getResponseEntity(uScheduleService.modifyUserSchedule(usNo, requestDto));
    }

    @DeleteMapping("/user/schedule")
    public ResponseEntity<Map<String, Object>> UserScheduleRemove(@RequestParam Long usNo) {
        return getResponseEntity(uScheduleService.removeUserSchedule(usNo));
    }

    @GetMapping("/user/goals") // 내 목표 목록
    public ResponseEntity<Map<String, Object>> UserGoalList(@RequestHeader(value = HEADER_AUTH) String token) throws Exception {
        return getResponseEntity(uGoalService.findUserGoals(jwtService.decodeToken(token)));
    }

    @GetMapping("/user/goal")
    public ResponseEntity<Map<String, Object>> UserGoalDetails(@RequestParam Long ugNo) {
        return getResponseEntity(uGoalService.findUserGoal(ugNo));
    }

    @PostMapping("/user/goal")
    public ResponseEntity<Map<String, Object>> UserGoalAdd(@RequestHeader(value = HEADER_AUTH) String token, @RequestBody UserGoalCreateRequestDto requestDto) throws Exception {
        return getResponseEntity(uGoalService.addUserGoal(jwtService.decodeToken(token), requestDto));
    }

    @PutMapping("/user/goal")
    public ResponseEntity<Map<String, Object>> UserGoalModify(@RequestParam Long ugNo, @RequestBody UserGoalUpdateRequestDto requestDto) {
        return getResponseEntity(uGoalService.modifyUserGoal(ugNo, requestDto));
    }

    @DeleteMapping("/user/goal")
    public ResponseEntity<Map<String, Object>> UserGoalRemove(@RequestParam Long ugNo) {
        return getResponseEntity(uGoalService.removeUserGoal(ugNo));
    }

    // GROUP
    @GetMapping("/groups")
    public ResponseEntity<Map<String, Object>> GroupList() {
        return getResponseEntity(groupService.findGroups());
    }

    @GetMapping("/group")
    public ResponseEntity<Map<String, Object>> GroupDetails(@RequestParam Long groNo) {
        return getResponseEntity(groupService.findGroupById(groNo));
    }

    @PostMapping("/group")
    public ResponseEntity<Map<String, Object>> GroupAdd(@RequestHeader(value = HEADER_AUTH) String token, @RequestBody GroupCreateRequestDto requestDto) {
        HashMap<String, Object> result = new HashMap<>();
        HttpStatus status;
        try {
            String email = jwtService.decodeToken(token);
            Long groNo = groupService.addGroup(requestDto);
            groupMemberService.addMember(email, new GroupMemberCreateRequestDto(email, groNo, "OWNER"));
            result.put("msg", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result.put("error", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    @PutMapping("/group")
    public ResponseEntity<Map<String, Object>> GroupModify(@RequestHeader(value = HEADER_AUTH) String token, @RequestBody GroupUpdateRequestDto requestDto) {
        HashMap<String, Object> result = new HashMap<>();
        HttpStatus status;
        try {
            String email = jwtService.decodeToken(token);
            if (groupMemberService.isValid(email, requestDto.getGroNo())) {
                groupService.modifyGroup(requestDto);
                result.put("msg", SUCCESS);
            } else {
                result.put("msg", FAIL);
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result.put("msg", FAIL);
            result.put("item", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    @DeleteMapping("/group")
    public ResponseEntity<Map<String, Object>> GroupRemove(@RequestHeader(value = HEADER_AUTH) String token, @RequestParam Long groNo) {
        HashMap<String, Object> result = new HashMap<>();
        HttpStatus status;
        try {
            String email = jwtService.decodeToken(token);
            if (groupMemberService.isValid(email, groNo)) {
                groupMemberService.removeAllMembers(groNo);
                groupService.removeGroup(groNo);
                result.put("msg", SUCCESS);
            } else {
                result.put("msg", FAIL);
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result.put("msg", FAIL);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    @GetMapping("/group/mygroups")
    public ResponseEntity<Map<String, Object>> MyGroupAndMemberList(@RequestHeader(value = HEADER_AUTH) String token) {
        Map<String, Object> result = new HashMap<>();
        HttpStatus status;
        try {
            String email = jwtService.decodeToken(token);
            List<Groups> myGroups = groupService.findMyGroups(email);
            List<MyGroupMemberListResponseDto> list = groupMemberService.findMyGroupMembers(myGroups);
            result.put("item", list);
            result.put("msg", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result.put("msg", ERROR);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    @GetMapping("/group/search")
    public ResponseEntity<Map<String, Object>> GroupSearchList(@RequestParam String keyword) throws Exception {
        return getResponseEntity(groupService.findGroupsByName(keyword));
    }

    // Get GroupMembers
    @GetMapping("/group/members")
    public ResponseEntity<Map<String, Object>> GroupMemberList(@RequestParam Long groNo) {
        return getResponseEntity(groupMemberService.findMembers(groNo));
    }

    // Get GroupMember
    @GetMapping("/group/member")
    public ResponseEntity<Map<String, Object>> GroupMemberDetails(@RequestParam Long gmNo) {
        return getResponseEntity(groupMemberService.findMember(gmNo));
        // 아마도 gmNo > groNo & email로 바꿀듯?
    }

    // Post GroupMember
    @PostMapping("/group/member")
    public ResponseEntity<Map<String, Object>> GroupMemberAdd(@RequestHeader(value = HEADER_AUTH) String token, @RequestBody GroupMemberCreateRequestDto requestDto) throws Exception {
        return getResponseEntity(groupMemberService.addMember(jwtService.decodeToken(token), requestDto));
    }

    // Modify GroupMember
    @PutMapping("/group/member")
    public ResponseEntity<Map<String, Object>> GroupMemberModify(@RequestHeader(value = HEADER_AUTH) String token, @RequestBody GroupMemberUpdateRequestDto requestDto) throws Exception {
        return getResponseEntity(groupMemberService.modifyMember(jwtService.decodeToken(token), requestDto));
        // 이것도 차라리 gmNo > groNo & email로 바꾸는게 어떨까
    }

    // Delete GroupMember
    @DeleteMapping("/group/member")
    public ResponseEntity<Map<String, Object>> GroupMemberRemove(@RequestHeader(value = HEADER_AUTH) String token, @RequestParam Long gmNo) throws Exception {
        return getResponseEntity(groupMemberService.removeMember(jwtService.decodeToken(token), gmNo));
    }

    @GetMapping("/group/schedules")
    public ResponseEntity<Map<String, Object>> GroupScheduleList(@RequestParam Long id) {
        // header에서 token을 추출해 id값을 지정하는 방식으로 변경 예정
        return getMapResponseEntity(id);
    }

    @GetMapping("/group/schedule")
    public ResponseEntity<Map<String, Object>> GroupScheduleDetails(@RequestParam Long id) {
        return getMapResponseEntity(id);
    }

    @PostMapping("/group/schedule")
    public ResponseEntity<String> GroupScheduleAdd(@RequestBody GroupScheduleCreateRequestDto requestDto) {
        return getStringResponseEntity(requestDto);
    }

    @PutMapping("/group/schedule")
    public ResponseEntity<String> GroupScheduleModify(@RequestBody GroupScheduleUpdateRequestDto requestDto) {
        return getStringResponseEntity(requestDto);
    }

    @DeleteMapping("/group/schedule")
    public ResponseEntity<String> GroupScheduleRemove(@RequestParam Long id) {
        return getStringResponseEntity(id);
    }

    @GetMapping("/group/goals")
    public ResponseEntity<Map<String, Object>> GroupGoalList(@RequestParam Long id) {
        // header에서 token을 추출해 id값을 지정하는 방식으로 변경 예정
        return getMapResponseEntity(id);
    }

    @GetMapping("/group/goal")
    public ResponseEntity<Map<String, Object>> GroupGoalDetails(@RequestParam Long id) {
        return getMapResponseEntity(id);
    }

    @PostMapping("/group/goal")
    public ResponseEntity<String> GroupGoalAdd(@RequestBody GroupGoalCreateRequestDto requestDto) {
        return getStringResponseEntity(requestDto);
    }

//    GroupGoalUpdateRequestDto 추가 필요
//    @PutMapping("/group/goal")
//    public ResponseEntity<String> GroupGoalModify(@RequestBody GroupGoalUpateRequestDto requestDto) {
//        return getStringResponseEntity(requestDto);
//    }

    @DeleteMapping("/group/goal")
    public ResponseEntity<String> GroupGoalRemove(@RequestParam Long id) {
        return getStringResponseEntity(id);
    }

    // Board
    @GetMapping("/posts")
    public ResponseEntity<Map<String, Object>> PostList(@RequestParam String category) {
        return getResponseEntity(postService.findPosts(category));
    }

    @GetMapping("/post")
    public ResponseEntity<Map<String, Object>> PostDetails(@RequestParam Long posNo) {
        return getResponseEntity(postService.findPostById(posNo));
    }

    @PostMapping("/post")
    public ResponseEntity<Map<String, Object>> PostAdd(@RequestHeader(value = HEADER_AUTH) String token, @RequestBody PostCreateRequestDto requestDto) throws Exception {
        return getResponseEntity(postService.addPost(jwtService.decodeToken(token), requestDto));
    }

    @PutMapping("/post")
    public ResponseEntity<Map<String, Object>> PostModify(@RequestBody PostUpdateRequestDto requestDto) {
        return getResponseEntity(postService.modifyPost(requestDto));
    }

    @DeleteMapping("/post")
    public ResponseEntity<Map<String, Object>> PostRemove(@RequestParam Long posNo) {
        return getResponseEntity(postService.removePost(posNo));
    }

    @GetMapping("/post/like")
    public ResponseEntity<String> PostLike(@RequestParam Long id) {
        return getStringResponseEntity(id);
    }

    @GetMapping("/post/scrap")
    public ResponseEntity<String> PostScrap(@RequestParam Long id) {
        return getStringResponseEntity(id);
    }

    @GetMapping("/post/report")
    public ResponseEntity<String> PostReport(@RequestParam Long id) {
        return getStringResponseEntity(id);
    }

    @GetMapping("/comments")
    public ResponseEntity<Map<String, Object>> CommentList(@RequestParam Long posNo) {
        return getResponseEntity();
    }

    // COMMENT
    @GetMapping("/comment")
    public ResponseEntity<Map<String, Object>> CommentDetails(@RequestParam Long id) {
        return getMapResponseEntity(id);
    }

    @PostMapping("/comment")
    public ResponseEntity<String> CommentAdd(@RequestBody CommentCreateRequestDto requestDto) {
        return getStringResponseEntity(requestDto);
    }

    @PutMapping("/comment")
    public ResponseEntity<String> CommentModify(@RequestBody CommentUpdateRequestDto requestDto) {
        return getStringResponseEntity(requestDto);
    }

    @DeleteMapping("/comment")
    public ResponseEntity<String> CommentRemove(@RequestParam Long id) {
        return getStringResponseEntity(id);
    }

    @GetMapping("/comment/like")
    public ResponseEntity<String> CommentLike(@RequestParam Long id) {
        return getStringResponseEntity(id);
    }

    // DIRECT MESSAGE
    @GetMapping("/direct-messages")
    public ResponseEntity<Map<String, Object>> DMessageList(@RequestParam Long id) {
        // header에서 token을 추출해 id값을 지정하는 방식으로 변경 예정
        return getMapResponseEntity(id);
    }

    @GetMapping("/direct-message")
    public ResponseEntity<Map<String, Object>> DMessageDetails(@RequestParam Long id) {
        return getMapResponseEntity(id);
    }

//    DMessage 관련 Dto 추가 생성 필요
//    @PostMapping("/direct-message")
//    public ResponseEntity<String> DMessageAdd(@RequestBody DMessageCreateRequestDto requestDto) {
//        return getStringResponseEntity(requestDto);
//    }

//    @PutMapping("/direct-message")
//    public ResponseEntity<String> DMessageModify(@RequestBody DMessageUpdateRequestDto requestDto) {
//        return getStringResponseEntity(requestDto);
//    }

    @DeleteMapping("/direct-message")
    public ResponseEntity<String> DMessageRemove(@RequestParam Long id) {
        return getStringResponseEntity(id);
    }

    // FLOWER
    @GetMapping("/flowers")
    public ResponseEntity<Map<String, Object>> FlowerList(@RequestParam Long id) {
        // header에서 token을 추출해 id값을 지정하는 방식으로 변경 예정
        return getMapResponseEntity(id);
    }

    @GetMapping("/flower")
    public ResponseEntity<Map<String, Object>> FlowerDetails(@RequestParam Long id) {
        return getMapResponseEntity(id);
    }

//    Flower 관련 Dto 추가 생성 필요
//    @PostMapping("/flower")
//    public ResponseEntity<String> FlowerAdd(@RequestBody FlowerCreateRequestDto requestDto) {
//        return getStringResponseEntity(requestDto);
//    }

//    @PutMapping("/flower")
//    public ResponseEntity<String> FlowerModify(@RequestBody FlowerUpdateRequestDto requestDto) {
//        return getStringResponseEntity(requestDto);
//    }

    @DeleteMapping("/flower")
    public ResponseEntity<String> FlowerRemove(@RequestParam Long id) {
        return getStringResponseEntity(id);
    }

    // LICENSE
    @GetMapping("/licenses")
    public ResponseEntity<Map<String, Object>> LicenseList(@RequestParam Long id) {
        // header에서 token을 추출해 id값을 지정하는 방식으로 변경 예정
        // 여기에 filter 처리를 위한 parameter도 추가 예정
        return getMapResponseEntity(id);
    }

    @GetMapping("/license")
    public ResponseEntity<Map<String, Object>> LicenseDetails(@RequestParam Long id) {
        return getMapResponseEntity(id);
    }

//    License 관련 Dto 추가 생성 필요
//    @PostMapping("/license")
//    public ResponseEntity<String> LicenseAdd(@RequestBody LicenseCreateRequestDto requestDto) {
//        return getStringResponseEntity(requestDto);
//    }

//    @PutMapping("/license")
//    public ResponseEntity<String> LicenseModify(@RequestBody LicenseUpdateRequestDto requestDto) {
//        return getStringResponseEntity(requestDto);
//    }

    @DeleteMapping("/license")
    public ResponseEntity<String> LicenseRemove(@RequestParam Long id) {
        return getStringResponseEntity(id);
    }


    // COMMON METHODS
    public ResponseEntity<Map<String, Object>> getResponseEntity(Object obj) {
        Map<String, Object> result = new HashMap<>();
        HttpStatus status;
        try {
            result.put("item", obj);
            result.put("msg", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result.put("item", e.getMessage());
            result.put("msg", FAIL);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    public ResponseEntity<Map<String, Object>> getMapResponseEntity(Object obj) {
        Map<String, Object> result = new HashMap<>();
        HttpStatus status;

        try {
            if ("test".equals(obj) || obj.equals(1L)) {
                result.put("item", obj);
                result.put("msg", SUCCESS);
            } else {
                result.put("item", obj);
                result.put("msg", FAIL);
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result.put("item", obj);
            result.put("msg", ERROR);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(result, status);
    }

    public ResponseEntity<String> getStringResponseEntity(Object obj) {
        String result;
        HttpStatus status;

        try {
            result = obj.toString();
            if ("test".equals(obj) || obj.equals(1L)) {
//                result = SUCCESS;
            } else {
//                result = FAIL;
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result = ERROR;
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(result, status);
    }
}
