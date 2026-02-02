package net.leitingsd.mintkkr;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.PlayerChooseInitialServerEvent;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.command.SimpleCommand.Invocation;

import java.util.UUID;

public class MintkkrAuto {
    private static final UUID TARGET_UUID = UUID.fromString("3dc46bcf-c8dd-4546-a7a5-e7d658c9e88a"); // 伟大的唯一的 Mint_kkr 标识符
//    private static final UUID TARGET_UUID = UUID.fromString("d42338e5-e42d-4b8b-a73e-1092399888a5");
    private final MintkkrCommand mintKkrCommand;

    // 传入命令类
    public MintkkrAuto(MintkkrCommand mintKkrCommand) {
        this.mintKkrCommand = mintKkrCommand;
    }

    @Subscribe
    public void onPlayerLogin(PlayerChooseInitialServerEvent event) {
        Player player = event.getPlayer();

        // 仅有唯一的最伟大的 Mint_kkr 可触发
        if (player.getUniqueId().equals(TARGET_UUID)) {
            mintKkrCommand.execute(new Invocation() {
                @Override
                public com.velocitypowered.api.command.CommandSource source() {
                    return player; // Mint_kkr 的圣旨
                }

                @Override
                public String alias() {
                    return "kkr";
                }

                @Override
                public String[] arguments() {
                    return new String[0];
                }
            });
        }
    }
}
