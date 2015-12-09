package cs3500.music.view;

import cs3500.music.Swingui.Constants;
//import cs3500.music.model.CompositionImpl;
import cs3500.music.model.CompositionImpl;
import cs3500.music.model.Playable;

import javax.swing.*;
import java.awt.*;
import java.util.List;


/**
 * A dummy view that simply draws a string
 */
public class ConcreteGuiViewPanel extends JPanel {
  private final boolean shouldScroll;
  Graphics g;
  private ViewModel viewModel;
  private int currentTime;


  ConcreteGuiViewPanel(ViewModel viewModel) {
    shouldScroll = true; //isScroll();
    this.viewModel = viewModel;
    this.currentTime = 0;
    this.setBackground(Color.WHITE);

  }

  /**
   * Updates the time and repaints the panel
   */
  public void updateTime() {
    this.currentTime += 1;
    this.repaint();

  }

  /**
   * Updates the time to 0 and repaints the panel
   */
  public void restartTime() {
    this.currentTime = 0;
    this.repaint();
  }

  /**
   * Updates the time to the end of song and repaints the panel
   */
  public void setTimeToEnd(int beat) {
    this.currentTime = beat;
    this.repaint();
  }

  /**
   * Paints the Jpanel
   */

  @Override public void paint(Graphics g) {
    this.g = g;
    draw();
    this.g.setColor(Color.black);
    drawBeat();
    drawNames();
  }

  /**
   * Renders the GUI Version of the music editor
   */
  public void draw() {
    for (int beat = 0; beat < viewModel.lastNote(); beat = beat + 1) {
      List<Playable> notesToDraw = viewModel.whatIsPlayingAt(beat);
      drawNotes(notesToDraw, beat);
    }


    drawHorizontalLines();
    drawVerticalLines();
    drawRedLine();
  }

  /**
   * draws all the notes at the given beat
   *
   * @param notesToDraw the notes played at the given beat
   * @param beat        the given beat
   */
  public void drawNotes(List<Playable> notesToDraw, int beat) {
    for (int note = 0; note < notesToDraw.size(); note++) {
      int pitchNum = CompositionImpl
              .getNumPitch(notesToDraw.get(note).getPitch(), notesToDraw.get(note).getOctave());

      Color c = Color.CYAN;
      if (notesToDraw.get(note).getInstrument() == 0) {
        c = new Color(120, 100, 253);
      }
      if (notesToDraw.get(note).getInstrument() == 1) {
        c = Color.CYAN;
      }
      if (notesToDraw.get(note).getInstrument() == 2) {
        c = Color.RED;
      }
      if (notesToDraw.get(note).getInstrument() == 3) {
        c = Color.BLUE;
      }
      if (notesToDraw.get(note).getInstrument() == 4) {
        c = Color.ORANGE;
      }
      if (notesToDraw.get(note).getInstrument() == 5) {
        c = Color.YELLOW;
      }
      if (notesToDraw.get(note).getInstrument() == 6) {
        c = Color.DARK_GRAY;
      }
      if (notesToDraw.get(note).getInstrument() == 7) {
        c = Color.MAGENTA;
      }
      if (notesToDraw.get(note).getInstrument() == 8) {
        c = Color.PINK;
      }
      if (notesToDraw.get(note).getInstrument() == 9) {
        c = Color.LIGHT_GRAY;
      }
      if (notesToDraw.get(note).getInstrument() == 10) {
        c = Color.GREEN;
      }
      if (notesToDraw.get(note).getInstrument() == 11) {
        c = new Color(13, 200, 200);
      }
      if (notesToDraw.get(note).getInstrument() == 12) {
        c = new Color(103, 100, 200);
      }
      if (notesToDraw.get(note).getInstrument() == 13) {
        c = new Color(13, 0, 200);
      }
      if (notesToDraw.get(note).getInstrument() == 14) {
        c = new Color(123, 20, 200);
      }
      if (notesToDraw.get(note).getInstrument() == 15) {
        c = new Color(103, 255, 140);
      }
      if (notesToDraw.get(note).getInstrument() == 16) {
        c = new Color(123, 210, 10);
      }



      if (notesToDraw.get(note).getStart() == beat) {
        c = Color.BLACK;
      }
      this.g.setColor(c);

      this.g.fillRect((beat * Constants.CELL_SIZE) + (Constants.CELL_PADDING),
              (viewModel.highestPitch() - pitchNum) * Constants.CELL_SIZE + (Constants.CELL_PADDING),
              Constants.CELL_SIZE, Constants.CELL_SIZE);
    }


  }

