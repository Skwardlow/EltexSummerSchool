package ru.skwardlow.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.json.JsonObject;

public class MainServer {
    public static void main(String[] args) {
            Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(100)); // количество обработчиков

            JsonObject object = new JsonObject();
            object.put("User", "Oleg Tinkoff");
            object.put("Email", "zaym@mail.ru");

            vertx.createHttpServer().requestHandler(
                    request -> {
                        System.out.println(request.uri());
                        request.response()
                                .putHeader("Content-Type", "application/json")
                                .end(object.toString());
                    }
            ).listen(8081);
        }

    }
