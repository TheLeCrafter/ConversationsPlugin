package dev.thelecrafter.dimensionz.conversations.utils;

public class TalkableUtils {

    public static Talkable fromNPCId(Integer id) {
        switch (id) {
            case 0:
                return Talkable.KING;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return Talkable.GUARD;
                // 6 was a test npc
            case 7:
                return Talkable.COUNCIL_1;
            case 8:
                return Talkable.COUNCIL_2;
            case 9:
                return Talkable.COUNCIL_3;
            case 10:
                return Talkable.COUNCIL_4;
            case 11:
                return Talkable.COUNCIL_5;
            default:
                return null;
        }
    }

}
