package app.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

import javax.print.DocFlavor;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

/**
 * Created by ASUS on 11/19/2016.
 */
@Component
public class JSONParserImpl {

    private Gson gson;

    public JSONParserImpl(){
        this.setGson(new GsonBuilder().setPrettyPrinting().create());
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public <T> T[] readFromJSON(Class<T[]> classes,String file){
        String fileData=null;
        T[] objects=null;

        try {
            fileData=new String(
                    Files.readAllBytes(Paths.get(file)));

            objects=this.getGson().fromJson(fileData,classes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return objects;
    }

    public <T> void writeToJSON(T object, String file){
        String json=this.getGson().toJson(object);
        BufferedWriter bfw=null;
        try{
            bfw=new BufferedWriter(new FileWriter(file));
            bfw.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(bfw!=null){
                    bfw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    public <T> void writeToJSON(T object,String file){
        String json=this.getGson().toJson(object);
        BufferedWriter bfw=null;
        try{
            bfw=new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(bfw!=null){
                    bfw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
}
