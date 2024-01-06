class Solution {
    public int[] solution(String[] park, String[] routes) {
        int scount[] = new int[2];
        boolean check[][] = new boolean[park.length][park[0].length()];
        for(int i=0; i<park.length; i++){
            int len = park[i].length();
            for(int j=0; j<len; j++){
                if(park[i].charAt(j) == 'S'){
                    scount[0] = i;
                    scount[1] = j;
                }
                if(park[i].charAt(j) == 'X'){
                    check[i][j] = true;
                }
            }
        }
        for (int i = 0; i < routes.length; i++) {
            String tmp = routes[i];
            String date[] = tmp.split(" ");
            int tmp2 = Integer.parseInt(date[1]);
            int newX = scount[0];
            int newY = scount[1];

            if (date[0].equals("N")) {
                newX -= tmp2;
            } else if (date[0].equals("S")) {
                newX += tmp2;
            } else if (date[0].equals("W")) {
                newY -= tmp2;
            } else {
                newY += tmp2;
            }
            if (newX >= 0 && newX < park.length && newY >= 0 && newY < park[newX].length() && !hasXInPath(scount[0], scount[1], newX, newY, park, check)) {
                scount[0] = newX;
                scount[1] = newY;
            }
        }
        return scount;
    }
     private boolean hasXInPath(int startX, int startY, int endX, int endY, String[] park, boolean[][] check) {
        int stepX = (startX < endX) ? 1 : (startX > endX) ? -1 : 0;
        int stepY = (startY < endY) ? 1 : (startY > endY) ? -1 : 0;
        int currentX = startX;
        int currentY = startY;

        while (currentX != endX || currentY != endY) {
            currentX += stepX;
            currentY += stepY;
            if (check[currentX][currentY]) {
                return true;
            }
        }

        return false;
    }
}