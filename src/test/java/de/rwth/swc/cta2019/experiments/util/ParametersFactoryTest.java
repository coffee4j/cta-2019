package de.rwth.swc.cta2019.experiments.util;

import de.rwth.swc.coffee4j.model.Parameter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParametersFactoryTest {

    @Test
    void testCorrectLengthParameters() {
        Parameter[] parameters = ParametersFactory.parameters(2, 2, 3, 3, 4, 4);

        assertEquals(9, parameters.length);
    }

    @Test
    void testCorrectOrderOfParameters() {
        Parameter[] parameters = ParametersFactory.parameters(2, 2, 3, 3, 4, 4);

        assertEquals("p0", parameters[0].getName());
        assertEquals("p4", parameters[4].getName());
    }

    @Test
    void testCorrectSizeOfParameters() {
        Parameter[] parameters = ParametersFactory.parameters(2, 2, 3, 3, 4, 4);

        assertEquals(2, parameters[0].getValues().size());
        assertEquals(2, parameters[1].getValues().size());
        assertEquals(3, parameters[2].getValues().size());
        assertEquals(3, parameters[4].getValues().size());
        assertEquals(4, parameters[5].getValues().size());
    }
}
