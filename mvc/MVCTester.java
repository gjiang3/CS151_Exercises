import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * MVCTester is the view.
 * It contains all GUI components.
 */
public class MVCTester 
{
  public static void main(String[] args)
  {
     final TextLine textLine = new TextLine();
     
     final JTextArea textArea =new JTextArea(10, 20);
     textArea.setEditable(false);
     final TextField inputTextArea =new TextField();
     /*
      * ChangeListener is controller. 
      * It calls the setText method to update the messeges diplayed on
      * the text area.
      */
     ChangeListener listener = new
     ChangeListener()
     {
         public void stateChanged(ChangeEvent event)
    	 {
    		 textArea.setText(textLine.content());
         }
      };
      textLine.addChangeListener(listener);
  
      JButton addButton = new JButton("add");
      addButton.addActionListener(new
      ActionListener()
      {
	         public void actionPerformed(ActionEvent event)
	         {
		          String text = inputTextArea.getText();
		          inputTextArea.setText("");
		          textLine.addText(text);
	         }
      });
      
      final JFrame textFrame = new JFrame();
      textFrame.add(addButton,BorderLayout.NORTH);
      textFrame.add(textArea,BorderLayout.CENTER);
      textFrame.add(inputTextArea,BorderLayout.SOUTH);
      
      textFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      textFrame.pack();
      textFrame.setVisible(true);
  }
}
