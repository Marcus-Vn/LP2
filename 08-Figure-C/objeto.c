#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
    int l, p;
} Seta;

void seta_print (Seta* this) {
    Figure* sup = (Figure*) this;
    printf("Seta com haste de tamanho (%d,%d) na posicao (%d,%d), ponta com extensao lateral (%d) e  frontal (%d).\n",
           this->w, this->h, sup->x, sup->y, this->l,this->p);
}

Seta* seta_new (int x, int y, int w, int h,int l, int p) {
    Seta*   this  = malloc(sizeof(Seta));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) seta_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
    this->l = l;
    this->p = p;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Triangulo;

void Triangulo_print (Triangulo* this) {
    Figure* sup = (Figure*) this;
    printf("Triangulo isosceles de base (%d) e altura (%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Triangulo* triangulo_new (int x, int y, int w, int h) {
    Triangulo* this = malloc(sizeof(Triangulo));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Triangulo_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

void main (void) {
    Figure* figs[4] = {
        (Figure*) seta_new(10,10,100,100,5,10),
        (Figure*) triangulo_new(130,130,100,200),
        (Figure*) seta_new(50,50,200,150,30,60),
        (Figure*) triangulo_new(70,110,250,300)
    };

    ///

    for (int i=0; i<4; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for (int i=0; i<4; i++) {
        free(figs[i]);
    }
}
