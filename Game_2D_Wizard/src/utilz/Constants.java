package utilz;

public class Constants {
    public static class PlayerConstants {
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int JUMP = 2;
        public static final int ATTACK_1 = 3;
        public static final int ATTACK_2 = 4;
        public static final int DEATH = 5;
        public static final int HIT = 6;
        public static final int FALL = 7;

        public static int GetSpriteAmount(int player_action) {
            switch (player_action) {
                case RUNNING:
                    return 6;
                case IDLE:
                    return 5;
                case ATTACK_1:
                case ATTACK_2:
                    return 8;
                case JUMP:
                case DEATH:
                case HIT:
                case FALL:
                default:
                    return 3;
            }
        }
    }
}
