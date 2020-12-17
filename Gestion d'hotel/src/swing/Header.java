package swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

class Header extends JPanel {

	
	@Override public void paint(Graphics g)
    {
		
	        //Get the current size of this component
        Dimension d = this.getSize(); 
        //draw in black
        g.setColor(Color.black);
        //draw a centered horizontal line
        g.drawLine(0,d.height/2,d.width,d.height/2);
        
        
      Graphics2D g2d = (Graphics2D) g;
      
      /**
        * The coordinate system of a graphics context is such that the
        * origin is at the northwest corner and x-axis increases toward the
        * right while the y-axis increases toward the bottom.
        */
       
        int x = d.width/2;
       
        int y = 3*d.height/8;
        g2d.setColor(Color.white);
        // Set the desired font if different from default font
       
        Font font = new Font("Serif", Font.BOLD,26);
       
        g2d.setFont(font);
       
        // Draw a string such that its base line is at x, y
       
        g2d.drawString("Rooms", x, y);
        }
//        
//        Graphics2D g2d = (Graphics2D) g;
//        
//        /**
//          * The coordinate system of a graphics context is such that the
//          * origin is at the northwest corner and x-axis increases toward the
//          * right while the y-axis increases toward the bottom.
//          */
//         
//          int x = 150;
//         
//          int y = d.height/4;
//         
//          // Set the desired font if different from default font
//         
//          Font font = new Font("Serif", Font.PLAIN, 12);
//         
//          g2d.setFont(font);
//         
//          // Draw a string such that its base line is at x, y
//         
//          g2d.drawString("This is a test string", x, y);
         

        
//    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
