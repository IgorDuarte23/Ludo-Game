package Models;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Controllers.Dice;
import Controllers.Game;
import Controllers.MovementFunctions;
import Controllers.Pieces;
import Views.Screen;

public class FileManager {

	/**********************************************************
     * 
     *  Save Game 
     *  Padr�o: Finalizadas red
     *          Finalizadas green
     *          Finalizadas yellow
     *          Finalizadas blue
     *          Round
     *          Dado retirado
     *          Numero de Jogadas 
     *          Qtd de 6 tirados repetidos 
     *          redpiece[0].posx
     *          redpiece[0].posy
     *          redpiece[1].posx
     *          redpiece[1].posy
     *          redpiece[2].posx
     *          redpiece[2].posy
     *          redpiece[3].posx
     *          redpiece[3].posy
     *          repetidos para todos os vetores na ordem: red,green,yellow e blue
     **********************************************************/
	
	public static void saveGame() throws IOException {
		
		FileWriter arq = new FileWriter("d:\\LudoGame.txt");
    	PrintWriter gravarArq = new PrintWriter(arq);
    	gravarArq.println(Game.getInstance().qtdPecasFinalizadasVermelho);
    	gravarArq.println(Game.getInstance().qtdPecasFinalizadasVerde);
    	gravarArq.println(Game.getInstance().qtdPecasFinalizadasAzul);
    	gravarArq.println(Game.getInstance().qtdPecasFinalizadasAmarelo);
    	gravarArq.println(Game.getInstance().rounds);
    	gravarArq.println(Dice.getInstance().GetAleatoryNumber());
    	gravarArq.println(Game.getInstance().jogadas);
    	gravarArq.println(Game.getInstance().qtdDeDadosSeisTirandosSeguidos);
    	
    	gravarArq.println(Game.getInstance().redPieces[0].house);
    	gravarArq.println(Game.getInstance().redPieces[0].posX);
    	gravarArq.println(Game.getInstance().redPieces[0].posY);
    	gravarArq.println(Game.getInstance().redPieces[0].isInGame);
    	gravarArq.println(Game.getInstance().redPieces[0].estaNaRetaFinal);
    	

    	gravarArq.println(Game.getInstance().redPieces[1].house);
    	gravarArq.println(Game.getInstance().redPieces[1].posX);
    	gravarArq.println(Game.getInstance().redPieces[1].posY);
    	gravarArq.println(Game.getInstance().redPieces[1].isInGame);
    	gravarArq.println(Game.getInstance().redPieces[1].estaNaRetaFinal);
    	

    	gravarArq.println(Game.getInstance().redPieces[2].house);
    	gravarArq.println(Game.getInstance().redPieces[2].posX);
    	gravarArq.println(Game.getInstance().redPieces[2].posY);
    	gravarArq.println(Game.getInstance().redPieces[2].isInGame);
    	gravarArq.println(Game.getInstance().redPieces[2].estaNaRetaFinal);
    	

    	gravarArq.println(Game.getInstance().redPieces[3].house);
    	gravarArq.println(Game.getInstance().redPieces[3].posX);
    	gravarArq.println(Game.getInstance().redPieces[3].posY);
    	gravarArq.println(Game.getInstance().redPieces[3].isInGame);
    	gravarArq.println(Game.getInstance().redPieces[3].estaNaRetaFinal);

    	

    	gravarArq.println(Game.getInstance().greenPieces[0].house);
    	gravarArq.println(Game.getInstance().greenPieces[0].posX);
    	gravarArq.println(Game.getInstance().greenPieces[0].posY);	
    	gravarArq.println(Game.getInstance().greenPieces[0].isInGame);
    	gravarArq.println(Game.getInstance().greenPieces[0].estaNaRetaFinal);
    	

    	gravarArq.println(Game.getInstance().greenPieces[1].house);
    	gravarArq.println(Game.getInstance().greenPieces[1].posX);
    	gravarArq.println(Game.getInstance().greenPieces[1].posY);
    	gravarArq.println(Game.getInstance().greenPieces[1].isInGame);
    	gravarArq.println(Game.getInstance().greenPieces[1].estaNaRetaFinal);
    	

    	gravarArq.println(Game.getInstance().greenPieces[2].house);
    	gravarArq.println(Game.getInstance().greenPieces[2].posX);
    	gravarArq.println(Game.getInstance().greenPieces[2].posY);
    	gravarArq.println(Game.getInstance().greenPieces[2].isInGame);
    	gravarArq.println(Game.getInstance().greenPieces[2].estaNaRetaFinal);
    	

    	gravarArq.println(Game.getInstance().greenPieces[3].house);
    	gravarArq.println(Game.getInstance().greenPieces[3].posX);
    	gravarArq.println(Game.getInstance().greenPieces[3].posY);
    	gravarArq.println(Game.getInstance().greenPieces[3].isInGame);
    	gravarArq.println(Game.getInstance().greenPieces[3].estaNaRetaFinal);

    	

    	gravarArq.println(Game.getInstance().yellowPieces[0].house);
    	gravarArq.println(Game.getInstance().yellowPieces[0].posX);
    	gravarArq.println(Game.getInstance().yellowPieces[0].posY);	
    	gravarArq.println(Game.getInstance().yellowPieces[0].isInGame);
    	gravarArq.println(Game.getInstance().yellowPieces[0].estaNaRetaFinal);
    	

    	gravarArq.println(Game.getInstance().yellowPieces[1].house);
    	gravarArq.println(Game.getInstance().yellowPieces[1].posX);
    	gravarArq.println(Game.getInstance().yellowPieces[1].posY);
    	gravarArq.println(Game.getInstance().yellowPieces[1].isInGame);
    	gravarArq.println(Game.getInstance().yellowPieces[1].estaNaRetaFinal);
    	

    	gravarArq.println(Game.getInstance().yellowPieces[2].house);
    	gravarArq.println(Game.getInstance().yellowPieces[2].posX);
    	gravarArq.println(Game.getInstance().yellowPieces[2].posY);
    	gravarArq.println(Game.getInstance().yellowPieces[2].isInGame);
    	gravarArq.println(Game.getInstance().yellowPieces[2].estaNaRetaFinal);
    	

    	gravarArq.println(Game.getInstance().yellowPieces[3].house);
    	gravarArq.println(Game.getInstance().yellowPieces[3].posX);
    	gravarArq.println(Game.getInstance().yellowPieces[3].posY);
    	gravarArq.println(Game.getInstance().yellowPieces[3].isInGame);
    	gravarArq.println(Game.getInstance().yellowPieces[3].estaNaRetaFinal);

    	

    	gravarArq.println(Game.getInstance().bluePieces[0].house);
    	gravarArq.println(Game.getInstance().bluePieces[0].posX);
    	gravarArq.println(Game.getInstance().bluePieces[0].posY);	
    	gravarArq.println(Game.getInstance().bluePieces[0].isInGame);
    	gravarArq.println(Game.getInstance().bluePieces[0].estaNaRetaFinal);
    	

    	gravarArq.println(Game.getInstance().bluePieces[1].house);
    	gravarArq.println(Game.getInstance().bluePieces[1].posX);
    	gravarArq.println(Game.getInstance().bluePieces[1].posY);
    	gravarArq.println(Game.getInstance().bluePieces[1].isInGame);
    	gravarArq.println(Game.getInstance().bluePieces[1].estaNaRetaFinal);
    	

    	gravarArq.println(Game.getInstance().bluePieces[2].house);
    	gravarArq.println(Game.getInstance().bluePieces[2].posX);
    	gravarArq.println(Game.getInstance().bluePieces[2].posY);
    	gravarArq.println(Game.getInstance().bluePieces[2].isInGame);
    	gravarArq.println(Game.getInstance().bluePieces[2].estaNaRetaFinal);
    	

    	gravarArq.println(Game.getInstance().bluePieces[3].house);
    	gravarArq.println(Game.getInstance().bluePieces[3].posX);
    	gravarArq.println(Game.getInstance().bluePieces[3].posY);
    	gravarArq.println(Game.getInstance().bluePieces[3].isInGame);
    	gravarArq.println(Game.getInstance().bluePieces[3].estaNaRetaFinal);
    
    	arq.close();
		
	}
	
