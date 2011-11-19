package de.neuesausfreaktown;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SpielstandTest {
    @Test
    public void zweiPumpenSind0Punkte() {
        Spielstand spielstand = new SpielstandImpl();
        spieleRunde(spielstand, 0, 0);

        int punkte = spielstand.berechnePunkte();

        assertThat(punkte, is(0));
    }

    @Test
    public void einePumpeUndEinKegelSind1Punkt() {
        Spielstand spielstand = new SpielstandImpl();
        spieleRunde(spielstand, 0, 1);
        int punkte = spielstand.berechnePunkte();

        assertThat(punkte, is(1));
    }

    @Test
    public void einKegelUndEinKegelSind2Punkte() {
        Spielstand spielstand = new SpielstandImpl();
        spieleRunde(spielstand, 1, 1);

        int punkte = spielstand.berechnePunkte();
        assertThat(punkte, is(2));
    }

    @Test
    public void nurPumpenSind0Punkte() {
        Spielstand spielstand = new SpielstandImpl();
        spieleRunde(spielstand, 0, 0);
        spieleRunde(spielstand, 0, 0);
        spieleRunde(spielstand, 0, 0);
        spieleRunde(spielstand, 0, 0);
        spieleRunde(spielstand, 0, 0);
        spieleRunde(spielstand, 0, 0);
        spieleRunde(spielstand, 0, 0);
        spieleRunde(spielstand, 0, 0);
        spieleRunde(spielstand, 0, 0);
        spieleRunde(spielstand, 0, 0);
        int punkte = spielstand.berechnePunkte();

        assertThat(punkte, is(0));
    }

    @Test
    public void nurEinsenSind20Punkte() {
        Spielstand spielstand = new SpielstandImpl();
        spieleRunde(spielstand, 1, 1);
        spieleRunde(spielstand, 1, 1);
        spieleRunde(spielstand, 1, 1);
        spieleRunde(spielstand, 1, 1);
        spieleRunde(spielstand, 1, 1);
        spieleRunde(spielstand, 1, 1);
        spieleRunde(spielstand, 1, 1);
        spieleRunde(spielstand, 1, 1);
        spieleRunde(spielstand, 1, 1);
        spieleRunde(spielstand, 1, 1);
        int punkte = spielstand.berechnePunkte();

        assertThat(punkte, is(20));
    }

    private void spieleRunde(Spielstand spielstand, int ersterWurf, int zweiterWurf) {
        spielstand.wurf(ersterWurf);
        spielstand.wurf(zweiterWurf);
    }
}
