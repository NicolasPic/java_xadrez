package xadrez.pecas;

import jogoDeTabuleiro.Posicao;
import jogoDeTabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez {
	
	private PartidaXadrez partidaXadrez;
	
	public Peao(Tabuleiro tabuleiro, Cor cor,PartidaXadrez partidaXadrez) {
		super(tabuleiro, cor);
		this.partidaXadrez = partidaXadrez;
	}

	@Override
	public boolean[][] movimentosPossiveis() {

		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao p = new Posicao(0, 0);

		if(getCor() == Cor.BRANCO) {
			p.colocarValor(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.colocarValor(posicao.getLinha() - 2, posicao.getColuna());
			Posicao p2= new Posicao(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p) && getTabuleiro().posicaoExiste(p2) && getContador() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.colocarValor(posicao.getLinha() - 1, posicao.getColuna() - 1);
			if (getTabuleiro().posicaoExiste(p) && temUmaPecaInimiga(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.colocarValor(posicao.getLinha() - 1, posicao.getColuna() + 1);
			if (getTabuleiro().posicaoExiste(p) && temUmaPecaInimiga(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			//en pansant
			if ( posicao.getLinha() == 4) {
				Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() -1);
				if(getTabuleiro().posicaoExiste(esquerda) && temUmaPecaInimiga(esquerda) && getTabuleiro().peca(esquerda) == partidaXadrez.getEnPassant()) {
					mat[esquerda.getLinha() -1][esquerda.getColuna()]=true;
				}		
				Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() +1);
				if(getTabuleiro().posicaoExiste(direita) && temUmaPecaInimiga(direita) && getTabuleiro().peca(direita) == partidaXadrez.getEnPassant()) {
					mat[direita.getLinha() -1][direita.getColuna()]=true;
				}
			}
		}
		else {
			p.colocarValor(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.colocarValor(posicao.getLinha() + 2, posicao.getColuna());
			Posicao p2= new Posicao(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p) && getTabuleiro().posicaoExiste(p2) && getContador() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.colocarValor(posicao.getLinha() + 1, posicao.getColuna() -1 );
			if (getTabuleiro().posicaoExiste(p) && temUmaPecaInimiga(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.colocarValor(posicao.getLinha() + 1, posicao.getColuna() + 1);
			if (getTabuleiro().posicaoExiste(p) && temUmaPecaInimiga(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			//en passant preto
			if ( posicao.getLinha() == 4) {
				Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() -1);
				if(getTabuleiro().posicaoExiste(esquerda) && temUmaPecaInimiga(esquerda) && getTabuleiro().peca(esquerda) == partidaXadrez.getEnPassant()) {
					mat[esquerda.getLinha() +1][esquerda.getColuna()]=true;
				}		
				Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() +1);
				if(getTabuleiro().posicaoExiste(direita) && temUmaPecaInimiga(direita) && getTabuleiro().peca(direita) == partidaXadrez.getEnPassant()) {
					mat[direita.getLinha() +1][direita.getColuna()]=true;
				}
			}
		}
		
		
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
