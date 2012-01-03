//
//  Game.h
//  BowlingGames
//
//  Created by Cölle Niels on 03.01.12.
//  Copyright (c) 2012 secunet AG. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Game : NSObject {
    int rolls[21];
    int currentRoll;
}

- (void) rollWithPinCount:(int) pins;
- (int) score;
- (BOOL) isSpare:(int) ballIndex;
@end
