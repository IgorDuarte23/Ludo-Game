package Views;
 
import java.awt.*;

import javax.swing.JPanel;
import Controllers.Game;
import Controllers.Pieces;
 
public class Screen extends JPanel{
     
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private static final Screen INSTANCE = new Screen();
     
    private int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private int height =(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    
    private int size;
    
    private Graphics2D g;
 
    private char matrizTabuleiro[][];
    /*
     *  w = white
     *  r = red
     *  g = green
     *  b = blue
     *  y = yellow
     *  d = dark(black)
     */
    
    public static Screen getInstance() { 
        return INSTANCE;
    }
	   
    private Screen()
    {
         
        height = height - 150;
        width = height;
         
        size = width/15;
        
        Game.getInstance().contruct = false;
    }
     
    public void paint (Graphics graphic)
    {
        g = (Graphics2D) graphic;
        /**********************************************************
         * 
         *  Quadrado Menores - sem cor
         *
         **********************************************************/
         
        matrizTabuleiro = new char[15][15];
         
        for(int i=0; i<15; i++) {
            for(int j=0; j<15; j++) {
                matrizTabuleiro[i][j] = 'w';    
            }
        }
         
        /**********************************************************
         * 
         *  Quadrado Menores - definindo a cor dos menores
         *
         **********************************************************/
         
        //Vermelho
         
        matrizTabuleiro[6][1] = 'r';
         
        for(int j = 1; j < 6; j++) {
            matrizTabuleiro[7][j] = 'r';
        }
         
        //Verde
         
        matrizTabuleiro[1][8] = 'g';
                 
        for(int j = 1; j < 6; j++) {
            matrizTabuleiro[j][7] = 'g';
        }
         
        //Amarelo
         
        matrizTabuleiro[8][13] = 'y';
                         
        for(int j = 1; j < 6; j++) {
            matrizTabuleiro[7][14-j] = 'y';
        }
         
        //Azul
         
        matrizTabuleiro[13][6] = 'b';
                                 
        for(int j = 1; j < 6; j++) {
            matrizTabuleiro[14-j][7] = 'b';
        }
         
        /**********************************************************
         * 
         *  Definindo casas de abrigo
         *
         **********************************************************/
         
        //blue
        matrizTabuleiro[13][8] = 'd';
             
        //yellow
        matrizTabuleiro[6][13] = 'd';
             
        //green
        matrizTabuleiro[1][6] = 'd';
         
        //vermelho
        matrizTabuleiro[8][1] = 'd';
         
        /**********************************************************
         * 
         *  Mostrando todos os quadrados
         *
         **********************************************************/
         
        showMatrizTabuleiro();
         
        /**********************************************************
         * 
         *  Quadrados grandes
         *
         **********************************************************/
             
        int bigSquareSize = size * 6; 
         
        //Quadrado grande vermelho
         
        g.setColor(Color.RED);
        g.fillRect(0, 0, bigSquareSize, bigSquareSize);
           
        //Quadrado grande verde
         
        g.setColor(Color.GREEN);
        g.fillRect(size * 9, 0, bigSquareSize, bigSquareSize);
           
        //Quadrado grande azul
         
        g.setColor(Color.BLUE);
        g.fillRect(0, size * 9, bigSquareSize, bigSquareSize);
           
        //Quadrado grande amarelo
         
        g.setColor(Color.YELLOW);
        g.fillRect(size * 9, size * 9, bigSquareSize, bigSquareSize);
 
        /**********************************************************
         * 
         *  Desenhando as setas pequenas indicando o inï¿½cio do tabuleiro
         *
         **********************************************************/
         
        fillWriteSetter();
         
        /**********************************************************
         * 
         *  Desenhando as setas do centro do tabuleiro
         *
         **********************************************************/
         
        setInsidePolygons();
         
        /**********************************************************
         * 
         *  Desenhando os quadrados brancos
         *
         **********************************************************/
         
        setWhiteSquare();
         
        if( Game.getInstance().contruct == false ){
             
            /**********************************************************
             * 
             *  Definindo a posiï¿½ï¿½o de inï¿½cio das peï¿½as
             *
             **********************************************************/
             
            setStartPiecesPosition();
             
        } else {
        	
        	refreshStartPieces();
        	
        }
         
        /**********************************************************
         * 
         *  Mostrando as peï¿½as
         *
         **********************************************************/
         
        setPositionOfHouses();
        setPositionOfFinalHouses();
         
        for ( int k =0; k <4 ;k++)
        {
            showPiece(Game.getInstance().redPieces[k]);
            showPiece(Game.getInstance().greenPieces[k]);
            showPiece(Game.getInstance().bluePieces[k]);
            showPiece(Game.getInstance().yellowPieces[k]);
                 
        }
         
    }
    
    private void refreshStartPieces() {
    	
    	if( !Game.getInstance().redPieces[0].isInGame ) {
    		Game.getInstance().redPieces[0].posX = size*2 +size/7;
    		Game.getInstance().redPieces[0].posY = size*2 + size/7;
    	}
         
    	if( !Game.getInstance().redPieces[1].isInGame ) {
    		Game.getInstance().redPieces[1].posX = size*3 + size/7;
    		Game.getInstance().redPieces[1].posY = size*2 + size/7;
    	}
         
    	if( !Game.getInstance().redPieces[2].isInGame ) {
    		Game.getInstance().redPieces[2].posX = size*2 + size/7;
    		Game.getInstance().redPieces[2].posY = size*3 + size/7;
    	}
         
    	if( !Game.getInstance().redPieces[3].isInGame ) {
    		Game.getInstance().redPieces[3].posX = size*3 + size/7;
    		Game.getInstance().redPieces[3].posY = size*3 + size/7;
    	}
         
    	if( !Game.getInstance().greenPieces[0].isInGame ) {
    		Game.getInstance().greenPieces[0].posX = size*11 + size/7;
    		Game.getInstance().greenPieces[0].posY = size*2 + size/7;
    	}
         
    	if( !Game.getInstance().greenPieces[1].isInGame ) {
    		Game.getInstance().greenPieces[1].posX = size*12 + size/7;
    		Game.getInstance().greenPieces[1].posY = size*2 + size/7;
    	}
         
    	if( !Game.getInstance().greenPieces[2].isInGame ) {
    		Game.getInstance().greenPieces[2].posX = size*11 + size/7;
    		Game.getInstance().greenPieces[2].posY = size*3 + size/7;
    	}
         
    	if( !Game.getInstance().greenPieces[3].isInGame ) {
    		Game.getInstance().greenPieces[3].posX = size*12 + size/7;
    		Game.getInstance().greenPieces[3].posY = size*3 + size/7;
    	}
         
    	if( !Game.getInstance().yellowPieces[0].isInGame ) {
    		Game.getInstance().yellowPieces[0].posX = size*11 + size/7;
    		Game.getInstance().yellowPieces[0].posY = size*11 + size/7;
    	}
         
    	if( !Game.getInstance().yellowPieces[1].isInGame ) {
    		Game.getInstance().yellowPieces[1].posX = size*12 + size/7;
    		Game.getInstance().yellowPieces[1].posY = size*11 + size/7;
    	}
         
    	if( !Game.getInstance().yellowPieces[2].isInGame ) {
    		Game.getInstance().yellowPieces[2].posX = size*11 + size/7;
    		Game.getInstance().yellowPieces[2].posY = size*12 + size/7;
    	}
         
    	if( !Game.getInstance().yellowPieces[3].isInGame ) {
    		Game.getInstance().yellowPieces[3].posX = size*12 + size/7;
    		Game.getInstance().yellowPieces[3].posY = size*12 + size/7;
    	}
         
    	if( !Game.getInstance().bluePieces[0].isInGame ) {
    		Game.getInstance().bluePieces[0].posX = size*2 + size/7;
    		Game.getInstance().bluePieces[0].posY = size*11 + size/7;
    	}
    	
    	if( !Game.getInstance().bluePieces[1].isInGame ) {
    		Game.getInstance().bluePieces[1].posX = size*3 + size/7;
    		Game.getInstance().bluePieces[1].posY = size*11 + size/7;
    	}
         
    	if( !Game.getInstance().bluePieces[2].isInGame ) {
    		Game.getInstance().bluePieces[2].posX = size*2 + size/7;
    		Game.getInstance().bluePieces[2].posY = size*12 + size/7;
    	}
         
    	if( !Game.getInstance().bluePieces[3].isInGame ) {
    		Game.getInstance().bluePieces[3].posX = size*3 + size/7;
    		Game.getInstance().bluePieces[3].posY = size*12 + size/7;
    	}
    	
    }
     
    private void setStartPiecesPosition() {
    	
    	for(int i=0; i<4; i++) {
        	Game.getInstance().redPieces[i].size = (int) (size*0.75);
        	Game.getInstance().greenPieces[i].size = (int) (size*0.75);
        	Game.getInstance().bluePieces[i].size = (int) (size*0.75);
            Game.getInstance().yellowPieces[i].size = (int) (size*0.75);
        }
         
        Game.getInstance().redPieces[0].posX = size*2 +size/7;
        Game.getInstance().redPieces[0].posY = size*2 + size/7;
         
        Game.getInstance().redPieces[1].posX = size*3 + size/7;
        Game.getInstance().redPieces[1].posY = size*2 + size/7;
         
        Game.getInstance().redPieces[2].posX = size*2 + size/7;
        Game.getInstance().redPieces[2].posY = size*3 + size/7;
         
        Game.getInstance().redPieces[3].posX = size*3 + size/7;
        Game.getInstance().redPieces[3].posY = size*3 + size/7;
         
        Game.getInstance().greenPieces[0].posX = size*11 + size/7;
        Game.getInstance().greenPieces[0].posY = size*2 + size/7;
         
        Game.getInstance().greenPieces[1].posX = size*12 + size/7;
        Game.getInstance().greenPieces[1].posY = size*2 + size/7;
         
        Game.getInstance().greenPieces[2].posX = size*11 + size/7;
        Game.getInstance().greenPieces[2].posY = size*3 + size/7;
         
        Game.getInstance().greenPieces[3].posX = size*12 + size/7;
        Game.getInstance().greenPieces[3].posY = size*3 + size/7;
         
        Game.getInstance().yellowPieces[0].posX = size*11 + size/7;
        Game.getInstance().yellowPieces[0].posY = size*11 + size/7;
         
        Game.getInstance().yellowPieces[1].posX = size*12 + size/7;
        Game.getInstance().yellowPieces[1].posY = size*11 + size/7;
         
        Game.getInstance().yellowPieces[2].posX = size*11 + size/7;
        Game.getInstance().yellowPieces[2].posY = size*12 + size/7;
         
        Game.getInstance().yellowPieces[3].posX = size*12 + size/7;
        Game.getInstance().yellowPieces[3].posY = size*12 + size/7;
         
        Game.getInstance().bluePieces[0].posX = size*2 + size/7;
        Game.getInstance().bluePieces[0].posY = size*11 + size/7;
         
        Game.getInstance().bluePieces[1].posX = size*3 + size/7;
        Game.getInstance().bluePieces[1].posY = size*11 + size/7;
         
        Game.getInstance().bluePieces[2].posX = size*2 + size/7;
        Game.getInstance().bluePieces[2].posY = size*12 + size/7;
         
        Game.getInstance().bluePieces[3].posX = size*3 + size/7;
        Game.getInstance().bluePieces[3].posY = size*12 + size/7;
         
    }
     
    private void showPiece(Pieces piece) {
         
        g.setColor(piece.color);
        g.fill(piece);
 
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(2));
        g.draw(piece);
         
    }
     
