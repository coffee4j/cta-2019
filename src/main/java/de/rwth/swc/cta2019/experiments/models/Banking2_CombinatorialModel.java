package de.rwth.swc.cta2019.experiments.models;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import de.rwth.swc.cta2019.experiments.Experiment;
import de.rwth.swc.cta2019.experiments.util.ParametersFactory;

import static de.rwth.swc.coffee4j.model.InputParameterModel.inputParameterModel;
import static de.rwth.swc.coffee4j.model.constraints.ConstraintBuilder.constrain;

public class Banking2_CombinatorialModel {

    private static InputParameterModel.Builder buildBaseModel(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        ParametersFactory.parameters(4, 1, 2, 14)
                )
                .errorConstraint(constrain("p0", "p9").by((Integer p0, Integer p9) ->
                        (p0 != 2 || p9 != 1) && (p0 != 1 || p9 != 1) && (p0 != 3 || p9 != 1)))
                ;
    }

    public static Experiment buildModel_Banking2(int strength) {
        System.out.println("INFO: building model 'Banking2' with strength t=" + strength);

        return new Experiment("Banking2 (t=" + strength + ")", buildBaseModel(strength).build());
    }

    public static Experiment buildModel_Banking2_Plus1(int strength) {
        System.out.println("INFO: building model 'Banking2+1' with strength t=" + strength);

        InputParameterModel model = buildBaseModel(strength).errorConstraint(
                        constrain("p0", "p9")
                                .by((Integer p0, Integer p9) -> (p0 != 2 || p9 != 1)))
                .build();

        return new Experiment("Banking2+1 (t=" + strength + ")", model);
    }

    public static Experiment buildModel_Banking2_Plus1_Plus1(int strength) {
        System.out.println("INFO: building model 'Banking2+1+1' with strength t=" + strength);

        InputParameterModel model = buildBaseModel(strength)
                        .errorConstraint(constrain("p0", "p9")
                                .by((Integer p0, Integer p9) ->
                                        (p0 != 2 || p9 != 1)
                                ))
                        .errorConstraint(constrain("p0", "p9")
                                .by((Integer p0, Integer p9) ->
                                        (p0 != 1 || p9 != 1)
                                ))
                .build();

        return new Experiment("Banking2+1+1 (t=" + strength + ")", model);
    }
}
