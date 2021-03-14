public class RectApp {
    public static void main (String[] args) {
        Rect r1 = new Rect(1,1, 10,10);
	r1.area();
	r1.drag(20,30);
        r1.print();
    }
}
class Rect {
    int dx, dy;
    int a;
    int x, y;
    int w, h;
    Rect (int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    int area () {
	this.a = (this.w) * (this.h);
	return this.a;
    }
    void drag (int dx, int dy) {
	this.dx = dx;
	this.dy = dy;
	this.x = this.x + this.dx;
	this.y = this.y + this.dy;
    }
    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) e area (%d) na posicao (%d,%d), foi movido (%d,%d) unidades.\n",
            this.w, this.h, this.a, this.x, this.y, this.dx, this.dy);
    }
    
}
