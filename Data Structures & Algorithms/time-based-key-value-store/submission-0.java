class TimeMap {
    Map<String, TreeMap<Integer, String>> timeMap = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, (k) -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }
        Integer k = timeMap.get(key).floorKey(timestamp);
        if (k == null) return "";
        return timeMap.get(key).get(k);
    }
}
