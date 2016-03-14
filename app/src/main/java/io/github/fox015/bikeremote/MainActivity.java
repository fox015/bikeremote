package io.github.fox015.bikeremote;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ioio.lib.api.DigitalOutput;
import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.IOIOLooper;
import ioio.lib.util.android.IOIOActivity;

public class MainActivity extends IOIOActivity {

    @Bind(R.id.go)
    Button mGoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
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

    @OnClick(R.id.go)
    void clickGo() {
        // Nothing for now.
        Toast.makeText(this, "GO!", Toast.LENGTH_SHORT).show();
    }

}
