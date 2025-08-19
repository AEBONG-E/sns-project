package com.fastcampus.sns.service;

import com.fastcampus.sns.exception.ErrorCode;
import com.fastcampus.sns.exception.SnsApplicationException;
import com.fastcampus.sns.fixture.PostEntityFixture;
import com.fastcampus.sns.fixture.UserEntityFixture;
import com.fastcampus.sns.model.entity.PostEntity;
import com.fastcampus.sns.model.entity.UserEntity;
import com.fastcampus.sns.repository.PostEntityRepository;
import com.fastcampus.sns.repository.UserEntityRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PostServiceTest {

    @Autowired private PostService postService;
    @MockBean private PostEntityRepository postEntityRepository;
    @MockBean private UserEntityRepository userEntityRepository;


    @Test
    void 포스트_작성이_성공한경우() {

        String title = "title";
        String body = "body";
        String userName = "userName";

        // mocking
        when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.of(mock(UserEntity.class)));
        when(postEntityRepository.save(any())).thenReturn(mock(PostEntity.class));

        Assertions.assertDoesNotThrow(() -> postService.create(title, body, userName));

    }

    @Test
    void 포스트_작성시_요청한_유저가_존재하지않은경우() {

        String title = "title";
        String body = "body";
        String userName = "userName";

        // mocking
        when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.empty());
        when(postEntityRepository.save(any())).thenReturn(mock(PostEntity.class));


        SnsApplicationException e = Assertions.assertThrows(SnsApplicationException.class, () -> postService.create(title, body, userName));
        Assertions.assertEquals(ErrorCode.USER_NOT_FOUND, e.getErrorCode());

    }

    @Test
    void 포스트수정이_성공한경우() {

        Integer postId = 1;
        String userName = "userName";
        String title = "title";
        String body = "body";

        PostEntity postFixture = PostEntityFixture.get(postId, userName, title, body);
        UserEntity userFixture = postFixture.getUser();

        // mocking
        when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.of(userFixture));
        when(postEntityRepository.findById(postId)).thenReturn(Optional.of(postFixture));

        Assertions.assertDoesNotThrow(() -> postService.modify(title, body, userName, postId));

    }

    @Test
    void 포스트수정시_포스트가_존재하지않는_경우() {

        Integer postId = 1;
        String title = "title";
        String body = "body";
        String userName = "userName";


        PostEntity postFixture = PostEntityFixture.get(postId, userName, title, body);
        UserEntity userFixture = postFixture.getUser();

        // mocking
        when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.of(userFixture));
        when(postEntityRepository.findById(postId)).thenReturn(Optional.empty());

        SnsApplicationException e = Assertions.assertThrows(SnsApplicationException.class, () -> postService.modify(title, body, userName, postId));
        Assertions.assertEquals(ErrorCode.POST_NOT_FOUND, e.getErrorCode());

    }

    @Test
    void 포스트수정시_권한이_없는_경우() {

        Integer postId = 1;
        String title = "title";
        String body = "body";
        Integer userId = 2;
        String userName = "userName";


        PostEntity postFixture = PostEntityFixture.get(postId, 1, userName, title, body);        // user id = 1
        UserEntity writer = UserEntityFixture.get(userId, "userName1", "password1"); // user id = 2

        // mocking
        when(userEntityRepository.findByUserName(userName)).thenReturn(Optional.of(writer));
        when(postEntityRepository.findById(postId)).thenReturn(Optional.of(postFixture));

        SnsApplicationException e = Assertions.assertThrows(SnsApplicationException.class, () -> postService.modify(title, body, userName, postId));
        Assertions.assertEquals(ErrorCode.INVALID_PERMISSION, e.getErrorCode());

    }

}
