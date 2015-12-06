package cs3500.music.view;

import cs3500.music.Controller.KeyboardHandler;
import cs3500.music.Swingui.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;


/**
 * A skeleton Frame (i.e., a window) in Swing
 */
public class GuiViewFrame extends javax.swing.JFrame implements GuiView {
  public JScrollPane jsp;
  private ConcreteGuiViewPanel displayPanel;
  private int currentTime;
  private int value;
  private MouseAdapter ml;

  /**
   * Creates new GuiView
   */
  public GuiViewFrame() {
    super("Music Editor");
    this.currentTime = 0;

  }

  @Override public void render(ViewModel viewModel) {

    this.setVisible(true);
    this.value = 0;
    this.displayPanel = new ConcreteGuiViewPanel(viewModel);
    this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    this.jsp = new JScrollPane(displayPanel);
    this.jsp.addMouseListener(this.ml);
    this.jsp.addMouseMotionListener(this.ml);
    this.jsp.getHorizontalScrollBar().setUnitIncrement(60);
    this.jsp.getVerticalScrollBar().setUnitIncrement(60);
    this.add(jsp);

    this.pack();


  }

  @Override public void scrollPaneListener(MouseAdapter ml) {
    this.ml = ml;
  }

  @Override public void updateFrame(ViewModel viewModel) {
    this.displayPanel.updatePanel(viewModel);

  }

  @Override public void updateTime() {
    this.displayPanel.updateTime();
    this.currentTime += 1;
    this.scrollWithBeat();
  }

  @Override public void restartTime() {
    displayPanel.restartTime();
    this.currentTime = -1;
  }

  @Override public void setTimeToEnd(int beat) {
    displayPanel.setTimeToEnd(beat);
    this.currentTime = beat;
  }

  @Override public void updateMidi(ViewModel viewModel) {

  }

  @Override public void mouseListener(MouseAdapter mh) {

  }

  @Override public void keyListener(KeyboardHandler kbh) {

  }

  @Override public void renderMidi(ViewModel viewModel) {

  }

  @Override public void updateGui(ViewModel viewModel) {

  }

  /**
   * Allows the frame to auto-scroll
   */
  public void scrollWithBeat() {
    if (this.currentTime * Constants.CELL_SIZE >= this.getBounds().width - (6
            * Constants.CELL_SIZE)) {
      value += Constants.CELL_SIZE;
      this.jsp.getHorizontalScrollBar().setValue(value);
    }
  }


  @Override public Dimension getPreferredSize() {
    return new Dimension(1000, 700);
  }
}
