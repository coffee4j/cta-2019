package de.rwth.swc.cta2019.experiments;

import de.rwth.swc.coffee4j.engine.TupleList;
import de.rwth.swc.coffee4j.engine.generator.ipog.Ipog;
import de.rwth.swc.coffee4j.engine.generator.negative.IpogNeg;
import de.rwth.swc.coffee4j.model.Combination;
import de.rwth.swc.coffee4j.model.InputParameterModel;
import de.rwth.swc.coffee4j.model.TestInputGroupContext;
import de.rwth.swc.coffee4j.model.manager.CombinatorialTestExecutionManager;
import de.rwth.swc.coffee4j.model.report.ExecutionReporter;
import de.rwth.swc.coffee4j.model.report.NoExecutionReporter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static de.rwth.swc.coffee4j.model.diagnosis.ConstraintDiagnosisConfiguration.disable;
import static de.rwth.swc.coffee4j.model.diagnosis.ConstraintDiagnosisConfiguration.enableButDoNotSkip;
import static de.rwth.swc.coffee4j.model.manager.CombinatorialTestConsumerManagerConfiguration.consumerManagerConfiguration;
import static de.rwth.swc.cta2019.experiments.models.Apache_CombinatorialModel.buildModel_Apache;
import static de.rwth.swc.cta2019.experiments.models.Banking1_CombinatorialModel.*;
import static de.rwth.swc.cta2019.experiments.models.Banking2_CombinatorialModel.*;
import static de.rwth.swc.cta2019.experiments.models.Customer_CombinatorialModel.buildModel_Customer;
import static de.rwth.swc.cta2019.experiments.models.Example1_CombinatorialModel.buildModel_Example1;
import static de.rwth.swc.cta2019.experiments.models.Example2_CombinatorialModel.buildModel_Example2;
import static de.rwth.swc.cta2019.experiments.models.HealthCare3_CombinatorialModel.buildModel_HealthCare3;
import static de.rwth.swc.cta2019.experiments.models.HealthCare3_CombinatorialModel.buildModel_HealthCare3_Plus3_Plus4_Plus5;
import static de.rwth.swc.cta2019.experiments.models.HealthCare4_CombinatorialModel.buildModel_HealthCare4;
import static de.rwth.swc.cta2019.experiments.models.HealthCare4_CombinatorialModel.buildModel_HealthCare4_Plus3_Plus4;

class ExperimentTest {

    private static final int WARM_UP = 15;
    private static final int EXECUTION = 30;
    
    private static final ExecutionReporter REPORTER = new NoExecutionReporter() {
        @Override
        public void testInputGroupGenerated(TestInputGroupContext context, List<Combination> testInputs) {

            String identifier;
            if(context.getIdentifier() instanceof String) {
                identifier = (String) context.getIdentifier();
            } else if(context.getIdentifier() instanceof TupleList) {
                identifier = String.valueOf(((TupleList) context.getIdentifier()).getId());
            } else {
                identifier = context.getIdentifier().toString();
            }

            System.out.println(testInputs.size() + " TestInputs generated for " + identifier);
        }
    };

    private static Experiment[] EXPERIMENTS = {
            //  buildModel_Apache(1)
             buildModel_Example1(1)
            , buildModel_Example2(1)
            , buildModel_Customer(1)
            , buildModel_Banking1(1)
            , buildModel_Banking1_plus10(1)
            , buildModel_Banking1_plus50(1)
            , buildModel_Banking2(1)
            , buildModel_Banking2_Plus1(1)
            , buildModel_Banking2_Plus1_Plus1(1)
            , buildModel_HealthCare3(1)
            , buildModel_HealthCare3_Plus3_Plus4_Plus5(1)
            , buildModel_HealthCare4(1)
            , buildModel_HealthCare4_Plus3_Plus4(1)

            //, buildModel_Apache(2)
            , buildModel_Example1(2)
            , buildModel_Example2(2)
            , buildModel_Customer(2)
            , buildModel_Banking1(2)
            , buildModel_Banking1_plus10(2)
            , buildModel_Banking1_plus50(2)
            , buildModel_Banking2(2)
            , buildModel_Banking2_Plus1(2)
            , buildModel_Banking2_Plus1_Plus1(2)
            , buildModel_HealthCare3(2)
            , buildModel_HealthCare3_Plus3_Plus4_Plus5(2)
            , buildModel_HealthCare4(2)
            , buildModel_HealthCare4_Plus3_Plus4(2)
    };

    private static Stream<Arguments> modelProvider() {
        return Stream.of(EXPERIMENTS).map(Arguments::of);
    }

    private static void generate(InputParameterModel inputParameterModel, boolean enableDiagnosis) {
        final CombinatorialTestExecutionManager executor = new CombinatorialTestExecutionManager(
                consumerManagerConfiguration()
                        .executionReporter(REPORTER)
                        .generators(new Ipog(), new IpogNeg())
                        .setConstraintDiagnosisConfiguration(
                                enableDiagnosis ? enableButDoNotSkip() : disable()
                        )
                        .build(),
                (Combination testInput) -> {},
                inputParameterModel
        );

        executor.execute();
    }

    @BeforeAll
    private static void warmup() {
        System.out.println("EXPERIMENT: begin warmup");

        for(Experiment experiment : EXPERIMENTS) {
            run(experiment.getTitle() + "(Enabled)  (Warmup) ", () -> generate(experiment.getModel(), true), WARM_UP);
            run(experiment.getTitle() + "(Disabled) (Warmup) ", () -> generate(experiment.getModel(), false), WARM_UP);
        }

        System.out.println("EXPERIMENT: finish warmup");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    @ParameterizedTest
    @MethodSource("modelProvider")
    void testExperiment(final Experiment experiment) {
        run(experiment.getTitle() + "(Enabled)", () -> generate(experiment.getModel(), true), EXECUTION);
        run(experiment.getTitle() + "(Disabled)", () -> generate(experiment.getModel(), false), EXECUTION);

        System.out.println();
    }

    private static void run(final String title, final Runnable runnable, final int repetitions) {
        System.out.println("EXPERIMENT: " + title);

        final long times[] = new long[repetitions];

        for (int i = 0; i < times.length; i++) {
            final long begin = System.nanoTime();

            runnable.run();
            final long end = System.nanoTime() - begin;

            times[i] = TimeUnit.MILLISECONDS.convert(end, TimeUnit.NANOSECONDS);

            System.out.println();
        }

        final double average = Arrays.stream(times).average().orElse(Double.NaN);

        System.out.printf("Average Time: %.2f ms.\t", average);
        System.out.println();
    }
}
