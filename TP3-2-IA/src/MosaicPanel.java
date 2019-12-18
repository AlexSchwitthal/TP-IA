
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *  A MosaicPanel object represents a grid containing rows
 *  and columns of colored rectangles.  There can be "grouting"
 *  between the rectangles.  (The grouting is just drawn as a 
 *  one-pixel outline around each rectangle.)  The rectangles
 *  are drawn as raised 3D-style rectangles.  Methods are 
 *  provided for getting and setting the colors of the rectangles.
 *  (Revision Spring 2006: added possibility of having a border.)
 *  (March 2006: added autopaint option for use in PentominosPanel).
 */
public class MosaicPanel extends JPanel {
   
	
   //------------------ private instance variables --------------------
   
   private Hidato game;
   private int rows;       // The number of rows of rectangles in the grid.
   private int columns;    // The number of columns of rectangles in the grid.
   private Color defaultColor;   // Color used for any rectangle whose color
                        //    has not been set explicitly.  This
                        //    can never be null.
   private String defaultString;
   private Color groutingColor;  // The color for "grouting" between 
                        //    rectangles.  If this is null, no
                        //    grouting is drawn.
   private boolean alwaysDrawGrouting;  // Grouting is drawn around default-
                              //    colored rects if this is true.
   private boolean autopaint = true;  // If true, then when a squar's color is set, repaint is called automatically.
   private String[][] gridString;
   private JTextField[][] gridTextField;
   private BufferedImage OSI;  // The mosaic is actually drawn here, then the image 
                        //is copied to the screen
   private boolean needsRedraw;   // This is set to true when a change has occurred that
                         // changes the appearance of the mosaic.

   
   //------------------------ constructors -----------------------------
   
   
   /**
    *  Construct a MosaicPanel with 42 rows and 42 columns of rectangles,
    *  and with preferred rectangle height and width both set to 16.
    */
   public MosaicPanel(Hidato h) {
      this(42,42,16,16,h);
   }
   
   /**
    *  Construct a MosaicPanel with specified numbers of rows and columns of rectangles,
    *  and with preferred rectangle height and width both set to 16.
    */
   public MosaicPanel(int rows, int columns, Hidato h) {
      this(rows,columns,16,16,h);
   }
   
