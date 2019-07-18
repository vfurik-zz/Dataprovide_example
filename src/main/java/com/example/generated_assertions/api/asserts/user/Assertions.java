package com.example.generated_assertions.api.asserts.user;

/**
 * Entry point for assertions of different data types. Each method in this class is a static factory for the
 * type-specific assertion objects.
 */
@javax.annotation.Generated(value="assertj-assertions-generator")
public class Assertions {

  /**
   * Creates a new instance of <code>{@link com.example.api.models.user.UserResponseAssert}</code>.
   *
   * @param actual the actual value.
   * @return the created assertion object.
   */
  @org.assertj.core.util.CheckReturnValue
  public static UserResponseAssert assertThat(com.example.api.models.user.UserResponse actual) {
    return new  UserResponseAssert(actual);
  }

  /**
   * Creates a new <code>{@link Assertions}</code>.
   */
  protected Assertions() {
    // empty
  }
}
