package cs3500.music.view;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.*;
import javax.swing.plaf.basic.BasicComboBoxUI;

import cs3500.music.model.*;

/**
 * represents the view factory
 * you can pick which one you want to make
 */
public class ViewFactory {
    //I DONT THINK I CHANGED THIS CORRECTLY
    private ModelImplToCompositionAdapter model = new CompositionImpl(2000);
    View view;

    /**
     * creates a view
     */
    public ViewFactory() {}

    /**
     * sets this model to the given model
     * @param model represents the given model
     */
    public void setModel(ModelImplToCompositionAdapter model) {
        this.model = model;
    }

    /**
     * builder class for view
     * allows you to pick which view you want to build
     * @param viewName string name of view interface you want
     * @return a ViewInterface
     */
    public View build(String viewName) {
        if (viewName.equals("console")) {
            view = new ConsoleView(model);
        } else if (viewName.equals("visual")) {
            view = new GuiViewFrame(model);
        } else if (viewName.equals("midi")) {
            view = new MidiViewImpl(model);
        } else if (viewName.equals("composite")) {
            view = new CompositeView(model);
        }
        return view;
    }

}
