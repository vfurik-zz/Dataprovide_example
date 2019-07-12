package com.example;

import com.example.api.actions.user.UserAction;
import com.example.api.models.user.UserResponse;
import com.example.api.utils.UserResponseCondition;
import io.github.sskorol.core.DataSupplier;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import one.util.streamex.StreamEx;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
public class UserTest /*extends AbstractTestNGSpringContextTests */ {

/*    @Autowired
    private UserRepo userRepo;

    private User user;*/

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        //user = userRepo.findById(1l).get();
    }


    @DataSupplier(flatMap = true)
    public List<Tuple2<UserAction.Params, Predicate<UserResponse>>> allData() {
        return StreamEx.of(
                Tuple.of(new UserAction.Params().withMaxAge(35), UserResponseCondition.verifyMaxAge(12)),
                Tuple.of(new UserAction.Params().withMinAge(22), UserResponseCondition.verifyMinAge(22))
        ).toList();
    }


    @Test(dataProvider = "allData")
    public void getUserTest(UserAction.Params params, Predicate<UserResponse> condition) {
        List<UserResponse> users = new UserAction().getUser(params);
        users.forEach(e -> assertThat(e).matches(condition));
        System.out.println(users);
    }

}
