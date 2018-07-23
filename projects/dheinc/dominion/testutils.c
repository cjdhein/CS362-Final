
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "dominion.h"

// equal: 0 for !=, 1 for ==, 2 for <, 3 for >, 4 for <=, 5 for >=
int assertLite(int line, int left, int right, int equal) {
	//printf("left: %d, right: %d",left,right);
	switch (equal){
		case 0://!=
			if(left != right){
				return 1;
			} else {
				printf("TEST FAILED. %d == %d at line %d\n",left,right, line);
			}
			break;
		case 1://==
			if(left == right){
				return 1;
			} else {
				printf("TEST FAILED. %d != %d at line %d\n",left,right, line);
			}
			break;
		case 2:
			if(left < right){
				return 1;
			} else {
				printf("TEST FAILED. %d is not < %d at line %d\n",left,right, line);
			}
			break;
		case 3:
			if(left > right){
				return 1;
			} else {
				printf("TEST FAILED. %d is not > %d at line %d\n",left,right, line);
			}
			break;
		case 4:
			if(left <= right){
				return 1;
			} else {
				printf("TEST FAILED. %d is not <= %d at line %d\n",left,right, line);
			}
			break;
		case 5:
			if(left >= right){
				return 1;
			} else {
				printf("TEST FAILED. %d is not >= %d at line %d\n",left,right, line);
			}
			break;
		default:
			return -1;
	}
	return 0;
}

int testCompare(const void* a, const void* b) {
  if (*(int*)a > *(int*)b)
    return 1;
  if (*(int*)a < *(int*)b)
    return -1;
  return 0;
}

void resetForTest(struct gameState *game, struct gameState *pre, int testCard) {

	memset(game,0,sizeof(struct gameState));

	// set the kingdom cards being used
	int k[10] = {smithy, gardens, great_hall, village, minion, mine, cutpurse, sea_hag, tribute, adventurer};	
	// initialize the game
	initializeGame(4,k,23,game);
	
	// give first player the test card in their hand
	game->hand[0][game->handCount[0]] = testCard;
	game->handCount[0]++;

	// store initial state in pre
	memset(pre,0,sizeof(struct gameState));
	memcpy(pre,game,sizeof(struct gameState));
	
}

void printDeck(struct gameState *game) {
	printf("Deck:\n");
	for(int i = 0; i < game->deckCount[0];i++){
		printf("%d, ",game->deck[0][i]);
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

void printHand(struct gameState *game) {
	printf("Hand:\n");
	for(int i = 0; i < game->handCount[0];i++){
		printf("%d, ",game->hand[0][i]);
	}
	printf("\n");
}