   /**
    *  Construct a MosaicPanel with the specified number of rows and
    *  columns of rectangles, and with a specified preferred size for the  
    *  rectangle.  The default rectangle color is black, the
    *  grouting color is gray, and alwaysDrawGrouting is set to false.
    *  @param rows the mosaic will have this many rows of rectangles.  This must be a positive number.
    *  @param columns the mosaic will have this many columns of rectangles.  This must be a positive number.
    *  @param preferredBlockWidth the preferred width of the mosaic will be set this value times the number of
    *  columns.  The actual width is set by the component that contains the mosaic, and so might not be
    *  equal to the preferred width.  Size is measured in pixels.  The value should not be less than about 5.
    *  @param preferredBlockHeight the preferred height of the mosaic will be set this value times the number of
    *  rows.  The actual height is set by the component that contains the mosaic, and so might not be
    *  equal to the preferred height.   Size is measured in pixels.  The value should not be less than about 5.
    */
   public MosaicPanel(int rows, int columns, int preferredBlockWidth, int preferredBlockHeight, Hidato h) {
      this(rows, columns, preferredBlockWidth, preferredBlockHeight, null, 0, h);
   }

   
   /**
    *  Construct a MosaicPanel with the specified number of rows and
    *  columns of rectangles, and with a specified preferred size for the  
    *  rectangle.  The default rectangle color is black, the
    *  grouting color is gray, and alwaysDrawGrouting is set to false.
    *  If a non-null border color is specified, then a border of that color is added
    *  to the panel, and its width is taken into account in the computation of the preferred
    *  size of the panel.
    *  @param rows the mosaic will have this many rows of rectangles.  This must be a positive number.
    *  @param columns the mosaic will have this many columns of rectangles.  This must be a positive number.
    *  @param preferredBlockWidth the preferred width of the mosaic will be set this value times the number of
    *  columns.  The actual width is set by the component that contains the mosaic, and so might not be
    *  equal to the preferred width.  Size is measured in pixels.  The value should not be less than about 5.
    *  @param preferredBlockHeight the preferred height of the mosaic will be set this value times the number of
    *  rows.  The actual height is set by the component that contains the mosaic, and so might not be
    *  equal to the preferred height.   Size is measured in pixels.  The value should not be less than about 5.
    *  @param borderColor if non-null, a border of this color is added to the panel.  The border is then
    *  taken into account in the computation of the panel's preferred size.
    *  @param borderWidth if borderColor is non-null, then this parameter gives the width of the border; any
    *  value less than 1 is treated as 1.
    */
   public MosaicPanel(int rows, int columns, int preferredBlockWidth, int preferredBlockHeight, Color borderColor, int borderWidth, Hidato h) {
      this.game = h; 
	  this.rows = rows;
      this.columns = columns;
      this.gridTextField = new JTextField[rows][columns];
      //Container cp = this.getContentPane();this.setl
      this.setLayout(new GridLayout(rows, columns));  // 9x9 GridLayout
      for (int row = 0; row < rows; ++row) {
          for (int col = 0; col < columns; ++col) {
             this.gridTextField[row][col] = new JTextField(); // Allocate element of array
             this.add(this.gridTextField[row][col]);            // ContentPane adds JTextField
             this.gridTextField[row][col].setOpaque(false);
             if (this.game.gridInit[row][col] == 0) {
            	 this.gridTextField[row][col].setText("");     // set to empty string
            	 this.gridTextField[row][col].setEditable(true);
            	 this.gridTextField[row][col].setName("" + row + " " + col);
  
                // Add ActionEvent listener to process the input
            	 this.gridTextField[row][col].addCaretListener(this.game);   // For all editable rows and cols
            	 this.gridTextField[row][col].addActionListener(this.game);
             } 
             // Beautify all the cells
             this.gridTextField[row][col].setHorizontalAlignment(JTextField.CENTER);
             this.gridTextField[row][col].setFont(new Font("Monospaced", Font.BOLD, 20));
          }
       }
      gridString = new String[rows][columns];
      for(int i = 0; i < rows; i++) {
    	  for(int j = 0; j < columns; j++) {
    		  if(this.game.grid[i][j] != 0) {
    			  this.gridString[i][j] = "" + this.game.grid[i][j];
    			  this.gridTextField[i][j].setEnabled(false);
    		  }
    		  else
    			  this.gridString[i][j] = "";
    	  }
      }
      defaultColor = Color.black;
      defaultString = "";
      groutingColor = Color.gray;
      alwaysDrawGrouting = false;
      setBackground(defaultColor);
      setOpaque(true);
      setDoubleBuffered(false);
      if (borderColor != null) {
         if (borderWidth < 1)
            borderWidth = 1;
         setBorder(BorderFactory.createLineBorder(borderColor,borderWidth));
      }
      else
         borderWidth = 0;
      if (preferredBlockWidth > 0 && preferredBlockHeight > 0)
         setPreferredSize(new Dimension(preferredBlockWidth*columns + 2*borderWidth, preferredBlockHeight*rows + 2*borderWidth));
   }
   
   
   //--------- methods for getting and setting grid properties ----------
   
   
   /**
    *  Set the defaultColor.  If c is null, the color will be set to black.
    *  When a mosaic is first created, the defaultColor is black.
    *  This is the color that is used for rectangles whose color
    *  value is null.  Such rectangles are drawn as flat rather
    *  than 3D rectangles.
    */
   public void setDefaultColor(Color c) {
      if (c == null)
         c = Color.black;
      if (! c.equals(defaultColor)) {
         defaultColor = c;
         setBackground(c);
         forceRedraw();
      }
   }
   
   
   /**
    *  Return the defaultColor, which cannot be null.
    */
   public Color getDefaultColor() {
      return defaultColor;
   }
   
   
   /**
    *  Set the color of the "grouting" that is drawn between rectangles.
    *  If the value is null, no grouting is drawn and the rectangles
    *  fill the entire grid.   When a mosaic is first created, the
    *  groutingColor is gray.
    */
   public void setGroutingColor(Color c) {
      if (c == null || ! c.equals(groutingColor)) {
         groutingColor = c;
         forceRedraw();
      }
   }
   
   
   /**
    *  Get the current groutingColor, which can be null.
    */
   public Color getGroutingColor(Color c) {
      return groutingColor;
   }
   
   
   /**
    *  Set the value of alwaysDrawGrouting.  If this is false, then
    *  no grouting is drawn around rectangles whose color value is null.
    *  When a mosaic is first created, the value is false.
    */
   public void setAlwaysDrawGrouting(boolean always) {
      if (alwaysDrawGrouting != always) {
         alwaysDrawGrouting = always;
         forceRedraw();
      }
   }
   
   
   /**
    *  Get the value of the alwaysDrawGrouting property.
    */   
   public boolean getAlwaysDrawGrouting() {
      return alwaysDrawGrouting; 
   }
   
   
   /**
    *  Return the number of rows of rectangles in the grid.
    */
   public int getRowCount() {
      return rows;
   }
   
   
   /**
    *  Return the number of columns of rectangles in the grid.
    */
   public int getColumnCount() {
      return columns;
   }   
   
   
   //------------------ other useful public methods ---------------------
   
   
   public String getString(int row, int col) {
	      if (row >=0 && row < rows && col >= 0 && col < columns)
	         return gridString[row][col];
	      else
	         return "";
	   }
   
   
   public void setString(int row, int col, String c) {
	      if (row >=0 && row < rows && col >= 0 && col < columns) {
	         gridString[row][col] = c;
	         drawSquare(row,col);
	      }
	   }
   
