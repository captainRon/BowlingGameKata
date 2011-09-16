/* =====================================================================================================================
 * Copyright (c) 2010, secunet Security Networks AG, Germany
 * ---------------------------------------------------------------------------------------------------------------------
 * $Id$
 * ---------------------------------------------------------------------------------------------------------------------
 * Project: zobel-core
 * =====================================================================================================================
 */
package de.neuesausfreaktown.bowlingkata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author coelle.niels / last coelle.niels
 * @version $ / $
 * @since 1.5
 */
public class Game {
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(final int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += sumOfBinsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private boolean isStrike(final int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private int sumOfBinsInFrame(final int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private int spareBonus(final int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int strikeBonus(final int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private boolean isSpare(final int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }
}
