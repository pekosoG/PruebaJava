package calisMouse1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComoPaint extends JPanel {

	int mouseX=50,mouseY=50;
	Point orale;
	
	//El Constructor de la Clase
	public ComoPaint(){
		KeyListener elTeclado= new MyKeyListener(); 
		MouseListener elMouse= new MyMouseListener();
		this.addMouseListener(elMouse);
		this.addKeyListener(elTeclado);
		this.setFocusable(true);
	}

	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d= (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.BLUE);
		g2d.drawOval(mouseX-10, mouseY-10, 20, 20);
		try{
			System.out.println("Esta en "+mouseX+" - "+mouseY);
		}catch(Exception e){
			System.out.println("Noooope "+e.getLocalizedMessage());
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Prueba Paint");
		ComoPaint algo= new ComoPaint();
		frame.add(algo);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public class MyKeyListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) { //Generamos el Listener para las teclas
			System.out.println("keyPressed="+e.getKeyCode());
			if(e.getKeyCode()==37) //izaquierda
				mouseX-=1;
			if(e.getKeyCode()==38)//abajo
				mouseY-=1;
			if(e.getKeyCode()==39)//arriba
				mouseX+=1;
			if(e.getKeyCode()==40)//derecha
				mouseY+=1;
			repaint();
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}
	}

	public class MyMouseListener implements MouseListener{
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			Point donde=e.getPoint();
			mouseX=donde.x;
			mouseY=donde.y;
			repaint();
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	}
}
