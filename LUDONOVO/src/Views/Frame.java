package Views;
 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Controllers.Dice;
import Controllers.Game;
import Controllers.GameRules;
import Models.FileManager;
 
public class Frame extends JFrame 
 {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private int casa = -1;
     
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    private int width;
    private int height =(int) screenSize.getHeight();
     
    int valorDado = 0;
     
    JLabel texto = new JLabel("Dado sorteado");
    JLabel vezDoJogador = new JLabel("Vez do Jogador:");
    JLabel jogador = new JLabel("");
    JLabel pecFinRed = new JLabel("Peças finalizadas: 0");
    JLabel pecFinGreen = new JLabel("Peças finalizadas: 0");
    JLabel pecFinYellow = new JLabel("Peças finalizadas: 0");
    JLabel pecFinBlue = new JLabel("Peças finalizadas: 0");
    
    JLabel lab = new JLabel();
    
    private String[] nomeDasCores = {"VERMELHO", "VERDE", "AMARELO", "AZUL"};
     
    Dice dice = Dice.getInstance();
     
    public Frame()
    {
         
        width = height + height/30;
        height -= height/6;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width,height);
        setResizable(false);
        setTitle("Ludo Game");
        setLocationRelativeTo(null);
        setLayout(null);
        startFrameLayout(); 
         
    }
 
    public void startFrameLayout()
    { 
        
        /**********************************************************
         * 
         *  Screen
         *
         **********************************************************/
     
    	Screen.getInstance().setBounds(0, 0, (int) screenSize.getHeight() - 150, (int) screenSize.getHeight() - 150);
        
        add(Screen.getInstance());
         
        /**********************************************************
         * 
         *  Labels
         *
         **********************************************************/
        
        pecFinRed.setForeground(Color.RED);
        pecFinGreen.setForeground(Color.GREEN);
        pecFinYellow.setForeground(Color.YELLOW);
        pecFinBlue.setForeground(Color.BLUE);
        
        pecFinRed.setBounds(width - height/4, height- height/2 - 100,200,30);
        pecFinGreen.setBounds(width - height/4, height- height/2 - 80,200,30);
        pecFinYellow.setBounds(width - height/4, height- height/2 - 60,200,30);
        pecFinBlue.setBounds(width - height/4, height- height/2 - 40,200,30);

        pecFinRed.setVisible(false);
        pecFinGreen.setVisible(false);
        pecFinYellow.setVisible(false);
        pecFinBlue.setVisible(false);
        
        add(pecFinRed);
        add(pecFinGreen);
        add(pecFinYellow);
        add(pecFinBlue);
        
        texto.setBounds(width- height/5, height - height/3 -20, 100, 30);       
        texto.setVisible(false);
        
        vezDoJogador.setBounds(width-height/5,height-height/2,100,30);
        vezDoJogador.setVisible(false);
        
        jogador.setBounds(width-height/5,height-height/2 +30,100,30);
        jogador.setVisible(false);
        
        add(texto);
        add(vezDoJogador);
        add(jogador);
        
        /**********************************************************
         * 
         *  Dice Image
         *
         **********************************************************/
        
        lab.setBounds(width-width/7, height -200, 60, 60);
        lab.setVisible(false);
        
        add(lab);
        
        /**********************************************************
         * 
         *  Buttons
         *
         **********************************************************/
        
        JButton NewGameButton = new JButton("New Game");
        JButton ThrowDiceButton = new JButton("Throw Dice");
        JButton SaveGameButton = new JButton ("Save Game");
        JButton LoadGameButton = new JButton ("Load Game");
         
        NewGameButton.setBounds(width -height/5, 10, 100, 30);
        SaveGameButton.setBounds(width -height/5, 50, 100, 30);
        LoadGameButton.setBounds(width - height/5, 90, 100, 30);
        ThrowDiceButton.setBounds(width -height/5, height -100, 100, 30);
        
        add(NewGameButton);
        add(ThrowDiceButton);
        add(SaveGameButton);
        add(LoadGameButton);
     
        /**********************************************************
         * 
         *  Buttons Action
         *
         **********************************************************/
        
        NewGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             
            	newGameButtonAction();
                 
            }
        });
     
        ThrowDiceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
 
            	throwDiceButtonAction();
             
            }
             
        });
         
        SaveGameButton.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		try {
					saveGameButtonAction();
				} catch (IOException e1) {
					e1.getMessage();
				}
        	}
        });
        
        LoadGameButton.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        	
					try {
						loadGameButton();
						texto.setVisible(true);
				    	jogador.setVisible(true);
				    	vezDoJogador.setVisible(true);
				    	pecFinRed.setVisible(true);
				    	pecFinGreen.setVisible(true);
				    	pecFinYellow.setVisible(true);
				    	pecFinBlue.setVisible(true);
				    	lab.setVisible(true); 
				    	lab.setIcon(dice.getImageIcon());
				    	jogador.setText(nomeDasCores[Game.getInstance().rounds%4]);
				    	jogador.setForeground(GameRules.colorOfRound(Game.getInstance().rounds%4));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						
					}
				
        		
        	}
        }
        );
        
        /**********************************************************
        * 
        *  Mouse Action
        *
        **********************************************************/
         
        Screen.getInstance().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 
            	mouseClickedAction(e);
 
            }
        });
         
        setVisible(true); 
 
    }
    
    /**********************************************************
     * 
     *  Save Game Button Action
     *  
     **********************************************************/
    
    private void saveGameButtonAction() throws IOException
    {
    	FileManager.saveGame();
		JOptionPane.showMessageDialog(new JFrame(), "Jogo salvo!", "Ludo Game",
                JOptionPane.INFORMATION_MESSAGE);

    }

    
    /**********************************************************
     * 
     *  loadGameButton
     *
     **********************************************************/
    
    private void loadGameButton() throws IOException
    {
    	newGameButtonAction();
    	FileManager.loadGame();
    	Game.getInstance().contruct=true;
    	Screen.getInstance().repaint();
    	
    	JOptionPane.showMessageDialog(new JFrame(), "Jogo carregado!", "Ludo Game",
	                JOptionPane.INFORMATION_MESSAGE);
    
    }
    
    /**********************************************************
     * 
     *  New Game Button Action
     *
     **********************************************************/
    private void newGameButtonAction() {
    	
    	Game.getInstance().rounds = 0;
        texto.setVisible(false);
        vezDoJogador.setVisible(false);
        jogador.setVisible(false);
        
        pecFinRed.setVisible(false);
        pecFinGreen.setVisible(false);
        pecFinYellow.setVisible(false);
        pecFinBlue.setVisible(false);
        
        pecFinRed.setText("Peï¿½as finalizadas: 0");
        pecFinGreen.setText("Peï¿½as finalizadas: 0");
        pecFinYellow.setText("Peï¿½as finalizadas: 0");
        pecFinBlue.setText("Peï¿½as finalizadas: 0");
        
        lab.setVisible(false);
         
        valorDado = 0;
        Game.getInstance().comecarJogoNovo();
    	
    }
    
    /**********************************************************
     * 
     *  Throw Dice Button Action
     *
     *
     **********************************************************/
    private void throwDiceButtonAction() {
    	
    	dice.GenerateAleatoryNumber();
    	valorDado = dice.GetAleatoryNumber();
    	texto.setVisible(true);
    	jogador.setVisible(true);
    	vezDoJogador.setVisible(true);
    	pecFinRed.setVisible(true);
    	pecFinGreen.setVisible(true);
    	pecFinYellow.setVisible(true);
    	pecFinBlue.setVisible(true);
    	
    	jogador.setText(nomeDasCores[Game.getInstance().rounds%4]);
    	jogador.setForeground(GameRules.colorOfRound(Game.getInstance().rounds%4));
    	
    	lab.setVisible(true); 
    	lab.setIcon(dice.getImageIcon());
    	
    	/**********************************************************
         * 
         *  Regra do Sobre 6: 
         *   - AvancÌ§ar sete casas caso naÌƒo tenha mais peoÌƒes para retirar de sua casa inicial.
         *
         **********************************************************/
    	
    	GameRules.dadoPodeValerSete();
    	
    	/**********************************************************
         * 
         *  Regra do Sobre 6: 
         *   - Se repetir o 6 3 vezes, retorna o Ãºltimo movimento
         *
         **********************************************************/
    	
    	if( valorDado == 6 )
    	{
    		Game.getInstance().qtdDeDadosSeisTirandosSeguidos++;
    	}
    	
    	if( valorDado != 6 )
    	{
    		Game.getInstance().qtdDeDadosSeisTirandosSeguidos = 0;
    	}
    	
    	if(Game.getInstance().qtdDeDadosSeisTirandosSeguidos == 3)
    	{
    		Game.getInstance().hidePiece(GameRules.colorOfRound(Game.getInstance().rounds-1), -dice.GetAleatoryNumber(), Game.getInstance().ultimaPecaMovimentada);
    	}
    	
    	Game.getInstance().jogadas = 2000;
    	Game.getInstance().jaInicializouNessaRodada = false;
    	Game.getInstance().rounds++;
    	
    }
    
    /**********************************************************
     * 
     *  Mouse Clicked Action
     *
     **********************************************************/
    
    private void mouseClickedAction(MouseEvent e) {
    	
    	pecFinRed.setText("Peï¿½as finalizadas: "+ Game.getInstance().qtdPecasFinalizadasVermelho);
        pecFinGreen.setText("Peï¿½as finalizadas: "+ Game.getInstance().qtdPecasFinalizadasVerde);
        pecFinYellow.setText("Peï¿½as finalizadas: "+ Game.getInstance().qtdPecasFinalizadasAmarelo);
        pecFinBlue.setText("Peï¿½as finalizadas: "+ Game.getInstance().qtdPecasFinalizadasAzul);
        
        if(valorDado != 0)
        { 
            casa = Game.getInstance().searchPieceHouseByClick(e.getX(), e.getY(),jogador.getForeground());
            
            boolean verificaSeTemBarreira = true;
            
            if (casa < 53) {
            	verificaSeTemBarreira = GameRules.verificaSeTemBarreira(GameRules.colorOfRound(Game.getInstance().rounds-1), casa, dice.GetAleatoryNumber());
            }
            
            if(dice.GetAleatoryNumber() != 6 && verificaSeTemBarreira)
        		Game.getInstance().jogadas--;
            
            if( casa != -1) {
                try{
                	
                	if( Game.getInstance().jogadas > 0 ) {
                		Game.getInstance().hidePiece(GameRules.colorOfRound(Game.getInstance().rounds-1), dice.GetAleatoryNumber() ,casa);
                		
                		pecFinRed.setText("Peï¿½as finalizadas: "+ Game.getInstance().qtdPecasFinalizadasVermelho);
                        pecFinGreen.setText("Peï¿½as finalizadas: "+ Game.getInstance().qtdPecasFinalizadasVerde);
                        pecFinYellow.setText("Peï¿½as finalizadas: "+ Game.getInstance().qtdPecasFinalizadasAzul);
                        pecFinBlue.setText("Peï¿½as finalizadas: "+ Game.getInstance().qtdPecasFinalizadasAmarelo);
                        
                	} else {
                		
                		 JOptionPane.showMessageDialog(new JFrame(), "Sua vez de jogar, acabou!", "Ludo Game",
                                 JOptionPane.INFORMATION_MESSAGE);
                		 
                	}
                    
                }
                catch(Exception ex)
                {
                     JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Ludo Game",
                             JOptionPane.ERROR_MESSAGE);
                }
            }
             
         }
    	
    }
    
    
        
}