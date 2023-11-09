package com.sist.file;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class FileListFrame extends JFrame{
	JList<String> list;
	JTextArea jta;
	
	public FileListFrame() {
		File dir = new File("C:\\javaStudy\\day0925");
				
		String []arr = dir.list();
		list = new JList<String>(arr);
		jta = new JTextArea(10, 80);
		
		JScrollPane jsp_list = new JScrollPane(list);
		JScrollPane jsp_jta = new JScrollPane(jta);
				
		add(jsp_list, BorderLayout.WEST);
		add(jsp_jta, BorderLayout.CENTER);
		
		list.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				String fname = list.getSelectedValue();
				
				try {
					FileReader fr = new FileReader("C:/javaStudy/day0925/"+fname);
					String str = "";
					int ch;
					while((ch=fr.read())!=-1){
						str +=(char)ch;
					}
					jta.setText(str);
					fr.close();
					
				}catch (Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class FileListGUI {
	public static void main(String[] args) {
		new FileListFrame();
	}
}
