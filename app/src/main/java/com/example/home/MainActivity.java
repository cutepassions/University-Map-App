package com.example.home;

import android.content.Context;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.naver.maps.map.overlay.Overlay;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout, baseLayout1, baseLayout2;

    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    // 메뉴를 통한 그리드뷰 변경
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.line1:
                setContentView(R.layout.grid1);
                baseLayout = (LinearLayout) findViewById(R.id.baseLayout1);
                final GridView gv1 = (GridView) findViewById(R.id.gridView1);
                MyGridAdapter gAdapter1 = new MyGridAdapter(this);
                gv1.setAdapter(gAdapter1);
                return true;
            case R.id.line2:
                setContentView(R.layout.grid2);
                baseLayout = (LinearLayout) findViewById(R.id.baseLayout2);
                final GridView gv2 = (GridView) findViewById(R.id.gridView2);
                MyGridAdapter gAdapter2 = new MyGridAdapter(this);
                gv2.setAdapter(gAdapter2);
                return true;
            case R.id.line3:
                setContentView(R.layout.activity_main);
                baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
                final GridView gv3 = (GridView) findViewById(R.id.gridView3);
                MyGridAdapter gAdapter3 = new MyGridAdapter(this);
                gv3.setAdapter(gAdapter3);
                return true;
            case R.id.line4:
                Intent intent = new Intent(getApplicationContext(),MapActivity.class);
                startActivity(intent);
                return true;

        }
        return false;
    }

    // 앱 기본 화면
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("전라북도 대학교");

        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        final GridView gv = (GridView) findViewById(R.id.gridView3);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }
    public class MyGridAdapter extends BaseAdapter {
        Context context;

        public MyGridAdapter(Context c) {
            context = c; // context 변수를 다른 메소드에서 사용하기 위함
        }

        @Override
        public int getCount() { // 그리드뷰에 보여질 이미지의 개수를 반환하도록 수정
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        // 이미지 파일을 배열로 초기화
        Integer[] posterID = {R.drawable.wku, R.drawable.wsu, R.drawable.jbu, R.drawable.jju, R.drawable.vsu,
                R.drawable.kju , R.drawable.jsu, R.drawable.ksu , R.drawable.hwu  };

        @Override
        public View getView(int position, View convertView, ViewGroup parent) { // 그림을 각 그리드뷰의 칸마다 이미지뷰를 생성해서 보여주게 함
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.WRAP_CONTENT, 400));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); // 그리드뷰 칸의 중앙에 배치
            imageView.setPadding(5,5,5,5);

            imageView.setImageResource(posterID[position]); // R.drawable.mov0x 이미지를 로드하여 출력
            //TODO 이미지를 클릭했을 때, 원래 이미지 크기가 보이도록 함
            final int pos = position;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
                    float scale = (float) (1024/(float)bitmap.getWidth());
                    int image_w = (int) (bitmap.getWidth() * scale);
                    int image_h = (int) (bitmap.getHeight() * scale);
                    Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
                    resize.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byte[] byteArray = stream.toByteArray();


                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("image", byteArray);

                    startActivity(intent);
                }



            });
            return imageView;
        }





    }


}