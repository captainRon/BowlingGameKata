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

import org.junit.Test;

/**
 * @author coelle.niels / last coelle.niels
 * @version 1$ / 20110915$
 * @since 1.5
 */
public class BowlingGameTest {
    @Test
    public void testGutterGame() {
        Game g = new Game();

        for (int i = 0; i < 20; i++) {
            g.roll(0);
        }

        assertThat(g.score(), is(0));
    }
}