    private void setWhiteSquare() {
         
        //Vermelho
        Polygon square = new Polygon();
                 
        square.addPoint(size/2, size*3);
        square.addPoint(size*3, size/2);
        square.addPoint(size*6 - size/2, size*3);
        square.addPoint(size*3, size*6 - size/2);
                 
        g.setColor(Color.WHITE);
        g.draw(square);
        g.fill(square);
         
        //Verde
        square.reset();
                         
        square.addPoint(size/2 + size*9, size*3);
        square.addPoint(size*12, size/2);
        square.addPoint(size*15 - size/2, size*3);
        square.addPoint(size*12, size*6 - size/2);
                         
        g.setColor(Color.WHITE);
        g.draw(square);
        g.fill(square);
         
        //Azul
        square.reset();
                         
        square.addPoint(size/2, size*12);
        square.addPoint(size*3, size/2 + size*9);
        square.addPoint(size*6 - size/2, size*12);
        square.addPoint(size*3, size*15 - size/2);
                         
        g.setColor(Color.WHITE);
        g.draw(square);
        g.fill(square);
         
        //Amarelo
        square.reset();
                                 
        square.addPoint(size/2 + size*9, size*12);
        square.addPoint(size*12, size/2 + size*9);
        square.addPoint(size*15 - size/2, size*12);
        square.addPoint(size*12, size*15 - size/2);
                                 
        g.setColor(Color.WHITE);
        g.draw(square);
        g.fill(square);
         
    }
     
