import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
   A component that shows a scene composed of items.
*/
public class CarComponent extends JComponent
{
   public CarComponent(JSlider s)
   {
	  slider = s;
	  car = new CarIcon(slider.getValue());
   
      slider.addChangeListener(new 
      ChangeListener()
      {
 	        public void stateChanged(ChangeEvent e)
 	        {
 		        JSlider s = (JSlider) e.getSource();
 		        car.enlarge(s.getValue());
 		        repaint();
 	        }
       });
   }
   
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      car.paintIcon(this, g2, 300 - car.getIconWidth()/2,  300 - car.getIconWidth()/3);
   }

   private CarIcon car;
   private JSlider slider;
}                               
