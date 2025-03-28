package com.metacoding.storev2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    // 서비스는 서비스 로직짜는곳임
    private final UserRepository userRepository;

    @Transactional
    public void 회원가입(UserRequest.JoinDTO joinDTO) {
        // 1. 유저네임 중복 체크
        User user = userRepository.findByUsername(joinDTO.getUsername());

        // 2. 중복있으면 RuntimeException 터트려버리기
        if (user != null) throw new RuntimeException("동일한 username이 존재합니다.");

        // 3. 없음 말고. 회원가입으로 ㄱ
        userRepository.save(joinDTO.getUsername(), joinDTO.getPassword(), joinDTO.getUsername());

    }
}
