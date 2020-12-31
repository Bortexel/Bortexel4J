package ru.ruscalworld.bortexel4j.models.user;

import com.google.gson.annotations.SerializedName;
import ru.ruscalworld.bortexel4j.Bortexel4J;
import ru.ruscalworld.bortexel4j.core.Action;

import java.sql.Timestamp;

public class User {
    private final int id;
    private String username;

    @SerializedName(value = "last_login")
    private int lastLogin;

    @SerializedName(value = "valid_till")
    private Timestamp validTill;

    @SerializedName(value = "active_till")
    private Timestamp activeTill;

    private boolean permanent;
    private boolean strange;

    @SerializedName(value = "warn_power")
    private int warnPower;

    @SerializedName(value = "warn_count")
    private int warnCount;

    @SerializedName(value = "skin_system")
    private final String skinSystem;

    @SerializedName(value = "skin_name")
    private final String skinName;

    public User(int id, String username, int lastLogin, Timestamp validTill, Timestamp activeTill, boolean permanent, boolean strange, int warnPower, int warnCount, String skinSystem, String skinName) {
        this.id = id;
        this.username = username;
        this.lastLogin = lastLogin;
        this.validTill = validTill;
        this.activeTill = activeTill;
        this.permanent = permanent;
        this.strange = strange;
        this.warnPower = warnPower;
        this.warnCount = warnCount;
        this.skinSystem = skinSystem;
        this.skinName = skinName;
    }

    public static Action<User> getByID(int id, Bortexel4J client) {
        Action<User> action = new Action<>("/users/" + id, client);
        action.setResponseType(User.class);
        return action;
    }

    public static Action<User> getByUsername(String username, Bortexel4J client) {
        Action<User> action = new Action<>("/players/" + username, client);
        action.setResponseType(User.class);
        return action;
    }

    public Action<UserSkin> getSkin(Bortexel4J client) {
        return UserSkin.getByUserID(this.getId(), client);
    }

    public Action<UserSkin> setSkin(String system, String name, Bortexel4J client) {
        return UserSkin.setByUserID(this.id, system, name, client);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(int lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Timestamp getValidTill() {
        return validTill;
    }

    public void setValidTill(Timestamp validTill) {
        this.validTill = validTill;
    }

    public Timestamp getActiveTill() {
        return activeTill;
    }

    public void setActiveTill(Timestamp activeTill) {
        this.activeTill = activeTill;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public boolean isStrange() {
        return strange;
    }

    public void setStrange(boolean strange) {
        this.strange = strange;
    }

    public int getWarnPower() {
        return warnPower;
    }

    public void setWarnPower(int warnPower) {
        this.warnPower = warnPower;
    }

    public int getWarnCount() {
        return warnCount;
    }

    public void setWarnCount(int warnCount) {
        this.warnCount = warnCount;
    }

    public String getSkinName() {
        return skinName;
    }

    public String getSkinSystem() {
        return skinSystem;
    }
}
