package de.rwth.swc.cta2019.experiments.util;

import java.util.function.Supplier;

public class ConstraintsHelper {
    
    private ConstraintsHelper() {
    }

    public static boolean implies(Supplier<Boolean> first, Supplier<Boolean> second) {
        if (first.get()) return second.get();
        else return true;
    }

    public static boolean biimplies(Supplier<Boolean> first, Supplier<Boolean> second) {
        if (first.get()) return second.get();
        else if (second.get()) return first.get();
        else return true;
    }
}
