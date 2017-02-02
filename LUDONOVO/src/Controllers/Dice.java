package Controllers;
import java.util.Random;

import javax.swing.ImageIcon;

public class Dice 
{
	private Random gerador = new Random();
	
	private int valorDado = 0;
	
	public static Dice instance = new Dice();
	
	private ImageIcon[] images = new ImageIcon[6];
	
	public static Dice getInstance() {
		return instance;
	}

	/**********************************************************
     * 
     *  Inicializador
     *
     **********************************************************/
	
	private Dice() {
		
		loadImages();
		
	}
	
	/**********************************************************
     * 
     *  Gerar número
     *
     **********************************************************/
	
	public void GenerateAleatoryNumber()
	{
		valorDado = gerador.nextInt(6) + 1;  // gerar� valores de 0 a 5 e somar� um.
	}
	
	/**********************************************************
     * 
     *  Retornar valor gerado
     *
     **********************************************************/
	
	public int GetAleatoryNumber()
	{
		if (valorDado == 0)
			GenerateAleatoryNumber();
		
		return valorDado;
	}
	
	/**********************************************************
     * 
     *  Retorna imagem correspondente ao dado
     *
     **********************************************************/
	
	public ImageIcon getImageIcon() {
		
		return images[valorDado-1];
		
	}
	
	/**********************************************************
     * 
     *  Setar valor aleatório
     *
     **********************************************************/
	
	public void setNumber(int number) {
		
		valorDado = number;
		
	}
	
	/**********************************************************
     * 
     *  Carregar as imagens
     *
     **********************************************************/
	
	private void loadImages() {
		
		images[0] = new ImageIcon( getClass().getResource(
                "/dado_01.png"));
		images[1] = new ImageIcon( getClass().getResource(
                "/dado_02.png"));
		images[2] = new ImageIcon( getClass().getResource(
                "/dado_03.png"));
		images[3] = new ImageIcon( getClass().getResource(
                "/dado_04.png"));
		images[4] = new ImageIcon( getClass().getResource(
                "/dado_05.png"));
		images[5] = new ImageIcon( getClass().getResource(
                "/dado_06.png"));
		
	}
	
}
