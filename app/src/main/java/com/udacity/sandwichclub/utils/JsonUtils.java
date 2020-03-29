package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static String NAME = "name";
    private static String MAIN_NAME = "mainName";
    private static String ALSO_KNOWN_AS = "alsoKnownAs";
    private static String PLACE_OF_ORIGIN = "placeOfOrigin";
    private static String DESCRIPTION = "description";
    private static String IMAGE= "image";
    private static String INGREDIENTS = "ingredients";

    public static List<String> getStringListFromJSONArray(JSONArray jsonArray) throws JSONException {
        List<java.lang.String> stringList = new ArrayList<String>();

        for (int i = 0; i < jsonArray.length(); i++) {
            stringList.add(jsonArray.getString(i));
        }

        return stringList;
    }

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        //Parse JSON
        JSONObject jsonObject = new JSONObject(json);
        JSONObject nameObject = jsonObject.getJSONObject(NAME);
        String mainNameString = nameObject.getString(MAIN_NAME);
        JSONArray akaArray = nameObject.getJSONArray(ALSO_KNOWN_AS);
        List<String> akaStringList = getStringListFromJSONArray(akaArray);
        String placeOfOriginString = jsonObject.getString(PLACE_OF_ORIGIN);
        String descriptionString = jsonObject.getString(DESCRIPTION);
        String imageString = jsonObject.getString(IMAGE);
        JSONArray ingredientsArray = jsonObject.getJSONArray(INGREDIENTS);
        List<String> ingredientsStringList = getStringListFromJSONArray(ingredientsArray);

        //Set the sandwich data
        Sandwich sandwich = new Sandwich();
        sandwich.setMainName(mainNameString);
        sandwich.setAlsoKnownAs(akaStringList);
        sandwich.setPlaceOfOrigin(placeOfOriginString);
        sandwich.setDescription(descriptionString);
        sandwich.setImage(imageString);
        sandwich.setIngredients(ingredientsStringList);

        return sandwich;
    }
}
