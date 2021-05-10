Pensando em jogos:

"Coletáveis"
Itens para coletar e usar depois.
O parâmetro number significa o número de itens coletados e utilizados
	
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

"Armas"
O parâmetro damage se refere ao dano e time ao tempo de execução.
Cada arma teria ataques com animações diferentes, ciclos de ataque diferentes, etc. Mas os métodos seriam similares.
Cada uma tem um ataque rápido (mais fraco) e um forte (mais lento).


interface Attacker {
	void FastAttack (int damage, int time);
	void StrongAttack (int damage, int time);
}

class Sword implements Attacker {
	void FastAttack (int damage, int time) {
		//Ataque rápido com espada
	}
	void StrongAttack (int damage, int time) {
		//Ataque forte com espada, demora mais
	}
}

class Bow implements Attacker {
	void FastAttack (int damage, int time) {
		//Tiro rápido de flecha
	}
	void StrongAttack (int damage, int time) {
		//Tiro carregado de flecha
	}
}

class MagicStaff implements Attacker {
	void FastAttack (int damage, int time){
		//Ataque mágico rápido com cajado 
	}
	void StrongAttack (int damage, int time) {
		//Ataque mágico carregado com cajado 
	}
}
