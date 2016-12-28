import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

/**
  A class that implements an Observer object that displays a barchart view of
  a data model.
*/
public class BarFrame extends JFrame implements ChangeListener
{
   /**
      Constructs a BarFrame object
      @param dataModel the data that is displayed in the barchart
   */
   public BarFrame(DataModel d)
   {
      dataModel = d;
      a = dataModel.getData();

      setLocation(0,200);
      setLayout(new BorderLayout());

      final Icon barIcon = new Icon()
      {
         public int getIconWidth() { return ICON_WIDTH; }
         public int getIconHeight() { return ICON_HEIGHT; }
         public void paintIcon(Component c, Graphics g, int x, int y)
         {
            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(Color.red);

            max =  (a.get(0)).doubleValue();
            for (Double v : a)
            {
               double val = v.doubleValue();
               if (val > max)
                  max = val;
            }

            double barHeight = getIconHeight() / a.size();

            int i = 0;
            for (Double v : a)
            {
               double value = v.doubleValue();
               double barLength = getIconWidth() * value / max;
               Rectangle2D.Double rectangle = new Rectangle2D.Double
                  (0, barHeight * i, barLength, barHeight);
               i++;
               g2.fill(rectangle);
            }
         }
      };
      add(new JLabel(barIcon));

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setVisible(true);
      
      addMouseListener(new
   		   MouseAdapter()
              {
	           	public void mouseClicked(MouseEvent event) 
	           	{
	           		if (mousePoint == null) return;
		           	double dx = mousePoint.getX() - WIDTH_OFF;
		           	double dy = mousePoint.getY() - HEIGHT_OFF; 
		           	double height = barIcon.getIconHeight() / 4;
		           	
		            for(int i=0; i<4; i++)
		            {
		            	if(height*i <= dy && height*(i+1) > dy)
		            	{
		                    double value = ((dx / barIcon.getIconWidth()) * max);  
		            		dataModel.update(i, value);
		            		break;
		            	}
		            }		
	           	} 
	            public void mousePressed(MouseEvent event)
	            {
	           		mousePoint = event.getPoint();	      
	           	} 
              });
   }

   /**
      Called when the data in the model is changed.
      @param e the event representing the change
   */
   public void stateChanged(ChangeEvent e)
   {
      a = dataModel.getData();
      repaint();
   }

   private ArrayList<Double> a;
   private DataModel dataModel;

   private static final int ICON_WIDTH = 200;
   private static final int ICON_HEIGHT = 200;
   private static final double WIDTH_OFF = 9.2;
   private static final double HEIGHT_OFF = 40;
   private double max;
   private Point mousePoint; 
}