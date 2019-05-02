package de.rwth.swc.cta2019.experiments.models;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import de.rwth.swc.cta2019.experiments.Experiment;
import de.rwth.swc.cta2019.experiments.util.ConstraintsHelper;
import de.rwth.swc.cta2019.experiments.util.ParametersFactory;

import static de.rwth.swc.coffee4j.model.InputParameterModel.inputParameterModel;
import static de.rwth.swc.coffee4j.model.constraints.ConstraintBuilder.constrain;

public class Example1_CombinatorialModel {

    public static Experiment buildModel_Example1(int strength) {
        System.out.println("INFO: building model 'Example1' with strength t=" + strength);
        InputParameterModel ipm = inputParameterModel("")
            .strength(strength)
            .parameters(
                ParametersFactory.parameters(3, 2, 2, 1)
            )
            .errorConstraint(constrain("p0")
                    .by((Integer title) -> title != 2))
            .errorConstraint(constrain("p1")
                    .by((Integer given) -> given != 2))
            .errorConstraint(constrain("p2")
                    .by((Integer family) -> family != 1))
            .errorConstraint(constrain("p0", "p1")
                    .by((Integer title, Integer given) -> ConstraintsHelper.implies(() -> title == 0, () -> given != 1)))
            .errorConstraint(constrain("p0", "p1")
                    .by((Integer title, Integer given) -> ConstraintsHelper.implies(() -> title == 1, () -> given != 0)))
            .build();

        return new Experiment("Example1 (t=" + strength + ")", ipm);
    }
}
