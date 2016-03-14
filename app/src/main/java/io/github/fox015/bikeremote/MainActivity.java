package io.github.fox015.bikeremote;

import android.os.Bundle;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.IOIOLooper;
import ioio.lib.util.android.IOIOActivity;

public class MainActivity extends IOIOActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected IOIOLooper createIOIOLooper() {
        return new IOIOLooper() {

            public DigitalOutput mSwitchOutput;

            @Override
            public void setup(IOIO ioio) throws ConnectionLostException, InterruptedException {
                // Force the pin to gnd to start.
                mSwitchOutput = ioio.openDigitalOutput(1, DigitalOutput.Spec.Mode.OPEN_DRAIN, false);
            }

            @Override
            public void loop() throws ConnectionLostException, InterruptedException {

            }

            @Override
            public void disconnected() {

            }

            @Override
            public void incompatible() {

            }

            @Override
            public void incompatible(IOIO ioio) {

            }
        };
    }

}
