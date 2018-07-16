/*
 * unittest4.c
 * Testing gainCard function.
 * 
 * Include in makefile:
 *
 * unittest4: unittest4.c dominion.o rngs.o testutils.o
 *      gcc -o unittest4 -g unittest4.c dominion.o rngs.o testutils.o $(CFLAGS)
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
#define NOISY_TEST 1

#define COPYSTATE\
	preDiscardCount = game->discardCount[player];\
	memcpy(preDiscard,game->discard[player],(sizeof(int)*MAX_HAND));\
	preHandCount = game->handCount[player];\
	memcpy(preHand,game->hand[player],(sizeof(int)*MAX_HAND));\
	preDeckCount = game->deckCount[player];\
	memcpy(preDeck,game->deck[player],(sizeof(int)*MAX_HAND)); \



int main(int argc, char *argv[]) {
	struct gameState *game;
	game = newGame();
	int ret;
	int supplyPos;
	int toFlag;
	int player = 0;
	int preSupplyCount;
	int preDiscardCount;
	int preDiscard[MAX_DECK];
	int preHandCount;
	int preHand[MAX_DECK];
	int preDeckCount;
	int preDeck[MAX_DECK];

	// Test gainCard with valid supply to discard
	preSupplyCount = 10;
	game->supplyCount[estate] = preSupplyCount;	// set to valid supply
	toFlag = 0; //	set to discard

	COPYSTATE;

	ret = gainCard(estate, game, toFlag, player);
	// Asserts - return is 0, supplyCount was decremented, and discard updated
	assertLite(__LINE__, ret, 0,1);	// assert return is 0
	assertLite(__LINE__, (preSupplyCount - game->supplyCount[estate]),1,1); // assert new supply is one less than previous
	assertLite(__LINE__, (preDiscardCount - game->discardCount[player]),-1,1); // new discard count should be 1 greater than prev
	assertLite(__LINE__, (preHandCount - game->handCount[player]),0,1); // new handCount should be same as old
	assertLite(__LINE__, (preDeckCount - game->deckCount[player]),0,1); // new deckCount should be same as old
	assertLite(__LINE__, memcmp(preDiscard,game->discard[player],(sizeof(int)*MAX_HAND)),0,0); // confirm new discard is different from old
	assertLite(__LINE__, estate, game->discard[player][game->discardCount[player]-1],1); // top of discard should be the gained card	
	assertLite(__LINE__, memcmp(preDeck,game->deck[player],(sizeof(int)*MAX_HAND)),0,1); // assert deck is unchanged
	assertLite(__LINE__, memcmp(preHand,game->hand[player],(sizeof(int)*MAX_HAND)),0,1); // assert hand is unchanged

    return 0;
}


