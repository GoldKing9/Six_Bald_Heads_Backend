package com.sixbald.webide.user;

import com.sixbald.webide.common.Response;
import com.sixbald.webide.user.dto.response.UserDTO;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 프로필 조회
    @GetMapping("/api/auth/profile")
    public Response<UserDTO> findUserInfo(){
        Long userId = 1L; // 임시
        UserDTO data = userService.getUserInfo(userId);
        return Response.success("회원 조회에 성공하셨습니다", data);
    }

    //프로필 이미지 수정
    @PutMapping("/api/auth/profile/image")
    public Response<Void> updateImage(@NotNull @RequestParam MultipartFile imageUrl) {
        Long userId = 1L; // 임시
        userService.updateUserProfileImage(userId, imageUrl);
        return Response.success("프로필 이미지 수정 성공");
    }
}