    private void showMatrizTabuleiro() {
         
        for(int i = 0; i < matrizTabuleiro.length ; i++) {
            for(int j = 0; j < matrizTabuleiro[i].length ; j++) {
                 
                g.fillRect(j*size, i*size, size, size);
                 
                if( matrizTabuleiro[i][j] == 'w' ){
                     
                    g.setColor(Color.WHITE);
                    g.fillRect(j*size, i*size, size, size);
                     
                }
                 
                if( matrizTabuleiro[i][j] == 'r' ){
                     
                    g.setColor(Color.RED);
                    g.fillRect(j*size, i*size, size, size);
                     
                }
                 
                if( matrizTabuleiro[i][j] == 'b' ){
                     
                    g.setColor(Color.BLUE);
                    g.fillRect(j*size, i*size, size, size);
                     
                }
                 
                if( matrizTabuleiro[i][j] == 'g' ){
                     
                    g.setColor(Color.GREEN);
                    g.fillRect(j*size, i*size, size, size);
                     
                }
 
                if( matrizTabuleiro[i][j] == 'y' ){
                     
                    g.setColor(Color.YELLOW);
                    g.fillRect(j*size, i*size, size, size);
                     
                }
                 
                if( matrizTabuleiro[i][j] == 'd' ){
                     
                    g.setColor(Color.BLACK);
                    g.fillRect(j*size, i*size, size, size);
                     
                }
                 
                g.setColor(Color.BLACK);
                g.drawRect(j*size, i*size, size, size);
                 
            }
        }
         
    }
     
