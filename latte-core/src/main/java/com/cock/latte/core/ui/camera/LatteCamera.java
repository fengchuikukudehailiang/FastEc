package com.cock.latte.core.ui.camera;

import android.net.Uri;

import com.cock.latte.core.delegates.PermissionCheckerDelegate;
import com.cock.latte.core.utils.file.FileUtil;

public class LatteCamera {

    public static Uri createCropFile() {
        return Uri.parse
                (FileUtil.createFile("crop_image",
                        FileUtil.getFileNameByTime("IMG", "jpg")).getPath());
    }

    public static void start(PermissionCheckerDelegate delegate) {
        new CameraHandler(delegate).beginCameraDialog();
    }
}
