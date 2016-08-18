package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import org.w3c.dom.Text;

public class QuizActivity extends AppCompatActivity {



    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
private static TextView mtext;
int n;
    private static final String TAG = "QuizActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


mtext=(TextView)findViewById(R.id.textViewer);
        mNextButton = (Button) findViewById(R.id.next_button);
        n=rando();
        mtext.setText("Is "+n+" a prime number?");
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {   n=rando();
                mtext.setText("Is "+n+" a prime number?");


            }
        });
        mTrueButton = (Button) findViewById(R.id.TrueButton);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(isPrime(n)) {
                    Log.d(TAG, "Correct!");
                    Toast.makeText(getApplicationContext(),"Correct!",Toast.LENGTH_SHORT).show();
                }
                else {
                    Log.d(TAG, "Incorrect!");
                    Toast.makeText(getApplicationContext(),"Incorrect!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        mFalseButton = (Button) findViewById(R.id.FalseButton);
        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(isPrime(n))
                {  Log.d(TAG, "Incorrect!");
                    Toast.makeText(getApplicationContext(),"Inorrect",Toast.LENGTH_SHORT).show();}
                else
                {  Log.d(TAG, "Correct!");
                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();}
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onSaveInstance");
    }
    public  int rando()
    {
        int diff=999;
        Random rn = new Random();
        int i = rn.nextInt(diff+1);

        i+=1;

        return i;
    }
    public boolean isPrime(int n)
    {
        if(n==1 || n==2)
        {
            if(n==1)
                return false;
            else
                return true;
        }
        else if(n>2 && n<1001)
        {int i;
            for(i=2;i<n;i++)
            {
                if(n%i==0)
                {
                    return false;

                }
            }
            return true;
        }
        else
            return false;

    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnREsume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }
}
