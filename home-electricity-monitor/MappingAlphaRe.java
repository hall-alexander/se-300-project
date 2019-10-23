import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


class Point {
    private int x;
    private int y;
    private int colorCode;
    private boolean connect;
    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return y;
    }
    public int getColorCode(){
    	return colorCode;
    }
    public int setColorCode(int x){
    	colorCode=x;
    	return colorCode;
	}
    public Point() {
        x = 0;
        y = 0;
    }
    
    public Point(int x, int y, int colorCode) {
        setX(x);
        setY(y);
        setColorCode(colorCode);
        connect=true;
    }
    public boolean getConnected(){
    	return connect;
    }
    public boolean setConnected(int c){
    	if(c==1){
    		connect=true;
    		return connect;
    	}else{
    		connect=false;
    		return connect;
    	}
    }
    @Override
    public String toString() {
        return String.format("%d %d %d", x, y, colorCode);
    }
}


class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener {
	//initialize variables
	private ArrayList<Point> points;
	public Point prevPoint;
	private String message;
    private int mouseX;
    private int mouseY;
    private int colorCode;
	public DrawingPanel(ArrayList<Point> points){
		this.points=points;
		addMouseListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
        message = "Click the mouse to add points.";
	}
	//drawing code 
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setPrevPointNull();
		g.setColor(Color.BLACK);
		for (Point p: points){
			g.fillOval(p.getX(),p.getY(),10,10);
			p.setColorCode(0);
			if (p.getConnected()==true){
                if (prevPoint != null) {
                    g.drawLine(prevPoint.getX()+5, prevPoint.getY()+5, p.getX()+5, p.getY()+5);
                }
                prevPoint = p;
        	}
		}
		if(prevPoint!=null){
        	g.drawLine(prevPoint.getX(),prevPoint.getY(),getMouseX(),getMouseY());
        }
		g.drawString(message, 300, 300);
		
		for (Point p: points){
			Point firstPoint = points.get(0);
			if (p.getX() == firstPoint.getX()+5 && firstPoint.getX()-5 ){
				
			}
		}
		
		
	}
	//get and set methods
	public Point setPrevPointNull(){
    	prevPoint=null;
    	return prevPoint;
    }
    public Point getPrevPoint(){
    	return prevPoint;
    }

    @Override
	public void mousePressed(MouseEvent e) {
		 Point p = new Point(e.getX(),e.getY(),colorCode);
	     points.add(p);
	     repaint();
	        for (int i = 0; i < points.size(); i++) {
	        	System.out.println(points.get(i));
	        }
	}
	public void mouseMoved(MouseEvent e) {
		requestFocusInWindow();
        message = String.format("Mouse is at (%d, %d)", e.getX(), e.getY());
        repaint();
        setMouseX(e.getX());
        setMouseY(e.getY());
		
	}
	public void mouseDragged(MouseEvent e) {
    	Point p = new Point(e.getX(),e.getY(),colorCode);
        points.add(p);
        repaint();
	}
    
    public int getMouseX(){
    	return mouseX;
    }
    public int getMouseY(){
    	return mouseY;
    }
    public int setMouseX(int x){
    	mouseX=x;
    	return x;
    }
    public int setMouseY(int y){
    	mouseY=y;
    	return y;
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}

class LoadingSavingPoints {
	//saving function
    public boolean savePoints(ArrayList<Point> points, File f) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
            for (Point p : points) {
                pw.println(p);
            }
            pw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    //calls save function
    public boolean savePoints(ArrayList<Point> points, String fname) {
        try {
            File f = new File(fname);
            return savePoints(points,f);
        } catch (Exception ex) {
            return false;
        }
    }
    //load function
    public boolean loadPoints(ArrayList<Point> points, File f) {
        try {
            Scanner sc = new Scanner(f);
            String line;
            String[] parts;
            int x, y,c;
            Point p;
            while (sc.hasNextLine()) {
                line = sc.nextLine().trim();
                if (!line.equals("")) {
                    parts = line.split(" ");
                    x = Integer.parseInt(parts[0]);
                    y = Integer.parseInt(parts[1]);
                    c = Integer.parseInt(parts[2]);
                    p = new Point(x,y,c);
                    points.add(p);
                }
            }
            sc.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}

class GUIFrame extends JFrame{
	 private ArrayList<Point> points;
	 public void clearPoints() {
	        points.clear();
	        repaint();
	    }
	 public void setupMenu(){
		 JMenuBar mbar = new JMenuBar();
		 JMenu mnuFile = new JMenu("File");
		 JMenuItem miLoad = new JMenuItem("Load");
	        miLoad.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                LoadingSavingPoints lsp = new LoadingSavingPoints();
	                JFileChooser jfc = new JFileChooser();
	                if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	                    if (lsp.loadPoints(points,jfc.getSelectedFile())) {
	                        JOptionPane.showMessageDialog(null, "Points were read successfully.");
	                    } else {
	                        JOptionPane.showMessageDialog(null, "The points file could not be read.");
	                    }
	                    repaint();
	                }
	            }
	        });
	        mnuFile.add(miLoad);
	        JMenuItem miSave = new JMenuItem("Save");
	        miSave.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	LoadingSavingPoints lsp = new LoadingSavingPoints();
	                JFileChooser jfc = new JFileChooser();
	                if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
	                    lsp.savePoints(points,jfc.getSelectedFile());
	                }
	            }
	        });
	        mnuFile.add(miSave);
	        JMenuItem miExit = new JMenuItem("Exit");
	        miExit.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                System.exit(0);
	            }
	        });
	        mnuFile.add(miExit);
	        mbar.add(mnuFile);
	        JMenu mnuEdit = new JMenu("Edit");
	        JMenuItem miClear = new JMenuItem("Clear");
	        miClear.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                clearPoints();
	            }
	        });
	        mbar.add(mnuFile);
	        mbar.add(mnuEdit);
	        mnuEdit.add(miClear);
	        setJMenuBar(mbar);
	 }
	 public void setupUI() {
	        setBounds(100,100,500,500);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setTitle("Alpha Map ");
	        Container c = getContentPane();
	        c.setLayout(new BorderLayout());
	        JPanel panSouth = new JPanel();
	        JButton btnClear = new JButton("Clear");
	        btnClear.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                clearPoints();
	            }
	        });
	        panSouth.add(btnClear);
	        c.add(panSouth, BorderLayout.SOUTH);
	        DrawingPanel panLines = new DrawingPanel(points);
	        c.add(panLines, BorderLayout.CENTER);
	        setupMenu();
	    }
	 public GUIFrame(ArrayList<Point> points) {
	        this.points = points;
	        setupUI();
	    }
}
public class MappingAlphaRe {
    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<Point>();
        GUIFrame frmLines = new GUIFrame(points);
        frmLines.setVisible(true);
    }
}
