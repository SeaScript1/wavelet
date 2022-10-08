import java.net.URI;
import java.util.ArrayList;
import java.io.IOException;

class SearchEngineTwo implements URLHandler {

    ArrayList<String> tempList = new ArrayList<String>();
    
    public String handleRequest(URI url) {
        if (url.getPath().equals("/add")) {
            String [] item = url.getQuery().split("=");
            tempList.add(item[1]);
            return "item added";
        }
        else if (url.getPath().equals("/search")) {
            String [] tItem = url.getQuery().split("=");
            for (int i = 0; i < tempList.size(); i++ ) {
                if (tempList.get(i).contains(tItem[1])) {
                    return tempList.get(i);
                }
            }
        }
        return "Error";
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}

