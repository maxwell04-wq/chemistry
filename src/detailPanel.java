import javax.swing.*;
import java.awt.*;
import java.util.*;

public class detailPanel extends JPanel
{
	String input;
	public detailPanel(String s)
	{
		input = s;
		setBackground(Color.white);
		setPreferredSize(new Dimension(100,500));
		
	}
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		page.setColor(Color.black);
		Scanner scan = new Scanner(input);
		int i = 8;
		while (scan.hasNext())
		{
			String k = scan.nextLine();
			page.drawString(k, 200, i*30);
			i++;
		}
	}
}
