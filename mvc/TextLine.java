import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 *  TextLine is model.
 *  It has no concern of how the program look.
 */
public class TextLine 
{
     private ArrayList<String> texts;
     private ArrayList<ChangeListener> listeners;
     public TextLine()
     {
    	 texts = new ArrayList<String>();
    	 listeners = new ArrayList<ChangeListener>();
     }
     
     public void addChangeListener(ChangeListener listener)
     { 
    	 listeners.add(listener); 
     }
     
     public void addText(String text)
     {
    	 texts.add(text);
    	 ChangeEvent event = new ChangeEvent(this);
    	 for (ChangeListener listener : listeners)
    	     listener.stateChanged(event);
     }
     
     public String content()
     {
    	 String r ="";
    	 for(String s: texts)
    	 {
    		 r += s + System.lineSeparator();
    	 }
    	 return r; 
     }
}
