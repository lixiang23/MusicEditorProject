package cs3500.music.view;

import javax.sound.midi.InvalidMidiDataException;
import javax.swing.*;

import cs3500.music.MusicEditor;
import javax.sound.midi.*;
import javax.swing.plaf.basic.BasicComboBoxUI;

public interface ViewInterface {

    public GuiView getGuiView();

    //TODO: not sure if i should put these methods here
    /**
     * Pauses the composition at the certain beat
     */
    public void pause();

    /**
     * Plays the composition
     */
    public void play();

    /**
     * Plays the composition from the beginning
     */
    public void start();

//
//  public void initialize(String view) throws MidiUnavailableException, InvalidMidiDataException, InterruptedException;
//
//  public void setModel(MusicEditorModel model) throws InvalidMidiDataException,
//          InterruptedException;

    /**
     * updates the current time
     */
    public void updateTime();


    /**
     * sets the current time to an integer
     * @param t represents the integer current time is set to
     */
    public void setCurrentTime(int t);
}
