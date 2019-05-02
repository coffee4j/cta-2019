package de.rwth.swc.cta2019.experiments.models;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import de.rwth.swc.cta2019.experiments.Experiment;

import static de.rwth.swc.coffee4j.model.InputParameterModel.inputParameterModel;
import static de.rwth.swc.coffee4j.model.constraints.ConstraintBuilder.constrain;
import static de.rwth.swc.cta2019.experiments.util.ParametersFactory.parameters;

public class HealthCare4_CombinatorialModel {

    private static InputParameterModel.Builder buildBaseModel(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(7, 1, 6, 1, 5, 2, 4, 6, 3, 12, 2, 13)
                )
                .errorConstraint(constrain("p4", "p19").by((Integer p4, Integer p19) ->
                                ( p19 != 2 || p4 != 3) &&
                                ( p19 != 1 || p4 != 3) &&
                                ( p19 != 0 || p4 != 2) &&
                                ( p19 != 0 || p4 != 1) &&
                                ( p19 != 0 || p4 != 0)
                ))
                .errorConstraint(constrain("p3", "p4").by((Integer p3, Integer p4) ->
                                ( p4 != 2 || p3 != 4) &&
                                ( p3 != 4 || p4 != 0) &&
                                ( p4 != 1 || p3 != 4) &&
                                ( p3 != 0 || p4 != 3)
                ))
                .errorConstraint(constrain("p6", "p34").by((Integer p6, Integer p34) ->
                                ( p6 != 1 || p34 != 0) &&
                                ( p34 != 0 || p6 != 2)
                ))
                .errorConstraint(constrain("p19", "p34").by((Integer p19, Integer p34) ->
                                ( p19 != 2 || p34  != 0)
                ))
                .errorConstraint(constrain("p1", "p19").by((Integer p1, Integer p19) ->
                                ( p19 != 0 || p1 != 5) &&
                                ( p19 != 0 || p1 != 4) &&
                                ( p19 != 0 || p1 != 0) &&
                                ( p19 != 0 || p1 != 3) &&
                                ( p19 != 0 || p1 != 2)
                ))
                .errorConstraint(constrain("p6", "p17").by((Integer p6, Integer p17) ->
                                ( p6 != 0 || p17 != 2) &&
                                ( p6 != 0 || p17 != 1)
                ))
                .errorConstraint(constrain("p3", "p4").by((Integer p3, Integer p4) ->
                                ( p3 != 1 || p4 != 3) &&
                                ( p3 != 3 || p4 != 3) &&
                                ( p3 != 2 || p4 != 3)
                ))
                ;
    }

    public static Experiment buildModel_HealthCare4(int strength) {
        System.out.println("INFO: building model 'HealthCare4' with strength t=" + strength);

        return new Experiment("HealthCare4 (t=" + strength + ")", buildBaseModel(strength).build());
    }

    public static Experiment buildModel_HealthCare4_Plus3_Plus4(int strength) {
        System.out.println("INFO: building model 'HealthCare4+3+4+5' with strength t=" + strength);

        InputParameterModel model = buildBaseModel(strength)
                        .errorConstraint(constrain("p4", "p19").by((Integer p4, Integer p19) ->
                                        ( p19 != 1 || p4 != 3) &&
                                        ( p19 != 0 || p4 != 2) &&
                                        ( p19 != 0 || p4 != 1) &&
                                        ( p19 != 0 || p4 != 0)
                        ))
                        .errorConstraint(constrain("p3", "p4").by((Integer p3, Integer p4) ->
                                        ( p3 != 4 || p4 != 0) &&
                                        ( p4 != 1 || p3 != 4) &&
                                        ( p3 != 0 || p4 != 3)
                        )
        ).build();

        return new Experiment("HealthCare4+3+4+5 (t=" + strength + ")", model);
    }
}
