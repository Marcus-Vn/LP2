//Pensando em jogos:

//"Coletáveis"
//Itens para coletar e usar depois

interface Collectable {
	void Collect (int number);
	void Use (int number);
}

class Coins implements Collectable {
	void Collect (int number) {
		//Adiciona em um espaço reservado do inventário
	}
	void Use (int number) {
		//Usa certa quantidade para comprar itens
	}
}

class Potion implements Collectable {
	void Collect (int number) {
		//Adiciona em um espaço reservado do inventário
	}
	void Use (int number) {
		//Usa certa quantidade para curar
	}
}

class CrystalPoints implements Collectable {
	void Collect (int number){
		//Adiciona em um espaço reservado do inventário
	}
	void Use (int number) {
		//Usa certa quantidade para aumentar o nível de poder
	}
}

//"Armas"
//Cada uma tem um ataque rápido (mais fraco) e um forte (mais lento).

interface Attacker {
	void FastAttack (void);
	void StrongAttack (void);
}

class Sword implements Attacker {
	void FastAttack (void) {
		//Ataque rápido com espada
	}
	void StrongAttack (void) {
		//Ataque forte com espada, demora mais
	}
}

class Bow implements Attacker {
	void FastAttack (void) {
		//Tiro rápido de flecha
	}
	void StrongAttack (void) {
		//Tiro carregado de flecha
	}
}

class MagicStaff implements Attacker {
	void FastAttack (void){
		//Ataque mágico rápido com cajado 
	}
	void StrongAttack (void) {
		//Ataque mágico carregado com cajado 
	}
}
