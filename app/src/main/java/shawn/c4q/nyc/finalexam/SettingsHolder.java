package shawn.c4q.nyc.finalexam;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by shawnspeaks on 2/12/17.
 */

public class SettingsHolder extends RecyclerView.ViewHolder {

    private TextView tv;

    public SettingsHolder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.settings_num_TV);
    }

    public void bind(int settingNumber){
        String settingString = "Setting - "+ String.valueOf(settingNumber);
        tv.setText(settingString);
    }
}
