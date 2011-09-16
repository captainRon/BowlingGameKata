/* =====================================================================================================================
 * Copyright (c) 2010, secunet Security Networks AG, Germany
 * ---------------------------------------------------------------------------------------------------------------------
 * $Id$
 * ---------------------------------------------------------------------------------------------------------------------
 * Project: zobel-core
 * =====================================================================================================================
 */
package de.neuesausfreaktown.bowlingkata;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author coelle.niels / last coelle.niels
 * @version 1$ / 20110915$
 * @since 1.5
 */
public class BowlingGameTest {

    protected Game g;

    @Before
    public void setUp() throws Exception {
        g = new Game();
    }

    @Test
    public void allGutters() {
        final int rolls = 20;
        final int pins = 0;

        rollMany(rolls, pins);

        assertThat(g.score(), is(0));
    }

    @Test
    public void allOnes() {
        final int rolls = 20;
        final int pins = 1;

        rollMany(rolls, pins);
        assertThat(g.score(), is(20));
    }

    @Test
    public void oneSpareRoundRestGutter() {
        rollSpare();
        g.roll(3);
        rollMany(17, 0);
        assertThat(g.score(), is(16));
    }

    @Test
    public void oneStrike() {
        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(16, 0);
        assertThat(g.score(), is(24));
    }

    @Test
    public void perfectGame() {
        rollMany(12, 10);
        assertThat(g.score(), is(300));
    }

    private void rollStrike() {
        g.roll(10);
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }

    private void rollMany(final int rolls, final int pins) {
        for (int i = 0; i < rolls; i++) {
            g.roll(pins);
        }
    }
}
