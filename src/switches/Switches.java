package switches;

public class Switches {
    public static void main(String[] args) {

        // ─── Classic switch with fall-through ─────────────────────────────────
        System.out.println("=== Classic switch (fall-through) ===");
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;   // without break, execution falls through to the next case
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
            case 7:      // intentional fall-through: both 6 and 7 print "Weekend"
                System.out.println("Weekend");
                break;
            default:
                System.out.println("Invalid day number");
        }

        // ─── Intentional Fall-Through ─────────────────────────────────────────
        System.out.println("\n=== Intentional Fall-Through ===");
        int month = 4;
        int daysInMonth;
        switch (month) {
            case 1: case 3: case 5: case 7:
            case 8: case 10: case 12:
                daysInMonth = 31;
                break;
            case 4: case 6: case 9: case 11:
                daysInMonth = 30;
                break;
            case 2:
                daysInMonth = 28;   // ignoring leap year for brevity
                break;
            default:
                daysInMonth = -1;
        }
        System.out.println("Month " + month + " has " + daysInMonth + " days.");

        // ─── Switch with Arrow Syntax (Java 14+, no fall-through) ────────────
        System.out.println("\n=== Arrow switch statement (Java 14+) ===");
        int dayArrow = 5;
        switch (dayArrow) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6, 7 -> System.out.println("Weekend");   // multiple labels, no fall-through
            default -> System.out.println("Invalid");
        }

        // ─── Switch Expression (returns a value, Java 14+) ────────────────────
        System.out.println("\n=== Switch Expression (Java 14+) ===");
        int score = 85;
        String grade = switch (score / 10) {
            case 10, 9 -> "A";
            case 8     -> "B";
            case 7     -> "C";
            case 6     -> "D";
            default    -> "F";
        };
        System.out.println("Score " + score + " → Grade: " + grade);

        // ─── Switch Expression with yield ─────────────────────────────────────
        System.out.println("\n=== Switch Expression with yield ===");
        int num = 2;
        String description = switch (num) {
            case 1 -> "one";
            case 2 -> {
                String text = "t" + "wo";   // multi-line block needs yield
                yield text;
            }
            case 3 -> "three";
            default -> "other";
        };
        System.out.println("num=" + num + " → " + description);

        // ─── Switch on String ─────────────────────────────────────────────────
        System.out.println("\n=== Switch on String ===");
        String season = "Winter";
        switch (season) {
            case "Spring" -> System.out.println("Flowers bloom.");
            case "Summer" -> System.out.println("It's hot.");
            case "Autumn", "Fall" -> System.out.println("Leaves fall.");
            case "Winter" -> System.out.println("It's cold.");
            default -> System.out.println("Unknown season.");
        }

        // ─── Switch on enum ───────────────────────────────────────────────────
        System.out.println("\n=== Switch on Enum ===");
        Direction direction = Direction.NORTH;
        String move = switch (direction) {
            case NORTH -> "Moving up";
            case SOUTH -> "Moving down";
            case EAST  -> "Moving right";
            case WEST  -> "Moving left";
        };
        System.out.println(direction + ": " + move);
    }

    enum Direction { NORTH, SOUTH, EAST, WEST }
}
