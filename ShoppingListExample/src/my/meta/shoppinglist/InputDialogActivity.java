// Used for adding items and editing existing items.

package my.meta.shoppinglist;

import my.meta.shoppinglist.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class InputDialogActivity extends Activity {
	
	EditText et;
	Button okButton;
	
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND, WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
		setContentView(R.layout.new_item_dialog);

		this.setTitle(getIntent().getExtras().getString("title"));
		
		et = (EditText) findViewById(R.id.editText1);
		String value = getIntent().getExtras().getString("value");
		if(value != null && value.length() > 0) {
			et.setText(value);
		}
		
		okButton = (Button) findViewById(R.id.button1);
		okButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
		        Intent resultIntent = new Intent();
		        resultIntent.putExtra("value", et.getText().toString());
		        resultIntent.putExtra("actual_requestCode", getIntent().getExtras().getString("actual_requestCode"));
		        resultIntent.putExtra("item_position", getIntent().getExtras().getInt("item_position"));
		        setResult(Activity.RESULT_OK, resultIntent);
		        finish();
			}
			
		});
	}
	
	public void onBackPressed() {
		setResult(Activity.RESULT_CANCELED, new Intent());
		finish();
        super.onBackPressed();
    }
}
