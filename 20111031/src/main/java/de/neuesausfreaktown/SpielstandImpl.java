package de.neuesausfreaktown;

/**
 * Created by IntelliJ IDEA. User: coellen Date: 31.10.11 Time: 06:47 To change this template use File | Settings | File
 * Templates.
 */
public class SpielstandImpl implements Spielstand {

    private static final char CLOSING_BRACKET = '}';
    private int punktestand;

    @Override
    public void wurf(int kegel) {
        if (punktestand == 0) {
            punktestand = kegel;
        } else {
            punktestand += kegel;
        }
    }

    @Override
    public int berechnePunkte() {
        return punktestand;
    }

    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder(32);
        sb.append("SpielstandImpl"); // NON-NLS
        sb.append("{punktestand=").append(punktestand); // NON-NLS
        sb.append(CLOSING_BRACKET); // NON-NLS
        return sb.toString();
    }
}
