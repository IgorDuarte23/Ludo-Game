package Models;

import Controllers.Pieces;

public class Houses {
	
	int posI;
	int posJ;
	int size;
	public Pieces[] pecas;
	
	public Houses() {
		
		this.pecas = new Pieces[16];
		
	}
	
	public void reorganizePieceArray()
	{
		int j;
		for ( int i = 0 ; i < 16 ; i++)
		{
			if( pecas[i] != null)
			{
				j = i;
				if( j > 0 && pecas[j-1] == null)
				{
					pecas[j-1] = pecas[j];
					pecas[j] = null;
					reorganizePieceArray(); //recurs�o 
				}
				
			}
		}
	}
	
	public void comerPecas() {
		
		for (int i= 0; i < 16 ; i++)
		{
			if(pecas[i] != null)
			{
				pecas[i].isInGame = false;
				pecas[i] = null;
			}
		}
		
	}
	
	public int getPieceFreeLocationOnHouseArray()
	{
		for (int i= 0; i < 16 ; i++)
		{
			if(pecas[i] == null)
			{
				return i;
			}
		}
		// erro
		return -1;
	}
	
	public int count()
	{
		int contador = 0;
		
		for (int i =0; i < 16; i++)
		{
			if( this.pecas[i] != null)
				contador++;
		}
		return contador;
	}
}
