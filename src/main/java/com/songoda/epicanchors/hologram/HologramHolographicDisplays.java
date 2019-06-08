package com.songoda.epicanchors.hologram;

import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import com.songoda.epicanchors.EpicAnchors;
import org.bukkit.Location;


public class HologramHolographicDisplays extends Hologram {

    public HologramHolographicDisplays(EpicAnchors plugin) {
        super(plugin);
    }

    @Override
    public void add(Location location, String line) {
        fixLocation(location);
        com.gmail.filoghost.holographicdisplays.api.Hologram hologram = HologramsAPI.createHologram(plugin, location);
        hologram.appendTextLine(line);
    }

    @Override
    public void remove(Location location) {
        fixLocation(location);
        for (com.gmail.filoghost.holographicdisplays.api.Hologram hologram : HologramsAPI.getHolograms(plugin)) {
            if (hologram.getX() != location.getX()
                    || hologram.getY() != location.getY()
                    || hologram.getZ() != location.getZ()) continue;
            hologram.delete();
        }
    }

    @Override
    public void update(Location location, String line) {
        fixLocation(location);
        for (com.gmail.filoghost.holographicdisplays.api.Hologram hologram : HologramsAPI.getHolograms(plugin)) {
            if (hologram.getX() != location.getX()
                    || hologram.getY() != location.getY()
                    || hologram.getZ() != location.getZ()) continue;
            if (hologram.getLine(0).toString().equals("CraftTextLine [text=" + line + "]")) continue;
            hologram.clearLines();
            hologram.appendTextLine(line);
        }
    }

    private void fixLocation(Location location) {
        location.add(0.5, 1.52, 0.5);
    }
}
