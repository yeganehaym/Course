package ir.plusteam.myapplication.Package2;

import ir.plusteam.myapplication.Bird;
import ir.plusteam.myapplication.VoiceInterface;


public class Owl extends Bird implements VoiceInterface{


    @Override
    public String Voice() {
        return "Owwww";
    }
}
