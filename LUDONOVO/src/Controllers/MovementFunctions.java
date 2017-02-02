package Controllers;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Models.Houses;

public class MovementFunctions {
	
	/**********************************************************
     * 
     *  Começar peça no jogo
     *
     **********************************************************/
	
	public static void startNewPieceInGame(int house, Pieces[] array, int numeroOfPieces) {
		Game.getInstance().listaPrincipal[house].pecas[Game.getInstance().listaPrincipal[house].count()] = array[numeroOfPieces];
		
		array[numeroOfPieces].isInGame = true;
	}
	
	/**********************************************************
     * 
     *  Movimento na reta final das cores
     *
     **********************************************************/
	
	public static int movimentoNaRetaFinal(Houses[] array, Color cor, int dado, int house) {
		
		int indexOfPiece=0;
		
		for( int j =0 ; j< array[house].count() ; j++)
        {
            if (array[house].pecas[j].color == cor);
            {
            	indexOfPiece = j;
            }
        }
       
        if((dado + house)  <= 6) {
        	
            int novoIndex =  array[house + dado].getPieceFreeLocationOnHouseArray();
            array[house + dado].pecas[novoIndex] = array[house].pecas[indexOfPiece];
            array[house].pecas[indexOfPiece] = null;
            array[house].reorganizePieceArray();
             
            Game.getInstance().jogadas--;
            
        }
		
        return indexOfPiece;
        
	}
	
	/**********************************************************
     * 
     *  Movimento para entrar na reta final
     *
     **********************************************************/
	
	public static void movimentoParaEntrarNaRetaFinal(int number, Houses[] arrayRetaFinal, Houses[] arrayPrincipal, int house, int dado, int indexOfPieceAtHouseVector) {
		
		int novoIndex =  arrayRetaFinal[((house + dado) - number)].getPieceFreeLocationOnHouseArray();
		arrayRetaFinal[((house + dado) - number) - 1].pecas[novoIndex] = arrayPrincipal[house].pecas[indexOfPieceAtHouseVector];
		arrayPrincipal[house].pecas[indexOfPieceAtHouseVector] = null;
		arrayRetaFinal[((house + dado) - number) - 1].pecas[novoIndex].house = ((house + dado) - number) - 1;
		//System.out.println(((house + dado) - number) - 1);
		arrayRetaFinal[((house + dado) - number) - 1].pecas[novoIndex].estaNaRetaFinal = true;
		
	}
	
	/**********************************************************
     * 
     *  Conferir se pode tirar uma peça do início
     *
     **********************************************************/
	
	public static void confereSePodeTirarPecaDoInicio(Color cor, int house,int dado) {
		
		if(dado == 5)
		{
			if(cor == Color.RED && Game.getInstance().setRedPieceInGame == true && house == 100) {
	            if( Game.getInstance().redPieces[0].isInGame == false || Game.getInstance().redPieces[1].isInGame == false || Game.getInstance().redPieces[2].isInGame == false
	                    || Game.getInstance().redPieces[3].isInGame == false)
	            {
	            	Game.getInstance().numberOfRedPieces = getHowManyPiecesAreInGame(Game.getInstance().redPieces);
	            	Game.getInstance().startNewPiece = true;
	            	Game.getInstance().setRedPieceInGame = false;
	            }
	        }
	         
	        if(cor == Color.GREEN && Game.getInstance().setGreenPieceInGame == true && house == 101) {
	            if( Game.getInstance().greenPieces[0].isInGame == false || Game.getInstance().greenPieces[1].isInGame == false || Game.getInstance().greenPieces[2].isInGame == false
	                    || Game.getInstance().greenPieces[3].isInGame == false)
	            {
	            	Game.getInstance().numberOfGreenPieces = getHowManyPiecesAreInGame(Game.getInstance().greenPieces);
	            	Game.getInstance().startNewPiece = true;
	            	Game.getInstance().setGreenPieceInGame = false;
	            }
	        }
	         
	        if(cor == Color.YELLOW && Game.getInstance().setYellowPieceInGame == true && house == 102) {
	            if( Game.getInstance().yellowPieces[0].isInGame == false || Game.getInstance().yellowPieces[1].isInGame == false || Game.getInstance().yellowPieces[2].isInGame == false
	                    || Game.getInstance().yellowPieces[3].isInGame == false)
	            {
	            	Game.getInstance().numberOfYellowPieces = getHowManyPiecesAreInGame(Game.getInstance().yellowPieces);
	            	Game.getInstance().startNewPiece = true;
	            	Game.getInstance().setYellowPieceInGame = false;
	            }
	        }
	         
	        if(cor == Color.BLUE && Game.getInstance().setBluePieceInGame == true && house == 103 ) {
	            if( Game.getInstance().bluePieces[0].isInGame == false || Game.getInstance().bluePieces[1].isInGame == false || Game.getInstance().bluePieces[2].isInGame == false
	                    || Game.getInstance().bluePieces[3].isInGame == false)
	            {
	            	Game.getInstance().numberOfBluePieces = getHowManyPiecesAreInGame(Game.getInstance().bluePieces);
	            	Game.getInstance().startNewPiece = true;
	            	Game.getInstance().setBluePieceInGame = false;
	            }
	        }
		}
		else 
		{
				if(cor == Color.RED && Game.getInstance().redPieces[0].isInGame == false && Game.getInstance().redPieces[1].isInGame == false &&
						Game.getInstance().redPieces[2].isInGame == false && Game.getInstance().redPieces[3].isInGame == false )
			{
				JOptionPane.showMessageDialog(new JFrame(), "Voc� n�o pode retirar pe�as, apenas com o dado 5", "Ludo Game",
                        JOptionPane.INFORMATION_MESSAGE);
			}
			if(cor == Color.GREEN && Game.getInstance().greenPieces[0].isInGame == false && Game.getInstance().greenPieces[1].isInGame == false &&
					Game.getInstance().greenPieces[2].isInGame == false && Game.getInstance().greenPieces[3].isInGame == false )
			{
				JOptionPane.showMessageDialog(new JFrame(), "Voc� n�o pode retirar pe�as, apenas com o dado 5", "Ludo Game",
                        JOptionPane.INFORMATION_MESSAGE);
			}
			if(cor == Color.YELLOW && Game.getInstance().yellowPieces[0].isInGame == false && Game.getInstance().yellowPieces[1].isInGame == false &&
					Game.getInstance().yellowPieces[2].isInGame == false && Game.getInstance().yellowPieces[3].isInGame == false )
			{
				JOptionPane.showMessageDialog(new JFrame(), "Voc� n�o pode retirar pe�as, apenas com o dado 5", "Ludo Game",
                        JOptionPane.INFORMATION_MESSAGE);
			}
			if(cor == Color.BLUE && Game.getInstance().bluePieces[0].isInGame == false && Game.getInstance().bluePieces[1].isInGame == false &&
					Game.getInstance().bluePieces[2].isInGame == false && Game.getInstance().bluePieces[3].isInGame == false )
			{
				JOptionPane.showMessageDialog(new JFrame(), "Voc� n�o pode retirar pe�as, apenas com o dado 5", "Ludo Game",
                        JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		
	}
	
	/**********************************************************
     * 
     *  Função auxiliar para contar a quantidade de peças no jogo
     *
     **********************************************************/
	
	private static int getHowManyPiecesAreInGame(Pieces piece[])
    {
        int numberOfPieces=0;
        for(int i =0 ; i < 4 ; i++)
        {
            if(piece[i].isInGame == true)
                numberOfPieces++;
        }
        return numberOfPieces;
    }
	
}
