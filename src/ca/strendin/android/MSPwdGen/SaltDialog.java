package ca.strendin.android.MSPwdGen;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SaltDialog extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.saltdialog);
        
        Button saveButton;

        saveButton = (Button) findViewById(R.id.btnSaveButton);
        
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
                //saveButtonPress();
                saveButtonPress();
            }            
        });
    }
    
    /*
     * This displays a toast messagebox with the specified message
     */
    private void MessageBox(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();        
    }
    
    private void saveButtonPress() { 
        this.finish();     
    }
    
}
