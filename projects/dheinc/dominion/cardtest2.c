/*
 * cardtest2.c
 *
 * Card being tested:	Adventurer
 *
 * Card's Function:		Draw cards from deck until 2 treasure cards are revealed.
 *					Place them in your hand and discard the other revealed cards.
 *
 * 
 * Include in makefile:
 *
 * cardtest2: cardtest2.c dominion.o rngs.o testutils.o
 *      gcc -o cardtest2 -g cardtest2.c dominion.o rngs.o testutils.o $(CFLAGS)
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
	int k[10] = {smithy, gardens, embargo, village, minion, mine, cutpurse, sea_hag, tribute, adventurer};	
	// initialize the game
	initializeGame(4,k,23,game);
	
	// give first player a adventurer card in their hand
	game->hand[0][game->handCount[0]] = adventurer;
	game->handCount[0]++;

	// store initial state in pre
	memset(pre,0,sizeof(struct gameState));
	memcpy(pre,game,sizeof(struct gameState));
	
}

int countTreasure(struct gameState *game) {
	int count = 0;
	int card;
	for(int i = 0; i < game->handCount[0]; i++) {
		card = game->hand[0][i];
		switch(card){
			case copper:
			case silver:
			case gold:
				count++;
			default:
				break;
		}
	}
	return count;
}


int main(int argc, char *argv[]) {
	struct gameState *game;
	struct gameState *pre;
	game = newGame();
	pre = newGame();
	int adventurerPos;
	int preCardCount;
	int cardCount;	

	// test 1 - confirm other players were not affected
	//	- no new cards added, no cards removed etc
	resetForTest(game, pre);
	adventurerPos = game->handCount[0]-1;
	cardEffect(adventurer,-1,-1,-1,game,adventurerPos,NULL);	

	// test 2 - confirm player has same number of cards in hand+deck+discard
	resetForTest(game, pre);
	adventurerPos = game->handCount[0]-1;
	cardEffect(adventurer,-1,-1,-1,game,adventurerPos,NULL);
#if NOISY_TEST
	printf("\nChecking if player 0 still has same number of cards total (deck + hand + discard)\n");
#endif	
	preCardCount = pre->deckCount[0] + pre->handCount[0] + pre->discardCount[0];
	cardCount = game->deckCount[0] + game->handCount[0] + game->discardCount[0];  
	assertLite(__LINE__,preCardCount,cardCount,1);

	// test 3 - is adventurer card discarded properly?
	//	- card leaves hand
	//	- card ends up in discard
	resetForTest(game, pre);
	adventurerPos = game->handCount[0]-1;
	cardEffect(adventurer,-1,-1,-1,game,adventurerPos,NULL);

#if NOISY_TEST
		printf("\nChecking if adventurer is still in hand\n");
#endif 
	for (int i = 0; i < game->handCount[0];i++){
		assertLite(__LINE__,(game->hand[i]),adventurer,0); // confirm adventurer is no longer in the hand
	}

	// test 4 - were two treasure cards added to player's hand?
	//	- handCount up by one (account for discarding adventurer)
	//	- count of old treasure cards is two less than count of new
	resetForTest(game, pre);
	adventurerPos = game->handCount[0]-1;
	cardEffect(adventurer,-1,-1,-1,game,adventurerPos,NULL);

#if NOISY_TEST
	printf("\nChecking if handcount up by two\n");
#endif
	assertLite(__LINE__,(game->handCount[0] - pre->handCount[0]),1,1);	
	
#if NOISY_TEST
	printf("\nChecking if count of treasures is up by 2\n");
#endif

	assertLite(__LINE__,countTreasure(game) - countTreasure(pre),2,1);
	printf("pre: %d, post: %d\n",countTreasure(game),countTreasure(pre));


	int ret;
    return 0;
}


