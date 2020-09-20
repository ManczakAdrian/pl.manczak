package src;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class RestClient {
    public static void main(String[] args) throws IOException {
        //musimy pobrać Jsona z API , do tego wykorzystujemy klasę InputStreamReader który służy do czytania zbiorów textowych z plików ze stron z różnych żródeł

        URL urlCatFact= new URL("https://cat-fact.herokuapp.com/facts/random");
        InputStreamReader readerCatfact= new InputStreamReader(urlCatFact.openStream());

        //kolejny krok to zamapowanie tego readera

        //tworzymy element któy będzie odpowiedzia

        CatFact catFact=new Gson().fromJson(readerCatfact,CatFact.class); // podajemy reader czyli skąd chcemy zczytać i drugi parametr gdzie chcemy zaimportować zczytane treści
// z wykorzystnaniem biblioteki GSOn mamy zamianę z jsona na zwykły obiekt javowy

        System.out.println(catFact.getText());// api które wykorzystaliśmy wywołuje randomową informację na temat kota

   // drugi sposób na pobranie danych z API


        URL urlCatImage= new URL("https://aws.random.cat/meow");
        InputStreamReader readerCatImage= new InputStreamReader(urlCatImage.openStream());

        JsonObject jsonObject= (new JsonParser().parse(readerCatImage).getAsJsonObject());
        System.out.println(jsonObject.get("file").getAsString());

    }
}
