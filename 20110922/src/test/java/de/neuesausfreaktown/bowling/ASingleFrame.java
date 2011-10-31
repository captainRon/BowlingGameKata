package de.neuesausfreaktown.bowling;

import org.jmock.Mockery;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class ASingleFrame {
    private final Mockery context = new Mockery();
    @Test
    public void shouldHaveNoPointsWithTwoGutters() throws Exception {
        BowlingLane lane = context.mock(BowlingLane.class);

        BowlingFrame frame = new BowlingFrame(lane);
        lane.pins(0);
        lane.pins(0);

        Assert.assertThat(frame.pinsSum(), is(0));
    }
}
