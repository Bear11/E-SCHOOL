package com.example.ext.activity.activities;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ext.R;


public class Test extends Activity {	
	 private TextView postionView;  
     
	    private LocationManager locationManager;  
	    private String locationProvider;  
	      
	    @Override  
	    protected void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	        setContentView(R.layout.fortest);  
	          
	        //获取显示地理位置信息的TextView  
	        postionView = (TextView) findViewById(R.id.positionView);  
	        //获取地理位置管理器  
	        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);  
	        //获取所有可用的位置提供器  
	        List<String> providers = locationManager.getProviders(true);  
	        if(providers.contains(LocationManager.GPS_PROVIDER)){  
	            //如果是GPS  
	            locationProvider = LocationManager.GPS_PROVIDER;  
	        }else if(providers.contains(LocationManager.NETWORK_PROVIDER)){  
	            //如果是Network  
	            locationProvider = LocationManager.NETWORK_PROVIDER;  
	        }else{  
	            Toast.makeText(this, "没有可用的位置提供器", Toast.LENGTH_SHORT).show();  
	            return ;  
	        }  
	        //获取Location  
	        Location location = locationManager.getLastKnownLocation(locationProvider);  
	        if(location!=null){  
	            //不为空,显示地理位置经纬度  
	            showLocation(location);  
	        }  
	        //监视地理位置变化  
	       // locationManager.requestLocationUpdates(locationProvider, 3000, 1, locationListener);  
	          
	    }  
	      
	    /** 
	     * 显示地理位置经度和纬度信息 
	     * @param location 
	     */  
	    private void showLocation(Location location){  
	        String locationStr = "维度：" + location.getLatitude() +"\n"   
	                + "经度：" + location.getLongitude();  
	        postionView.setText(locationStr);  
	    }  
	      
	    /** 
	     * LocationListern监听器 
	     * 参数：地理位置提供器、监听位置变化的时间间隔、位置变化的距离间隔、LocationListener监听器 
	     */  
	      
	    /*LocationListener locationListener =  new LocationListener() {  
	          
	        @Override  
	        public void onStatusChanged(String provider, int status, Bundle arg2) {  
	              
	        }  
	          
	        @Override  
	        public void onProviderEnabled(String provider) {  
	              
	        }  
	          
	        @Override  
	        public void onProviderDisabled(String provider) {  
	              
	        }  
	          
	        @Override  
	        public void onLocationChanged(Location location) {  
	            //如果位置发生变化,重新显示  
	            showLocation(location);  
	              
	        }  
	    };  
	      
	    @Override  
	    protected void onDestroy() {  
	        super.onDestroy();  
	        if(locationManager!=null){  
	            //移除监听器  
	            locationManager.removeUpdates(locationListener);  
	        }  
	    }  
	    @Override  
	    public boolean onCreateOptionsMenu(Menu menu) {  
	        // Inflate the menu; this adds items to the action bar if it is present.  
	        getMenuInflater().inflate(R.menu.main, menu);  
	        return true;  
	    }  */
}
	
	
/*	private LocationManager manager;
    private SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.homepage);
		        
		        manager = (LocationManager) getSystemService(LOCATION_SERVICE);//获取手机位置信息
		        
		        List<String> providers = manager.getAllProviders();
                
		        
	        for (String provider : providers) {
		            System.out.println(provider);
		        }
		        
		       //获取的条件
		        Criteria criteria = new Criteria();
		        criteria.setAccuracy(Criteria.ACCURACY_FINE);//获取精准位置
		        criteria.setCostAllowed(true);//允许产生开销
		        criteria.setPowerRequirement(Criteria.POWER_HIGH);//消耗大的话，获取的频率高
		        criteria.setSpeedRequired(true);//手机位置移动
		        criteria.setAltitudeRequired(true);//海拔
		        
		        //获取最佳provider: 手机或者模拟器上均为gps
		        String bestProvider = manager.getBestProvider(criteria, true);//使用GPS卫星
		      
		        Location loca = new Location(bestProvider);
                loca.getAccuracy();//精确度	          
                //Location[gps 0.000000,0.000000 acc=??? t=?!? et=?!?]
                String  latitude = loca.getLatitude()+"";//经度
	            String longitude = loca.getLongitude()+"";//纬度
		        Log.i(latitude, latitude);
		        Log.i(longitude, longitude);
	            System.out.println("最好的位置提供者是"+bestProvider);
		        sp = getSharedPreferences("config",MODE_PRIVATE);
		        
		        //parameter: 1. provider 2. 每隔多少时间获取一次  3.每隔多少米  4.监听器触发回调函数
		        manager.requestLocationUpdates(bestProvider,60000,100, new MyLocationListener());
		    }
		    
		    private class MyLocationListener implements LocationListener{
		        *//**
		         * 手机位置发生变动
		         *//*
		        public void onLocationChanged(Location location) {
		            location.getAccuracy();//精确度
		            String  latitude = location.getLatitude()+"";//经度
		            String longitude = location.getLongitude()+"";//纬度
		            
		            //将获取到的经纬度信息存入SharedPreferences
		            Editor editor = sp.edit();
		            editor.putString("lastloaction", latitude + "-" + longitude);
		            editor.commit();
		            
		        }
		        
		        *//**
		         * 当某个位置提供者的状态发生改变时
		         *//*
		        public void onStatusChanged(String provider, int status, Bundle extras) {
		            
		        }
		        
		        
		        *//**
		         * 某个设备打开时
		         *//*
		        public void onProviderEnabled(String provider) {
		            
		        }

		        
		        *//**
		         * 某个设备关闭时
		         *//*
		        public void onProviderDisabled(String provider) {
		            
		        }
		        
		    }*/
		
	

