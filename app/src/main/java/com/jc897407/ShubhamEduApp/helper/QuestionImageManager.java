package com.jc897407.ShubhamEduApp.helper;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

public class QuestionImageManager {

    private final String assetPath; //is actually the level of questions: 1, 2, 3
    private String[] imageNames;
    private final AssetManager assetManager;

    public QuestionImageManager(String assetPath, AssetManager assetManager) {
        this.assetPath = assetPath;
        this.assetManager = assetManager;
        try {
            imageNames = assetManager.list(assetPath);

        } catch (IOException e) {
            imageNames = null;
        }
    }

    //given an index, return the image
    public Bitmap getImage(int i) {

        try {
            InputStream stream = assetManager.open(assetPath + "/" + imageNames[i]);
            Bitmap bitmap = BitmapFactory.decodeStream(stream);
            stream.close();
            return bitmap;
        }catch (IOException e){
            System.out.println("error: " + e);
            return null;
        }
    }
    //given an index, get the solution
    public String getAnswer(int i){
        int len = imageNames[i].length();
        String filename = imageNames[i].trim().substring(0, len - 4); // Remove "."; just keep the file name
        return filename.substring(14); // Return the answer
    }

    public int count(){
        return imageNames.length;
    }

    //public String[] getImageNames() { return imageNames; }

    //public String getAssetPath() { return assetPath; }
}
