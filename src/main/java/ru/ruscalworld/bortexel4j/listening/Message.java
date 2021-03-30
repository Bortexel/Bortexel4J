package ru.ruscalworld.bortexel4j.listening;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import okhttp3.WebSocket;
import ru.ruscalworld.bortexel4j.listening.events.Event;
import ru.ruscalworld.bortexel4j.models.ban.Ban;
import ru.ruscalworld.bortexel4j.models.warning.Warning;

import java.lang.reflect.Type;

public class Message {
    private final int operation;
    private final Object payload;

    public Message(int operation, Object payload) {
        this.operation = operation;
        this.payload = payload;
    }

    public void send(WebSocket webSocket) {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        webSocket.send(json);
    }

    public Type getEventType() {
        JsonElement payload = new Gson().toJsonTree(this.getPayload());
        switch (payload.getAsJsonObject().get("event_id").getAsInt()) {
            case Event.BAN_CREATED_EVENT:
            case Event.BAN_UPDATED_EVENT:
            case Event.BAN_DELETED_EVENT:
                return Ban.class;
            case Event.WARNING_CREATED_EVENT:
            case Event.WARNING_UPDATED_EVENT:
            case Event.WARNING_DELETED_EVENT:
                return Warning.class;
        }

        return Object.class;
    }

    public int getOperation() {
        return operation;
    }

    public Object getPayload() {
        return payload;
    }

    public static class Authorization {
        private final String token;

        public Authorization(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }
    }
}
