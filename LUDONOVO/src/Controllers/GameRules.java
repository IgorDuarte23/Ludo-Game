package Controllers;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameRules {

	/**********************************************************
     * 
     *  Mouse Listener
     *
     **********************************************************/
	
	
	
	/**********************************************************
     * 
     *  Conferir se casa é casa de saída ou casa de abrigo
     *
     **********************************************************/
	
	public static boolean conferirSeCasaEAbrigoOuSaida(int house) {
		
		if( house == 0 || house == 9 || house == 13 || house == 22 || house == 26 || house == 35 || house == 39 || house == 48 ) {
			return true;
		}
		
		return false;
		
	}
	
	/**********************************************************
     * 
     *  Conferir se comeu alguma peça
     *
     **********************************************************/
	
	public static boolean confereSePodeComerPeca(int casaChegada, Color cor) {
		
		if( !conferirSeCasaEAbrigoOuSaida(casaChegada) ) {
			
			boolean corDiferente = false;
			
			for(int i=0; i<16; i++) {
				if( Game.getInstance().listaPrincipal[casaChegada].pecas[i] != null ) {
					if( Game.getInstance().listaPrincipal[casaChegada].pecas[i].color != cor ) {
						corDiferente = true;
					}
				}
			}
			
			return corDiferente;
			
		}
		
		return false;
	}
	
	/**********************************************************
     * 
     *  Conferir se tem barreira no caminho
     *
     **********************************************************/
	
	public static boolean confereSeTemBarreira(int casaSaida, int casaChegada, Color cor) {
		
		for(int i = casaSaida+1; i <= casaChegada ; i++ ){
			
			if( Game.getInstance().listaPrincipal[i].count() >= 2 ) {
				return true;
			}
			
		}
		
		return false;
	}
	
	public static boolean verificaSeTemBarreira(Color cor ,int house, int dado)
    {
    	boolean temBarreira ;
        int iprov = house;
        int dadoProv = dado;
        
        while(iprov+dadoProv >= 52){
            if(iprov == 52){
                iprov=0;
            } else {
                iprov++;
                dadoProv--;
            }
        }
        
        if((house + dado) >= 52  && iprov == 0 && dadoProv > 0) {
        	dado = dadoProv;
        }
        
        boolean podeAndar = true;
         
   
    	 if (podeAndar) {
    		 
             temBarreira = GameRules.confereSeTemBarreira(house, iprov+dadoProv, cor);
          	if(temBarreira){
          		
         		JOptionPane.showMessageDialog(new JFrame(), "Ops! Barreira no caminho!", "Ludo Game",
                         JOptionPane.INFORMATION_MESSAGE);
         		podeAndar = false;
         		
         	}
         	
         }
    	 
    	 return podeAndar;
    }
	
	/**********************************************************
     * 
     *  Conferir se todas as peças já foram inicializadas
     *
     **********************************************************/
	
	public static boolean confereSeTodasAsPecasForamInicializadas(Color cor) {
		
		if(cor == Color.GREEN) {
			for(int i=0; i < 4; i++) {
				
				if( Game.getInstance().greenPieces[i].isInGame == false ) {
					return false;
				}
				
			}
		}
		
		if(cor == Color.RED) {
			for(int i=0; i < 4; i++) {
				
				if( Game.getInstance().redPieces[i].isInGame == false ) {
					return false;
				}
				
			}
		}
		
		if(cor == Color.YELLOW) {
			for(int i=0; i < 4; i++) {
				
				if( Game.getInstance().yellowPieces[i].isInGame == false ) {
					return false;
				}
				
			}
		}
		
		if(cor == Color.BLUE) {
			for(int i=0; i < 4; i++) {
				
				if( Game.getInstance().bluePieces[i].isInGame == false ) {
					return false;
				}
				
			}
		}
		
		return true;
	}
	
	/**********************************************************
     * 
     *  Regra do Sobre 6: 
     *   - Avançar sete casas caso não tenha mais peões para retirar de sua casa inicial.
     *
     **********************************************************/
	
	public static void dadoPodeValerSete() {
		
		boolean jaInicializouTodasAsPecas = GameRules.confereSeTodasAsPecasForamInicializadas(colorOfRound(Game.getInstance().rounds));
    	
    	if( Dice.getInstance().GetAleatoryNumber() == 6 && jaInicializouTodasAsPecas ) {
    		
    		JOptionPane.showMessageDialog(new JFrame(), "Voc� pode avan�ar sete casas!", "Ludo Game",
                    JOptionPane.INFORMATION_MESSAGE);
    		
    		Dice.getInstance().setNumber(7);
    		
    	}
		
	}
	
	/**********************************************************
     * 
     *  Color of Round
     *
     **********************************************************/
     
    public static Color colorOfRound(int round) {
         
        if( round % 4 == 0 )
            return Color.RED;
        else if( round % 4 == 1 )
            return Color.GREEN;
        else if( round % 4 == 2 )
            return Color.YELLOW;
        else
            return Color.BLUE;
        
    }
	
}
