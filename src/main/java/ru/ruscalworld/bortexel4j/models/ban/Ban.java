package ru.ruscalworld.bortexel4j.models.ban;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import ru.ruscalworld.bortexel4j.Bortexel4J;
import ru.ruscalworld.bortexel4j.core.Action;

import java.sql.Timestamp;
import java.util.List;

public class Ban {
    private final int id;
    private final String username;
    private String reason;

    @SerializedName(value = "banned_by")
    private final String bannedBy;

    private final Timestamp time;
    private Timestamp expire;
    private String ip;

    @SerializedName(value = "by_name")
    private boolean byName;

    @SerializedName(value = "by_ip")
    private boolean byIP;

    private boolean paused;

    public Ban(int id, String username, String reason, String bannedBy, Timestamp time, Timestamp expire, String ip, boolean byName, boolean byIP, boolean paused) {
        this.id = id;
        this.username = username;
        this.reason = reason;
        this.bannedBy = bannedBy;
        this.time = time;
        this.expire = expire;
        this.ip = ip;
        this.byName = byName;
        this.byIP = byIP;
        this.paused = paused;
    }

    public static Action<Ban> getByID(int id, Bortexel4J client) {
        Action<Ban> action = new Action<>("/bans/" + id, client);
        action.setResponseType(Ban.class);
        return action;
    }

    public static Action<List<Ban>> getAll(Bortexel4J client) {
        Action<List<Ban>> action = new Action<>("/bans", client);
        action.setResponseType(TypeToken.getParameterized(List.class, Ban.class).getType());
        return action;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getBannedBy() {
        return bannedBy;
    }

    public Timestamp getTime() {
        return time;
    }

    public Timestamp getExpireTime() {
        return expire;
    }

    public void setExpireTime(Timestamp expire) {
        this.expire = expire;
    }

    public String getIP() {
        return ip;
    }

    public void setIP(String ip) {
        this.ip = ip;
    }

    public boolean isBannedByName() {
        return byName;
    }

    public void setBannedByName(boolean byName) {
        this.byName = byName;
    }

    public boolean isBannedByIP() {
        return byIP;
    }

    public void setBannedByIP(boolean byIP) {
        this.byIP = byIP;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }
}
