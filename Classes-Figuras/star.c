#include <stdio.h>

//struct star
typedef struct {
  int x, y;
  int p, t;
} Star;

//função star
void print (Star* r) {
  printf("Estrela na posicao (%d,%d) com (%d) pontas de tamanho (%d).\n",
    r->x, r->y, r->p,r->t);
}

void main (void) {
    Star r1 = { 1, 1, 5, 20 };
    print(&r1);
}
