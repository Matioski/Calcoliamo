package com.example.mattia.calcoliamo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Logger;

public class MainActivity0 extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private boolean equ = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main0);
        TextView op = (TextView) findViewById(R.id.operation);
        Button b1 = (Button) findViewById(R.id.d1);
        b1.setOnClickListener(new MyAdapter(b1));
        Button b2 = (Button) findViewById(R.id.d2);
        b2.setOnClickListener(new MyAdapter(b2));
        Button b3 = (Button) findViewById(R.id.d3);
        b3.setOnClickListener(new MyAdapter(b3));
        Button b4 = (Button) findViewById(R.id.d4);
        b4.setOnClickListener(new MyAdapter(b4));
        Button b5 = (Button) findViewById(R.id.d5);
        b5.setOnClickListener(new MyAdapter(b5));
        Button b6 = (Button) findViewById(R.id.d6);
        b6.setOnClickListener(new MyAdapter(b6));
        Button b7 = (Button) findViewById(R.id.d7);
        b7.setOnClickListener(new MyAdapter(b7));
        Button b8 = (Button) findViewById(R.id.d8);
        b8.setOnClickListener(new MyAdapter(b8));
        Button b9 = (Button) findViewById(R.id.d9);
        b9.setOnClickListener(new MyAdapter(b9));
        Button b0 = (Button) findViewById(R.id.d0);
        b0.setOnClickListener(new MyAdapter(b0));
        Button bMin = (Button) findViewById(R.id.dMin);
        bMin.setOnClickListener(new MyAdapter(bMin));
        Button bFor = (Button) findViewById(R.id.dFor);
        bFor.setOnClickListener(new MyAdapter(bFor));
        Button bDiv = (Button) findViewById(R.id.dDiv);
        bDiv.setOnClickListener(new MyAdapter(bDiv));
        Button bPlus = (Button) findViewById(R.id.dPlus);
        bPlus.setOnClickListener(new MyAdapter(bPlus));
        Button bPoint = (Button) findViewById(R.id.dPoint);
        bPoint.setOnClickListener(new MyAdapter(bPoint));
        Button bIs = (Button) findViewById(R.id.dIs);
        bIs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView op = (TextView) findViewById(R.id.operation);
                op.append("=");
                calcolo(op.getText().toString());

            }
        });
        Button bCE = (Button) findViewById(R.id.dCE);
        bCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView op = (TextView) findViewById(R.id.operation);
                op.setText("0");


            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("MainActivity0 Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Button bIs = (Button) findViewById(R.id.dIs);
        bIs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView op = (TextView) findViewById(R.id.operation);
                op.append("=");
                calcolo(op.getText().toString());

            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    protected class MyAdapter implements View.OnClickListener {
        private Button b;


        public MyAdapter(Button b) {
            this.b = b;
        }

        @Override
        public void onClick(View v) {
            TextView op = (TextView) findViewById(R.id.operation);
            String operators = "+-*/";
            if (equ && operators.contains(b.getText())) {
                equ = false;
            } else if (equ) {
                op.setText("");
                equ = false;
            }
            if (op.getText().equals("0")) {
                op.setText("");
            }
            op.append(b.getText());
        }
    }

    public void calcolo(String operazione) {
/*
        double primoN = 0;
        double secondoN = 0;
        for(int i=0;i<operazione.length();i++){
            Character actual=operazione.charAt(1);
            if(Character.isDigit(actual)&& !primo){
                temp1.concat(actual.toString());
            }
            if(Character.isDigit(actual)&& !secondo && primo){
                temp2.concat(actual.toString());
            }
            if(!Character.isDigit(actual) && !primo && !secondo){
                primo=true;

            }
            if(!Character.isDigit(actual) && primo && !secondo){
                secondo=true;

            }
            if(!Character.isDigit(actual) && primo && secondo){
                primoN=Double.parseDouble(temp1);
                secondoN=Double.parseDouble(temp2);

            }
            }
 equ=true;
        int i = operazione.indexOf("+");
        primoN = Double.parseDouble(operazione.substring(0, i));
        secondoN = Double.parseDouble(operazione.substring(i + 1, operazione.length()-1));
*/
        ArrayList<String> tokens;
        tokens=new ArrayList();

        double returnValue = 0;
        boolean first=false;
        boolean second=false;
        String ope="";
        for(int i=0;i<operazione.length()-1;){

            int intL=0;


                while(Character.isDigit(operazione.charAt(i+intL))||operazione.charAt(i+intL)=='.')  {
                    intL++;

            }
            if(!Character.isDigit(operazione.charAt(i))&&operazione.charAt(i+intL)!='.') {
                ope= String.valueOf(operazione.charAt(i));
                i++;
            }
            else{

            if(first)second=true;
                else first=true;

            tokens.add(operazione.substring(i,i+intL));
                i=i+intL;
            }
            if(first&&second){
                second=false;
                tokens.add(ope);
            }

        }
        String operators = "+-*/";
        Logger log=Logger.getLogger("lol");
        log.info(String.valueOf(tokens));
        log.info(operazione);
        Stack<String> stack = new Stack<String>();

        for (String t : tokens) {
            if(t==null)continue;
            if (!operators.contains(t)) {
                stack.push(t);
            } else {
                Double a = Double.valueOf(stack.pop());
                Double b = Double.valueOf(stack.pop());
                int index = operators.indexOf(t);
                switch (index) {
                    case 0:
                        stack.push(String.valueOf(a + b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b - a));
                        break;
                    case 2:
                        stack.push(String.valueOf(a * b));
                        break;
                    case 3:
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }

        returnValue = Double.valueOf(stack.pop());


        TextView op = (TextView) findViewById(R.id.operation);
        Double result = returnValue;
        op.setText(result.toString());
        equ=true;
    }


}