   public void fillString(String c) {
	      for (int i = 0; i < rows; i++)
	         for (int j = 0; j < columns; j++)
	            gridString[i][j] = c;
	      forceRedraw();      
	   }
   

   /**
    * Returns the current value of the autopaint property.
    * @see #setAutopaint(boolean)
    */
   public boolean getAutopaint() {
      return autopaint;
   }

   /**
    * Sets the value of the autopaint property.  When this property is true,
    * then every call to one of the setColor methods automatically results in
    * repainting that square on the screen.  When it is desired to avoid this
    * immediate repaint -- for example, during a long sequence of setColors
    * that will all show up at once -- then the value of the autopaint property
    * can be set to false.  When the value is false, color changes are recorded
    * in the data for the mosaic but are not made on the screen.  When the
    * autopaint property is reset to true, the changes are applied and the
    * entire mosaic is repainted.  The default value of this property is
    * true.  
    * <p>Note that clearing or filling the mosaic will cause an immediate 
    * screen update, even if autopaint is false.
    */
   public void setAutopaint(boolean autopaint) {
      if (this.autopaint == autopaint)
         return;
      this.autopaint = autopaint;
      if (autopaint) 
         forceRedraw();
   }

   /**
    * This method can be called to force redrawing of the entire mosaic.  The only
    * time it might be necessary for users of this class to recall this method is
    * while the autopaint property is set to false, and it is desired to show
    * all the changes that have been made to the mosaic, without resetting
    * the autopaint property to true.
    *@see #setAutopaint(boolean)
    */
   final public void forceRedraw() {
      needsRedraw = true;
      repaint();
   }
   
   public void disableTextField() {
	   for(int i = 0; i < this.gridTextField.length; i++) {
		   for(int j = 0; j < this.gridTextField[i].length; j++) {
			   this.gridTextField[i][j].setText("");
			   this.gridTextField[i][j].setEnabled(false);
		   }
	   }
   }
   
   public void clearTextField() {
	   for(int i = 0; i < this.gridTextField.length; i++) {
		   for(int j = 0; j < this.gridTextField[i].length; j++) {
			   this.gridTextField[i][j].setText("");
			   this.gridTextField[i][j].setEnabled(true);
		   }
	   }
   }
   
   
   /**
    * Given an x-coordinate of a pixel in the MosaicPanel, this method returns
    * the row number of the mosaic rectangle that contains that pixel.  If
    * the x-coordinate does not lie within the bounds of the mosaic, the return
    * value is -1 or is equal to the number of columns, depending on whether
    * x is to the left or to the right of the mosaic.
    */
   public int xCoordToColumnNumber(int x) {
      Insets insets = getInsets();
      if (x < insets.left)
         return -1;
      double colWidth = (double)(getWidth()-insets.left-insets.right) / columns;
      int col = (int)( (x-insets.left) / colWidth);
      if (col >= columns)
         return columns;
      else
         return col;
   }
   
