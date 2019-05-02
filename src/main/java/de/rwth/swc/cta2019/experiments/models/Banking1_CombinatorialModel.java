package de.rwth.swc.cta2019.experiments.models;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import de.rwth.swc.cta2019.experiments.Experiment;
import de.rwth.swc.cta2019.experiments.util.ParametersFactory;

import static de.rwth.swc.coffee4j.model.InputParameterModel.inputParameterModel;
import static de.rwth.swc.coffee4j.model.constraints.ConstraintBuilder.constrain;

public class Banking1_CombinatorialModel {

    private static InputParameterModel.Builder buildBaseModel(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        ParametersFactory.parameters(4, 1, 3, 4)
                )
                .errorConstraint(constrain("p0", "p1", "p2", "p3", "p4")
                        .by((Integer p0, Integer p1, Integer p2, Integer p3, Integer p4) ->
                                (p2 != 0 || p0 != 3 || p3 != 1 || p4 != 2 || p1 != 0) &&
                                        (p1 != 2 || p2 != 1 || p4 != 2 || p3 != 0 || p0 != 2) &&
                                        (p1 != 2 || p2 != 0 || p4 != 0 || p3 != 1 || p0 != 0) &&
                                        (p2 != 0 || p4 != 0 || p3 != 2 || p1 != 0 || p0 != 1) &&
                                        (p1 != 2 || p2 != 0 || p4 != 0 || p3 != 1 || p0 != 2) &&
                                        (p1 != 2 || p2 != 0 || p3 != 2 || p0 != 3 || p4 != 1) &&
                                        (p2 != 1 || p4 != 2 || p3 != 0 || p0 != 2 || p1 != 0) &&
                                        (p4 != 1 || p3 != 0 || p0 != 2 || p2 != 2 || p1 != 0) &&
                                        (p1 != 2 || p2 != 1 || p4 != 0 || p0 != 3 || p3 != 0) &&
                                        (p2 != 0 || p1 != 1 || p0 != 3 || p4 != 2 || p3 != 0) &&
                                        (p2 != 0 || p0 != 3 || p4 != 1 || p3 != 0 || p1 != 0) &&
                                        (p1 != 2 || p2 != 0 || p0 != 3 || p3 != 1 || p4 != 2) &&
                                        (p3 != 2 || p1 != 1 || p4 != 2 || p0 != 0 || p2 != 2) &&
                                        (p1 != 2 || p2 != 1 || p4 != 0 || p3 != 0 || p0 != 2) &&
                                        (p2 != 0 || p4 != 0 || p3 != 2 || p1 != 1 || p0 != 0) &&
                                        (p1 != 2 || p2 != 1 || p0 != 3 || p4 != 2 || p3 != 0) &&
                                        (p2 != 0 || p4 != 0 || p3 != 2 || p1 != 1 || p0 != 2) &&
                                        (p1 != 2 || p2 != 0 || p4 != 0 || p3 != 2 || p0 != 1) &&
                                        (p2 != 0 || p1 != 1 || p4 != 2 || p0 != 0 || p3 != 0) &&
                                        (p2 != 0 || p4 != 0 || p3 != 2 || p1 != 1 || p0 != 3) &&
                                        (p4 != 0 || p3 != 2 || p2 != 2 || p1 != 0 || p0 != 1) &&
                                        (p2 != 0 || p4 != 0 || p0 != 3 || p3 != 1 || p1 != 0) &&
                                        (p1 != 2 || p0 != 3 || p3 != 1 || p4 != 2 || p2 != 2) &&
                                        (p2 != 0 || p4 != 0 || p1 != 1 || p3 != 0 || p0 != 2) &&
                                        (p1 != 2 || p4 != 0 || p3 != 1 || p0 != 2 || p2 != 2) &&
                                        (p2 != 0 || p4 != 0 || p3 != 0 || p1 != 0 || p0 != 1) &&
                                        (p1 != 2 || p0 != 3 || p4 != 1 || p3 != 0 || p2 != 2) &&
                                        (p1 != 2 || p3 != 2 || p4 != 1 || p0 != 0 || p2 != 2) &&
                                        (p2 != 0 || p3 != 2 || p1 != 1 || p4 != 2 || p0 != 0) &&
                                        (p2 != 0 || p3 != 2 || p4 != 1 || p0 != 2 || p1 != 0) &&
                                        (p2 != 0 || p3 != 2 || p1 != 1 || p4 != 2 || p0 != 2) &&
                                        (p2 != 1 || p3 != 2 || p0 != 3 || p4 != 2 || p1 != 0) &&
                                        (p1 != 2 || p2 != 0 || p3 != 1 || p4 != 2 || p0 != 2) &&
                                        (p4 != 0 || p1 != 1 || p0 != 3 || p3 != 0 || p2 != 2) &&
                                        (p1 != 2 || p2 != 0 || p3 != 1 || p4 != 2 || p0 != 0) &&
                                        (p1 != 2 || p2 != 1 || p4 != 0 || p3 != 2 || p0 != 0) &&
                                        (p1 != 1 || p0 != 3 || p4 != 2 || p3 != 0 || p2 != 2) &&
                                        (p1 != 2 || p2 != 1 || p4 != 0 || p3 != 2 || p0 != 2) &&
                                        (p1 != 2 || p2 != 1 || p4 != 0 || p3 != 2 || p0 != 3) &&
                                        (p1 != 2 || p2 != 0 || p4 != 0 || p3 != 0 || p0 != 1) &&
                                        (p1 != 2 || p2 != 1 || p3 != 2 || p0 != 3 || p4 != 2) &&
                                        (p1 != 2 || p2 != 0 || p4 != 1 || p3 != 0 || p0 != 2) &&
                                        (p2 != 1 || p4 != 0 || p3 != 2 || p0 != 0 || p1 != 0) &&
                                        (p1 != 2 || p2 != 0 || p4 != 2 || p3 != 0 || p0 != 1) &&
                                        (p1 != 2 || p2 != 0 || p0 != 3 || p4 != 1 || p3 != 0) &&
                                        (p1 != 1 || p4 != 2 || p0 != 0 || p3 != 0 || p2 != 2) &&
                                        (p4 != 2 || p3 != 0 || p2 != 2 || p1 != 0 || p0 != 1) &&
                                        (p2 != 0 || p4 != 0 || p1 != 1 || p0 != 0 || p3 != 0) &&
                                        (p3 != 2 || p0 != 3 || p4 != 1 || p2 != 2 || p1 != 0) &&
                                        (p2 != 0 || p3 != 2 || p0 != 3 || p4 != 1 || p1 != 0) &&
                                        (p1 != 2 || p2 != 0 || p4 != 1 || p0 != 0 || p3 != 0) &&
                                        (p1 != 2 || p4 != 0 || p3 != 1 || p0 != 0 || p2 != 2) &&
                                        (p1 != 2 || p3 != 2 || p4 != 2 || p2 != 2 || p0 != 1) &&
                                        (p1 != 2 || p3 != 1 || p4 != 2 || p0 != 0 || p2 != 2) &&
                                        (p4 != 0 || p3 != 2 || p1 != 1 || p0 != 3 || p2 != 2) &&
                                        (p2 != 0 || p3 != 2 || p4 != 1 || p0 != 0 || p1 != 0) &&
                                        (p1 != 2 || p2 != 0 || p4 != 0 || p0 != 3 || p3 != 1) &&
                                        (p1 != 2 || p4 != 0 || p0 != 3 || p3 != 1 || p2 != 2) &&
                                        (p4 != 0 || p1 != 1 || p3 != 0 || p0 != 2 || p2 != 2) &&
                                        (p2 != 0 || p3 != 1 || p4 != 2 || p0 != 0 || p1 != 0) &&
                                        (p2 != 1 || p4 != 0 || p3 != 2 || p0 != 2 || p1 != 0) &&
                                        (p4 != 1 || p0 != 0 || p3 != 0 || p2 != 2 || p1 != 0) &&
                                        (p2 != 1 || p4 != 0 || p0 != 0 || p3 != 0 || p1 != 0) &&
                                        (p2 != 0 || p4 != 1 || p3 != 0 || p0 != 2 || p1 != 0) &&
                                        (p4 != 0 || p0 != 3 || p3 != 1 || p2 != 2 || p1 != 0) &&
                                        (p1 != 2 || p4 != 0 || p3 != 2 || p2 != 2 || p0 != 1) &&
                                        (p1 != 2 || p4 != 0 || p3 != 0 || p2 != 2 || p0 != 1) &&
                                        (p4 != 0 || p1 != 1 || p0 != 0 || p3 != 0 || p2 != 2) &&
                                        (p4 != 0 || p3 != 2 || p1 != 1 || p0 != 2 || p2 != 2) &&
                                        (p1 != 2 || p2 != 1 || p4 != 0 || p0 != 0 || p3 != 0) &&
                                        (p2 != 0 || p4 != 1 || p0 != 0 || p3 != 0 || p1 != 0) &&
                                        (p2 != 1 || p4 != 0 || p3 != 0 || p0 != 2 || p1 != 0) &&
                                        (p4 != 0 || p3 != 0 || p2 != 2 || p1 != 0 || p0 != 1) &&
                                        (p2 != 1 || p4 != 0 || p0 != 3 || p3 != 0 || p1 != 0) &&
                                        (p2 != 0 || p4 != 0 || p3 != 1 || p0 != 2 || p1 != 0) &&
                                        (p1 != 2 || p2 != 0 || p3 != 2 || p4 != 1 || p0 != 2) &&
                                        (p1 != 2 || p4 != 2 || p3 != 0 || p2 != 2 || p0 != 1) &&
                                        (p1 != 2 || p2 != 0 || p3 != 2 || p4 != 1 || p0 != 0) &&
                                        (p2 != 1 || p3 != 2 || p4 != 2 || p0 != 2 || p1 != 0) &&
                                        (p1 != 2 || p3 != 2 || p4 != 1 || p0 != 2 || p2 != 2) &&
                                        (p1 != 2 || p2 != 1 || p4 != 2 || p0 != 0 || p3 != 0) &&
                                        (p1 != 2 || p3 != 1 || p4 != 2 || p0 != 2 || p2 != 2) &&
                                        (p1 != 2 || p4 != 1 || p3 != 0 || p0 != 2 || p2 != 2) &&
                                        (p2 != 0 || p1 != 1 || p4 != 2 || p3 != 0 || p0 != 2) &&
                                        (p3 != 2 || p4 != 1 || p0 != 2 || p2 != 2 || p1 != 0) &&
                                        (p2 != 0 || p3 != 2 || p1 != 1 || p0 != 3 || p4 != 2) &&
                                        (p4 != 0 || p3 != 1 || p0 != 0 || p2 != 2 || p1 != 0) &&
                                        (p2 != 0 || p3 != 1 || p4 != 2 || p0 != 2 || p1 != 0) &&
                                        (p0 != 3 || p4 != 1 || p3 != 0 || p2 != 2 || p1 != 0) &&
                                        (p1 != 2 || p2 != 1 || p3 != 2 || p4 != 2 || p0 != 2) &&
                                        (p2 != 0 || p4 != 0 || p1 != 1 || p0 != 3 || p3 != 0) &&
                                        (p3 != 2 || p1 != 1 || p4 != 2 || p0 != 2 || p2 != 2) &&
                                        (p1 != 2 || p2 != 1 || p3 != 2 || p4 != 2 || p0 != 0) &&
                                        (p1 != 2 || p2 != 0 || p3 != 2 || p4 != 2 || p0 != 1) &&
                                        (p4 != 0 || p3 != 2 || p1 != 1 || p0 != 0 || p2 != 2) &&
                                        (p0 != 3 || p3 != 1 || p4 != 2 || p2 != 2 || p1 != 0) &&
                                        (p4 != 0 || p3 != 1 || p0 != 2 || p2 != 2 || p1 != 0) &&
                                        (p3 != 1 || p4 != 2 || p0 != 0 || p2 != 2 || p1 != 0) &&
                                        (p3 != 2 || p1 != 1 || p0 != 3 || p4 != 2 || p2 != 2) &&
                                        (p1 != 1 || p4 != 2 || p3 != 0 || p0 != 2 || p2 != 2) &&
                                        (p2 != 1 || p4 != 2 || p0 != 0 || p3 != 0 || p1 != 0) &&
                                        (p1 != 2 || p4 != 1 || p0 != 0 || p3 != 0 || p2 != 2) &&
                                        (p3 != 2 || p4 != 2 || p2 != 2 || p1 != 0 || p0 != 1) &&
                                        (p2 != 0 || p3 != 2 || p4 != 2 || p1 != 0 || p0 != 1) &&
                                        (p3 != 1 || p4 != 2 || p0 != 2 || p2 != 2 || p1 != 0) &&
                                        (p2 != 1 || p0 != 3 || p4 != 2 || p3 != 0 || p1 != 0) &&
                                        (p1 != 2 || p3 != 2 || p0 != 3 || p4 != 1 || p2 != 2) &&
                                        (p2 != 0 || p4 != 2 || p3 != 0 || p1 != 0 || p0 != 1) &&
                                        (p2 != 0 || p4 != 0 || p3 != 1 || p0 != 0 || p1 != 0) &&
                                        (p2 != 1 || p4 != 0 || p3 != 2 || p0 != 3 || p1 != 0) &&
                                        (p3 != 2 || p4 != 1 || p0 != 0 || p2 != 2 || p1 != 0) &&
                                        (p2 != 1 || p3 != 2 || p4 != 2 || p0 != 0 || p1 != 0)
                        ));
    }

    public static Experiment buildModel_Banking1(int strength) {
        System.out.println("INFO: building model 'Banking1' with strength t=" + strength);

        return new Experiment("Banking1 (t=" + strength + ")", buildBaseModel(strength).build());
    }

    public static Experiment buildModel_Banking1_plus10(int strength) {
        System.out.println("INFO: building model 'Banking1+10' with strength t=" + strength);

        InputParameterModel model = buildBaseModel(strength)
                .errorConstraint(constrain("p0", "p1", "p2", "p3", "p4")
                        .by((Integer p0, Integer p1, Integer p2, Integer p3, Integer p4) ->
                                (p2 != 1 || p3 != 2 || p4 != 2 || p0 != 2 || p1 != 0) &&
                                        (p1 != 2 || p3 != 2 || p4 != 1 || p0 != 2 || p2 != 2) &&
                                        (p1 != 2 || p2 != 1 || p4 != 2 || p0 != 0 || p3 != 0) &&
                                        (p1 != 2 || p3 != 1 || p4 != 2 || p0 != 2 || p2 != 2) &&
                                        (p1 != 2 || p4 != 1 || p3 != 0 || p0 != 2 || p2 != 2) &&
                                        (p2 != 0 || p1 != 1 || p4 != 2 || p3 != 0 || p0 != 2) &&
                                        (p3 != 2 || p4 != 1 || p0 != 2 || p2 != 2 || p1 != 0) &&
                                        (p2 != 0 || p3 != 2 || p1 != 1 || p0 != 3 || p4 != 2) &&
                                        (p4 != 0 || p3 != 1 || p0 != 0 || p2 != 2 || p1 != 0) &&
                                        (p2 != 0 || p3 != 1 || p4 != 2 || p0 != 2 || p1 != 0)
                        )).build();

        return new Experiment("Banking1+10 (t=" + strength + ")", model);
    }

    public static Experiment buildModel_Banking1_plus50(int strength) {
        System.out.println("INFO: building model 'Banking1+50' with strength t=" + strength);

        InputParameterModel model = buildBaseModel(strength)
                .errorConstraint(constrain("p0", "p1", "p2", "p3", "p4")
                        .by((Integer p0, Integer p1, Integer p2, Integer p3, Integer p4) ->
                                (p2 != 0 || p3 != 1 || p4 != 2 || p0 != 0 || p1 != 0) &&
                                        (p2 != 1 || p4 != 0 || p3 != 2 || p0 != 2 || p1 != 0) &&
                                        (p4 != 1 || p0 != 0 || p3 != 0 || p2 != 2 || p1 != 0) &&
                                        (p2 != 1 || p4 != 0 || p0 != 0 || p3 != 0 || p1 != 0) &&
                                        (p2 != 0 || p4 != 1 || p3 != 0 || p0 != 2 || p1 != 0) &&
                                        (p4 != 0 || p0 != 3 || p3 != 1 || p2 != 2 || p1 != 0) &&
                                        (p1 != 2 || p4 != 0 || p3 != 2 || p2 != 2 || p0 != 1) &&
                                        (p1 != 2 || p4 != 0 || p3 != 0 || p2 != 2 || p0 != 1) &&
                                        (p4 != 0 || p1 != 1 || p0 != 0 || p3 != 0 || p2 != 2) &&
                                        (p4 != 0 || p3 != 2 || p1 != 1 || p0 != 2 || p2 != 2) &&
                                        (p1 != 2 || p2 != 1 || p4 != 0 || p0 != 0 || p3 != 0) &&
                                        (p2 != 0 || p4 != 1 || p0 != 0 || p3 != 0 || p1 != 0) &&
                                        (p2 != 1 || p4 != 0 || p3 != 0 || p0 != 2 || p1 != 0) &&
                                        (p4 != 0 || p3 != 0 || p2 != 2 || p1 != 0 || p0 != 1) &&
                                        (p2 != 1 || p4 != 0 || p0 != 3 || p3 != 0 || p1 != 0) &&
                                        (p2 != 0 || p4 != 0 || p3 != 1 || p0 != 2 || p1 != 0) &&
                                        (p1 != 2 || p2 != 0 || p3 != 2 || p4 != 1 || p0 != 2) &&
                                        (p1 != 2 || p4 != 2 || p3 != 0 || p2 != 2 || p0 != 1) &&
                                        (p1 != 2 || p2 != 0 || p3 != 2 || p4 != 1 || p0 != 0) &&
                                        (p2 != 1 || p3 != 2 || p4 != 2 || p0 != 2 || p1 != 0) &&
                                        (p1 != 2 || p3 != 2 || p4 != 1 || p0 != 2 || p2 != 2) &&
                                        (p1 != 2 || p2 != 1 || p4 != 2 || p0 != 0 || p3 != 0) &&
                                        (p1 != 2 || p3 != 1 || p4 != 2 || p0 != 2 || p2 != 2) &&
                                        (p1 != 2 || p4 != 1 || p3 != 0 || p0 != 2 || p2 != 2) &&
                                        (p2 != 0 || p1 != 1 || p4 != 2 || p3 != 0 || p0 != 2) &&
                                        (p3 != 2 || p4 != 1 || p0 != 2 || p2 != 2 || p1 != 0) &&
                                        (p2 != 0 || p3 != 2 || p1 != 1 || p0 != 3 || p4 != 2) &&
                                        (p4 != 0 || p3 != 1 || p0 != 0 || p2 != 2 || p1 != 0) &&
                                        (p2 != 0 || p3 != 1 || p4 != 2 || p0 != 2 || p1 != 0) &&
                                        (p0 != 3 || p4 != 1 || p3 != 0 || p2 != 2 || p1 != 0) &&
                                        (p1 != 2 || p2 != 1 || p3 != 2 || p4 != 2 || p0 != 2) &&
                                        (p2 != 0 || p4 != 0 || p1 != 1 || p0 != 3 || p3 != 0) &&
                                        (p3 != 2 || p1 != 1 || p4 != 2 || p0 != 2 || p2 != 2) &&
                                        (p1 != 2 || p2 != 1 || p3 != 2 || p4 != 2 || p0 != 0) &&
                                        (p1 != 2 || p2 != 0 || p3 != 2 || p4 != 2 || p0 != 1) &&
                                        (p4 != 0 || p3 != 2 || p1 != 1 || p0 != 0 || p2 != 2) &&
                                        (p0 != 3 || p3 != 1 || p4 != 2 || p2 != 2 || p1 != 0) &&
                                        (p4 != 0 || p3 != 1 || p0 != 2 || p2 != 2 || p1 != 0) &&
                                        (p3 != 1 || p4 != 2 || p0 != 0 || p2 != 2 || p1 != 0) &&
                                        (p3 != 2 || p1 != 1 || p0 != 3 || p4 != 2 || p2 != 2) &&
                                        (p1 != 1 || p4 != 2 || p3 != 0 || p0 != 2 || p2 != 2) &&
                                        (p2 != 1 || p4 != 2 || p0 != 0 || p3 != 0 || p1 != 0) &&
                                        (p1 != 2 || p4 != 1 || p0 != 0 || p3 != 0 || p2 != 2) &&
                                        (p3 != 2 || p4 != 2 || p2 != 2 || p1 != 0 || p0 != 1) &&
                                        (p2 != 0 || p3 != 2 || p4 != 2 || p1 != 0 || p0 != 1) &&
                                        (p3 != 1 || p4 != 2 || p0 != 2 || p2 != 2 || p1 != 0) &&
                                        (p2 != 1 || p0 != 3 || p4 != 2 || p3 != 0 || p1 != 0) &&
                                        (p1 != 2 || p3 != 2 || p0 != 3 || p4 != 1 || p2 != 2) &&
                                        (p2 != 0 || p4 != 2 || p3 != 0 || p1 != 0 || p0 != 1) &&
                                        (p2 != 0 || p4 != 0 || p3 != 1 || p0 != 0 || p1 != 0)
                        )).build();

        return new Experiment("Banking1+50 (t=" + strength + ")", model);
    }
}