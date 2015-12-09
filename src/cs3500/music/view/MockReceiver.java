package cs3500.music.view;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;

/**
 * Created by sabrinakantor on 11/13/15.
 */
public class MockReceiver implements Receiver {
    protected StringBuilder sb;

    MockReceiver(StringBuilder sb) {
        this.sb = sb;
    }

    @Override public void send(MidiMessage message, long timeStamp) {


        ShortMessage sm = (ShortMessage) message;
        int data1 = sm.getData1();
        int data2 = sm.getData2();
        int channel = sm.getChannel();
        int command = sm.getStatus();


        String result = "Note" + " " + Integer.toString(data1) + " "  +
            Integer.toString((int) (timeStamp)) + "\n";
        this.sb.append(result);
        System.out.print(result);
    }


    @Override public void close() {
        String result = this.sb.toString();

    }
}
