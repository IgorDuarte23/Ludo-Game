package Controllers;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Models.Houses;
import Views.Screen;

public class Game {
	
	private int height =(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	private int size = (height - 150)/15;
	
	public static Game instance;
	
	private int indexOfPieceAtHouseVector ;
    
    private boolean clickIsInsideRetaFinal = false;
    
    public boolean jaInicializouNessaRodada = false;
    
    private Dice dice = Dice.getInstance();
    
    public boolean deveMoverPeca = false;
    
    public int ultimaPecaMovimentada;
	
	//--------------------- Array de Peças --------------------
	
	public Pieces redPieces[];
    public Pieces greenPieces[];
    public Pieces bluePieces[];
    public Pieces yellowPieces[]; 
    
    //------------- Variáveis de controle do jogo --------------
    
    public int jogadas = 0;
    
    public int qtdPecasFinalizadasVerde = 0;
    public  int qtdPecasFinalizadasVermelho = 0;
    public  int qtdPecasFinalizadasAmarelo = 0;
    public  int qtdPecasFinalizadasAzul = 0;
    
    public int numberOfRedPieces =0;
    public int numberOfYellowPieces =0;
    public int numberOfBluePieces=0;
    public int numberOfGreenPieces =0;
    
    public int qtdDeDadosSeisTirandosSeguidos = 0;
    
    public boolean setRedPieceInGame = false;
    public boolean setYellowPieceInGame = false;
    public boolean setBluePieceInGame = false;
    public boolean setGreenPieceInGame = false;
    
    public Boolean startNewPiece = false;
    
    public Color selectColor = Color.BLACK;
    
    public Boolean contruct = false;
    
    public Houses listaPrincipal[];
    
    public Houses retaFinalGreen[];
    public Houses retaFinalRed[];
    public Houses retaFinalBlue[];
    public Houses retaFinalYellow[];
	
    public int rounds;
    
	public static Game getInstance() {
		
		if (instance == null) {
			instance = new Game();
		}
		
		return instance;
	}
	
	/**********************************************************
     * 
     *  Inicializador
     *
     **********************************************************/
	
	private Game() {
		
		//------------------ Iniciando Array de Peças -----------------
		
		redPieces = new Pieces[4];
    	greenPieces = new Pieces[4];
    	bluePieces = new Pieces[4];
    	yellowPieces = new Pieces[4];
    	
    	for(int i=0; i<4; i++) {
            
        	redPieces[i] = new Pieces();
        	redPieces[i].color = Color.RED;
        	greenPieces[i] = new Pieces();
        	greenPieces[i].color = Color.GREEN;
        	bluePieces[i] = new Pieces();
        	bluePieces[i].color = Color.BLUE;
        	yellowPieces[i] = new Pieces();
            yellowPieces[i].color = Color.YELLOW;
        }
    	
    	//---------------- Iniciando a lista principal ----------------
    	
    	listaPrincipal = new Houses[52];
        
        for(int i=0; i<52;i++) {
            listaPrincipal[i] = new Houses();
        }
        
      //------------------ Iniciando as lista finais ------------------
        
        retaFinalGreen = new Houses[16];
        
        for(int i=0; i<16;i++) {
            retaFinalGreen[i] = new Houses();
        }
         
        retaFinalRed = new Houses[16];
         
        for(int i=0; i<16;i++) {
            retaFinalRed[i] = new Houses();
        }
         
        retaFinalBlue = new Houses[16];
         
        for(int i=0; i<16;i++) {
            retaFinalBlue[i] = new Houses();
        }
         
        retaFinalYellow = new Houses[16];
         
        for(int i=0; i<16;i++) {
            retaFinalYellow[i] = new Houses();
        }
		
	}
	
	/**********************************************************
     * 
     *  Começar um jogo novo
     *
     **********************************************************/
	
	public void comecarJogoNovo() {
		
		qtdPecasFinalizadasVerde = 0;
        
    	setRedPieceInGame = false;
    	setYellowPieceInGame = false;
        setBluePieceInGame = false;
        setGreenPieceInGame = false;
         
        startNewPiece = false;
         
        numberOfRedPieces = 0;
        numberOfYellowPieces = 0;
        numberOfBluePieces = 0;
        numberOfGreenPieces = 0;
        
        qtdPecasFinalizadasVermelho = 0;
        qtdPecasFinalizadasAmarelo = 0;
        qtdPecasFinalizadasAzul = 0;
        qtdPecasFinalizadasVerde = 0;
        
        jogadas = 0;
        
        selectColor = Color.BLACK;
        
        contruct = false;
        
        Screen.getInstance().repaint();
		
	}
	
	/**********************************************************
     * 
     *  Search Piece House By Click
     *
     **********************************************************/
	
	 public int searchPieceHouseByClick(int x, int y,Color cor)
	    {
	        clickIsInsideRetaFinal = false;
	         
	        for ( int i =0 ; i < 52 ; i++)
	        {
	        	Game.getInstance().listaPrincipal[i].reorganizePieceArray();
	        	
	                for( int j = 0 ; j < Game.getInstance().listaPrincipal[i].count() ; j++)
	                {
	                    if (Game.getInstance().listaPrincipal[i].pecas[j].color == cor)
	                    {
	                        indexOfPieceAtHouseVector = j;
	                        if(x+size >Game.getInstance().listaPrincipal[i].pecas[indexOfPieceAtHouseVector].posX && 
	                                x-size <Game.getInstance().listaPrincipal[i].pecas[indexOfPieceAtHouseVector].posX && 
	                                y+size > Game.getInstance().listaPrincipal[i].pecas[indexOfPieceAtHouseVector].posY &&
	                                y-size < Game.getInstance().listaPrincipal[i].pecas[indexOfPieceAtHouseVector].posY )
	                        {
	                            return i;   
	                        }
	                    }
	                }
	              
	        }
	         
	        if(x >size*2 && x <size*4 && y >size*2 && y <size*4 )
	        {
	        	Game.getInstance().setRedPieceInGame  = true;
	            Game.getInstance().jogadas++;
	            return 100; // red
	        }
	          
	        if(x >size*11 && x <size*13 && y >size*2 && y <size*4 )
	        {
	        	Game.getInstance().setGreenPieceInGame  = true;
	            return 101; // green
	        }
	          
	        if(x >size*11 && x <size*13 && y >size*11 && y <size*13 )
	        {
	        	Game.getInstance().setYellowPieceInGame  = true;
	            return 102; // yellow
	        }
	          
	        if(x >size*2 && x <size*4 && y >size*11 && y <size*13 )
	        {
	        	Game.getInstance().setBluePieceInGame  = true;
	            return 103; // blue
	        }
	         
	        if ( searchPieceHouseInRetaFinalByClick(Game.getInstance().retaFinalGreen, x, y, cor) != -1 )
	        {
	            clickIsInsideRetaFinal = true;
	            return searchPieceHouseInRetaFinalByClick(Game.getInstance().retaFinalGreen, x, y, cor);
	        }
	         
	        if ( searchPieceHouseInRetaFinalByClick(Game.getInstance().retaFinalRed, x, y, cor) != -1 )
	        {
	            clickIsInsideRetaFinal = true;
	            return searchPieceHouseInRetaFinalByClick(Game.getInstance().retaFinalRed, x, y, cor);
	        }
	         
	        if ( searchPieceHouseInRetaFinalByClick(Game.getInstance().retaFinalYellow, x, y, cor) != -1 )
	        {
	            clickIsInsideRetaFinal = true;
	            return searchPieceHouseInRetaFinalByClick(Game.getInstance().retaFinalYellow, x, y, cor);
	        }
	         
	        if ( searchPieceHouseInRetaFinalByClick(Game.getInstance().retaFinalBlue, x, y, cor) != -1 )
	        {
	            clickIsInsideRetaFinal = true;
	            return searchPieceHouseInRetaFinalByClick(Game.getInstance().retaFinalBlue, x, y, cor);
	        }
	          
	        return -1;
	    }
	 
	/**********************************************************
     * 
     *  Search Piece in Reta Final
     *
     **********************************************************/
	     
	 public int searchPieceHouseInRetaFinalByClick(Houses[] array, int x, int y,Color cor)
	 {
	         
		 for ( int i =0 ; i < 6 ; i++)
		 {
			 for( int j = 0 ; j < array[i].count() ; j++)
			 {
				 if (array[i].pecas[j].color == cor);
				 {
					 indexOfPieceAtHouseVector = j;
					 if(x+size >array[i].pecas[indexOfPieceAtHouseVector].posX && 
							 x-size <array[i].pecas[indexOfPieceAtHouseVector].posX && 
							 y+size > array[i].pecas[indexOfPieceAtHouseVector].posY &&
							 y-size < array[i].pecas[indexOfPieceAtHouseVector].posY )
					 {
						 return i;   
					 }
				 }
			 }
	             
		 }
		 return -1;
	 }
	 public boolean tenhoBarreira(Color cor)
	 {
		 int qtd=0;
		 for ( int i = 0 ; i < 52; i++)
		 {
			 for(int j = 0 ; j < listaPrincipal[i].pecas.length ; j++)
			 {
				 if(listaPrincipal[i].pecas[j].color == cor)
				 {
					 qtd++;
				 }
			 }
			 if(qtd == 2)
				 return true;
		 }
		 return false;
	 }
	 
	 
	 /**********************************************************
	  * 
	  *  Hide Piece
	  *
	  **********************************************************/
	     
	 public void hidePiece(Color cor, int dado, int house) {
		 	
	    	Game.getInstance().selectColor = cor;
	    	boolean tenhobarreira;
	     	if(dado == 6)
	    		deveMoverPeca = true;
	    	
	        MovementFunctions.confereSePodeTirarPecaDoInicio(cor, house,dado);
	        
	        /**********************************************************
	         * 
	         *  Movimentar
	         *
	         **********************************************************/
	        
	        if(Game.getInstance().startNewPiece == true && this.jaInicializouNessaRodada == false) {
	             
	        	Game.getInstance().startNewPiece = false;
	            
	            Game.getInstance().jogadas++;
	            
	            if (cor == Color.RED && jaInicializouNessaRodada == false) {
	            	
	            	MovementFunctions.startNewPieceInGame(0, Game.getInstance().redPieces, Game.getInstance().numberOfRedPieces);
	                redPieces[Game.getInstance().numberOfRedPieces].house = 0;
	            	jaInicializouNessaRodada  = true;
	            } else if (cor == Color.GREEN && jaInicializouNessaRodada == false) {
	            	
	            	MovementFunctions.startNewPieceInGame(13, Game.getInstance().greenPieces, Game.getInstance().numberOfGreenPieces);
	            	greenPieces[Game.getInstance().numberOfGreenPieces].house = 13;
	            	jaInicializouNessaRodada = true;
	            } else if (cor == Color.YELLOW && jaInicializouNessaRodada == false) {
	            	
	            	MovementFunctions.startNewPieceInGame(26, Game.getInstance().yellowPieces, Game.getInstance().numberOfYellowPieces);
	            	yellowPieces[Game.getInstance().numberOfYellowPieces].house = 26;
	            	jaInicializouNessaRodada = true;
	            } else if (cor == Color.BLUE && jaInicializouNessaRodada == false) {
	            	
	            	MovementFunctions.startNewPieceInGame(39, Game.getInstance().bluePieces, Game.getInstance().numberOfBluePieces);
	            	bluePieces[Game.getInstance().numberOfBluePieces].house = 39;
	            	jaInicializouNessaRodada = true;
	            }
	             
	        } else {
	             
	            if(clickIsInsideRetaFinal == true && house >= 0 && house < 5) {
	 
	                if(Color.GREEN == cor) {
	                    
	                	indexOfPieceAtHouseVector = MovementFunctions.movimentoNaRetaFinal(Game.getInstance().retaFinalGreen, cor, dado, house);
	                    
	                    if((dado + house) == 5) { 
	                    	Game.getInstance().qtdPecasFinalizadasVerde++;
	                        
	                        if(Game.getInstance().qtdPecasFinalizadasVerde == 4) {
	                        	
	                        	/**********************************************************
	                             * 
	                             *  O vencedor do jogo seraÌ� o jogador que primeiro conseguir poÌ‚r seus 4 peoÌƒes na casa final. Nesse momento, o jogo seraÌ� finalizado.
	                             *
	                             **********************************************************/
	                        	
	                        	JOptionPane.showMessageDialog(new JFrame(), "Você ganhou o jogo! Parabêns!", "Ludo Game",
	                                    JOptionPane.INFORMATION_MESSAGE);
	                        	Game.getInstance().comecarJogoNovo();
	                        	
	                        } else {
	                        	
	                        	/**********************************************************
	                             * 
	                             *  O jogador que chegar com um peaÌƒo aÌ€ sua casa final poderaÌ� avancÌ§araÌ� 10 casas com algum de seus outros peoÌƒes.
	                             *
	                             **********************************************************/
	                            
	                            JOptionPane.showMessageDialog(new JFrame(), "Você pode andar 10 casas com algum peão!", "Ludo Game",
	                                    JOptionPane.INFORMATION_MESSAGE);
	                            dice.setNumber(10);
	                            Game.getInstance().jogadas++;
	                        	
	                        }
	                        
	                    }
	                    
	                }
	                 
	                if(Color.RED == cor) {
	                	
	                	indexOfPieceAtHouseVector = MovementFunctions.movimentoNaRetaFinal(Game.getInstance().retaFinalRed, cor, dado, house);
	                    
	                    if((dado + house) == 5) { 
	                    	Game.getInstance().qtdPecasFinalizadasVermelho++;
	                        
	                        if(Game.getInstance().qtdPecasFinalizadasVermelho == 4) {
	                        	
	                        	/**********************************************************
	                             * 
	                             *  O vencedor do jogo seraÌ� o jogador que primeiro conseguir poÌ‚r seus 4 peoÌƒes na casa final. Nesse momento, o jogo seraÌ� finalizado.
	                             *
	                             **********************************************************/
	                        	
	                        	JOptionPane.showMessageDialog(new JFrame(), "Voce ganhou o jogo! Parabens!", "Ludo Game",
	                                    JOptionPane.INFORMATION_MESSAGE);
	                        	Game.getInstance().comecarJogoNovo();
	                        	
	                        } else {
	                        	
	                        	/**********************************************************
	                             * 
	                             *  O jogador que chegar com um peaÌƒo aÌ€ sua casa final poderaÌ� avancÌ§araÌ� 10 casas com algum de seus outros peoÌƒes.
	                             *
	                             **********************************************************/
	                            
	                            JOptionPane.showMessageDialog(new JFrame(), "Voce pode andar 10 casas com algum peao!", "Ludo Game",
	                                    JOptionPane.INFORMATION_MESSAGE);
	                            dice.setNumber(10);
	                            Game.getInstance().jogadas++;
	                        	
	                        }
	                    }
	                     
	                }
	                 
	                if(Color.BLUE == cor) {
	                	
	                	indexOfPieceAtHouseVector = MovementFunctions.movimentoNaRetaFinal(Game.getInstance().retaFinalBlue, cor, dado, house);
	                    
	                    if((dado + house) == 5) { 
	                    	Game.getInstance().qtdPecasFinalizadasAzul++;
	                        
	                        if(Game.getInstance().qtdPecasFinalizadasAzul == 4) {
	                        	
	                        	/**********************************************************
	                             * 
	                             *  O vencedor do jogo seraÌ� o jogador que primeiro conseguir poÌ‚r seus 4 peoÌƒes na casa final. Nesse momento, o jogo seraÌ� finalizado.
	                             *
	                             **********************************************************/
	                        	
	                        	JOptionPane.showMessageDialog(new JFrame(), "Voce ganhou o jogo! Parabens!", "Ludo Game",
	                                    JOptionPane.INFORMATION_MESSAGE);
	                        	Game.getInstance().comecarJogoNovo();
	                        	
	                        } else {
	                        	
	                        	/**********************************************************
	                             * 
	                             *  O jogador que chegar com um peaÌƒo aÌ€ sua casa final poderaÌ� avancÌ§araÌ� 10 casas com algum de seus outros peoÌƒes.
	                             *
	                             **********************************************************/
	                            
	                            JOptionPane.showMessageDialog(new JFrame(), "Voce pode andar 10 casas com algum peao!", "Ludo Game",
	                                    JOptionPane.INFORMATION_MESSAGE);
	                            dice.setNumber(10);
	                            Game.getInstance().jogadas++;
	                        	
	                        }
	                    }
	                     
	                }
	                 
	                if(Color.YELLOW == cor) {
	                	
	                	indexOfPieceAtHouseVector = MovementFunctions.movimentoNaRetaFinal(Game.getInstance().retaFinalYellow, cor, dado, house);
	                    
	                    if((dado + house) == 5) { 
	                    	Game.getInstance().qtdPecasFinalizadasAmarelo++;
	                        
	                        if(Game.getInstance().qtdPecasFinalizadasAmarelo == 4) {	
	                        	
	                        	/**********************************************************
	                             * 
	                             *  O vencedor do jogo seraÌ� o jogador que primeiro conseguir poÌ‚r seus 4 peoÌƒes na casa final. Nesse momento, o jogo seraÌ� finalizado.
	                             *
	                             **********************************************************/
	                        	
	                        	JOptionPane.showMessageDialog(new JFrame(), "VocÃª ganhou o jogo! ParabÃ©ns!", "Ludo Game",
	                                    JOptionPane.INFORMATION_MESSAGE);
	                        	Game.getInstance().comecarJogoNovo();
	                        	
	                        } else {
	                        	
	                        	/**********************************************************
	                             * 
	                             *  O jogador que chegar com um peaÌƒo aÌ€ sua casa final poderaÌ� avancÌ§araÌ� 10 casas com algum de seus outros peoÌƒes.
	                             *
	                             **********************************************************/
	                            
	                            JOptionPane.showMessageDialog(new JFrame(), "Você pode andar 10 casas com algum peão!", "Ludo Game",
	                                    JOptionPane.INFORMATION_MESSAGE);
	                            dice.setNumber(10);
	                            Game.getInstance().jogadas++;
	                        	
	                        }
	                    }
	                     
	                }
	                 
	            }
	             
	            if(clickIsInsideRetaFinal == false && house >= 0 && house < 52) {

	                for( int j =0 ; j< Game.getInstance().listaPrincipal[house].count() ; j++)
	                {
	                	
	                    if (Game.getInstance().listaPrincipal[house].pecas[j].color.equals(cor))
	                    {
	                        indexOfPieceAtHouseVector = j;
	                    }
	                }
	                
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
	                 
	                boolean entrarNaCasaFinal = false;
	                
	                //Regra para entrar na casa final: 
	                 
	                if(cor == Color.GREEN && house <= 11 && (house + dado) > 11) {
	                    if (((house + dado) - 11) <= 6) {
	                        entrarNaCasaFinal = true;
	                    } else {
	                        podeAndar = false; //NÃ£o pode andar, pois para chegar na casa final, tem que ser com um nÃºmero exato
	                    }
	                }
	                 
	                if(cor == Color.YELLOW && house <= 24 && (house + dado) > 24) {
	                    if (((house + dado) - 24) <= 6) {
	                        entrarNaCasaFinal = true;
	                    } else {
	                        podeAndar = false; //NÃ£o pode andar, pois para chegar na casa final, tem que ser com um nÃºmero exato
	                    }
	                }
	                 
	                if(cor == Color.BLUE && house <= 37 && (house + dado) > 37) {
	                    if (((house + dado) - 37) <= 6) {
	                        entrarNaCasaFinal = true;
	                    } else {
	                        podeAndar = false; //NÃ£o pode andar, pois para chegar na casa final, tem que ser com um nÃºmero exato
	                    }
	                }
	                 
	                if(cor == Color.RED && house <= 50 && (house + dado) > 50) {
	                    if (((house + dado) - 50) <= 6) {
	                        entrarNaCasaFinal = true;
	                    } else {
	                        podeAndar = false; //NÃ£o pode andar, pois para chegar na casa final, tem que ser com um nÃºmero exato
	                    }
	                }
	                
	                /************************************************
	                 * 
	                 * Verifica se te barreira
	                 * 
	                 ***********************************************/
	                if(podeAndar) {
	                	podeAndar = GameRules.verificaSeTemBarreira(cor, house, dado);
	                }
	                 
	                if(podeAndar && Game.getInstance().listaPrincipal[house].pecas[indexOfPieceAtHouseVector] != null && Game.getInstance().listaPrincipal[house].pecas[indexOfPieceAtHouseVector].color == cor  ) {
	 
	                	Game.getInstance().jogadas--;
	                	
	                    if(entrarNaCasaFinal == false) {
	                    	
	                    	/**********************************************************
	                         * 
	                         *  Comer peÃ§a
	                         *
	                         **********************************************************/
	                    	
	                    	boolean podeComer = GameRules.confereSePodeComerPeca(iprov+dadoProv, cor);
	                    	
	                    	if( podeComer ) {
	                    		Game.getInstance().listaPrincipal[iprov+dadoProv].comerPecas();
	                    	}
	                    	
	                    	Game.getInstance().listaPrincipal[iprov+dadoProv].reorganizePieceArray();
	                    	int novoIndex = Game.getInstance().listaPrincipal[iprov+dadoProv].getPieceFreeLocationOnHouseArray();
	                    	Game.getInstance().listaPrincipal[iprov+dadoProv].pecas[novoIndex] = Game.getInstance().listaPrincipal[house].pecas[indexOfPieceAtHouseVector];
	                    	Game.getInstance().listaPrincipal[iprov+dadoProv].pecas[novoIndex].house = iprov+dadoProv;
	                    	Game.getInstance().listaPrincipal[house].pecas[indexOfPieceAtHouseVector] = null;
	                        ultimaPecaMovimentada = iprov+dadoProv;
	                        
	                        if( podeComer ) {
	                        	Screen.getInstance().repaint();
	                        	
	                        	 JOptionPane.showMessageDialog(new JFrame(), "Você capturou uma peça do adversario, ande 20 casas", "Ludo Game",
	                                     JOptionPane.INFORMATION_MESSAGE);
	                        	 
	                        	 dice.setNumber(20);
	                        	 Game.getInstance().jogadas+=2;
	                        	 
	                        	   if(cor == Color.GREEN && house <= 11 && (house + 20) > 11) {
	                                   if (((house + 20) - 11) <= 6) {
	                                       entrarNaCasaFinal = true;
	                                   } else {
	                                       podeAndar = false; //NÃ£o pode andar, pois para chegar na casa final, tem que ser com um nÃºmero exato
	                                   }
	                               }
	                                
	                               if(cor == Color.YELLOW && house <= 24 && (house + 20) > 24) {
	                                   if (((house + 20) - 24) <= 6) {
	                                       entrarNaCasaFinal = true;
	                                   } else {
	                                       podeAndar = false; //NÃ£o pode andar, pois para chegar na casa final, tem que ser com um nÃºmero exato
	                                   }
	                               }
	                                
	                               if(cor == Color.BLUE && house <= 37 && (house + 20) > 37) {
	                                   if (((house + 20) - 37) <= 6) {
	                                       entrarNaCasaFinal = true;
	                                   } else {
	                                       podeAndar = false; //NÃ£o pode andar, pois para chegar na casa final, tem que ser com um nÃºmero exato
	                                   }
	                               }
	                                
	                               if(cor == Color.RED && house <= 50 && (house + 20) > 50) {
	                                   if (((house + 20) - 50) <= 6) {
	                                       entrarNaCasaFinal = true;
	                                   } else {
	                                       podeAndar = false; //NÃ£o pode andar, pois para chegar na casa final, tem que ser com um nÃºmero exato
	                                   }
	                               }
	                        }

	                         
	                    } if(entrarNaCasaFinal == true) {

	                    	
	                        if(cor == Color.GREEN) {
	                        	//TODO:
	                        	MovementFunctions.movimentoParaEntrarNaRetaFinal(11, Game.getInstance().retaFinalGreen, Game.getInstance().listaPrincipal, house, dado, indexOfPieceAtHouseVector);
	                        	
	                        }
	                         
	                        if(cor == Color.YELLOW) {
	                        	
	                        	MovementFunctions.movimentoParaEntrarNaRetaFinal(24, Game.getInstance().retaFinalYellow, Game.getInstance().listaPrincipal, house, dado, indexOfPieceAtHouseVector);
	                        
	                        }
	                         
	                        if(cor == Color.BLUE) {
	                        	
	                        	MovementFunctions.movimentoParaEntrarNaRetaFinal(37, Game.getInstance().retaFinalBlue, Game.getInstance().listaPrincipal, house, dado, indexOfPieceAtHouseVector);
	                        
	                        }
	                         
	                        if(cor == Color.RED) {
	                        	
	                        	MovementFunctions.movimentoParaEntrarNaRetaFinal(50, Game.getInstance().retaFinalRed, Game.getInstance().listaPrincipal, house, dado, indexOfPieceAtHouseVector);
	                        	
	                        }
	                         
	                    }
	                         
	                }
	                 
	            }
	   
	        }
	        
	        Game.getInstance().contruct = true;

	        Screen.getInstance().repaint();
	    }

}
