package com.xt.api.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.extensions.permessage_deflate.PerMessageDeflateExtension;
import org.java_websocket.handshake.ServerHandshake;

/**
 * @author zhouzhuang
 * @create 2023/12/12 17:06
 */
public class XtWebSocketClient extends WebSocketClient {

	private static final Logger LOG = Logger.getLogger(XtWebSocketClient.class);
	
    public XtWebSocketClient(String uri) throws URISyntaxException {
        super(new URI(uri),new Draft_6455(Collections.singletonList(new PerMessageDeflateExtension())));
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        LOG.debug("websocket connect server success");
    }
    @Override
    public void onMessage(String message) {
        LOG.debug("websocket recive msg ="+ message);
    }
    @Override
    public void onClose(int code, String reason, boolean remote) {
        LOG.debug("websocket client quit");
    }
    @Override
    public void onError(Exception ex) {
        LOG.debug("websocket connect error ="+ex.getMessage());
    }
}
