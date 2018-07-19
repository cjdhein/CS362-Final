/*
 * cardtest1.c
 *
 * Card being tested:	Smithy
 *
 * Card's Function:		Draw three cards from player's deck to their hand
 *
 * 
 * Include in makefile:
 *
 * cardtest1: cardtest1.c dominion.o rngs.o testutils.o
 *      gcc -o cardtest1 -g cardtest1.c dominion.o rngs.o testutils.o $(CFLAGS)
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

void resetForTest(struct gameState *game, struct gameState *pre) {

	// set the kingdom cards being used
	int k[10] = {adventurer, gardens, embargo, village, minion, mine, cutpurse, sea_hag, tribute, smithy};	
	// initialize the game
	initializeGame(4,k,23,game);
	
	// give first player a smithy card in their hand
	game->hand[0][game->handCount[0]] = smithy;
	game->handCount[0]++;

	// store initial state in pre
	memset(pre,0,sizeof(struct gameState));
	memcpy(pre,game,sizeof(struct gameState));
	
}

void printHand(struct gameState *game) {
	printf("Hand:\n");
	for(int i = 0; i < game->handCount[0];i++){
		printf("%d, ",game->hand[0][i]);
	}
	printf("\n");
}

void printDiscard(struct gameState *game) {
	printf("Discard:\n");
	for(int i = 0; i < game->discardCount[0];i++){
		printf("%d, ",game->discard[0][i]);
	}
	printf("\n");
}
void printDeck(struct gameState *game) {
	printf("Deck:\n");
	for(int i = 0; i < game->deckCount[0];i++){
		printf("%d, ",game->deck[0][i]);
	}
	printf("\n");
}


int main(int argc, char *argv[]) {
	struct gameState *game;
	struct gameState *pre;
	game = newGame();
	pre = newGame();

	int ret;
	int smithyPos;
	int preCardCount;
	int cardCount;

	// test 1 - confirm other players were not affected
	//	- no new cards added, no cards removed etc
	resetForTest(game, pre);
	smithyPos = game->handCount[0]-1;
	cardEffect(smithy,-1,-1,-1,game,smithyPos,NULL);

	for(int i = 1; i < 4;i++) {
#if NOISY_TEST
		printf("\nChecking memory for changes to player %d.\n",i+1);
#endif
		assertLite(__LINE__,memcmp(game->hand[i],pre->hand[i],sizeof(int)* (int) pre->handCount[i]),0,1);   
		assertLite(__LINE__,memcmp(game->deck[i],pre->deck[i],sizeof(int)* (int) pre->deckCount[i]),0,1);
		assertLite(__LINE__,memcmp(game->discard[i],pre->discard[i],sizeof(int)* (int) pre->discardCount[i]),0,1);
	}

	// test 2 - confirm player has same number of cards (none removed from game or added)
	resetForTest(game, pre);
	smithyPos = game->handCount[0]-1;
	cardEffect(smithy,-1,-1,-1,game,smithyPos,NULL);
#if NOISY_TEST
	printf("\nChecking if player 0 still has same number of cards total (deck + hand + discard)\n");
#endif	
	preCardCount = pre->deckCount[0] + pre->handCount[0] + pre->discardCount[0];
	cardCount = game->deckCount[0] + game->handCount[0] + game->discardCount[0];  
	assertLite(__LINE__,preCardCount,cardCount,1);	

	// test 3 - is smithy card discarded properly?
	//	- card leaves hand
	//	- card ends up in discard
	resetForTest(game, pre);
	smithyPos = game->handCount[0]-1;
	cardEffect(smithy,-1,-1,-1,game,smithyPos,NULL);
#if NOISY_TEST
	printf("\nChecking if discard count was increased\n");
#endif
	assertLite(__LINE__,(game->discardCount[0] - pre->discardCount[0]),1,1); // assert new discardCount - old is equal to 1
#if NOISY_TEST
	printf("\nChecking if smithy is the latest card in discard\n");
#endif
	assertLite(__LINE__,(game->discard[game->discardCount[0]-1]),smithy,1); // assert the latest card in the discard pile is smithy

#if NOISY_TEST
		printf("\nChecking if smithy is still in hand\n");
#endif
	for (int i = 0; i < game->handCount[0];i++){
		assertLite(__LINE__,(game->hand[i]),smithy,0); // confirm smithy is no longer in the hand
	}

	// test 4 - were 3 cards added to the hand and removed from the deck
	//	- deckCount drops by 3 cards
	//	- handCount goes up by 2 cards (accounting for smithy being removed)
	resetForTest(game, pre);
	smithyPos = game->handCount[0]-1;
	cardEffect(smithy,-1,-1,-1,game,smithyPos,NULL);

#if NOISY_TEST
	printf("\nChecking for deckCount decrease by three...\n");
#endif
	assertLite(__LINE__,(pre->deckCount[0] - game->deckCount[0]),3,1);
#if NOISY_TEST
	printf("\nChecking for handCount increase by two...\n");
#endif
	assertLite(__LINE__,(game->handCount[0] - pre->handCount[0]),2,1);
 
	// test 5 - ensure supply was not affected
	// memory state of supply is same now as before
	resetForTest(game, pre);
	smithyPos = game->handCount[0]-1;
	cardEffect(smithy,-1,-1,-1,game,smithyPos,NULL);

#if NOISY_TEST
	printf("\nChecking for no change in supply...\n");
#endif
	assertLite(__LINE__,memcmp(game->supplyCount,pre->supplyCount,(sizeof(int)*(treasure_map+1))),0,1);

	// test 6 - confirm scores for all plays are unchanged
	resetForTest(game, pre);
	smithyPos = game->handCount[0]-1;
	cardEffect(smithy,-1,-1,-1,game,smithyPos,NULL);

	for(int i = 0; i < 4;i++) {
#if NOISY_TEST
		printf("\nChecking score unchanged for player %d.\n",i+1);
#endif
		assertLite(__LINE__,scoreFor(i,game),scoreFor(i,pre),1);
	}

	printf("All tests complete.\n");

    return 0;
}


