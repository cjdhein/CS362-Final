
#include <stdio.h>

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

