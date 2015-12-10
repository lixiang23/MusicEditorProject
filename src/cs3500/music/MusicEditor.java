package cs3500.music;

import cs3500.music.controller.Controller;
import cs3500.music.controller.ControllerInterface;
import cs3500.music.controller.ViewFactory;
import cs3500.music.model.Composition;
import cs3500.music.model.ModelImplToCompositionAdapter;
import cs3500.music.model.MusicEditorModel;

import cs3500.music.util.CompositionBuilder;
import cs3500.music.util.MusicReader;
import cs3500.music.model.CompositionImpl;
import cs3500.music.view.CompositeView;
import cs3500.music.view.ConcreteGuiViewPanel;
import cs3500.music.view.GuiView;
import cs3500.music.view.GuiViewFrame;
import cs3500.music.view.MidiViewImpl;
import cs3500.music.view.View;
import cs3500.music.view.ViewModel;
import cs3500.music.view.ViewToViewInterfaceAdapter;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;



public class MusicEditor {

  public static void main(String[] args) throws MidiUnavailableException,
          IOException, InvalidMidiDataException, InterruptedException {
    CompositionBuilder<Composition> model = new ModelImplToCompositionAdapter.Builder();
    Composition model1 = MusicReader.parseFile(new FileReader(args[0]), model);
    ViewFactory viewFactory = new ViewFactory(model1);
//    viewFactory.build(args[1]);
    String view = args[1];
    GuiView guiView = new GuiViewFrame();
    View midiView = new MidiViewImpl();
    ViewModel viewModel = ViewModel.fromComposition(model1);
    ViewToViewInterfaceAdapter compositeView = new ViewToViewInterfaceAdapter(guiView, midiView, viewModel);
    Controller controller = new Controller(compositeView, model1);
    if (view.equals("console") || view.equals("visual")) {
      viewFactory.build(view).updateGui(viewModel);
      viewFactory.build(view).render(viewModel);
    }
    else if (view.equals("midi")){
      viewFactory.build(view).updateMidi(viewModel);
      viewFactory.build(view).renderMidi(viewModel);
    }
    else if (view.equals("composite")) {
      compositeView.getMidiView();
      compositeView.getGuiView();
    }

  }
}
