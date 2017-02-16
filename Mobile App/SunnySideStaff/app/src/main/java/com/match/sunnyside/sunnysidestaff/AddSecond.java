package com.match.sunnyside.sunnysidestaff;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddSecond extends AppCompatActivity implements SurfaceHolder.Callback{
    static Camera myCamera=null;
    SurfaceView previewSurfaceView;
    SurfaceHolder previewSurfaceHolder;
    boolean previewing ,gallery= false;
    ImageView ivTrue;
    static String  videoPath,picTruePath;
    Button btnSubmit,btnTrueGallery;
    EditText question;
    final Context context =this;
    private static int RESULT_LOAD_IMAGE = 1;
    private static int RESULT_END = 2;
    private static int RESULT_RESET = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_second);
        question = (EditText) findViewById(R.id.question);
        getWindow().setFormat(PixelFormat.UNKNOWN);
        videoPath = getIntent().getStringExtra("Path");
        previewSurfaceView = (SurfaceView)findViewById(R.id.surfaceTrue);
        ivTrue = (ImageView)findViewById(R.id.ivTrue);
        previewSurfaceHolder = previewSurfaceView.getHolder();
        previewSurfaceHolder.addCallback(this);
        previewSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnTrueGallery = (Button)findViewById(R.id.btnTrueGallery);
        Button buttonTakePicture = (Button)findViewById(R.id.trueTake);
        buttonTakePicture.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if(previewSurfaceView.getVisibility()==View.GONE) {
                    ivTrue.setVisibility(View.GONE);
                    previewSurfaceView.setVisibility(View.VISIBLE);
                    gallery = false;
                    myCamera.startPreview();
                    previewing =true;
                }else {
                    gallery = false;
                    myCamera.takePicture(shutterCallback, rawPictureCallback, jpegPictureCallback);
                }
            }});
        Button btnTrueReset = (Button) findViewById(R.id.trueReset);
        btnTrueReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(previewSurfaceView.getVisibility()==View.GONE) {
                    ivTrue.setVisibility(View.GONE);
                    previewSurfaceView.setVisibility(View.VISIBLE);
                }
                previewing =true;
                gallery = false;
                myCamera.startPreview();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSubmit.setClickable(false);
                String a = question.getText().toString();
                if(gallery == true && !a.equals("")){
                    try {
                        String oldpath = picTruePath;
                        File old = new File(oldpath);
                        File temp = getOutputMediaFile();
                        copy(old, temp);
                        Intent intent = new Intent(context, WrongAns.class);
                        intent.putExtra("videoPath", videoPath);
                        intent.putExtra("picTruePath", picTruePath);
                        intent.putExtra("question", a);
                        startActivityForResult(intent, 2);
                    }catch(IOException e){
                        Log.d("**********",e.toString());
                    }
                }else {
                    if (previewing == false && !a.equals("")) {
                        Intent intent = new Intent(context, WrongAns.class);
                        intent.putExtra("videoPath", videoPath);
                        intent.putExtra("picTruePath", picTruePath);
                        intent.putExtra("question", a);
                        myCamera.stopPreview();
                        myCamera.release();
                        myCamera = null;
                        previewing = false;
                        startActivityForResult(intent, 2);
                    } else {
                        btnSubmit.setClickable(true);
                        Toast.makeText(context, "請先拍照及填寫問題", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnTrueGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.putExtra("return-data", true);
                startActivityForResult(Intent.createChooser(intent, "Select Umage"), RESULT_LOAD_IMAGE);
            }
        });


    }
    public void copy(File src, File dst) throws IOException {
        FileInputStream inStream = new FileInputStream(src);
        FileOutputStream outStream = new FileOutputStream(dst);
        FileChannel inChannel = inStream.getChannel();
        FileChannel outChannel = outStream.getChannel();
        inChannel.transferTo(0, inChannel.size(), outChannel);
        inStream.close();
        outStream.close();
    }

    Camera.ShutterCallback shutterCallback = new Camera.ShutterCallback(){

        @Override
        public void onShutter() {
            // TODO Auto-generated method stub

        }};

    Camera.PictureCallback rawPictureCallback = new Camera.PictureCallback(){

        @Override
        public void onPictureTaken(byte[] arg0, Camera arg1) {
            // TODO Auto-generated method stub

        }};

    Camera.PictureCallback jpegPictureCallback = new Camera.PictureCallback(){

        @Override
        public void onPictureTaken(byte[] arg0, Camera arg1) {
            // TODO Auto-generated method stub
            File pictureFile = getOutputMediaFile();
            if (pictureFile == null) {
                return;
            }
            try {
                Bitmap bitmapPicture = BitmapFactory.decodeByteArray(arg0, 0, arg0.length);
                FileOutputStream fos = new FileOutputStream(pictureFile);
                bitmapPicture.compress(Bitmap.CompressFormat.PNG, 100, fos);
                fos.flush();
                fos.close();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {
            }
            previewing = false;
        }};
    public static Bitmap rotateImage(Bitmap source, float angle) {
        Bitmap retVal;

        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        retVal = Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);

        return retVal;
    }

    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
        // TODO Auto-generated method stub

        if(previewing){
            myCamera.stopPreview();
            previewing = false;
        }


        try {
            myCamera.setPreviewDisplay(arg0);
            myCamera.startPreview();
            previewing = true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    @Override
    public void surfaceCreated(SurfaceHolder arg0) {
        // TODO Auto-generated method stub
        try {
            myCamera = Camera.open();
        }catch (Exception e){

        }
    }


    @Override
    public void surfaceDestroyed(SurfaceHolder arg0) {
        // TODO Auto-generated method stub
        try {
            myCamera.stopPreview();
            myCamera.release();
            myCamera = null;
            previewing = false;
        }catch (Exception e){

        }
    }

    private static File getOutputMediaFile() {
        File mediaStorageDir = new File("/sdcard/SunnyPic");
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }
        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());
        File mediaFile;
        picTruePath = mediaStorageDir.getPath() + File.separator
                + "IMG_" + timeStamp + ".bmp";
        mediaFile = new File(picTruePath);

        return mediaFile;
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == RESULT_LOAD_IMAGE) {
                Uri selectedImageUri = data.getData();
                // MEDIA GALLERY
                String selectedImagePath = getPath(selectedImageUri);
                if(selectedImagePath!=null){
                    previewSurfaceView.setVisibility(View.GONE);
                    ivTrue.setVisibility(View.VISIBLE);
                    ivTrue.setImageURI(selectedImageUri);
                    picTruePath = selectedImagePath;
                    gallery = true;
                    previewing = false;
                }

            }
        }else if (resultCode == RESULT_END) {
            setResult(RESULT_END);
            finish();

        }else if (resultCode == RESULT_RESET) {
            setResult(RESULT_RESET);
            finish();
        }

    }
    public String getPath(Uri uri)
    {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        if (cursor != null) {
            // HERE YOU WILL GET A NULLPOINTER IF CURSOR IS NULL
            // THIS CAN BE, IF YOU USED OI FILE MANAGER FOR PICKING THE MEDIA
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } else
            return null;
    }

}

