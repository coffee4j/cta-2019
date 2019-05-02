package de.rwth.swc.cta2019.experiments.util;

import de.rwth.swc.coffee4j.engine.util.Preconditions;
import de.rwth.swc.coffee4j.model.Parameter;

import java.util.ArrayList;
import java.util.List;

import static de.rwth.swc.coffee4j.model.Parameter.parameter;

public class ParametersFactory {
    
    private ParametersFactory() {
    }

    public static Parameter[] parameters(int... configuration) {
        Preconditions.check(configuration.length % 2 == 0);

        int counter = 0;

        final List<Parameter> parameters = new ArrayList<>();

        for(int i = 0; i < configuration.length; i += 2) {
            final int valueSize = configuration[i];
            final int parameterSize = configuration[i + 1];

            Object[] values = new Object[valueSize];
            for (int v = 0; v < valueSize; v++) {
                values[v] = v;
            }

            for(int j = 0; j < parameterSize; j++) {
                parameters.add(parameter("p" + counter++).values(values).build());
            }
        }

        return parameters.toArray(new Parameter[0]);
    }
}
