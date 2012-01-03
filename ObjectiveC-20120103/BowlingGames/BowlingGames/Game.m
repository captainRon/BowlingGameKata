//
//  Game.m
//  BowlingGames
//
//  Created by Cölle Niels on 03.01.12.
//  Copyright (c) 2012 secunet AG. All rights reserved.
//

#import "Game.h"

@implementation Game
- (void) rollWithPinCount:(int)pins {
    rolls[currentRoll++] = pins;
}

- (int) score {
    int score = 0;
    int ballInFrame = 0;
    for (int frame = 0; frame < 10; frame++) {
        if (rolls[ballInFrame] + rolls[ballInFrame + 1] == 10) {
            score += 10 + rolls[ballInFrame + 2];
            ballInFrame += 2;
        } else {
        score += rolls[ballInFrame] + rolls[ballInFrame + 1];
        ballInFrame += 2;
        }
    }
    return score;
}
@end
