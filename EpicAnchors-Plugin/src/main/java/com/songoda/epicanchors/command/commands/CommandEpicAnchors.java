package com.songoda.epicanchors.command.commands;

import com.songoda.arconix.api.methods.formatting.TextComponent;
import com.songoda.epicanchors.api.EpicAnchors;
import com.songoda.epicanchors.command.AbstractCommand;
import com.songoda.epicanchors.EpicAnchorsPlugin;
import org.bukkit.command.CommandSender;

public class CommandEpicAnchors extends AbstractCommand {

    public CommandEpicAnchors() {
        super("EpicAnchors", null, false);
    }

    @Override
    protected ReturnType runCommand(EpicAnchorsPlugin instance, CommandSender sender, String... args) {
        sender.sendMessage("");
        sender.sendMessage(TextComponent.formatText(instance.references.getPrefix() + "&7Version " + instance.getDescription().getVersion() + " Created with <3 by &5&l&oBrianna"));

        for (AbstractCommand command : instance.getCommandManager().getCommands()) {
            if (command.getPermissionNode() == null || sender.hasPermission(command.getPermissionNode())) {
                sender.sendMessage(TextComponent.formatText("&8 - &a" + command.getSyntax() + "&7 - " + command.getDescription()));
            }
        }
        sender.sendMessage("");

        return ReturnType.SUCCESS;
    }

    @Override
    public String getPermissionNode() {
        return null;
    }

    @Override
    public String getSyntax() {
        return "/EpicAnchors";
    }

    @Override
    public String getDescription() {
        return "Displays this page.";
    }
}
