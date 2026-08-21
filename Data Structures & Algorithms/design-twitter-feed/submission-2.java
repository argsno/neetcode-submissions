class Twitter {
    private static int timestamp = 0;

    class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id) {
            this.id = id;
            this.time = timestamp;
            timestamp += 1;
        }
    }

    class User {
        int id;
        Set<Integer> followed;
        Tweet tweetHead;

        User(int id) {
            this.id = id;
            this.followed = new HashSet<>();
            this.followed.add(id);
        }

        void follow(int id) {
            followed.add(id);
        }

        void unfollow(int id) {
            if (id != this.id) {
                followed.remove(id);
            }
        }

        void post(int id) {
            Tweet tweet = new Tweet(id);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }

    Map<Integer, User> userMap = new HashMap<>();

    User getUser(int id) {
        if (userMap.containsKey(id)) {
            return userMap.get(id);
        }
        User user = new User(id);
        userMap.put(id, user);
        return user;
    }

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        User user = getUser(userId);
        user.post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return res;
        }
        Set<Integer> users = getUser(userId).followed;

        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        for (int user : users) {
            Tweet head = getUser(user).tweetHead;
            if (head != null) {
                pq.offer(head);
            }
        }

        while (!pq.isEmpty() && res.size() < 10) {
            Tweet curr = pq.poll();
            res.add(curr.id);
            if (curr.next != null) pq.offer(curr.next);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        User user = getUser(followerId);
        getUser(followeeId);
        user.follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            User user = getUser(followerId);
            getUser(followeeId);
            user.unfollow(followeeId);
        }
    }
}
