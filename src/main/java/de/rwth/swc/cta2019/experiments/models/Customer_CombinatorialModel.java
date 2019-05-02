package de.rwth.swc.cta2019.experiments.models;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import de.rwth.swc.cta2019.experiments.Experiment;

import java.util.Arrays;

import static de.rwth.swc.coffee4j.model.InputParameterModel.inputParameterModel;
import static de.rwth.swc.coffee4j.model.Parameter.parameter;
import static de.rwth.swc.coffee4j.model.constraints.ConstraintBuilder.constrain;
import static de.rwth.swc.cta2019.experiments.util.ConstraintsHelper.implies;

public class Customer_CombinatorialModel {

    private static InputParameterModel.Builder buildBaseModel(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameter("VIP").values(true, false)
                        , parameter("Mitarbeiter").values(true, false)
                        , parameter("Anrede").values("Herr", "Frau")
                        , parameter("Name").values("Stegmann", "2352155", "Edmund", "Thomas")
                        , parameter("Vorname").values("Edmund", "Sabine", "21051221", "Stegmann")
                        , parameter("Geschlecht").values("M", "W")
                        , parameter("Geburtsname").values("x", "LEER")
                        , parameter("Geburtsort").values("LEER", "2125")
                        , parameter("Geburtsland").values("x", "LEER")
                        , parameter("Familienstand").values("x", "Zusammenlebend")
                        , parameter("StatusAntrag").values(true, false)
                        , parameter("Komm-Strasse").values("Altes Wehr 1", "Schurzelter-Str. 479", "Schurzelter-Str. 481", "LEER")
                        , parameter("Komm-PLZ").values("51688", "52066", "52074", "B5207", "520745", "LEER")
                        , parameter("Komm-Ort").values("Wipperfürth", "Aachen", "LEER")
                        , parameter("Geburtsdatum").values("15.04.1990", "LEER", "01.01.2099", "01.01.1900")
                ).errorConstraints(
                        constrain("Anrede", "Vorname").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Frau"),
                                        () -> !vorname.equals("Edmund"))
                        )
                        , constrain("Anrede", "Vorname").by((String anrede, String vorname) ->
                                implies(() -> anrede.equals("Herr"),
                                        () -> !vorname.equals("Sabine"))
                        )
                        , constrain("Anrede", "Geschlecht").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Frau"),
                                        () -> !geschlecht.equals("M"))
                        )
                        , constrain("Anrede", "Geschlecht").by((String anrede, String geschlecht) ->
                                implies(() -> anrede.equals("Herr"),
                                        () -> !geschlecht.equals("W"))
                        )
                        , constrain("Name").by((String name) ->
                                !name.equals("2352155")
                        )
                        , constrain("Name").by((String name) ->
                                !name.equals("Thomas")
                        )
                        , constrain("Name", "Vorname").by((String name, String vorname) ->
                                !name.equals("Edmund") && !vorname.equals("Stegmann")
                        )
                        , constrain("Geburtsort").by((String geburtsort) ->
                                !geburtsort.equals("2125")
                        )
                        , constrain("Geburtsdatum").by((String geburtsdatum) ->
                                !geburtsdatum.equals("LEER")
                        )
                        , constrain("Geburtsdatum").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.2099")
                        )
                        , constrain("Geburtsdatum").by((String geburtsdatum) ->
                                !geburtsdatum.equals("01.01.1900")
                        )
                        , constrain("Komm-PLZ").by((String kommPlz) ->
                                !Arrays.asList("B5207", "520745", "LEER").contains(kommPlz)
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Altes Wehr 1"),
                                        () -> plz.equals("51688"))
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").by((String plz, String ort) ->
                                implies(() -> plz.equals("51688"),
                                        () -> ort.equals("Wipperfürth"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Schurzelter-Str. 479"),
                                        () -> plz.equals("52066"))
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").by((String plz, String ort) ->
                                implies(() -> plz.equals("52066"),
                                        () -> ort.equals("Aachen"))
                        )
                        , constrain("Komm-Strasse", "Komm-PLZ").by((String strasse, String plz) ->
                                implies(() -> strasse.equals("Schurzelter-Str. 481"),
                                        () -> plz.equals("52074"))
                        )
                        , constrain("Komm-PLZ", "Komm-Ort").by((String plz, String ort) ->
                                implies(() -> plz.equals("52074"),
                                        () -> ort.equals("Aachen"))
                        )
                )
                ;
    }

    public static Experiment buildModel_Customer(int strength) {
        System.out.println("INFO: building model 'Customer' with strength t=" + strength);

        return new Experiment("Customer (t=" + strength + ")", buildBaseModel(strength).build());
    }
}
