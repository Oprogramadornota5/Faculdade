import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import org.json.JSONObject;

public class DataServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/data", new DataHandler());
        server.setExecutor(null);
        server.start();
    }
    
    static class DataHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            Sensor sensor = new Sensor("sensor1");
            sensor.readValue();
            JSONObject json = new JSONObject();
            json.put("id", sensor.getId());
            json.put("value", sensor.getValue());
            
            String response = json.toString();
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
    