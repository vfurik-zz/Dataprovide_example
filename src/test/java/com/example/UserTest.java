package com.example;

import com.example.api.actions.user.UserAction;
import com.example.api.models.user.UserResponse;
import com.example.api.utils.UserResponseCondition;
import io.github.sskorol.core.DataSupplier;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import one.util.streamex.StreamEx;
import org.testng.annotations.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @DataSupplier(flatMap = true)
    public List<Tuple2<UserAction.Params, Predicate<UserResponse>>> allData() {
        return StreamEx.of(
                Tuple.of(new UserAction.Params().withMaxAge(35), UserResponseCondition.verifyMaxAge(35)),
                Tuple.of(new UserAction.Params().withMinAge(22), UserResponseCondition.verifyMinAge(22)),
                Tuple.of(new UserAction.Params().withPassport("PS23232"), UserResponseCondition.verifyPassport("PS23232")),
                Tuple.of(new UserAction.Params().withName("will"), UserResponseCondition.verifyName("william")),
                Tuple.of(new UserAction.Params().withEmail("Michael89@gmail.com"), UserResponseCondition.verifyEmail("Michael89@gmail.COM"))
        ).toList();
    }

    @Test(dataProvider = "allData")
    public void getUserTest(UserAction.Params params, Predicate<UserResponse> condition) {
        List<UserResponse> users = new UserAction().getUser(params);
        users.forEach(e -> assertThat(e).matches(condition));
    }

}
