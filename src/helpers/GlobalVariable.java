package helpers;

public class GlobalVariable {
    // Biến toàn cục tĩnh có thể thay đổi
    private static String globalValue;

    // Getter để lấy giá trị của biến
    public static String getGlobalValue() {
        return globalValue;
    }

    // Setter để thay đổi giá trị của biến
    public static void setGlobalValue(String value) {
        globalValue = value;
    }
}
