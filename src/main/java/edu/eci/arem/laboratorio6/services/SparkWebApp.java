
package edu.eci.arem.laboratorio6.services;

/**
 * Hello world!
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import spark.*;
import static spark.Spark.*;
     
    
     public class SparkWebApp {

        private static MathServices app = new MathServices();
        
        public static void main(String[] args) {
            port(getPort());
            get("/inputdata", (req, res) -> inputDataPage(req, res));
            get("/results", (req, res) -> resultsPage(req, res));
        }
        
        static int getPort() {
            if (System.getenv() != null) {
                return Integer.parseInt(System.getenv("PORT"));
            }
            return 4567;
        }
        
        private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Calculo del cuadrado dado</h2>"
                + "<form action=\"/results\">"
                + "  * Ingrese numero a retornar su cuadrado : <br>"
                + "  <input type=\"text\" name='numero'>"
                + "  <br>"
                + "  <br><br>"
                + "<input type=\"submit\" value=\"Submit\">"
                + "<p> found \"\"\"/results\".</p>"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
    }
        
    
    private static String resultsPage(Request req, Response res) {
        float a;
        float b;
        String htm;
        String value=req.queryParams("numero");
        
            try {
                htm = "<!DOCTYPE html>"
                        + "<html>"
                        + "<body>"
                        + "<br:>" + "Cuadrado :" + app.square(Integer.parseInt(value))+ "<br:>"
                        + "</body>"
                        + "</html>";
                return htm;
            } catch (Exception ex) {
                Logger.getLogger(SparkWebApp.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }    
    }

   
    
}