    private void fillWriteSetter()
    {
         
        //Vermelho
        Polygon direction_setter = new Polygon();
         
        direction_setter.addPoint(size+size/5 , size * 6 + size/5);
        direction_setter.addPoint(size+size/5, size * 7- size/5);
        direction_setter.addPoint(size*2 - size/5, size *6 + size/2);
         
        g.setColor(Color.WHITE);
        g.draw(direction_setter);
        g.fill(direction_setter);
         
        //Verde
        direction_setter.reset();
         
        direction_setter.addPoint(size*8+size/5, size+size/5);
        direction_setter.addPoint(size*9 -size/5, size+size/5);
        direction_setter.addPoint(size*8 + size/2, size*2-size/5);
         
        g.setColor(Color.WHITE);
        g.draw(direction_setter);
        g.fill(direction_setter);
         
        //Amarelo
        direction_setter.reset();
         
        direction_setter.addPoint(size*14-size/5,size*8+size/5);
        direction_setter.addPoint(size*14-size/5,size*9-size/5);
        direction_setter.addPoint(size*13+size/5,size*8 +size/2);
         
        g.setColor(Color.WHITE);
        g.draw(direction_setter);
        g.fill(direction_setter);
     
        //Azul
        direction_setter.reset();
         
        direction_setter.addPoint(size*6+size/5, size*14-size/5);
        direction_setter.addPoint(size*7-size/5, size*14-size/5);
        direction_setter.addPoint(size*6+size/2, size*13+size/5);
         
        g.setColor(Color.WHITE);
        g.draw(direction_setter);
        g.fill(direction_setter);
                 
    }
     
