package net.leitingsd.mintkkr;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.Component;

import javax.inject.Inject;
import java.nio.file.Path;

@Plugin(
        id = "mintkkr",
        name = "MintKkr",
        version = "1.0.1",
        description = "Make Mint_kkr Great Again!",
        authors = {"Leitingsd"}
)
public class Mintkkr {

    private final ProxyServer server;
    private final Path dataDirectory;

    @Inject
    public Mintkkr(ProxyServer server, @DataDirectory Path dataDirectory) {
        this.server = server;
        this.dataDirectory = dataDirectory;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        // 注册指令
        MintkkrCommand mintkkrCommand = new MintkkrCommand(server);
        server.getCommandManager().register("kkr", new MintkkrCommand(server));
        server.getEventManager().register(this, new MintkkrAuto(mintkkrCommand));
        server.getConsoleCommandSource().sendMessage(Component.text("伟大的 Mint_kkr 最喜欢的音乐现将传遍各地~"));
    }
}