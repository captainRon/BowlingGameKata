//
//  Game.m
//  BowlingGames
//
//  Created by Cölle Niels on 03.01.12.
//  Copyright (c) 2012 secunet AG. All rights reserved.
//

#import "Game.h"

@interface Game ()
- (BOOL) isSpare:(int) ballIndex;
- (BOOL) isStrike:(int) ballIndex;
- (int) strikeBonus:(int) ballIndex;
- (int) spareBonus:(int) ballIndex;
- (int) sumOfBallsInFrame:(int) ballIndex;
@end

@implementation Game
- (void) rollWithPinCount:(int)pins {
    rolls[currentRoll++] = pins;
}

- (int) score {
    int score = 0;
    int ballIndex = 0;
    for (int frame = 0; frame < 10; frame++) {
        if ([self isStrike:ballIndex]) { // strike
            score += 10 + [self strikeBonus:ballIndex];
            ++ballIndex;
        } else if ([self isSpare:ballIndex]) {
            score += 10 + [self spareBonus:ballIndex];
            ballIndex += 2;
        } else {
        score += [self sumOfBallsInFrame:ballIndex];
        ballIndex += 2;
        }
    }
    return score;
}

- (BOOL) isSpare:(int) ballIndex {
    return rolls[ballIndex] + rolls[ballIndex + 1] == 10;
}

- (BOOL) isStrike:(int)ballIndex {
    return rolls[ballIndex] == 10;
}

- (int) strikeBonus:(int) ballIndex {
    return rolls[ballIndex + 1] + rolls[ballIndex + 2];
}

- (int) spareBonus:(int) ballIndex {
    return rolls[ballIndex + 2];
}

- (int) sumOfBallsInFrame:(int)ballIndex {
    return rolls[ballIndex] + rolls[ballIndex + 1];
}

@end
