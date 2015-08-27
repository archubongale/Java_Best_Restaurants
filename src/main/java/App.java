import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
      staticFileLocation("/public");
      String layout = "templates/layout.vtl";

      get("/", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("cuisines",Cuisine.all());
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/cuisines", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();

        String type = request.queryParams("type");
        Cuisine newCuisine = new Cuisine(type);
        newCuisine.save();

        model.put("cuisines",Cuisine.all());
        model.put("template", "templates/index.vtl");

        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());


      // get("/cuisines/new", (request, response) -> {
      //   HashMap<String, Object> model = new HashMap<String, Object>();
      //   model.put("template", "templates/index.vtl");
      //   return new ModelAndView(model, layout);
      // }, new VelocityTemplateEngine());

      //
      // get("/cuisines/:id", (request, response) -> {
      //   HashMap<String, Object> model = new HashMap<String, Object>();
      //   //model.put("cuisine", Cuisine.find(Integer.parseInt(request.params(":id"))));
      //   //model.put("cuisines",Cuisine.all());
      //   model.put("template", "templates/restaurants.vtl");
      //   return new ModelAndView(model, layout);
      // }, new VelocityTemplateEngine());
      //
      // post("/cuisines/:id", (request, response) -> {
      //   HashMap<String, Object> model = new HashMap<String, Object>();
      //   Cuisine cuisine = Cuisine.find(Integer.parseInt(request.queryParams("cuisine_id")));
      //
      //   model.put("cuisine", cuisine);
      //
      //   String name = request.queryParams("name");
      //   String phone = request.queryParams("phone");
      //   Restaurant newRestaurant = new Restaurant(name,cuisine.getId(),phone);
      //   newRestaurant.save();
      //
      //   model.put("restaurants",Restaurant.all());
      //   model.put("template", "templates/index.vtl");
      //
      //   return new ModelAndView(model, layout);
      // }, new VelocityTemplateEngine());
      //

    }
}