    private void setInsidePolygons()
    {
        //Vermelho
         
        Polygon center_arrow = new Polygon();
         
        center_arrow.addPoint(height/2, height/2);
        center_arrow.addPoint(size*6, size*6);
        center_arrow.addPoint(size*6, size*9);
         
        g.setColor(Color.RED);
        g.fill(center_arrow);
         
        g.setColor(Color.BLACK);
        g.draw(center_arrow);
         
        //Verde
         
        center_arrow.reset();
         
        center_arrow.addPoint(height/2, height/2);
        center_arrow.addPoint(size*6, size*6);
        center_arrow.addPoint(size*9, size*6);
         
        g.setColor(Color.GREEN);
        g.fill(center_arrow);
         
        g.setColor(Color.BLACK);
        g.draw(center_arrow);
         
        //Amarelo
         
        center_arrow.reset();
         
        center_arrow.addPoint(height/2, height/2);
        center_arrow.addPoint(size*9, size*6);
        center_arrow.addPoint(size*9, size*9);
         
        g.setColor(Color.YELLOW);
        g.fill(center_arrow);
         
        g.setColor(Color.BLACK);
        g.draw(center_arrow);
         
        //Azul
         
        center_arrow.reset();
         
        center_arrow.addPoint(height/2, height/2);
        center_arrow.addPoint(size*6, size*9);
        center_arrow.addPoint(size*9, size*9);
         
        g.setColor(Color.BLUE);
        g.fill(center_arrow);
         
        g.setColor(Color.BLACK);
        g.draw(center_arrow);
         
    }
     
    private void setPositionOfFinalHouses() {
     
        /**********************************************************
         * 
         *  Verde
         *
         **********************************************************/
         
        for(int i=0; i<6; ++i) {
            for(int j = 0 ; j < Game.getInstance().retaFinalGreen[i].pecas.length; j++) {
                 
                if( Game.getInstance().retaFinalGreen[i].pecas[j] != null && Game.getInstance().selectColor == Game.getInstance().retaFinalGreen[i].pecas[j].color ){
                     
                	Game.getInstance().retaFinalGreen[i].pecas[j].posX = size*7 + size/8;
                	Game.getInstance().retaFinalGreen[i].pecas[j].posY = size*(i+1) +  + size/8;
                     
                }
                 
            }
        }
         
        /**********************************************************
         * 
         *  Vermelho
         *
         **********************************************************/
         
        for(int i=0; i<6; ++i) {
            for(int j = 0 ; j < Game.getInstance().retaFinalRed[i].pecas.length; j++) {
                 
                if( Game.getInstance().retaFinalRed[i].pecas[j] != null && Game.getInstance().selectColor == Game.getInstance().retaFinalRed[i].pecas[j].color ){
                     
                	Game.getInstance().retaFinalRed[i].pecas[j].posX = size*(i+1) +  + size/8;
                	Game.getInstance().retaFinalRed[i].pecas[j].posY = size*7 + size/8;
                     
                }
                 
            }
        }
         
        /**********************************************************
         * 
         *  Amarelo
         *
         **********************************************************/
         
        for(int i=0; i<6; ++i) {
            for(int j = 0 ; j < Game.getInstance().retaFinalYellow[i].pecas.length; j++) {
                 
                if( Game.getInstance().retaFinalYellow[i].pecas[j] != null && Game.getInstance().selectColor == Game.getInstance().retaFinalYellow[i].pecas[j].color ){
                     
                	Game.getInstance().retaFinalYellow[i].pecas[j].posX = size*(13-i) + size/8;
                	Game.getInstance().retaFinalYellow[i].pecas[j].posY = size*7 + size/8;
                     
                }
                 
            }
        }
         
        /**********************************************************
         * 
         *  Azul
         *
         **********************************************************/
         
        for(int i=0; i<6; ++i) {
            for(int j = 0 ; j < Game.getInstance().retaFinalBlue[i].pecas.length; j++) {
                 
                if( Game.getInstance().retaFinalBlue[i].pecas[j] != null && Game.getInstance().selectColor == Game.getInstance().retaFinalBlue[i].pecas[j].color ){
                     
                	Game.getInstance().retaFinalBlue[i].pecas[j].posX = size*7 + size/8;
                	Game.getInstance().retaFinalBlue[i].pecas[j].posY = size*(13-i) + size/8;
                     
                }
                 
            }
        }
     
    }
     
