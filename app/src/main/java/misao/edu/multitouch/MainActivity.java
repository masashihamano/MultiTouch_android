package misao.edu.multitouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.view.View.Y;

public class MainActivity extends AppCompatActivity{

    EditText editText1, editText2,editText3,editText4;
    TextView textView;

    float xAxis,yAxis,lastXaxis,lastYaxis = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        editText1 = findViewById( R.id.et1 );
        editText2 = findViewById( R.id.et2 );
        editText3 = findViewById( R.id.et3 );
        editText4 = findViewById( R.id.et4 );
        textView = findViewById( R.id.tv );


        textView.setOnTouchListener( new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final int actionPerformed = motionEvent.getAction();

                switch(actionPerformed){
                    case MotionEvent.ACTION_DOWN:{
                        final float x = motionEvent.getX();
                        final float y = motionEvent.getY();

                        lastXaxis = x;
                        lastYaxis = y;

                        editText1.setText( Float.toString( lastXaxis ) );
                        editText2.setText( Float.toString( lastYaxis ) );
                        break;
                    }

                    case MotionEvent.ACTION_MOVE:{
                        final float x = motionEvent.getX();
                        final float y = motionEvent.getY();

                        final float dx = x - lastXaxis;
                        final float dy = y - lastYaxis;

                        xAxis += dx;
                        yAxis += dy;

                        editText3.setText( Float.toString( xAxis ) );
                        editText4.setText( Float.toString( yAxis ) );
                        break;
                    }
                }
                return true;

            }
        } );

    }
}
