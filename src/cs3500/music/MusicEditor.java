package cs3500.music;

import cs3500.music.controller.Controller;
import cs3500.music.controller.ControllerInterface;
import cs3500.music.model.MusicEditorModel;

import cs3500.music.util.CompositionBuilder;
import cs3500.music.util.MusicReader;
import cs3500.music.model.MusicEditorImpl;
import cs3500.music.view.CompositeView;
import cs3500.music.view.ConcreteGuiViewPanel;
import cs3500.music.view.GuiView;
import cs3500.music.view.ViewFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;


public class MusicEditor {

    public static void main(String[] args) throws MidiUnavailableException,
        IOException, InvalidMidiDataException, InterruptedException {
        CompositionBuilder<MusicEditorModel> model = new MusicEditorImpl.Builder();
        MusicEditorModel model1 = MusicReader.parseFile(new FileReader(args[0]), model);

        // GuiView guiView = new GuiViewFrame(model1);
        GuiView compositeView = new CompositeView(model1);
        Controller controller = new Controller(compositeView, model1);
//    ViewFactory view = new ViewFactory();
//    CompositionBuilder<MusicEditorModel> model = new MusicEditorImpl.Builder();
//    MusicEditorModel model1;
//    ConcreteGuiViewPanel scene = new ConcreteGuiViewPanel();
//    JFrame fra = new JFrame();
//    fra.setVisible(true);
//    fra.setSize(1280, 700);
//    fra.getContentPane().add(scene);
//    model1 = MusicReader.parseFile(new FileReader(args[0]), model);
//    view.setModel(model1);
//
//
//    Controller controller = new Controller(view.getComposite(),
//            model.build());
//   // controller.keySetUp();
//    System.out.println("1");
//    view.initialize(args[1]);

//    if (args[1] == "composite") {
//      Controller controller = new Controller(view.getComposite(),model.build());
//      controller.keySetUp();
//      view.initialize("composite");
//    }
//    else {
//      view.initialize("composite");
//    }
    }
}
