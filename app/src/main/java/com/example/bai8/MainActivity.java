package com.example.bai8;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {


    String ss = " ",s1 =" ",ten=" ",cmnd =" ",ttbs =" ";
    Button btngui;
    EditText edtten,edtcmnd,edtbs;
    RadioGroup radioGroupbc;
    CheckBox c1,c2,c3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Sự kiện này sẽ dành cho phần game sau này
        edtcmnd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                Toast.makeText(MainActivity.this,"HIHIH2",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                Toast.makeText(MainActivity.this,"HIHIH",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                Toast.makeText(MainActivity.this,"HIHIH3",Toast.LENGTH_SHORT).show();
            }
        });*/
       dangkynut();
      dangkysk();
    }

    private void dangkynut()
    {
        btngui = (Button)findViewById(R.id.btndy);
        edtten = (EditText)findViewById(R.id.edthoten);
        edtcmnd = (EditText)findViewById(R.id.edtcmnd);
        edtbs = (EditText)findViewById(R.id.edtbs);
        edtten.setText(edtten.getText().toString().trim());
        edtcmnd.setText(edtcmnd.getText().toString().trim());
        edtbs.setText(edtbs.getText().toString().trim());
        radioGroupbc = (RadioGroup)findViewById(R.id.bangcap);
        c1 = (CheckBox)findViewById(R.id.docbao);
        c2 = (CheckBox)findViewById(R.id.docsach);
        c3 = (CheckBox)findViewById(R.id.doccode);
        edtten.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if(event.getAction() == KeyEvent.ACTION_UP)
                {
                    if(edtten.getText().length() <= 2)
                    {
                        btngui.setEnabled(false);
                        edtcmnd.setEnabled(false);
                        edtbs.setHint("Bạn phải điền xong thông tin ô trên trước");
                        edtcmnd.setHint("Bạn phải điền xong thông tin ô trên trước");
                        edtten.setBackgroundColor(Color.RED);
                    }
                    else if(edtten.getText().length() >= 3)
                    {
                        edtcmnd.setEnabled(true);
                       edtcmnd.setHint("Mời bạn nhập thông tin bổ sung");
                        edtten.setBackgroundColor(Color.WHITE);

                    }
                }
                return false;
            }
        });
        edtcmnd.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if(event.getAction() == KeyEvent.ACTION_UP)
                {
                    if(edtcmnd.getText().length() < 9 || edtcmnd.getText().length() > 9)
                    {
                        btngui.setEnabled(false);
                        edtbs.setEnabled(false);
                        edtbs.setHint("Bạn phải điền xong thông tin ô trên trước");
                        edtcmnd.setBackgroundColor(Color.RED);
                        c1.setEnabled(false);
                        c2.setEnabled(false);
                        c3.setEnabled(false);
                    }
                    else if(edtcmnd.getText().length() == 9)
                    {
                        edtbs.setEnabled(true);
                        edtbs.setHint("Mời bạn nhập thông tin bổ sung");
                        edtcmnd.setBackgroundColor(Color.WHITE);
                        c1.setEnabled(true);
                        c2.setEnabled(true);
                        c3.setEnabled(true);

                    }
                }
                return false;
            }
        });
        edtbs.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if(event.getAction() == KeyEvent.ACTION_UP)
                {
                    if(edtbs.getText().length() < 0)
                    {
                       btngui.setEnabled(false);
                        edtbs.setBackgroundColor(Color.RED);
                    }
                    else if(edtbs.getText().length() > 0)
                    {
                        btngui.setEnabled(true);
                        edtbs.setBackgroundColor(Color.WHITE);

                    }
                }
                return false;
            }
        });
    }
    private void dangkysk()
    {
        btngui.setOnClickListener(new sukiencuatoi());
    }
    private class sukiencuatoi implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            if(v.equals(btngui))
            {
                hiennoidung();
            }
        }
    }
    private void hiennoidung()
    {
        dangkynutrg(radioGroupbc);
        dangkynutrg2();
        thongtincanhan();
        String k = "\n--------------------------------\n";
        String kq = k + ten + "\n" + cmnd + "\n"+ k + ss + k + s1 + k +" Thông tin bổ sung \n" + ttbs;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("THÔNG TIN CÁ NHÂN \n");
        builder.setMessage(kq);
        builder.setNegativeButton("ĐÓNG", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                finish();
            }
        });
        builder.create().show();
    }

    private void thongtincanhan()
    {

        if(edtbs.getText().length() > 0)
        {
            ttbs =" " + edtbs.getText().toString();
        }
        if(edtten.getText().length() > 0)
        {
            ten =" " + edtten.getText().toString();
        }
        if(edtcmnd.getText().length() > 0)
        {
            cmnd =" " + edtcmnd.getText().toString();
        }
    }
    private void dangkynutrg(RadioGroup radioGroup)
    {
        int idd = radioGroup.getCheckedRadioButtonId();
        s1 = "\n Bằng cấp";
        switch (idd)
        {
            case R.id.tc:
                s1 += "\n Trung cấp ";
                Toast.makeText(getApplication(),"Trung cấp",Toast.LENGTH_SHORT).show();
                break;
            case R.id.dh:
                s1 += "\n Đại học ";
                Toast.makeText(getApplication(),"Đại học",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cd:
                s1 += "\n Cao đẳng ";
                Toast.makeText(getApplication(),"Cao đẳng",Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private void dangkynutrg2()
    {
        ss = "Sở thích :";
        if(c1.isChecked())
        {
            ss += "\n Đọc báo" + " ";
        }
        if(c2.isChecked())
        {
            ss += "\n Đọc sách" + " ";
        }
        if(c3.isChecked())
        {
            ss += "\n Đọc code" + " ";
        }

    }

}