	public static void loadGame() throws IOException {
		int size = Game.getInstance().redPieces[0].size;
		int indexAtPieceHouse = 0;
		FileReader arq;
		int casa;
		arq = new FileReader("d:\\LudoGame.txt");
		BufferedReader lerArq = new BufferedReader(arq);
		String lida;
		Pieces red[];
		Pieces green[];
		Pieces blue[];
		Pieces yellow[];
		red = new Pieces[4];
    	green = new Pieces[4];
    	yellow = new Pieces[4];
    	blue = new Pieces[4];
		for (int i = 0 ; i < 4 ; i++)
		{

			red[i] = new Pieces();
			green[i]= new Pieces();
			blue[i]= new Pieces();
			yellow[i] = new Pieces();
			
		}
		 
		
		String temp = lerArq.readLine();
		Game.getInstance().qtdPecasFinalizadasVermelho = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().qtdPecasFinalizadasVerde = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().qtdPecasFinalizadasAzul = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().qtdPecasFinalizadasAmarelo = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().rounds = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Dice.getInstance().setNumber(Integer.parseInt(temp));
		temp = lerArq.readLine();
		Game.getInstance().jogadas = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().qtdDeDadosSeisTirandosSeguidos = Integer.parseInt(temp);
		
		temp = lerArq.readLine();
		Game.getInstance().redPieces[0].house = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().redPieces[0].posX = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().redPieces[0].posY = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().redPieces[0].isInGame = Boolean.parseBoolean(temp);
		temp = lerArq.readLine();
		Game.getInstance().redPieces[0].estaNaRetaFinal = Boolean.parseBoolean(temp);
		temp = lerArq.readLine();
		
		Game.getInstance().redPieces[1].house = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().redPieces[1].posX = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().redPieces[1].posY = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().redPieces[1].isInGame = Boolean.parseBoolean(temp);
		temp = lerArq.readLine();
		Game.getInstance().redPieces[1].estaNaRetaFinal = Boolean.parseBoolean(temp);
		
		
		
		temp = lerArq.readLine();
		Game.getInstance().redPieces[2].house = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().redPieces[2].posX = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().redPieces[2].posY = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().redPieces[2].isInGame = Boolean.parseBoolean(temp);
		temp = lerArq.readLine();
		Game.getInstance().redPieces[2].estaNaRetaFinal = Boolean.parseBoolean(temp);
		
		temp = lerArq.readLine();
		Game.getInstance().redPieces[3].house = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().redPieces[3].posX = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().redPieces[3].posY = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().redPieces[3].isInGame = Boolean.parseBoolean(temp);
		temp = lerArq.readLine();
		Game.getInstance().redPieces[3].estaNaRetaFinal = Boolean.parseBoolean(temp);
		
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[0].house = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[0].posX = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[0].posY = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[0].isInGame = Boolean.parseBoolean(temp);
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[0].estaNaRetaFinal = Boolean.parseBoolean(temp);
		
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[1].house = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[1].posX = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[1].posY = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[1].isInGame = Boolean.parseBoolean(temp);
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[1].estaNaRetaFinal = Boolean.parseBoolean(temp);
		
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[2].house = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[2].posX = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[2].posY = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[2].isInGame = Boolean.parseBoolean(temp);
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[2].estaNaRetaFinal = Boolean.parseBoolean(temp);
		
		
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[3].house = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[3].posX = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[3].posY = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[3].isInGame = Boolean.parseBoolean(temp);
		temp = lerArq.readLine();
		Game.getInstance().greenPieces[3].estaNaRetaFinal = Boolean.parseBoolean(temp);
		
		
		
		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[0].house = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[0].posX = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[0].posY = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[0].isInGame = Boolean.parseBoolean(temp);
		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[0].estaNaRetaFinal = Boolean.parseBoolean(temp);
		

		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[1].house = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[1].posX = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[1].posY = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[1].isInGame = Boolean.parseBoolean(temp);
		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[1].estaNaRetaFinal = Boolean.parseBoolean(temp);
		

		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[2].house = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[2].posX = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[2].posY = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[2].isInGame = Boolean.parseBoolean(temp);
		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[2].estaNaRetaFinal = Boolean.parseBoolean(temp);
		

		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[3].house = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[3].posX = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[3].posY = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[3].isInGame = Boolean.parseBoolean(temp);
		temp = lerArq.readLine();
		Game.getInstance().yellowPieces[3].estaNaRetaFinal = Boolean.parseBoolean(temp);
		
		

		temp = lerArq.readLine();
		Game.getInstance().bluePieces[0].house = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().bluePieces[0].posX = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().bluePieces[0].posY = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().bluePieces[0].isInGame = Boolean.parseBoolean(temp);
		temp = lerArq.readLine();
		Game.getInstance().bluePieces[0].estaNaRetaFinal = Boolean.parseBoolean(temp);
		
		temp = lerArq.readLine();
		Game.getInstance().bluePieces[1].house = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().bluePieces[1].posX = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().bluePieces[1].posY = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().bluePieces[1].isInGame = Boolean.parseBoolean(temp);
		temp = lerArq.readLine();
		Game.getInstance().bluePieces[1].estaNaRetaFinal = Boolean.parseBoolean(temp);
		
	
		temp = lerArq.readLine();
		Game.getInstance().bluePieces[2].house = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().bluePieces[2].posX = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().bluePieces[2].posY = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().bluePieces[2].isInGame = Boolean.parseBoolean(temp);
		temp = lerArq.readLine();
		Game.getInstance().bluePieces[2].estaNaRetaFinal = Boolean.parseBoolean(temp);
		
	
		
		temp = lerArq.readLine();
		Game.getInstance().bluePieces[3].house = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().bluePieces[3].posX = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().bluePieces[3].posY = Integer.parseInt(temp);
		temp = lerArq.readLine();
		Game.getInstance().bluePieces[3].isInGame = Boolean.parseBoolean(temp);
		temp = lerArq.readLine();
		Game.getInstance().bluePieces[3].estaNaRetaFinal = Boolean.parseBoolean(temp);

	
		for ( int i = 0 ; i < 4 ; i++)
		{		
			Game.getInstance().retaFinalRed[Game.getInstance().redPieces[i].house].reorganizePieceArray();
			if(Game.getInstance().redPieces[i].isInGame == true)
			{
				if( Game.getInstance().redPieces[i].estaNaRetaFinal == false)
				{
					Game.getInstance().listaPrincipal[Game.getInstance().redPieces[i].house].reorganizePieceArray();
					int novoIndex = Game.getInstance().listaPrincipal[Game.getInstance().redPieces[i].house].getPieceFreeLocationOnHouseArray();
					Game.getInstance().listaPrincipal[Game.getInstance().redPieces[i].house].pecas[novoIndex] = Game.getInstance().redPieces[i];
				}
				else
				{
					Game.getInstance().retaFinalRed[Game.getInstance().redPieces[i].house].reorganizePieceArray();
					int novoIndex = Game.getInstance().retaFinalRed[Game.getInstance().redPieces[i].house].getPieceFreeLocationOnHouseArray();
					Game.getInstance().retaFinalRed[Game.getInstance().redPieces[i].house].pecas[novoIndex] = Game.getInstance().redPieces[i];
			
				}
			}
			if(Game.getInstance().greenPieces[i].isInGame == true )
			{
				if(Game.getInstance().greenPieces[i].estaNaRetaFinal == false)
				{
					Game.getInstance().listaPrincipal[Game.getInstance().greenPieces[i].house].reorganizePieceArray();
					int novoIndex = Game.getInstance().listaPrincipal[Game.getInstance().greenPieces[i].house].getPieceFreeLocationOnHouseArray();
					Game.getInstance().listaPrincipal[Game.getInstance().greenPieces[i].house].pecas[novoIndex] = Game.getInstance().greenPieces[i];
				}
				else
				{
					
					Game.getInstance().retaFinalGreen[Game.getInstance().greenPieces[i].house].reorganizePieceArray();
					int novoIndex = Game.getInstance().retaFinalGreen[Game.getInstance().greenPieces[i].house].getPieceFreeLocationOnHouseArray();
			
					Game.getInstance().retaFinalGreen[Game.getInstance().greenPieces[i].house].pecas[novoIndex] = Game.getInstance().greenPieces[i];
				}
			}
			if(Game.getInstance().yellowPieces[i].isInGame == true)
			{
				if(Game.getInstance().yellowPieces[i].estaNaRetaFinal == false)
				{
				Game.getInstance().listaPrincipal[Game.getInstance().yellowPieces[i].house].reorganizePieceArray();
				int novoIndex = Game.getInstance().listaPrincipal[Game.getInstance().yellowPieces[i].house].getPieceFreeLocationOnHouseArray();
            
				Game.getInstance().listaPrincipal[Game.getInstance().yellowPieces[i].house].pecas[novoIndex] = Game.getInstance().yellowPieces[i];
				}
				else
				{
					Game.getInstance().retaFinalYellow[Game.getInstance().yellowPieces[i].house].reorganizePieceArray();
					int novoIndex = Game.getInstance().retaFinalYellow[Game.getInstance().yellowPieces[i].house].getPieceFreeLocationOnHouseArray();
					Game.getInstance().retaFinalYellow[Game.getInstance().yellowPieces[i].house].pecas[novoIndex] = Game.getInstance().yellowPieces[i];
				}
			}
			if(Game.getInstance().bluePieces[i].isInGame == true )
			{
				if( Game.getInstance().bluePieces[i].estaNaRetaFinal == false)
				{
					Game.getInstance().listaPrincipal[Game.getInstance().bluePieces[i].house].reorganizePieceArray();
					int novoIndex = Game.getInstance().listaPrincipal[Game.getInstance().bluePieces[i].house].getPieceFreeLocationOnHouseArray();
					Game.getInstance().listaPrincipal[Game.getInstance().bluePieces[i].house].pecas[novoIndex] = Game.getInstance().bluePieces[i];
				}
				else{
					Game.getInstance().retaFinalBlue[Game.getInstance().bluePieces[i].house].reorganizePieceArray();
					int novoIndex = Game.getInstance().retaFinalBlue[Game.getInstance().bluePieces[i].house].getPieceFreeLocationOnHouseArray();
					Game.getInstance().retaFinalBlue[Game.getInstance().bluePieces[i].house].pecas[novoIndex] = Game.getInstance().bluePieces[i];
				}
			}
		}
		
		arq.close();
		Screen.getInstance().repaint();
	}

}
