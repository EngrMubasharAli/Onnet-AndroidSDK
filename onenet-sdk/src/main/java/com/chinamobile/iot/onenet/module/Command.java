package com.chinamobile.iot.onenet.module;

import com.chinamobile.iot.onenet.http.Urls;

import okhttp3.HttpUrl;

public class Command {

    public enum CommandType {
        TYPE_CMD_REQ, TYPE_PUSH_DATA
    }

    public static String urlForSending(String deviceId) {
        String s = new HttpUrl.Builder().scheme(Urls.sScheme).host(Urls.sHost).port(Urls.sPort).addPathSegment("cmds")
                .addQueryParameter("device_id", deviceId).toString();
        System.out.println(s);
        return s;
    }

    public static String urlForSending(String deviceId, boolean needResponse, int timeout, CommandType type) {
        String s = new HttpUrl.Builder().scheme(Urls.sScheme).host(Urls.sHost).port(Urls.sPort).addPathSegment("cmds")
                .addQueryParameter("device_id", deviceId).addQueryParameter("qos", needResponse ? "1" : "0")
                .addQueryParameter("timeout", String.valueOf(timeout))
                .addQueryParameter("type", String.valueOf(type.ordinal())).toString();
        System.out.println(s);
        return s;
    }

    public static String urlForQueryingStatus(String cmdUuid) {
        String s = new HttpUrl.Builder().scheme(Urls.sScheme).host(Urls.sHost).port(Urls.sPort).addPathSegment("cmds")
                .addPathSegment(cmdUuid).toString();
        System.out.println(s);
        return s;
    }

    public static String urlForQueryingResponse(String cmdUuid) {
        String s = new HttpUrl.Builder().scheme(Urls.sScheme).host(Urls.sHost).port(Urls.sPort).addPathSegment("cmds")
                .addPathSegment(cmdUuid).addPathSegment("resp").toString();
        System.out.println(s);
        return s;
    }

}
