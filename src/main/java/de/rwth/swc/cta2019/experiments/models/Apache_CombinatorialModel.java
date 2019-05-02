package de.rwth.swc.cta2019.experiments.models;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import de.rwth.swc.cta2019.experiments.Experiment;

import static de.rwth.swc.coffee4j.model.InputParameterModel.inputParameterModel;
import static de.rwth.swc.coffee4j.model.constraints.ConstraintBuilder.constrain;
import static de.rwth.swc.cta2019.experiments.util.ParametersFactory.parameters;

public class Apache_CombinatorialModel {

    public static Experiment buildModel_Apache(int strength) {
        System.out.println("INFO: building model 'Apache' with strength t=" + strength);

        InputParameterModel ipm = inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(6, 1, 5, 1, 4, 4, 3, 8, 2, 158)
                )
                .errorConstraint(constrain("p78", "p79")
                        .by((Integer p78, Integer p79) -> (p78 != 0 || p79 != 0)))
                .errorConstraint(constrain("p15", "p168")
                        .by((Integer p15, Integer p168) -> (p15 != 0 || p168 != 0)))
                .errorConstraint(constrain("p169", "p170")
                        .by((Integer p169, Integer p170) -> (p169 != 0 || p170 != 0)))
                .errorConstraint(constrain("p91", "p99", "p171")
                        .by((Integer p91, Integer p99, Integer p171) -> (p91 != 0 || p99 != 0 || p171 != 0)))
                .errorConstraint(constrain("p35", "p44", "p45", "p133")
                        .by((Integer p35, Integer p44, Integer p45, Integer p133) -> (p35 != 0 || p44 != 0 || p45 != 0 || p133 != 0)))
                .errorConstraint(constrain("p44", "p45", "p166", "p167")
                        .by((Integer p44, Integer p45, Integer p166, Integer p167) -> (p44 != 0 || p45 != 0 || p166 != 0 || p167 != 0)))
                .errorConstraint(constrain("p35", "p44", "p45", "p46", "p165")
                        .by((Integer p35, Integer p44, Integer p45, Integer p46, Integer p165) -> (p35 != 0 || p44 != 0 || p45 != 0 || p46 != 0 || p165 != 0)))
                .build();

        return new Experiment("Apache (t=" + strength + ")", ipm);
    }
}