    private void setPositionOfHouses(){
         
        /**********************************************************
         * 
         *  Casa 0 ï¿½ 4
         *
         **********************************************************/
         
        for(int i=0; i<=4; ++i) {
            for(int j = 0 ; j < Game.getInstance().listaPrincipal[i].pecas.length; j++)
            {
                if( Game.getInstance().listaPrincipal[i].pecas[j] != null && Game.getInstance().selectColor == Game.getInstance().listaPrincipal[i].pecas[j].color ){
                     
                	Game.getInstance().listaPrincipal[i].pecas[j].posX = size*(i+1) +  + size/8;
                	Game.getInstance().listaPrincipal[i].pecas[j].posY = size*6 + size/8;
     
                }
            }
        }
         
        /**********************************************************
         * 
         *  Casa 5 ï¿½ 10
         *
         **********************************************************/
         
        for(int i=5; i<=10; ++i) {
            for(int j = 0 ; j < Game.getInstance().listaPrincipal[i].pecas.length; j++)
            {
                if( Game.getInstance().listaPrincipal[i].pecas[j] != null && Game.getInstance().selectColor == Game.getInstance().listaPrincipal[i].pecas[j].color ){
                     
                	Game.getInstance().listaPrincipal[i].pecas[j].posX = size*6 +  + size/8;
                    Game.getInstance().listaPrincipal[i].pecas[j].posY = size*(10-i) + size/8;
     
                }
            }
        }
         
        /**********************************************************
         * 
         *  Casa 11 ï¿½ 12
         *
         **********************************************************/
         
        for(int i=11; i<=12; ++i) {
             
            for(int j = 0 ; j < Game.getInstance().listaPrincipal[i].pecas.length; j++)
            {
                if( Game.getInstance().listaPrincipal[i].pecas[j] != null && Game.getInstance().selectColor == Game.getInstance().listaPrincipal[i].pecas[j].color ){
                     
                	Game.getInstance().listaPrincipal[i].pecas[j].posX = size*(8-(12-i)) +  + size/8;
                	Game.getInstance().listaPrincipal[i].pecas[j].posY = size*0 + size/8;
     
                }
            }
        }
         
        /**********************************************************
         * 
         *  Casa 13 ï¿½ 17
         *
         **********************************************************/
         
        for(int i=13; i<=17; ++i) {
            for(int j = 0 ; j < Game.getInstance().listaPrincipal[i].pecas.length; j++)
            {
                if( Game.getInstance().listaPrincipal[i].pecas[j] != null && Game.getInstance().selectColor == Game.getInstance().listaPrincipal[i].pecas[j].color ){
                     
                	Game.getInstance().listaPrincipal[i].pecas[j].posX = size*8 +  + size/8;
                	Game.getInstance().listaPrincipal[i].pecas[j].posY = size*(i-12) + size/8;
     
                }
            }
        }
         
        /**********************************************************
         * 
         *  Casa 18 ï¿½ 23
         *
         **********************************************************/
         
        for(int i=18; i<=23; ++i) {
            for(int j = 0 ; j < Game.getInstance().listaPrincipal[i].pecas.length; j++)
            {
                if( Game.getInstance().listaPrincipal[i].pecas[j] != null && Game.getInstance().selectColor == Game.getInstance().listaPrincipal[i].pecas[j].color ){
                     
                	Game.getInstance().listaPrincipal[i].pecas[j].posX = size*(9+(i-18)) +  + size/8;
                	Game.getInstance().listaPrincipal[i].pecas[j].posY = size*6 + size/8;
     
                }
            }
        }
         
        /**********************************************************
         * 
         *  Casa 24 ï¿½ 25
         *
         **********************************************************/
         
        for(int i=24; i<=25; ++i) {
            for(int j = 0 ; j < Game.getInstance().listaPrincipal[i].pecas.length; j++)
            {
                if( Game.getInstance().listaPrincipal[i].pecas[j] != null && Game.getInstance().selectColor == Game.getInstance().listaPrincipal[i].pecas[j].color ){
                     
                	Game.getInstance().listaPrincipal[i].pecas[j].posX = size*14 +  + size/8;
                	Game.getInstance().listaPrincipal[i].pecas[j].posY = size*(7+(i-24)) + size/8;
                }
            }
        }
         
        /**********************************************************
         * 
         *  Casa 26 ï¿½ 30
         *
         **********************************************************/
         
        for(int i=26; i<=30; ++i) {
            for(int j = 0 ; j < Game.getInstance().listaPrincipal[i].pecas.length; j++)
            {
                if( Game.getInstance().listaPrincipal[i].pecas[j] != null && Game.getInstance().selectColor == Game.getInstance().listaPrincipal[i].pecas[j].color ){
                	Game.getInstance().listaPrincipal[i].pecas[j].posX = size*(13-(i-26)) +  + size/8;
                	Game.getInstance().listaPrincipal[i].pecas[j].posY = size*8 + size/8;
     
                }
            }
        }
         
        /**********************************************************
         * 
         *  Casa 31 ï¿½ 36
         *
         **********************************************************/
         
        for(int i=31; i<=36; ++i) {
            for(int j = 0 ; j < Game.getInstance().listaPrincipal[i].pecas.length; j++)
            {
                if( Game.getInstance().listaPrincipal[i].pecas[j] != null && Game.getInstance().selectColor == Game.getInstance().listaPrincipal[i].pecas[j].color ){
                     
                	Game.getInstance().listaPrincipal[i].pecas[j].posX = size*8 +  + size/8;
                    Game.getInstance().listaPrincipal[i].pecas[j].posY = size*(9+(i-31)) + size/8;
                }
            }
        }
         
        /**********************************************************
         * 
         *  Casa 37 ï¿½ 38
         *
         **********************************************************/
         
        for(int i=37; i<=38; ++i) {
            for(int j = 0 ; j < Game.getInstance().listaPrincipal[i].pecas.length; j++)
            {
                if( Game.getInstance().listaPrincipal[i].pecas[j] != null && Game.getInstance().selectColor == Game.getInstance().listaPrincipal[i].pecas[j].color ){
                     
                	Game.getInstance().listaPrincipal[i].pecas[j].posX = size*(6+(38-i)) + size/8;
                	Game.getInstance().listaPrincipal[i].pecas[j].posY = size*14 + size/8;
                }
            }
        }
         
        /**********************************************************
         * 
         *  Casa 39 ï¿½ 43
         *
         **********************************************************/
         
        for(int i=39; i<=43; ++i) {
            for(int j = 0 ; j < Game.getInstance().listaPrincipal[i].pecas.length; j++)
            {
                if( Game.getInstance().listaPrincipal[i].pecas[j] != null && Game.getInstance().selectColor == Game.getInstance().listaPrincipal[i].pecas[j].color ){
                     
                	Game.getInstance().listaPrincipal[i].pecas[j].posX = size*6 + size/8;
                	Game.getInstance().listaPrincipal[i].pecas[j].posY = size*(9+(43-i)) + size/8;
                }
            }
        }
         
        /**********************************************************
         * 
         *  Casa 44 ï¿½ 49
         *
         **********************************************************/
         
        for(int i=44; i<=49; ++i) {
            for(int j = 0 ; j < Game.getInstance().listaPrincipal[i].pecas.length; j++)
            {
                if( Game.getInstance().listaPrincipal[i].pecas[j] != null && Game.getInstance().selectColor == Game.getInstance().listaPrincipal[i].pecas[j].color ){
                     
                	Game.getInstance().listaPrincipal[i].pecas[j].posX = size*(49-i) + size/8;
                	Game.getInstance().listaPrincipal[i].pecas[j].posY = size*8 + size/8;
     
                }
            }
        }
         
        /**********************************************************
         * 
         *  Casa 50 ï¿½ 51
         *
         **********************************************************/
         
        for(int i=50; i<=51; ++i) {
            for(int j = 0 ; j < Game.getInstance().listaPrincipal[i].pecas.length; j++)
            {
                if( Game.getInstance().listaPrincipal[i].pecas[j] != null && Game.getInstance().selectColor == Game.getInstance().listaPrincipal[i].pecas[j].color ){
                     
                	Game.getInstance().listaPrincipal[i].pecas[j].posX = 0 + size/8;
                    Game.getInstance().listaPrincipal[i].pecas[j].posY = size*(6+(51-i)) + size/8;
                }
            }
        }
         
    }
   
}