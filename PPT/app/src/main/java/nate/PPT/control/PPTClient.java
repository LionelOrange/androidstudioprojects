package nate.PPT.control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PPTClient extends Activity {
	private Button start;
	private Button escape;
	private Button forward;
	private Button back;
	private Button connection;
	private EditText ipaddr;
	
	private Socket sock;
	private ObjectOutputStream fromClient;
	private ObjectInputStream fromServer;
	
	
	private final static int RIGHT = 1;
	private final static int LEFT = 2;
	private final static int SHIFTF5 = 0;
	private final static int ESC = 3;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        start = (Button)this.findViewById(R.id.start);
        escape = (Button)this.findViewById(R.id.escape);
        forward = (Button)this.findViewById(R.id.froward);
        back = (Button)this.findViewById(R.id.back);
		connection=(Button)findViewById(R.id.connection);

		connection.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				ipaddr=(EditText)findViewById(R.id.ipaddr);
				String  ip=ipaddr.getText().toString();
				try {
					//sock = new Socket(InetAddress.getByName("125.71.69.199"),2011);
					sock = new Socket(InetAddress.getByName(ip),2011);
					Log.d("TCP", "C: Connecting...");
					fromClient = new ObjectOutputStream(sock.getOutputStream());
					fromServer = new ObjectInputStream(sock.getInputStream());

				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

        start.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				Choices choice = new Choices(SHIFTF5);
				try {
					fromClient.writeObject(choice);
					System.out.println("send the start shift + f5");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
        	
        });
        
        escape.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				Choices  choice = new Choices(ESC);
				try {
					fromClient.writeObject(choice);
					System.out.println("send the escape");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

        });
        forward.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				Choices choice = new Choices(RIGHT);
				try {
					fromClient.writeObject(choice);
					System.out.println("send the right (the next)");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
        	
        });
        back.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				Choices choice = new Choices(LEFT);
				try {
					fromClient.writeObject(choice);
					System.out.println("send the left (the last)");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
        });
    }
    
    /**
     * ����BACK��
     * @param keyCode
     * @param event
     * @return
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) 
    {	
		if ( event.getKeyCode() == KeyEvent.KEYCODE_BACK){
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("exit app");
			builder.setMessage("You will exit the app...");
			//builder.setIcon(R.drawable.stat_sys_warning);
			builder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Intent startMain = new Intent(Intent.ACTION_MAIN);
					startMain.addCategory(Intent.CATEGORY_HOME); 
					startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
					startActivity(startMain);
					System.exit(0);
				}
			});
			builder.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					
				}
			});
			builder.show();
		}
		return super.onKeyDown(keyCode, event);
	}
}