public class SetaApp {
    public static void main (String[] args) {
        Seta r1 = new Seta(100, 100, 100, 50, 150, 180);
        r1.print();
    }
}
//classe Seta
class Seta {
    int x, y;
    int w, h;
    int l, p;			
    Seta (int x, int y, int w, int h, int l, int p) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
	this.l = l;
        this.p = p;
	
    }//método print
    void print () {
        System.out.format("Seta com haste de tamanho (%d,%d) na posicao (%d,%d) e ponta de extensao (%d,%d).\n",
            this.w, this.h, this.x, this.y, this.l, this.p);
    }
}
