private record UserData(
    String value,
    int timestamp
) {}

class TimeMap {
    private HashMap<String, List<UserData>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new UserData(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        final List<UserData> userData = map.get(key);

        if (userData == null) return "";

        int left = 0;
        int right = userData.size() - 1;
        int temp = -1;
        while (left <= right) {
            final int mid = left + (right - left) / 2;
            final int userTimestamp = userData.get(mid).timestamp();

            if (userTimestamp == timestamp) {
                return userData.get(mid).value();
            }

            if (userTimestamp < timestamp) {
                temp = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return temp == -1 ? "" : userData.get(temp).value();
    }
}
