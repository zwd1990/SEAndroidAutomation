import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class RulesFrame extends JFrame implements ActionListener{
	private JPanel topPanel;
	private JScrollPane scrollPane;
	private JButton ok;
	private JList lst;
	private List<String> mRules;
		public RulesFrame(List<String> Rules){
			mRules = Rules;			
			setTitle("Select Rules to Add");
			setSize(400,400);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			topPanel = new JPanel();
			topPanel.setLayout(new BorderLayout());
			getContentPane().add(topPanel);

			lst = new JList(Rules);
			scrollPane = new JScrollPane(lst);
			topPanel.add(scrollPane, BorderLayout.CENTER);
			
			ok = new JButton("Ok");
			ok.setPreferredSize(new Dimension(50, 50));
			ok.addActionListener(this);
			topPanel.add(ok, BorderLayout.SOUTH);
		}
	public static void main(String args[]){

	}
	public void actionPerformed(ActionEvent e){
		int[] selectedIx = this.lst.getSelectedIndices();
		int k = 0;
		for(int i=0; i<selectedIx.length; i++)  
			SEAndroidAutomation.rulesByUser[k++] = mRules[i];
			//System.out.println("Selected Rule : "+mRules[i]);
		this.dispose();
		SEAndroidAutomation.afterOkClick();
	}
}
