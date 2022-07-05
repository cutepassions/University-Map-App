package com.example.home;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapOptions;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.map);

        FragmentManager fm = getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment)fm.findFragmentById(R.id.map);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            fm.beginTransaction().add(R.id.map, mapFragment).commit();
        }

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        Marker marker = new Marker();
        Marker marker1 = new Marker();
        Marker marker2 = new Marker();
        Marker marker3 = new Marker();
        Marker marker4 = new Marker();
        Marker marker5 = new Marker();
        Marker marker6 = new Marker();
        Marker marker7 = new Marker();
        Marker marker8 = new Marker();

        marker.setPosition(new LatLng(35.96933, 126.95732));
        marker.setCaptionText("원광대");
        marker.setCaptionColor(Color.BLUE);
        marker.setMap(naverMap);

        marker1.setPosition(new LatLng(35.91262, 127.06668));
        marker1.setCaptionText("우석대");
        marker1.setCaptionColor(Color.BLUE);
        marker1.setMap(naverMap);

        marker2.setPosition(new LatLng(35.84673, 127.12935));
        marker2.setCaptionText("전북대");
        marker2.setCaptionColor(Color.BLUE);
        marker2.setMap(naverMap);

        marker3.setPosition(new LatLng(35.81348, 127.08686));
        marker3.setCaptionText("전주대");
        marker3.setCaptionColor(Color.BLUE);
        marker3.setMap(naverMap);

        marker4.setPosition(new LatLng(35.81556, 127.13458));
        marker4.setCaptionText("예수대");
        marker4.setCaptionColor(Color.BLUE);
        marker4.setMap(naverMap);

        marker5.setPosition(new LatLng(35.80889 , 127.09013));
        marker5.setCaptionText("전주비전대");
        marker5.setCaptionColor(Color.BLUE);
        marker5.setMap(naverMap);

        marker6.setPosition(new LatLng(35.81725, 127.13574));
        marker6.setCaptionText("전주기전대");
        marker6.setCaptionColor(Color.BLUE);
        marker6.setMap(naverMap);

        marker7.setPosition(new LatLng(35.94604, 126.68212));
        marker7.setCaptionText("군산대");
        marker7.setCaptionColor(Color.BLUE);
        marker7.setMap(naverMap);

        marker8.setPosition(new LatLng(35.96604, 126.86484));
        marker8.setCaptionText("호원대");
        marker8.setCaptionColor(Color.BLUE);
        marker8.setMap(naverMap);


    }
}