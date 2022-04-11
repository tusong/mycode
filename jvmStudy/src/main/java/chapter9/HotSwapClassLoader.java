package chapter9;

/** defineClass㡈 㽤 ㆏ 㟍 ⒉ 㧴 ᧨ ♹ 㦘 ⮥ 捷 㣍 ㆞ 庒 䞷 䤓 㢅 ⊨ 㓜 ↩ ∎ 䞷 Ⓙ loadByte㡈 㽤 *䟀 壩 㕮 㧉 庒 䞷 㢅 ᧨ ⅜ 䏅 㖘 䏶 ☮ 㦘 䤓 ♛ ⅁ Ᵽ 㿍 屓 ⒨ ∎ 䞷 loadClass㡈 㽤 扪 嫛 伊 ┯ 戌 **@author zzm */
public class HotSwapClassLoader extends ClassLoader{
    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }
    public Class loadByte(byte[]classByte){
        return defineClass(null,classByte,0,classByte.length);
    }
}
