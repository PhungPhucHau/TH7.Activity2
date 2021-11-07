package draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawPanel extends JPanel implements ActionListener{
    private Color drawColor = new Color(0, 255, 0);
    Timer timer;
    
    public DrawPanel(){
        super.setSize(300, 300);
        this.addKeyListener(new MyKeyAdapter());
        this.setFocusable(true);
        
        timer = new Timer (150, this);
        timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g){
        setOpaque(false);
        g.setColor(drawColor);
        g.fillOval(100, 100, 50, 50);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        repaint();
    }

    void setColor(Color c) {
        drawColor = c;
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_B -> drawColor = new Color(0, 0, 255);
            }
        }
    }
}
