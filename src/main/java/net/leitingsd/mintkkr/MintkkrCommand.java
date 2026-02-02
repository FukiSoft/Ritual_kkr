package net.leitingsd.mintkkr;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.Component;

import javax.inject.Inject;

public class MintkkrCommand implements SimpleCommand {

    private final ProxyServer server;

    @Inject
    public MintkkrCommand(ProxyServer server) {
        this.server = server;
    }

    @Override
    public void execute(Invocation invocation) {
        CommandSource source = invocation.source();

        if (!(source instanceof Player player)) {
            source.sendMessage(Component.text("只有玩家可以执行这个指令！"));
            return;
        }

        // 触发 /music 指令
        server.getCommandManager().executeAsync(player, "music https://music.163.com/dj?id=2532321241");

        // 给玩家发送私聊
        player.sendMessage(Component.text("我们伟大的 Mint_kkr 啊，我们赞美你！"));
    }
}