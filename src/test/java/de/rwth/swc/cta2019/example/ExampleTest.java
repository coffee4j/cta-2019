package de.rwth.swc.cta2019.example;

import de.rwth.swc.coffee4j.engine.generator.ipog.Ipog;
import de.rwth.swc.coffee4j.engine.generator.negative.IpogNeg;
import de.rwth.swc.coffee4j.junit.CombinatorialTest;
import de.rwth.swc.coffee4j.junit.provider.configuration.diagnosis.EnableConstraintDiagnosis;
import de.rwth.swc.coffee4j.junit.provider.configuration.generator.Generator;
import de.rwth.swc.coffee4j.junit.provider.model.ModelFromMethod;
import de.rwth.swc.coffee4j.model.InputParameterModel;

import static de.rwth.swc.coffee4j.model.InputParameterModel.inputParameterModel;
import static de.rwth.swc.coffee4j.model.Parameter.parameter;
import static de.rwth.swc.coffee4j.model.constraints.ConstraintBuilder.constrain;
import static de.rwth.swc.coffee4j.model.constraints.ConstraintStatus.CORRECT;

class ExampleTest {

    @CombinatorialTest
    @ModelFromMethod("model")
    @Generator({Ipog.class, IpogNeg.class})
    /* Enable Constraint Diagnosis but do not skip generation if conflicts were detected */
    @EnableConstraintDiagnosis(skip = false)
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
