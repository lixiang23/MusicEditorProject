

package cs3500.music.view;

import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;


/**
 * Created by sabrinakantor on 11/16/15.
 */
public interface GuiView extends View {
  /**
   * adds a key listener to all panes
   *
   * @param kl the keylistener to add
   */
  void addKeyListener(KeyListener kl);

  /**
   * adds a mouse listener to all panes
   *
   * @param ml the mouselistener to add
   */
  void addMouseListener(MouseListener ml);

  /**
   * adds the mouse listener to specifically the scroll pane
   *
   * @param ml the mosuelistener to add
   */
  void scrollPaneListener(MouseAdapter ml);

  /**
   * updates the frame based on the new viewModel
   *
   * @param viewModel the new viewModel with which to update the frame
   */
  void updateFrame(ViewModel viewModel);

}
