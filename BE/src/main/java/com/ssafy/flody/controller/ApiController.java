package com.ssafy.flody.controller;

import com.ssafy.flody.domain.groups.Groups;
import com.ssafy.flody.dto.request.posts.PostCreateRequestDto;
import com.ssafy.flody.dto.request.comments.CommentCreateRequestDto;
import com.ssafy.flody.dto.request.comments.CommentUpdateRequestDto;
import com.ssafy.flody.dto.request.groups.*;
import com.ssafy.flody.dto.request.posts.PostReportRequestDto;
import com.ssafy.flody.dto.request.posts.PostUpdateRequestDto;
import com.ssafy.flody.dto.request.users.*;
import com.ssafy.flody.dto.response.groups.MyGroupMemberListResponseDto;
import com.ssafy.flody.service.JWTService;
import com.ssafy.flody.service.comments.CommentService;
import com.ssafy.flody.service.flowers.FlowerService;
import com.ssafy.flody.service.groups.GroupService;
import com.ssafy.flody.service.groups.goals.GroupGoalService;
import com.ssafy.flody.service.groups.members.GroupMemberService;
import com.ssafy.flody.service.groups.schedules.GroupScheduleService;
import com.ssafy.flody.service.posts.PostService;
import com.ssafy.flody.service.posts.like.CLikeService;
import com.ssafy.flody.service.posts.like.PLikeService;
import com.ssafy.flody.service.posts.report.PReportService;
import com.ssafy.flody.service.posts.scrap.PScrapService;
import com.ssafy.flody.service.users.UserService;
import com.ssafy.flody.service.users.follows.UFollowService;
import com.ssafy.flody.service.users.goals.UGoalService;
import com.ssafy.flody.service.users.schedules.UScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    private final CommentService commentService;
    private final GroupGoalService groupGoalService;

    private final GroupScheduleService groupScheduleService;

    private final PLikeService postLikeService;
    private final PReportService postReportService;
    private final PScrapService postScrapService;
    private final FlowerService flowerService;

    private final CLikeService commentLikeService;
    // USER
    @GetMapping("/users")
    public ResponseEntity<Map<String, Object>> UserList() {
        return getResponseEntity(userService.findUsers());
    }

    // 유저 단일 조회
    @GetMapping("/user")
    public ResponseEntity<Map<String, Object>> UserDetails(@RequestParam String email) throws Exception {
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

    @GetMapping("/user/followers")
    public ResponseEntity<Map<String, Object>> UserFollowerList(@RequestHeader(value = HEADER_AUTH) String token) throws Exception {
        return getResponseEntity(uFollowService.findUserFollowers(jwtService.decodeToken(token)));
    }

    @GetMapping("/user/followings")
    public ResponseEntity<Map<String, Object>> UserFollowingList(@RequestHeader(value = HEADER_AUTH) String token) throws Exception {
        return getResponseEntity(uFollowService.findUserFollowings(jwtService.decodeToken(token)));
    }

    @GetMapping("/user/follow")
    public ResponseEntity<Map<String, Object>> UserFollow(@RequestHeader(value = HEADER_AUTH) String token, @RequestParam String following) throws Exception {
        return getResponseEntity(uFollowService.addUserFollow(jwtService.decodeToken(token), following));
    }

    @GetMapping("/user/unfollow")
    public ResponseEntity<Map<String, Object>> UserUnfollow(@RequestParam String email) {
        return getResponseEntity(uFollowService.removeUserFollow(email));
    }

    @GetMapping("/user/likes")
    public ResponseEntity<Map<String, Object>> UserLikeList(@RequestHeader(value = HEADER_AUTH) String token) throws Exception {
        return getResponseEntity(userService.findPostLikes(jwtService.decodeToken(token)));
    }

    @GetMapping("/user/scraps")
    public ResponseEntity<Map<String, Object>> UserScrapList(@RequestHeader(value = HEADER_AUTH) String token) throws Exception {
        return getResponseEntity(userService.findPostScraps(jwtService.decodeToken(token)));
    }

    @GetMapping("/user/schedules") // 내 스케줄만 궁금하잖아
    public ResponseEntity<Map<String, Object>> UserScheduleList(@RequestHeader(value = HEADER_AUTH) String token) throws Exception {
        return getResponseEntity(uScheduleService.findUserSchedules(jwtService.decodeToken(token)));
    }

    @GetMapping("/user/dayschedules")
    public ResponseEntity<Map<String, Object>> UserDayScheduleList(@RequestHeader(value = HEADER_AUTH) String token, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) throws Exception {
        return getResponseEntity(uScheduleService.findUserDaySchedules(jwtService.decodeToken(token), date));
    }

    @GetMapping("/user/monthschedules")
    public ResponseEntity<Map<String, Object>> UserMonthScheduleList(@RequestHeader(value = HEADER_AUTH) String token, @RequestParam @DateTimeFormat(pattern = "yyyy-MM") Date date) throws Exception {
        return getResponseEntity(uScheduleService.findUserMonthSchedules(jwtService.decodeToken(token), date));
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

    @GetMapping("/user/daygoals")
    public ResponseEntity<Map<String, Object>> UserDayGoalList(@RequestHeader(value = HEADER_AUTH) String token, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) throws Exception {
        return getResponseEntity(uGoalService.findUserDayGoals(jwtService.decodeToken(token), date));
    }

    @GetMapping("/user/monthgoals")
    public ResponseEntity<Map<String, Object>> UserMonthGoalList(@RequestHeader(value = HEADER_AUTH) String token, @RequestParam @DateTimeFormat(pattern = "yyyy-MM") Date date) throws Exception {
        return getResponseEntity(uGoalService.findUserMonthGoals(jwtService.decodeToken(token), date));
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
    public ResponseEntity<Map<String, Object>> GroupScheduleList(@RequestParam Long groNo) throws Exception {
        // header에서 token을 추출해 id값을 지정하는 방식으로 변경 예정
        return getResponseEntity(groupScheduleService.findAllGroupSchedules(groNo));
    }

    @GetMapping("/group/dayschedules")
    public ResponseEntity<Map<String, Object>> GroupDayGoalList (@RequestParam Long groNo, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) throws Exception {
        return getResponseEntity(groupScheduleService.findGroupDaySchedules(groNo,date));
    }

    @GetMapping("/group/monthchedules")
    public ResponseEntity<Map<String, Object>> GroupMonthGoalList(@RequestParam Long groNo, @RequestParam @DateTimeFormat(pattern = "yyyy-MM") Date date) throws Exception {
        return getResponseEntity(groupScheduleService.findGroupMonthSchedules(groNo, date));
    }

    @GetMapping("/group/schedule")
    public ResponseEntity<Map<String, Object>> GroupScheduleDetails(@RequestParam Long gsNo) {
        return getResponseEntity(groupScheduleService.findGroupSchedule(gsNo));
    }

    @PostMapping("/group/schedule")
    public ResponseEntity<Map<String, Object>> GroupScheduleAdd(@RequestParam Long groNo, @RequestBody GroupScheduleCreateRequestDto requestDto) throws Exception {
        return getResponseEntity(groupScheduleService.addGroupSchedule(groNo, requestDto));
    }

    @PutMapping("/group/schedule")
    public ResponseEntity<Map<String, Object>> GroupScheduleModify(@RequestParam Long gsNo, @RequestBody GroupScheduleUpdateRequestDto requestDto) throws Exception {
        return getResponseEntity(groupScheduleService.modifyGroupSchedule(gsNo, requestDto));
    }

    @DeleteMapping("/group/schedule")
    public ResponseEntity<Map<String, Object>> GroupScheduleRemove(@RequestParam Long gsNo) {
        return getResponseEntity(groupScheduleService.removeGroupSchedule(gsNo));
    }

    @GetMapping("/group/goals")
    public ResponseEntity<Map<String, Object>> GroupGoalList(@RequestParam Long groNo) {
        // header에서 token을 추출해 id값을 지정하는 방식으로 변경 예정
        return getResponseEntity(groupGoalService.findAllGroupGoals(groNo));
    }

    @GetMapping("/group/goal")
    public ResponseEntity<Map<String, Object>> GroupGoalDetails(@RequestParam Long ggNo) {
        return getResponseEntity(groupGoalService.findGroupGoal(ggNo));
    }

    @PostMapping("/group/goal")
    public ResponseEntity<Map<String, Object>> GroupGoalAdd(@RequestParam Long groNo, @RequestHeader(value = HEADER_AUTH) String token, @RequestBody GroupGoalCreateRequestDto requestDto) throws Exception{
        return getResponseEntity(groupGoalService.addGroupGoal(groNo, jwtService.decodeToken(token), requestDto));
    }

//    GroupGoalUpdateRequestDto 추가 필요
    @PutMapping("/group/goal")
    public ResponseEntity<Map<String, Object>> GroupGoalModify(@RequestParam Long ggNo, @RequestBody GroupGoalUpdateRequestDto requestDto) throws Exception {
        return getResponseEntity(groupGoalService.modifyGroupGoal(ggNo, requestDto));
    }

    @DeleteMapping("/group/goal")
    public ResponseEntity<Map<String, Object>> GroupGoalRemove(@RequestParam Long ggNo) {
        return getResponseEntity(groupGoalService.removeGroupGoal(ggNo));
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
    public ResponseEntity<Map<String, Object>> PostLikeAdd(@RequestHeader(value = HEADER_AUTH) String token, @RequestParam Long posNo ) throws Exception {
        return getResponseEntity(postLikeService.addPostLike(jwtService.decodeToken(token), posNo ));
    }
    @DeleteMapping("/post/like")
    public ResponseEntity<Map<String, Object>> PoseLikeRemove(@RequestHeader(value = HEADER_AUTH) String token, @RequestParam Long posNo ) throws Exception {
        return getResponseEntity(postLikeService.removePostLike(jwtService.decodeToken(token), posNo ));
    }

    @GetMapping("/post/scrap")
    public ResponseEntity<Map<String, Object>> PostScrapAdd(@RequestHeader(value = HEADER_AUTH) String token, @RequestParam Long posNo) throws Exception {
        return getResponseEntity(postScrapService.addPostScrap(jwtService.decodeToken(token), posNo ));
    }

    @DeleteMapping("/post/scrap")
    public ResponseEntity<Map<String, Object>> PostScrapRemove(@RequestHeader(value = HEADER_AUTH) String token, @RequestParam Long posNo) throws Exception {
        return getResponseEntity(postScrapService.removePostScrap(jwtService.decodeToken(token), posNo ));
    }

    @PostMapping("/post/report")
    public ResponseEntity<Map<String, Object>> PostReport(@RequestHeader(value = HEADER_AUTH) String token, @RequestParam Long posNo, PostReportRequestDto requestDto) throws Exception{
        return getResponseEntity(postReportService.addPostReport(jwtService.decodeToken(token),posNo, requestDto));
    }

    // COMMENT
    @GetMapping("/comments")
    public ResponseEntity<Map<String, Object>> CommentList(@RequestParam Long posNo) {
        return getResponseEntity(commentService.findComments(posNo));
    }

    // 댓글은 단일조회할 일이 없다는 판단
//    @GetMapping("/comment")
//    public ResponseEntity<Map<String, Object>> CommentDetails(@RequestParam Long id) {
//        return getMapResponseEntity(id);
//    }

    @PostMapping("/comment")
    public ResponseEntity<Map<String, Object>> CommentAdd(@RequestHeader(value = HEADER_AUTH) String token, @RequestBody CommentCreateRequestDto requestDto) throws Exception {
        return getResponseEntity(commentService.addComment(jwtService.decodeToken(token), requestDto));
    }

    @PutMapping("/comment")
    public ResponseEntity<Map<String, Object>> CommentModify(@RequestBody CommentUpdateRequestDto requestDto) {
        return getResponseEntity(commentService.modifyComment(requestDto));
    }

    @DeleteMapping("/comment")
    public ResponseEntity<Map<String, Object>> CommentRemove(@RequestParam Long comNo) {
        return getResponseEntity(commentService.removeComment(comNo));
    }

    @GetMapping("/comment/like")
    public ResponseEntity<Map<String, Object>> CommentLikeAdd(@RequestHeader(value = HEADER_AUTH) String token, @RequestParam Long comNo) throws Exception {
        return getResponseEntity(commentLikeService.addCommentLike(jwtService.decodeToken(token), comNo ));
    }

    @DeleteMapping("/comment/like")
    public ResponseEntity<Map<String, Object>> CommentLikeRemove(@RequestHeader(value = HEADER_AUTH) String token, @RequestParam Long comNo) throws Exception {
        return getResponseEntity(commentLikeService.removeCommentLike(jwtService.decodeToken(token), comNo ));
    }

    // DIRECT MESSAGE
//    @GetMapping("/direct-messages")
//    public ResponseEntity<Map<String, Object>> DMessageList(@RequestParam Long id) {
//        // header에서 token을 추출해 id값을 지정하는 방식으로 변경 예정
//        return getMapResponseEntity(id);
//    }

//    @GetMapping("/direct-message")
//    public ResponseEntity<Map<String, Object>> DMessageDetails(@RequestParam Long id) {
//        return getMapResponseEntity(id);
//    }

//    DMessage 관련 Dto 추가 생성 필요
//    @PostMapping("/direct-message")
//    public ResponseEntity<String> DMessageAdd(@RequestBody DMessageCreateRequestDto requestDto) {
//        return getStringResponseEntity(requestDto);
//    }

//    @PutMapping("/direct-message")
//    public ResponseEntity<String> DMessageModify(@RequestBody DMessageUpdateRequestDto requestDto) {
//        return getStringResponseEntity(requestDto);
//    }

//    @DeleteMapping("/direct-message")
//    public ResponseEntity<String> DMessageRemove(@RequestParam Long id) {
//        return getStringResponseEntity(id);
//    }

    // FLOWER
    @GetMapping("/flowers")
    public ResponseEntity<Map<String, Object>> FlowerList(@RequestHeader(value = HEADER_AUTH) String token) throws Exception {
        return getResponseEntity(flowerService.findFlowers(jwtService.decodeToken(token)));
    }

    @GetMapping("/flower")
    public ResponseEntity<Map<String, Object>> FlowerDetails(@RequestParam Long garNo) {
        return getResponseEntity(flowerService.findFlowerById(garNo));
    }

    @PostMapping("/flower")
    public ResponseEntity<Map<String, Object>> FlowerAdd(@RequestHeader(value = HEADER_AUTH) String token) throws Exception {
        return getResponseEntity(flowerService.addFlower(jwtService.decodeToken(token)));
    }

    @PutMapping("/flower")
    public ResponseEntity<Map<String, Object>> FlowerModify(@RequestParam Long garNo, @RequestParam int exp) {
        return getResponseEntity(flowerService.modifyFlower(garNo, exp));
    }

    @DeleteMapping("/flower")
    public ResponseEntity<Map<String, Object>> FlowerRemove(@RequestParam Long garNo) {
        return getResponseEntity(flowerService.removeFlower(garNo));
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
