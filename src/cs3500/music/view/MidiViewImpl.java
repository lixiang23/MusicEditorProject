package cs3500.music.view;

import cs3500.music.controller.KeyboardHandler;
import cs3500.music.model.CompositionImpl;
import cs3500.music.model.Playable;

import javax.sound.midi.*;
import java.awt.event.MouseAdapter;
import java.util.List;
import java.util.Timer;

/**
 * A skeleton for MIDI playback
 */
public class MidiViewImpl implements View {
  Timer timer;
  private final Synthesizer synth;
  private final Receiver receiver;
  private int currentTime;


  public MidiViewImpl() {
    timer = new Timer();
    Synthesizer tempSynth = null;
    Receiver tempReceiver = null;
    try {

      tempSynth = MidiSystem.getSynthesizer();
      tempReceiver = tempSynth.getReceiver();
      tempSynth.open();
    } catch (MidiUnavailableException e) {
      e.printStackTrace();
      tempSynth = null;
      tempReceiver = null;
    } finally {
      this.synth = tempSynth;
      this.receiver = tempReceiver;
    }
    this.currentTime = -1;

  }

  public MidiViewImpl(StringBuilder sb) {
    this.synth = new MockMidi(sb);
    this.receiver = new MockReceiver(sb);
    this.currentTime = -1;
  }

  public void testresults() {
    this.receiver.close();
  }


  /**
   * Relevant classes and methods from the javax.sound.midi library: <ul> <li>{@link
   * MidiSystem#getSynthesizer()}</li> <li>{@link Synthesizer} <ul> <li>{@link
   * Synthesizer#open()}</li> <li>{@link Synthesizer#getReceiver()}</li> <li>{@link
   * Synthesizer#getChannels()}</li> </ul> </li> <li>{@link Receiver} <ul> <li>{@link
   * Receiver#send(MidiMessage, long)}</li> <li>{@link Receiver#close()}</li> </ul> </li>
   * <li>{@link MidiMessage}</li> <li>{@link ShortMessage}</li> <li>{@link MidiChannel} <ul>
   * <li>{@link MidiChannel#getProgram()}</li> <li>{@link MidiChannel#programChange(int)}</li>
   * </ul> </li> </ul>
   *
   * @see <a href="https://en.wikipedia.org/wiki/General_MIDI">
   *   https://en.wikipedia.org/wiki/General_MIDI
   * </a>
   */


  public void render(ViewModel viewModel) {
    if (currentTime >= 0 && currentTime <= viewModel.lastNote()) {
      try {
        this.renderMidi(viewModel);
      } catch (InvalidMidiDataException e) {
        e.printStackTrace();
      }
    }

  }

  /**
   * Updates the time by one
   */

  public void updateTime() {
    this.currentTime += 1;
  }

  /**
   * Restarts time to -1
   */
  public void restartTime() {
    this.currentTime = -1;
  }

  @Override public void setTimeToEnd(int lastBeat) {
    this.currentTime = lastBeat;
  }


  @Override public void updateMidi(ViewModel viewModel) {

  }

  @Override public void mouseListener(MouseAdapter mh) {

  }

  @Override public void keyListener(KeyboardHandler kbh) {

  }

  /**
   * Plays all the notes
   *
   * @param viewModel to render
   * @throws InvalidMidiDataException
   */

  @Override public void renderMidi(ViewModel viewModel) throws InvalidMidiDataException {
    List<Playable> notesToPlay = viewModel.whatStartsAt(currentTime);
    this.playNote(notesToPlay, viewModel);

  }

  @Override public void updateGui(ViewModel viewModel) {

  }

  /**
   * Renders the given notes
   *
   * @param notesToPlay the notes at a give beat
   * @param viewModel   the given viewModel
   * @throws InvalidMidiDataException
   */

  public void playNote(List<Playable> notesToPlay, ViewModel viewModel)
          throws InvalidMidiDataException {
    for (int i = 0; i < notesToPlay.size(); i++) {
      int pitch =
              CompositionImpl.getNumPitch(notesToPlay.get(i).getPitch(), notesToPlay.get(i).getOctave())
                      - 1;
      int volume = notesToPlay.get(i).getVolume();
      int duration = notesToPlay.get(i).getDuration();
      int tempo = viewModel.getTempo();
      int instrument = (notesToPlay.get(i).getInstrument() - 1) % 16;


      MidiMessage start = new ShortMessage(ShortMessage.NOTE_ON, instrument, pitch, volume);
      MidiMessage stop = new ShortMessage(ShortMessage.NOTE_OFF, instrument, pitch, volume);

      this.receiver.send(start, this.synth.getMicrosecondPosition());
      this.receiver.send(stop, (this.synth.getMicrosecondPosition() + (duration * tempo)));

    }

  }


}
