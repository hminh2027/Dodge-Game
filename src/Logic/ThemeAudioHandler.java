package Logic;

import IO.AudioLoader;

import javax.sound.sampled.Clip;

public class ThemeAudioHandler {
    AudioLoader audio;
    Clip game_theme;
    Clip boss_theme;
    Clip win;
    Clip lose;

    public ThemeAudioHandler(){
        audio = new AudioLoader();
        game_theme = audio.getAudio("game_theme.wav");
        boss_theme = audio.getAudio("boss_theme.wav");
        win = audio.getAudio("win.wav");
        lose = audio.getAudio("gameover.wav");
    }

    public void gameTheme(){
        boss_theme.stop();
        game_theme.start();
    }

    public void bossTheme(){
        game_theme.stop();
        boss_theme.start();
    }

    public void winTheme(){
        game_theme.stop();
        boss_theme.stop();
        win.start();
    }

    public void loseTheme(){
        game_theme.stop();
        boss_theme.stop();
        lose.start();
    }

    public void restart(){
        win.stop();
        lose.stop();
    }
}
