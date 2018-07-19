/*
 * cardtest3.c
 *
 * Card being tested:	Adventurer
 *
 * Card's Function:		Draw cards from deck until 2 treasure cards are revealed.
 *					Place them in your hand and discard the other revealed cards.
 *
 * 
 * Include in makefile:
 *
 * cardtest3: cardtest3.c dominion.o rngs.o testutils.o
 *      gcc -o cardtest3 -g cardtest3.c dominion.o rngs.o testutils.o $(CFLAGS)
 *
 */

#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include "dominion.h"
#include "dominion_helpers.h"
#include "rngs.h"
#include "testutils.h"

// set NOISY_TEST to 0 to remove printfs from output
#define NOISY_TEST 0

int main(int argc, char *argv[]) {
	struct gameState *game;
	struct gameState *pre;
	game = newGame();
	pre = newGame();

	int ret;
    return 0;
}


