package de.rwth.swc.cta2019.experiments;


import de.rwth.swc.coffee4j.model.InputParameterModel;

public class Experiment {
    
    private final String title;
    private final InputParameterModel model;

    public Experiment(String title, InputParameterModel ipm) {
        this.title = title;
        this.model = ipm;
    }

    public String getTitle() {
        return title;
    }

    public InputParameterModel getModel() {
        return model;
    }

    @Override
    public String toString() {
        return title;
    }
}
