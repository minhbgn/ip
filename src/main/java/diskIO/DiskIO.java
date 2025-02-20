package diskIO;


import item.Item;

import com.google.gson.*;
import java.io.*;
import java.util.ArrayList;

public class DiskIO {
    private static final Gson gson = new Gson();

    public static void saveItemsToJson(String filePath, ArrayList<Item> items) throws IOException {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(items, writer);
        }
    }

    public static ArrayList<Item> loadItemsFromJson(String filePath) throws IOException {
        try (Reader reader = new FileReader(filePath)) {
            return new Gson().fromJson(reader, new TypeToken<ArrayList<Item>>() {}.getType());
        }
    }
}
