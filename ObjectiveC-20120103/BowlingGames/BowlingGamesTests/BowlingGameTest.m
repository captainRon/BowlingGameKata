//
//  BowlingGames - BowlingGameTest.m
//  Copyright 2012 secunet AG. All rights reserved.
//
//  Created by: Cölle Niels
//

    // Class under test
#import "Game.h"

    // Collaborators

    // Test support
#import <SenTestingKit/SenTestingKit.h>

// Uncomment the next two lines to use OCHamcrest for test assertions:
//#define HC_SHORTHAND
//#import <OCHamcrestIOS/OCHamcrestIOS.h>


@interface BowlingGameTest : SenTestCase
{
    Game *game;
}
@end


@implementation BowlingGameTest
- (void) setUp {
    [super setUp];
    game = [[Game alloc] init];
}

- (void) tearDown {
    [game release];
    [super tearDown];
}

- (void)rollPins:(int)pins times:(int)n {
    for (int i = 0; i < n; i++) {
        [game rollWithPinCount:pins];
    }
}

- (void)rollSpare {
    [game rollWithPinCount:5];
    [game rollWithPinCount:5];
}


- (void) testGutterGame {
    [self rollPins:0 times:20];

    STAssertEquals([game score], 0, nil);
}

-(void) testAllOnes {
    [self rollPins:1 times:20];

    STAssertEquals([game score], 20, nil);    
}

- (void) testOneSpare {
    [self rollSpare];
    [game rollWithPinCount:3];
    [self rollPins:0 times:17];

    STAssertEquals([game score], 16, nil);
}
@end
