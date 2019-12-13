package com.zxin.java.design.flyweight;

import lombok.Data;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * 一个集合存储
 * 新建时获取引用
 *
 */
public final class FontData {
    /**
     * A weak hash map will drop unused references to FontData.
     * Values have to be wrapped in WeakReferences, 
     * because value objects in weak hash map are held by strong references.
     */
    private static final WeakHashMap<FontData, WeakReference<FontData>> FLY_WEIGHT_DATA = new WeakHashMap<>();
    private final int pointSize;
    private final String fontFace;
    private final Color color;
    private final Set<FontEffect> effects;

    private FontData(int pointSize, String fontFace, Color color, EnumSet<FontEffect> effects) {
        this.pointSize = pointSize;
        this.fontFace = fontFace;
        this.color = color;
        this.effects = Collections.unmodifiableSet(effects);
    }

    public static FontData create(int pointSize, String fontFace, Color color,
        FontEffect... effects) {
        EnumSet<FontEffect> effectsSet = EnumSet.noneOf(FontEffect.class);
        for (FontEffect fontEffect : effects) {
            effectsSet.add(fontEffect);
        }
        // We are unconcerned with object creation cost, we are reducing overall memory consumption  真精辟！！！
        FontData data = new FontData(pointSize, fontFace, color, effectsSet);

        // Retrieve previously created instance with the given values if it (still) exists
        WeakReference<FontData> ref = FLY_WEIGHT_DATA.get(data);
        FontData result = (ref != null) ? ref.get() : null;
        
        // Store new font data instance if no matching instance exists
        if (result == null) {
            FLY_WEIGHT_DATA.put(data, new WeakReference<FontData> (data));
            result = data;
        }
        // return the single immutable copy with the given values
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FontData) {
            if (obj == this) {
                return true;
            }
            FontData other = (FontData) obj;
            return other.pointSize == pointSize && other.fontFace.equals(fontFace)
                && other.color.equals(color) && other.effects.equals(effects);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (pointSize * 37 + effects.hashCode() * 13) * fontFace.hashCode();
    }

    // Getters for the font data, but no setters. FontData is immutable.
}

@Data
class Color {

}