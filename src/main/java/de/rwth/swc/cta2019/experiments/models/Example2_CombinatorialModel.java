package de.rwth.swc.cta2019.experiments.models;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import de.rwth.swc.cta2019.experiments.Experiment;

import static de.rwth.swc.coffee4j.model.InputParameterModel.inputParameterModel;
import static de.rwth.swc.coffee4j.model.constraints.ConstraintBuilder.constrain;
import static de.rwth.swc.cta2019.experiments.util.ConstraintsHelper.implies;
import static de.rwth.swc.cta2019.experiments.util.ParametersFactory.parameters;

public class Example2_CombinatorialModel {

    public static Experiment buildModel_Example2(int strength) {
        System.out.println("INFO: building model 'Example2' with strength t=" + strength);
        InputParameterModel ipm = inputParameterModel("")
            .strength(strength)
            .parameters(
                parameters(3, 2, 2, 1)
            )
            .errorConstraint(constrain("p0")
                    .by((Integer title) -> title != 2))
            .errorConstraint(constrain("p1")
                    .by((Integer given) -> given != 2))
            .errorConstraint(constrain("p2")
                    .by((Integer family) -> family != 1))
            .errorConstraint(constrain("p0", "p1")
                    .by((Integer title, Integer given) -> implies(() -> title == 0, () -> given == 0)))
            .errorConstraint(constrain("p0", "p1")
                    .by((Integer title, Integer given) -> implies(() -> title == 1, () -> given == 1)))
            .build();


        return new Experiment("Example2 (t=" + strength + ")", ipm);
    }
}
