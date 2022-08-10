package com.ssafy.flody.controller;

import com.ssafy.flody.dto.request.posts.PostCreateRequestDto;
import com.ssafy.flody.dto.request.comments.CommentCreateRequestDto;
import com.ssafy.flody.dto.request.comments.CommentUpdateRequestDto;
import com.ssafy.flody.dto.request.groups.*;
import com.ssafy.flody.dto.request.users.*;
import com.ssafy.flody.dto.response.groups.GroupDetailResponseDto;
import com.ssafy.flody.dto.response.users.UserFollowResponseDto;
import com.ssafy.flody.dto.response.users.UserGoalResponseDto;
import com.ssafy.flody.dto.response.users.UserScheduleListResponseDto;
import com.ssafy.flody.service.JWTService;
import com.ssafy.flody.service.groups.GroupService;
import com.ssafy.flody.service.groups.members.GroupMemberService;
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

    // USER
    @GetMapping("/users") // 모든 유저 리스트 출력 (필요한 기능이 생각나진 않음)
    public ResponseEntity<Map<String, Object>> UserList() {
        Map<String, Object> result = new HashMap<>();
        HttpStatus status;
        try {
            if (!userService.findUsers().isEmpty()) {
                result.put("item", userService.findUsers());
                result.put("msg", SUCCESS);
            } else {
                result.put("msg", FAIL);
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result.put("msg", ERROR);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    // 유저 단일 조회 > 수정하면서 좀 잘못됬나? 확인 필요
    @GetMapping("/user") // 단일 유저 정보 조회 (타 유저 정보는 다 개인정보니까 알 필요 없음. 즉, 내 정보만 조회할 수 있도록)
    public ResponseEntity<Map<String, Object>> UserDetails(@RequestParam String email) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            result.put("item", userService.findUserById(email));
            result.put("msg", SUCCESS);
        } catch (Exception e) {
            result.put("error", e.getMessage());
            result.put("msg", FAIL);
        }
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }

    @GetMapping("/user/checkEmail") // 회원가입 전에 email check
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
    @PostMapping("/user") // 회원가입
    public ResponseEntity<String> UserAdd(@RequestBody UserCreateRequestDto requestDto) {
        String result;
        HttpStatus status;
        try {
            if (userService.addUser(requestDto) != null) {
                result = SUCCESS;
            } else {
                result = FAIL;
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result = e.getMessage();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    //회원 정보 수정 > 이것도 수정하면서 잘못 건드렸나;;;
    @PutMapping("/user") // 개인 정보 수정 > 내 정보만 수정 가능
    public ResponseEntity<Map<String, Object>> UserModify(@RequestHeader(value = HEADER_AUTH) String token, @RequestBody UserUpdateRequestDto requestDto) {
        HashMap<String, Object> result = new HashMap<>();
        HttpStatus status;
        try {
            String email = jwtService.decodeToken(token);
            if (userService.modifyUser(email, requestDto) != null) {
                result.put("msg", SUCCESS);
            } else {
                result.put("msg", FAIL);
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result.put("error", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    //회원 비밀번호 수정
    @PutMapping("/user/password") // 비밀번호 수정 > 내 비밀번호만 수정 가능
    public ResponseEntity<Map<String, Object>> UserModify(@RequestHeader(value = HEADER_AUTH) String token, @RequestBody UserPasswordUpdateRequestDto requestDto) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            String email = jwtService.decodeToken(token);
            if (userService.modifyUserPassword(email, requestDto) != null) {
                result.put("msg", SUCCESS);
            } else {
                result.put("msg", FAIL);
            }
        } catch (Exception e) {
            result.put("error", e.getMessage());
        }

        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }

    //회원 탈퇴
    @DeleteMapping("/user") // 회원탈퇴도 내 계정만 탈퇴 가능
    public ResponseEntity<Map<String, Object>> UserRemove(@RequestHeader(value = HEADER_AUTH) String token) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            userService.removeUser(jwtService.decodeToken(token));
            result.put("msg", SUCCESS);
        } catch (Exception e) {
            result.put("error", e.getMessage());
            result.put("msg", FAIL);
        }
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
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
    public ResponseEntity<Map<String, Object>> UserFollowList(@RequestHeader(value = HEADER_AUTH) String token) {
        Map<String, Object> result = new HashMap<>();
        HttpStatus status;
        try {
            String email = jwtService.decodeToken(token);
            List<UserFollowResponseDto> list = uFollowService.findUserFollows(email);
            if (!list.isEmpty()) {
                result.put("item", list);
                result.put("msg", SUCCESS);
            } else {
                result.put("msg", FAIL);
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result.put("msg", ERROR);
            result.put("errorMsg", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    @GetMapping("/user/follow")
    public ResponseEntity<String> UserFollow(@RequestHeader(value = HEADER_AUTH) String token, @RequestParam String following) {
        String result;
        HttpStatus status;
        try {
            String follower = jwtService.decodeToken(token);
            if (uFollowService.addUserFollow(follower, following) != null) {
                result = SUCCESS;
            } else {
                result = FAIL;
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result = e.getMessage();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    @GetMapping("/user/unfollow")
    public ResponseEntity<String> UserUnfollow(@RequestParam Long folNo) {
        String result;
        HttpStatus status;
        try {
            if (uFollowService.removeUserFollow(folNo) != null) {
                result = SUCCESS;
            } else {
                result = FAIL;
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result = e.getMessage();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
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
    public ResponseEntity<Map<String, Object>> UserScheduleList(@RequestHeader(value = HEADER_AUTH) String token) {
        Map<String, Object> result = new HashMap<>();
        HttpStatus status;
        try {
            String email = jwtService.decodeToken(token);
            List<UserScheduleListResponseDto> responseDtoList = uScheduleService.findUserSchedules(email);
            result.put("item", responseDtoList);
            result.put("msg", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result.put("msg", ERROR);
            e.printStackTrace();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    @GetMapping("/user/schedule") // 내 스케줄 하나, 근데 스케줄 Id가 어차피 주어짐
    public ResponseEntity<Map<String, Object>> UserScheduleDetails(@RequestParam Long usNo) {
        Map<String, Object> result = new HashMap<>();
        HttpStatus status;
        try {
            result.put("item", uScheduleService.findUserSchedule(usNo));
            result.put("msg", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result.put("msg", ERROR);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    @PostMapping("/user/schedule")
    public ResponseEntity<String> UserScheduleAdd(@RequestHeader(value = HEADER_AUTH) String token, @RequestBody UserScheduleCreateRequestDto requestDto) {
        String result;
        HttpStatus status;
        try {
            String email = jwtService.decodeToken(token);
            if (uScheduleService.addUserSchedule(email, requestDto) != 0L) {
                result = SUCCESS;
            } else {
                result = FAIL;
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result = e.getMessage();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    @PutMapping("/user/schedule")
    public ResponseEntity<String> UserScheduleModify(@RequestParam Long usNo, @RequestBody UserScheduleUpdateRequestDto requestDto) {
        String result;
        HttpStatus status;
        try {
            if (uScheduleService.modifyUserSchedule(usNo, requestDto) != 0L) {
                result = SUCCESS;
            } else {
                result = FAIL;
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result = e.getMessage();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    @DeleteMapping("/user/schedule")
    public ResponseEntity<String> UserScheduleRemove(@RequestParam Long usNo) {
        String result;
        HttpStatus status;
        try {
            if (uScheduleService.removeUserSchedule(usNo) != 0L) {
                result = SUCCESS;
            } else {
                result = FAIL;
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result = e.getMessage();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    @GetMapping("/user/goals") // 내 목표 목록
    public ResponseEntity<Map<String, Object>> UserGoalList(@RequestHeader(value = HEADER_AUTH) String token) {
        Map<String, Object> result = new HashMap<>();
        HttpStatus status;
        try {
            String email = jwtService.decodeToken(token);
            List<UserGoalResponseDto> responseDtoList = uGoalService.findUserGoals(email);
            result.put("item", responseDtoList);
            result.put("msg", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result.put("msg", ERROR);
            e.printStackTrace();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    @GetMapping("/user/goal")
    public ResponseEntity<Map<String, Object>> UserGoalDetails(@RequestParam Long ugNo) {
        Map<String, Object> result = new HashMap<>();
        HttpStatus status;
        try {
            result.put("item", uGoalService.findUserGoal(ugNo));
            result.put("msg", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result.put("msg", ERROR);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    @PostMapping("/user/goal")
    public ResponseEntity<String> UserGoalAdd(@RequestHeader(value = HEADER_AUTH) String token, @RequestBody UserGoalCreateRequestDto requestDto) {
        String result;
        HttpStatus status;
        try {
            String email = jwtService.decodeToken(token);
            uGoalService.addUserGoal(email, requestDto);
            result = SUCCESS;
//            if (uGoalService.addUserGoal(email, requestDto) != 0L) {
//                result = SUCCESS;
//            } else {
//                result = FAIL;
//            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result = e.getMessage();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    @PutMapping("/user/goal")
    public ResponseEntity<String> UserGoalModify(@RequestParam Long ugNo, @RequestBody UserGoalUpdateRequestDto requestDto) {
        String result;
        HttpStatus status;
        try {
            if (uGoalService.modifyUserGoal(ugNo, requestDto) != 0L) {
                result = SUCCESS;
            } else {
                result = FAIL;
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result = e.getMessage();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(result, status);
    }

    @DeleteMapping("/user/goal")
    public ResponseEntity<String> UserGoalRemove(@RequestParam Long ugNo) {
        String result;
        HttpStatus status;
        try {
            if (uGoalService.removeUserGoal(ugNo) != 0L) {
                result = SUCCESS;
            } else {
                result = FAIL;
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result = e.getMessage();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    // GROUP
    @GetMapping("/groups")
    public ResponseEntity<Map<String, Object>> GroupList() {
        Map<String, Object> result = new HashMap<>();
        HttpStatus status;
        try {
            List<GroupDetailResponseDto> list = groupService.findGroups();
            if (!list.isEmpty()) {
                result.put("users", list);
                result.put("msg", SUCCESS);
            } else {
                result.put("msg", FAIL);
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result.put("msg", ERROR);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    @GetMapping("/group")
    public ResponseEntity<Map<String, Object>> GroupDetails(@RequestParam Long groNo) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            result.put("item", groupService.findGroupById(groNo));
            result.put("msg", SUCCESS);
        } catch (Exception e) {
            result.put("error", e.getMessage());
            result.put("msg", FAIL);
        }
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }

    @PostMapping("/group")
    public ResponseEntity<Map<String, Object>> GroupAdd(@RequestBody GroupCreateRequestDto requestDto) {
        HashMap<String, Object> result = new HashMap<>();
        HttpStatus status;
        try {
            Long groNo = groupService.addGroup(requestDto);
            // groupMemberService.addMember(email, "OWNER");
            if (groNo != 0L) {
                result.put("item", groNo);
                result.put("msg", SUCCESS);
            } else {
                result.put("msg", FAIL);
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result.put("error", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    @PutMapping("/group")
    public ResponseEntity<Map<String, Object>> GroupModify(@RequestHeader(value = HEADER_AUTH) String token, @RequestParam Long groNo, @RequestBody GroupUpdateRequestDto requestDto) {
        HashMap<String, Object> result = new HashMap<>();
        HttpStatus status;
        try {
            String email = jwtService.decodeToken(token);
            // groupMemberService.isValid(email, groNo);
            groupService.modifyGroup(groNo, requestDto);
            result.put("msg", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result.put("msg", FAIL);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    @DeleteMapping("/group")
    public ResponseEntity<Map<String, Object>> GroupRemove(@RequestParam Long groNo) {
        HashMap<String, Object> result = new HashMap<>();
        HttpStatus status;
        try {
            // groupMemberService.isValid(email, groNo);
            groupService.removeGroup(groNo);
            result.put("msg", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result.put("msg", FAIL);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }

    /* <JJONG NOW>
    // Get GroupMembers
    @GetMapping("/group/{groNo}")
    public ResponseEntity<Map<String, Object>> GroupMemberList(@PathVariable Long groNo) {
        Map<String, Object> result = new HashMap<>();
        HttpStatus status;
        try {
            List<GroupMemBerResponseDto> list = groupService.findGroups();
            if (!list.isEmpty()) {
                result.put("users", list);
                result.put("msg", SUCCESS);
            } else {
                result.put("msg", FAIL);
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result.put("msg", ERROR);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }
    // Get GroupMember
    @GetMapping("/group/{groNo}")
    public ResponseEntity<Map<String, Object>> GroupMemberDetails() {
        HashMap<String, Object> result = new HashMap<>();
        try {
            result.put("item", groupService.findGroupById(groNo));
            result.put("msg", SUCCESS);
        } catch (Exception e) {
            result.put("error", e.getMessage());
            result.put("msg", FAIL);
        }
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }
    // Post GroupMember
    @PostMapping("/group/{groNo}")
    public ResponseEntity<String> GroupMemberAdd() {
        String result;
        HttpStatus status;
        try {
            if (groupService.addGroup(requestDto) != 0L) {
                result = SUCCESS;
            } else {
                result = FAIL;
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result = e.getMessage();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }
    // Modify GroupMember
    @PutMapping("/group/{groNo}")
    public ResponseEntity<String> GroupMemberModify() {
        String result;
        HttpStatus status;
        try {
            String email = jwtService.decodeToken(token);
            if (true) { //여기서 email로 groupMemberService.validateEditor 판별
                if (groupService.modifyGroup(groNo, requestDto) != null) {
                    result = SUCCESS;
                } else {
                    result = FAIL;
                }
            } else {
                result = FAIL;
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result = ERROR;
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }
    // Delete GroupMember
    @DeleteMapping("/group/{groNo}")
    public ResponseEntity<String> GroupMemberRemove() {
        String result;
        HttpStatus status;
        try {
            if (groupService.removeGroup(groNo) != 0L) {
                result = SUCCESS;
            } else {
                result = FAIL;
            }
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            result = ERROR;
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, status);
    }
    */

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
    @GetMapping("/boards")
    public ResponseEntity<Map<String, Object>> BoardList(@RequestParam String category) {
        // 개인 피드는 여기에 RequestParam 걸어서 option처럼 주는게 어떨까 싶습니다.
        // 추가로 정렬도 RequestParam으로 주면 좋을 것 같습니다.
        return getMapResponseEntity(category);
    }

    @GetMapping("/board")
    public ResponseEntity<Map<String, Object>> BoardDetails(@RequestParam Long id) {
        return getMapResponseEntity(id);
    }

    @PostMapping("/board")
    public ResponseEntity<String> BoardAdd(@RequestBody PostCreateRequestDto requestDto) {
        return getStringResponseEntity(requestDto);
    }

    @PutMapping("/board")
    public ResponseEntity<String> BoardModify(@RequestBody PostCreateRequestDto requestDto) {
        return getStringResponseEntity(requestDto);
    }

    @DeleteMapping("/board")
    public ResponseEntity<String> BoardRemove(@RequestParam Long id) {
        return getStringResponseEntity(id);
    }

    @GetMapping("/board/like")
    public ResponseEntity<String> BoardLike(@RequestParam Long id) {
        return getStringResponseEntity(id);
    }

    @GetMapping("/board/scrap")
    public ResponseEntity<String> BoardScrap(@RequestParam Long id) {
        return getStringResponseEntity(id);
    }

    @GetMapping("/board/report")
    public ResponseEntity<String> BoardReport(@RequestParam Long id) {
        return getStringResponseEntity(id);
    }

    @GetMapping("/comments")
    public ResponseEntity<Map<String, Object>> CommentList(@RequestParam Long id) {
        return getMapResponseEntity(id);
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
