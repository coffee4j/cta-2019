This is the companion website to the paper **Repairing Over-constrained Models for Combinatorial Robustness Testing** by Konrad Fögen and Horst Lichter. It is submitted to the IEEE International Workshop on*Combinatorial Testing and its Applications* [(CTA-2019)](https://paris.utdallas.edu/cta19/) and currently in review.

- *src/main/java/de/rwth/swc/cta2019* contains source code which implements the system models used for experimentation
- *src/test/java/de/rwth/swc/cta2019/experiments* contains the test to execute the experiment
- *src/test/java/de/rwth/swc/cta2019/example* contains an example test to illustrate the usage of **@EnableConstraintDiagnosis**

To obtain more detailed reports, the test methods must be executed either individually in the IDE or via `mvn clean test`. Please keep in mind that executing all scenarios might take some time. 

Reference implementations of the algorithms presented in the paper are also published. See https://coffee4j.github.io/ for more information.

```java
class ExampleTest {

    @CombinatorialTest
    @ModelFromMethod("model")
    @Generator({Ipog.class, IpogNeg.class})
    @EnableConstraintDiagnosis(skip = true) /* Enable Constraint Diagnosis */
    void testExample(String title, String firstName, String givenName) {
        /* Stimulate the System under Test */
    }

    static InputParameterModel model() {
        return inputParameterModel("example")
                .parameters(
                        parameter("Title").values("Mr", "Mrs", "123"),
                        parameter("FirstName").values("John", "Jane", "123"),
                        parameter("GivenName").values("Doe", "123")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("valid-mr")
                                .by((String title, String firstName) ->
                                        !(title.equals("Mr") && firstName.equals("Jane"))
                                     && !(title.equals("Mr") && firstName.equals("123"))),
                        constrain("Title", CORRECT).withName("valid-title") /* Mark Error-Constraint as Correct */
                                .by((String title) -> !title.equals("123")),
                        constrain("FirstName", CORRECT).withName("valid-firstname")
                                .by((String firstName) -> !firstName.equals("123")),
                        constrain("GivenName", CORRECT).withName("valid-givenname")
                                .by((String givenName) -> !givenName.equals("123")),
                        constrain("Title", "FirstName").withName("valid-mrs")
                                .by((String title, String firstName) ->
                                        !(title.equals("Mrs") && firstName.equals("John"))
                                     && !(title.equals("Mrs") && firstName.equals("123")))
                )
               .build();
    }
}
```

