package id.co.telkom.maxmemoryheap;

import android.app.ActivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textMemInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textMemInfo = (TextView) findViewById(R.id.txmeminfo);
        textMemInfo.setText(getMemInfo());
    }
    private String getMemInfo() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager =
                (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(memoryInfo);

        Runtime runtime = Runtime.getRuntime();
        int memoryClass = activityManager.getMemoryClass();


        String strMemInfo =
                "MemoryInfo.availMem = " + memoryInfo.availMem + "\n"
                        + "MemoryInfo.totalMem = " + memoryInfo.totalMem + "\n" // API 16
                        + "\n"
                        + "activitymanager.getMemoryClass() = " + Integer.toString(memoryClass) + "\n"
                        + "Runtime.maxMemory() = " + runtime.maxMemory() + "\n"
                        + "Runtime.totalMemory() = " + runtime.totalMemory() + "\n"
                        + "Runtime.freeMemory() = " + runtime.freeMemory() + "\n";

        return strMemInfo;
    }
}
