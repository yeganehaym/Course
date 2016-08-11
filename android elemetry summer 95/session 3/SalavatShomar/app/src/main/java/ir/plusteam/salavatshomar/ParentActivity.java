package ir.plusteam.salavatshomar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by ali on 8/11/2016.
 */
public class ParentActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
}
