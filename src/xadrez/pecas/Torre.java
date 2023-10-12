package xadrez.pecas;

import jogoDeTabuleiro.Posicao;
import jogoDeTabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Torre extends PecaXadrez{

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
		
	}
	
	@Override
	public String toString() {
		return "T";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0,0);
		
		//cima
		p.colocarValor(posicao.getLinha()-1,posicao.getColuna());
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			p.setLinha(p.getLinha()-1);
		}
		if (getTabuleiro().posicaoExiste(p) && temUmaPecaInimiga(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//esquerda
		p.colocarValor(posicao.getLinha(),posicao.getColuna()-1);
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			p.setColuna(p.getColuna()-1);
		}
		if (getTabuleiro().posicaoExiste(p) && temUmaPecaInimiga(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//direita
		p.colocarValor(posicao.getLinha(),posicao.getColuna()+1);
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			p.setColuna(p.getColuna()+1);
		}
		if (getTabuleiro().posicaoExiste(p) && temUmaPecaInimiga(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//baixo
		p.colocarValor(posicao.getLinha()+1,posicao.getColuna());
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()]=true;
			p.setLinha(p.getLinha()+1);
		}
		if (getTabuleiro().posicaoExiste(p) && temUmaPecaInimiga(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		
		return mat;
	}
	
	

}