   /**
    * Given a y-coordinate of a pixel in the MosaicPanel, this method returns
    * the column number of the mosaic rectangle that contains that pixel.  If
    * the y-coordinate does not lie within the bounds of the mosaic, the return
    * value is -1  or is equal to the number of rows, depending on whether
    * y is above or below the mosaic.
    */
   public int yCoordToRowNumber(int y) {
      Insets insets = getInsets();
      if (y < insets.top)
         return -1;
      double rowHeight = (double)(getHeight()-insets.top-insets.bottom) / rows;
      int row = (int)( (y-insets.top) / rowHeight);
      if (row >= rows)
         return rows;
      else
         return row;
   }
   
   /**
    *  Returns the BufferedImage that contains the actual image of the mosaic.
    *  If this is called before the mosaic has been drawn on screen, the return value will be null.
    */
   public BufferedImage getImage() {
      return OSI;
   }
   
   //--------------- implementation details ------------------------
   //---------- (routines called internally or by the system) ------
   
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      if ( (OSI == null) || OSI.getWidth() != getWidth() || OSI.getHeight() != getHeight() ) {
         OSI = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
         needsRedraw = true;
      }
      if (needsRedraw) {
         Graphics OSG = OSI.getGraphics();
         for (int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++)
               drawSquare(OSG,r,c,false);
         OSG.dispose();
         needsRedraw = false;
      }
      g.drawImage(OSI,0,0,null);
   }
   
   private void drawSquare(Graphics g, int row, int col, boolean callRepaint) {
      // Draw one of the rectangles in a specified graphics 
      // context.  g must be non-null and (row,col) must be
      // in the grid.
      if (callRepaint && !autopaint)
         return;
      Insets insets = getInsets();
      double rowHeight = (double)(getHeight()-insets.left-insets.right) / rows;
      double colWidth = (double)(getWidth()-insets.top-insets.bottom) / columns;
      int xOffset = insets.left;
      int yOffset = insets.top; 
      int y = yOffset + (int)Math.round(rowHeight*row);
      int h = Math.max(1, (int)Math.round(rowHeight*(row+1))+yOffset - y);
      int x = xOffset + (int)Math.round(colWidth*col);
      int w = Math.max(1, (int)Math.round(colWidth*(col+1))+xOffset - x);
      g.setColor(defaultColor);
      if (groutingColor == null || !alwaysDrawGrouting) {
        	g.fillRect(x,y,w,h);
            g.setColor(Color.BLACK);
            g.setFont(g.getFont().deriveFont((float)(16)));
            if(this.game.isSolved() || !this.gridString[row][col].isBlank()) {
            	g.drawString(gridString[row][col], x + (int)Math.round(colWidth/3), y + (int)Math.round(rowHeight*0.66));
            	System.out.println(row + " " + col + " " + gridString[row][col]);
            }
            g.setColor(defaultColor);
      }
      else {
    	  if(this.game.gridInit[row][col] == 1)
         	 g.setColor(Color.GREEN);
          else {
         	 if(this.game.gridInit[row][col] == this.columns * this.rows)
         		 g.setColor(Color.RED);
          }
         	g.fillRect(x+1,y+1,w-2,h-2);
            g.setColor(Color.BLACK);
            g.setFont(g.getFont().deriveFont((float)(16)));
            if(this.game.isSolved() || !this.gridString[row][col].isBlank()) {
            	g.drawString(gridString[row][col], x + (int)Math.round(colWidth/3), y + (int)Math.round(rowHeight*0.66));
            }
         g.setColor(groutingColor);
         g.drawRect(x,y,w-1,h-1);
      }
      if (callRepaint)
         repaint(x,y,w,h);
   }
   
   private void drawSquare(int row, int col) {
      // Draw a specified rectangle directly on the applet in
      // the off-screen image, and call repaint to copy that
      // square to the screen.  (row,col) must be
      // within the grid.
      if (OSI == null) {
         repaint();
      }
      else {
         Graphics g = OSI.getGraphics();
         drawSquare(g,row,col,true);
         g.dispose();
      }
   }
   
   
} // end class MosaicPanel
