package user;

/**
 * Entry point for soft assertions of different data types.
 */
@javax.annotation.Generated(value="assertj-assertions-generator")
public class SoftAssertions extends org.assertj.core.api.SoftAssertions {

  /**
   * Creates a new "soft" instance of <code>{@link com.example.api.models.user.UserResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created "soft" assertion object.
   */
  @org.assertj.core.util.CheckReturnValue
  public com.example.api.models.user.UserResponseAssert assertThat(com.example.api.models.user.UserResponse actual) {
    return proxy(com.example.api.models.user.UserResponseAssert.class, com.example.api.models.user.UserResponse.class, actual);
  }

}
