package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_2304 {

    // 1. 좌측 순행
    // 2. 우측순행
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            posts.add(new Post(input[0], input[1]));
        }

        int answer = 0;
        Post highestPost;
        Post leftPost;
        Post rightPost;
        for (int i = 0; i < posts.size() - 1; i++) {
            Post now = posts.get(i);
            Post next = posts.get(i + 1);
            // 다음이 더 작은 경우
            if (now.compareTo(next) > 0) {
                highestPost = findHighestPost(posts, now);
            }
            // 다음이 더 크거나 같은 경우
            else {
                answer += (next.xPos - now.xPos) * now.yPos;
                leftPost = next;
            }

        }
    }

    private static Post findHighestPost(List<Post> posts, Post standard) {
        for (Post post: posts) {
            if (post.xPos < standard.xPos) continue;
            if (post.yPos >= standard.yPos) {
                standard = post;
            }
        }
        return standard;
    }

    static class Post implements Comparable<Post> {
        private final int xPos;
        private final int yPos;

        public Post(int xPos, int yPos) {
            this.xPos = xPos;
            this.yPos = yPos;
        }

        public int getXPos() {
            return xPos;
        }

        public int getYPos() {
            return yPos;
        }

        @Override
        public int compareTo(Post o) {
            return this.yPos - o.yPos;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Post post = (Post) o;

            if (xPos != post.xPos) return false;
            return yPos == post.yPos;
        }

        @Override
        public int hashCode() {
            int result = xPos;
            result = 31 * result + yPos;
            return result;
        }

    }

}
