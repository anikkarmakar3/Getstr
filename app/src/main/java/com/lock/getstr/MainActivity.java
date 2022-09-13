package com.lock.getstr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    BluetoothDevice bluetoothDevice;
    public static int bluethooth_request_code=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*IntentFilter filter1 = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);*/
        IntentFilter filter1 = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(mBroadcastReceiver1, filter1);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, bluethooth_request_code);
        }
    }
    private final BroadcastReceiver mBroadcastReceiver1 = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(BluetoothDevice.ACTION_FOUND.equals(action)) {
                short rssi = intent.getShortExtra(BluetoothDevice.EXTRA_RSSI,Short.MIN_VALUE);
                Toast.makeText(getApplicationContext(),"  RSSI: " + rssi + "dBm", Toast.LENGTH_SHORT).show();
            }
            /*String action = intent.getAction();
            Log.d("BroadcastActions", "Action "+action+"received");
            int state;
            BluetoothDevice bluetoothDevice;

            switch(action)
            {
                case BluetoothAdapter.ACTION_STATE_CHANGED:
                    state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1);
                    if (state == BluetoothAdapter.STATE_OFF)
                    {
                        Toast.makeText(context, "Bluetooth is off", Toast.LENGTH_SHORT).show();
                        Log.d("BroadcastActions", "Bluetooth is off");
                    }
                    else if (state == BluetoothAdapter.STATE_TURNING_OFF)
                    {
                        Toast.makeText(context, "Bluetooth is turning off", Toast.LENGTH_SHORT).show();
                        Log.d("BroadcastActions", "Bluetooth is turning off");
                    }
                    else if(state == BluetoothAdapter.STATE_ON)
                    {
                        Log.d("BroadcastActions", "Bluetooth is on");
                    }
                    break;

                case BluetoothDevice.ACTION_ACL_CONNECTED:
                    bluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    *//*Toast.makeText(getApplicationContext(), "Connected to "+bluetoothDevice.getName(),
                            Toast.LENGTH_SHORT).show();*//*
                    Log.d("BroadcastActions", "Connected to "+bluetoothDevice.getName());
                    break;

                case BluetoothDevice.ACTION_ACL_DISCONNECTED:
                    bluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    Toast.makeText(context, "Disconnected from "+bluetoothDevice.getName(),
                            Toast.LENGTH_SHORT).show();
                    break;
            }*/
            /*final String action = intent.getAction();
            BluetoothDevice bluetoothDevice;*/

            /*if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
                switch(state) {
                    case BluetoothAdapter.STATE_OFF:
                        Log.d("get","bluetooth off");
                        Toast.makeText(getApplicationContext(), "bluetooth off", Toast.LENGTH_SHORT).show();
                        break;
                    case BluetoothAdapter.STATE_TURNING_OFF:
                        Log.d("get","bluetooth off");
                        break;
                    case BluetoothAdapter.STATE_ON:
                        Log.d("get","bluetooth on");
                        Toast.makeText(getApplicationContext(), "bluetooth on", Toast.LENGTH_SHORT).show();
                        break;
                    case BluetoothAdapter.STATE_TURNING_ON:
                        Log.d("get","bluetooth on");
                        break;

                }

            }*/
        }

    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(mBroadcastReceiver1);
    }
}