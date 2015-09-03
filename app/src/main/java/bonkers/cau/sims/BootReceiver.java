package bonkers.cau.sims;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
    public BootReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

            context.startService(new Intent(context, ScreenService.class));
            context.startService(new Intent(context, SoundService.class));
    }
}
