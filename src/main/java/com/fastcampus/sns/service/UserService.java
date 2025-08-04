package com.fastcampus.sns.service;

import com.fastcampus.sns.exception.SnsApplicationException;
import com.fastcampus.sns.model.User;
import com.fastcampus.sns.model.entity.UserEntity;
import com.fastcampus.sns.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserEntityRepository userEntityRepository;

    // TODO : implement
    public User join(String userName, String password) {

        // 회원가입하려는 userName 으로 회원가입된 user 가 있는지 체크
        Optional<UserEntity> userEntity = userEntityRepository.findByUserName(userName);

        // 회원가입 진행 = user 를 등록
        userEntityRepository.save(userEntity.orElseThrow(SnsApplicationException::new));

        return User.builder()
                .userName(userName)
                .password(password)
                .build();
    }

    // TODO : implement
    public String login(String userName, String password) {

        // 회원가입 여부 체크
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() -> new SnsApplicationException());

        // password 체크
        if (!userEntity.getPassword().equals(password)) {
            throw new SnsApplicationException();
        }

        // token 생성

        return "";
    }

}
