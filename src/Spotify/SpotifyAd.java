package Spotify;

import java.util.*;

public class SpotifyAd {
    private static final Random random = new Random();
    static final ArrayList<String> ads = new ArrayList<>(List.of(
            "🎶 Go Premium! 🚀",
            "🎧 Skip ads, play nonstop! 🔥",
            "💚 1 month free! 🎵",
            "📀 Premium = pure music ❤️",
            "🎙️ Podcasts, no ads! 🎙️",
            "🎵 Unlimited skips ⏭️",
            "🌍 Music everywhere 🌍",
            "🎶 Play without limits! ✨",
            "💚 Tap into Premium 💚",
            "🔥 Ad-free vibes 🔥",
            "🎧 Download music and listen offline, anytime, anywhere 🌍",
            "🎶 Upgrade to Spotify Premium and enjoy unlimited skips! ⏭️",
            "📀 Unlock ad-free listening with millions of tracks ❤️",
            "🎙️ Exclusive podcasts, only on Spotify Premium 🎤",
            "🎶 Music never stops with Premium 🚀",
            "🔥 Get Premium and unlock your playlists 🔑",
            "🎧 Skip every ad, every time ⏭️",
            "🎶 Millions of songs, zero interruptions ✨",
            "📱 Take your playlists offline, wherever you go 🌍",
            "💚 Enjoy music your way, with Spotify Premium ❤️",
            "🎶 With Spotify Premium, you can enjoy your favorite playlists without a single interruption, even when you’re offline. 📴",
            "💚 Experience crystal clear sound, unlimited skips, and exclusive podcasts — all included with Premium. 🎙️",
            "🔥 Join millions of fans already on Premium. Download your music, enjoy offline mode, and never hear an ad again! 🚀",
            "🎧 Why wait? With Spotify Premium, you get uninterrupted music, anytime, anywhere — no ads, no limits 🌍",
            "🎶 Upgrade today and unlock ad-free listening, offline mode, and the freedom to skip as much as you want ⏭️",
            "💚 Premium means no interruptions, no waiting, and no limits — just music, the way it should be 🎶",
            "📀 Take your playlists on the go, listen offline, and enjoy every track without ads ❤️",
            "🎙️ From exclusive podcasts to your favorite artists, Premium gives you everything, ad-free 🎧",
            "🔥 The music you love, the way you want it — Premium puts you in control 🚀",
            "🎶 Imagine music with no breaks, no ads, and unlimited skips — that’s Premium ✨"
    ));


    static void printWelcome() {
        System.out.println("""
                🎶 Discover Your New Favorite Playlist on Spotify! 🎧
                
                🌟 From chill vibes 🌙 to high-energy beats ⚡, Spotify has it all! 🔥
                
                🎵 Stream millions of songs 📱
                🎶 Create your own playlists 🎼
                💃 Dance to the latest hits 🕺
                🌍 Explore new genres from around the world 🌎
                
                ✨ Upgrade to Spotify Premium for:
                🔒 No ads 🚫
                🎧 Offline listening 🌟
                🎶 Unlimited skips 🔁
                
                What are you waiting for? Press play and let the music take over! 🎉🎶
                
                👉 Tap to start your Spotify journey today! 🎧
                
                #ListenOnSpotify #MusicEverywhere #PlayYourWay 🎶
                """);

        for (int i = 10; i >= 0; i--) {
            System.out.print("\rTime left of your ad: " + i + " seconds");
            System.out.flush();

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                break;
            }
        }
        System.out.print("\r" + "-".repeat(20) + "\n");
    }

    static void printAd(int timer) {
        String ad = ads.get(random.nextInt(ads.size()));
        System.out.println(ad);

        if (timer > 0) {
            for (int i = timer; i >= 0; i--) {
                System.out.print("\rTime left of your ad: " + i + " seconds");
                System.out.flush();

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    break;
                }
            }

            System.out.print("\r" + "-".repeat(20) + "\n");
        }
    }
}