  /**
   * Draws Horizontal Lines of the grid
   */
  public void drawHorizontalLines() {
    int bottomLine = (viewModel.highestPitch() - viewModel.lowestPitch() + 2) * Constants.CELL_SIZE;
    for (int i = 0; i < bottomLine; i += Constants.CELL_SIZE) {
      this.g.setColor(Color.black);
      this.g.drawLine((Constants.CELL_PADDING), i + (Constants.CELL_PADDING),
              viewModel.lastNote() * Constants.CELL_SIZE + (Constants.CELL_PADDING),
              i + (Constants.CELL_PADDING));
    }


  }

  /**
   * Draws Vertical lines of the grid
   */
  public void drawVerticalLines() {
    int rightLine = (viewModel.lastNote() + 1) * Constants.CELL_SIZE;
    int bottomLine = (viewModel.highestPitch() - viewModel.lowestPitch() + 1) * Constants.CELL_SIZE;
    for (int i = 0; i < rightLine; i += Constants.CELL_SIZE * 4) {
      this.g.drawLine(i + (Constants.CELL_PADDING), (Constants.CELL_PADDING),
              i + (Constants.CELL_PADDING), bottomLine + (Constants.CELL_PADDING));
    }
  }

  /**
   * puts the beats on top of the composition
   */
  public void drawBeat() {
    int rightLine = (viewModel.lastNote() + 1) * Constants.CELL_SIZE;
    for (int i = 0; i < rightLine; i += 4 * 4) {
      String result = Integer.toString(i);
      this.g.drawString(result, i * Constants.CELL_SIZE + (Constants.CELL_PADDING - 4),
              (Constants.CELL_SIZE * 2));
    }
  }


  /**
   * draws the pitch names/octaves
   */

  public void drawNames() {
    String pitchTemplate = "%4s";
    for (int i = viewModel.lowestPitch(); i < viewModel.highestPitch() + 1; i++) {
      int pitch = i % 12;
      int octave = (i - pitch) / 12;
      String pitchOctave = String
              .format(pitchTemplate, CompositionImpl.noteNames(pitch) + Integer.toString(octave) + " ");
      this.g.drawString(pitchOctave, Constants.CELL_SIZE / 2,
              ((viewModel.highestPitch() - i + 1) * (Constants.CELL_SIZE)) + (Constants.CELL_PADDING));
    }
  }

  /**
   * Updates the panel with the given viewModel and repaints
   */
  void updatePanel(ViewModel viewModel) {
    this.viewModel = viewModel;
    repaint();

  }

  /**
   * Draws the red line at the currentTime
   */
  public void drawRedLine() {
    this.g.setColor(Color.RED);
    this.g.drawLine((currentTime * Constants.CELL_SIZE) + Constants.CELL_PADDING,
            Constants.CELL_PADDING, (currentTime * Constants.CELL_SIZE) + Constants.CELL_PADDING,
            (viewModel.highestPitch() - viewModel.lowestPitch() + 1) * Constants.CELL_SIZE
                    + (Constants.CELL_PADDING));


  }


  /**
   * Determines the preferred size
   *
   * @return the dimension of the preferred size
   */
  @Override public Dimension getPreferredSize() {
    int bottomLine =
            ((viewModel.highestPitch() - viewModel.lowestPitch() + 4) * Constants.CELL_SIZE)
                    + (Constants.CELL_PADDING);
    int rightLine = ((viewModel.lastNote() + 1) * Constants.CELL_SIZE) + (Constants.CELL_PADDING);
    return new Dimension(rightLine, bottomLine);
  }


}
