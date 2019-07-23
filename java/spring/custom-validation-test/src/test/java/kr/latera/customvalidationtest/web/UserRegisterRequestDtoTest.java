package kr.latera.customvalidationtest.web;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRegisterRequestDtoTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validatorFromFactory;

    @Autowired
    private Validator validatorInjected;

    @BeforeAll
    public static void init() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validatorFromFactory = validatorFactory.getValidator();
    }

    @AfterAll
    public static void close() {
        validatorFactory.close();
    }

    @Test
    void test_should_fail() {
        // Given
        UserRegisterRequestDto registerRequestDto = UserRegisterRequestDto.of("james", "test123@example.com");

        // When
        Set<ConstraintViolation<UserRegisterRequestDto>> violations = validatorFromFactory.validate(registerRequestDto);

        // Then
        assertThat(violations).isNotEmpty();
    }

    @Test
    void test_must_succeed() {
        // Given
        UserRegisterRequestDto registerRequestDto = UserRegisterRequestDto.of("james", "test123@example.com");

        // When
        Set<ConstraintViolation<UserRegisterRequestDto>> violations = validatorInjected.validate(registerRequestDto);

        // Then
        assertThat(violations).isNotEmpty();
    }
}
