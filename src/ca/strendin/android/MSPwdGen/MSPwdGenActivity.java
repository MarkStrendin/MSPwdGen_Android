package ca.strendin.android.MSPwdGen;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MSPwdGenActivity extends Activity {    
    String Salt;
    String Input;
    
    Button generateButton, btnSel8, btnSel12, btnSel15, btnSel20;      
    TextView txtSalt, txtInput, txtOutput;
      
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /* Initialize some variables */
        
        Salt = "";
        Input = "";
        
        /* Set up references to the UI elements */
        
        generateButton = (Button) findViewById(R.id.btnGenerate);
        btnSel8 = (Button) findViewById(R.id.btnSel8);
        btnSel12 = (Button) findViewById(R.id.btnSel12);
        btnSel15 = (Button) findViewById(R.id.btnSel15);
        btnSel20 = (Button) findViewById(R.id.btnSel20);

        txtSalt = (TextView) findViewById(R.id.txtSalt);
        txtInput = (TextView) findViewById(R.id.txtInput);
        txtOutput = (TextView) findViewById(R.id.txtOutput);
        
        /* Set up onClick listeners */
        
        generateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GenerateButtonPress();                
            }            
        });
        
        btnSel8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { 
                MessageBox("First 8 characters copied to clipboard!");
                copyCharactersToClipboard(8,txtOutput.getText().toString());
            }            
        });
        
        btnSel12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
                MessageBox("First 12 characters copied to clipboard!");
                copyCharactersToClipboard(12,txtOutput.getText().toString());          
            }            
        });
        
        btnSel15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
                MessageBox("First 15 characters copied to clipboard!");
                copyCharactersToClipboard(15,txtOutput.getText().toString());
            }            
        });
        
        btnSel20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  
                MessageBox("First 20 characters copied to clipboard!");
                copyCharactersToClipboard(20,txtOutput.getText().toString());
            }            
        });        
    }
    
    
    /* 
     * This copies the specified number of characters (numCharacters) from
     *  the given string (stringToCopy) to the clipboard
     */
    private void copyCharactersToClipboard(int numCharacters, String stringToCopy) {        
        String returnMe = "";        
        if (stringToCopy.length() > numCharacters) {
            returnMe = stringToCopy.substring(0, numCharacters);        
        } else {
            returnMe = stringToCopy;
        }        
        
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        clipboard.setText(returnMe);
    };

    /*
     * This displays a toast messagebox with the specified message
     */
    private void MessageBox(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();        
    }
    
    
    /*
     * This forces the software keyboard to be hidden so that
     *  it doesn't block the output text box
     */
    private void hideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(txtInput.getWindowToken(), 0);   
    }
    
    /* 
     * Enable or Disable the "copy to clipboard" buttons.
     * The buttons start disabled, because copying NULL to
     * the clipboard is counterproductive.
     */
    private void toggleClipBoardButtons(boolean setToThis) {
        btnSel8.setEnabled(setToThis);
        btnSel12.setEnabled(setToThis);
        btnSel15.setEnabled(setToThis);
        btnSel20.setEnabled(setToThis);        
    }
    
    /*
     * This is called when the "Generate" button is pressed 
     */
    private void GenerateButtonPress() {
        toggleClipBoardButtons(true);
        txtOutput.setText(crypto.hash(txtSalt.getText().toString(),txtInput.getText().toString()));
        hideSoftKeyboard();
    }
}