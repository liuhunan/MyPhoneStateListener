package com.example.liuhunan.myphonestatelistener;
import me.weyye.hipermission.PermissionItem;
import me.weyye.hipermission.HiPermission;
import me.weyye.hipermission.PermissionCallback;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handlePermission();
        button=(Button) findViewById(R.id.button);
        initListener();

    }
    private void handlePermission() {
        List<PermissionItem> permissionItems = new ArrayList<>();
        permissionItems.add(new PermissionItem(Manifest.permission.READ_PHONE_STATE, "获取电话状态", R.drawable.permission_ic_phone));
        permissionItems.add(new PermissionItem(Manifest.permission.PROCESS_OUTGOING_CALLS, "获取拨打电话号码", R.drawable.permission_ic_location));

        HiPermission.create(this)
                .permissions(permissionItems)
                .checkMutiPermission(new PermissionCallback() {
                    @Override
                    public void onClose() {
                    }

                    @Override
                    public void onFinish() {
                    }

                    @Override
                    public void onDeny(String permission, int position) {
                    }

                    @Override
                    public void onGuarantee(String permission, int position) {

                    }
                });

    }
   public void initListener(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPhoneStateService();
            }
        });
    }
    public void startPhoneStateService(){
        Intent intent = new Intent(MainActivity.this,PhoneStateService.class);
        startService(intent);
        disableBtn();
    }
    public void disableBtn(){
        button.setText("监听服务已打开");
        button.setEnabled(false);
    }
}
