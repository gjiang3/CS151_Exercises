import java.awt.*;

import javax.swing.*;


/**
   A program that allows users to move a car with the mouse.
*/
public class SliderTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.setSize(600, 600);
      JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 600, 60);
      slider.setMajorTickSpacing(600);
      slider.setMinorTickSpacing(60);
      slider.setPaintTicks(true);
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(new CarComponent(slider), BorderLayout.CENTER);
      frame.add(slider, BorderLayout.SOUTH);
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }

   
}


