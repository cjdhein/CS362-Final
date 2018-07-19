/*
 * cardtest3.c
 *
 * Card being tested:	Village
 *
 * Card's Function:		Draws a single card and gives player 2 additional actions.
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
#define NOISY_TEST 1

void resetForTest(struct gameState *game, struct gameState *pre) {

	// set the kingdom cards being used
	int k[10] = {adventurer, gardens, embargo, village, minion, mine, cutpurse, sea_hag, tribute, village};	
	// initialize the game
	initializeGame(4,k,23,game);
	
	// give first player a village card in their hand
	game->hand[0][game->handCount[0]] = village;
	game->handCount[0]++;

	// store initial state in pre
	memset(pre,0,sizeof(struct gameState));
	memcpy(pre,game,sizeof(struct gameState));
	
}

int main(int argc, char *argv[]) {
	struct gameState *game;
	struct gameState *pre;
	game = newGame();
	pre = newGame();
	int villagePos;
	int preCardCount;
	int cardCount;	

	// test 1 - confirm other players were not affected
	//	- no new cards added, no cards removed etc
	resetForTest(game, pre);
	villagePos = game->handCount[0]-1;
	cardEffect(village,-1,-1,-1,game,villagePos,NULL);	
	// loop through players 2-4
	for(int i = 1; i < 4;i++) {
#if NOISY_TEST
		printf("\nChecking memory for changes to player %d.\n",i+1);
#endif
		assertLite(__LINE__,memcmp(game->hand[i],pre->hand[i],sizeof(int)* (int) pre->handCount[i]),0,1);   
		assertLite(__LINE__,memcmp(game->deck[i],pre->deck[i],sizeof(int)* (int) pre->deckCount[i]),0,1);
		assertLite(__LINE__,memcmp(game->discard[i],pre->discard[i],sizeof(int)* (int) pre->discardCount[i]),0,1);
	}	

	// test 2 - confirm player has same number of cards in hand+deck+discard
	resetForTest(game, pre);
	villagePos = game->handCount[0]-1;
	cardEffect(village,-1,-1,-1,game,villagePos,NULL);
#if NOISY_TEST
	printf("\nChecking if player 0 still has same number of cards total (deck + hand + discard)\n");
#endif	
	preCardCount = pre->deckCount[0] + pre->handCount[0] + pre->discardCount[0];
	cardCount = game->deckCount[0] + game->handCount[0] + game->discardCount[0];  
	assertLite(__LINE__,preCardCount,cardCount,1);

	// test 3 - is village card discarded properly?
	//	- card leaves hand
	//	- card ends up in discard
	resetForTest(game, pre);
	villagePos = game->handCount[0]-1;
	cardEffect(village,-1,-1,-1,game,villagePos,NULL);
#if NOISY_TEST
	printf("\nChecking if discard count was increased\n");
#endif
	assertLite(__LINE__,(game->discardCount[0] - pre->discardCount[0]),1,1); // assert new discardCount - old is equal to 1
#if NOISY_TEST
	printf("\nChecking if village is the latest card in discard\n");
#endif
	assertLite(__LINE__,(game->discard[game->discardCount[0]-1]),village,1); // assert the latest card in the discard pile is village

#if NOISY_TEST
		printf("\nChecking if village is still in hand\n");
#endif
	for (int i = 0; i < game->handCount[0];i++){
		assertLite(__LINE__,(game->hand[i]),village,0); // confirm village is no longer in the hand
	}

	int ret;
	return 0;
}


