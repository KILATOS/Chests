import java.util.Scanner;

public class Main {
    private static int n;
    private static int m;
    private static int[][] field;
    private static int white = 0;
    private static int black = 0;

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            m = scanner.nextInt();
            n = scanner.nextInt();
            field = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    field[i][j] = scanner.nextInt();
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                switch (field[i][j]) {
                    case 0:
                        continue;
                    case 1:
                        white += checkWhiteHourse(i, j);
                        break;
                    case 2:
                        white += jumboWhiteCounter(i, j);
                        break;
                    case 3:
                        white+= fortWhiteCounter(i,j);
                        break;
                    case 4:
                        white+= kingWhiteCounter(i,j);
                        break;
                    case 5:
                        black+=checkBlackHourse(i,j);
                        break;
                    case 6:
                        black+=jumboBlackCounter(i,j);
                        break;
                    case 7:
                        black+=fortBlackCounter(i,j);
                        break;
                    case 8:
                        black+=kingBlackCounter(i,j);
                        break;
                }
            }
        }
        System.out.println(white + " " + black);

    }

    public static int checkWhiteHourse(int i, int j) {
        int localCounter = 0;
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                if (Math.abs(k - i) == 2 && Math.abs(l - j) == 1) {
                    if (field[k][l] > 4 && field[k][l] < 9) {
                        localCounter++;
                    }
                }
                if (Math.abs(k - i) == 1 && Math.abs(l - j) == 2) {
                    if (field[k][l] > 4 && field[k][l] < 9) {
                        localCounter++;
                    }
                }
            }
        }
        return localCounter;
    }

    public static int jumboWhiteCounter(int i, int j) {
        int localCounter = 0;
        boolean flag = true;
        int l = j;
        for (int k = i - 1; k >= 0; k--) {
            l+=1;
            if (l<n) {
                if (field[k][l] > 4 && field[k][l] < 9) {
                    localCounter++;
                    flag = false;
                    break;
                }
                if (field[k][l] != 0) {
                    flag = false;
                    break;
                }
            }
        }
        flag = true;
        l = j;
        for (int k = i + 1; k < m; k++) {
            l+=1;
            if (l<n) {
                if (field[k][l] > 4 && field[k][l] < 9) {
                    localCounter++;
                    flag = false;
                    break;
                }
                if (field[k][l] != 0) {
                    flag = false;
                    break;
                }
            }

        }
        flag = true;
        l = j;
        for (int k = i + 1; k < m; k++) {
            l--;
            if (l>=0) {
                if (field[k][l] > 4 && field[k][l] < 9) {
                    localCounter++;
                    flag = false;
                    break;
                }
                if (field[k][l] != 0) {
                    flag = false;
                    break;
                }
            }

        }
        flag = true;
        l=j;
        for (int k = i - 1; k >= 0; k--) {
            l--;
            if (l>=0) {
                if (field[k][l] > 4 && field[k][l] < 9) {
                    localCounter++;
                    flag = false;
                    break;
                }
                if (field[k][l] != 0) {
                    flag = false;
                    break;
                }
            }

        }
        return localCounter;

    }

    public static int fortWhiteCounter(int i, int j) {
        int localCounter = 0;
        for (int k = i + 1; k <m; k++) {
            if (field[k][j] > 4 && field[k][j] < 9) {
                localCounter++;
                break;
            }
            if (field[k][j] != 0) {
                break;
            }
        }
        for (int k = i - 1; k >= 0; k--) {
            if (field[k][j] > 4 && field[k][j] < 9) {
                localCounter++;
                break;
            }
            if (field[k][j] != 0) {
                break;
            }
        }
        for (int k = j + 1; k <n; k++) {
            if (field[i][k] > 4 && field[i][k] < 9) {
                localCounter++;
                break;
            }
            if (field[i][k] != 0) {
                break;
            }
        }
        for (int k = j - 1; k >=0; k--) {
            if (field[i][k] > 4 && field[i][k] < 9) {
                localCounter++;
                break;
            }
            if (field[i][k] != 0) {
                break;
            }
        }
        return localCounter;
    }
    public static int kingWhiteCounter(int i, int j){
        int localCounter = 0;
        for (int k = i-1; k <= i+1; k++) {
            for (int l = j - 1; l <= j+1; l++) {
                if (k>=0 && k<m && l>=0 &&l<n) {
                    if (field[k][l] > 4 && field[k][l] < 9) {
                        localCounter++;
                    }
                }
            }
        }
        return localCounter;
    }
    public static int checkBlackHourse(int i, int j) {
        int localCounter = 0;
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                if (Math.abs(k - i) == 2 && Math.abs(l - j) == 1) {
                    if (field[k][l] <=4 && field[k][l]>0) {
                        localCounter++;
                    }
                }
                if (Math.abs(k - i) == 1 && Math.abs(l - j) == 2) {
                    if (field[k][l] <=4 && field[k][l]>0) {
                        localCounter++;
                    }
                }
            }
        }
        return localCounter;
    }
    public static int jumboBlackCounter(int i, int j) {
        int localCounter = 0;
        boolean flag = true;
        int l = j;
        for (int k = i - 1; k >= 0; k--) {
            l+=1;
            if (l<n) {
                if (field[k][l] <=4 && field[k][l]>0) {
                    localCounter++;
                    flag = false;
                    break;
                }
                if (field[k][l] != 0) {
                    flag = false;
                    break;
                }
            }
        }
        flag = true;
        l = j;
        for (int k = i + 1; k < m; k++) {
            l+=1;
            if (l<n) {
                if (field[k][l] <=4 && field[k][l]>0) {
                    localCounter++;
                    flag = false;
                    break;
                }
                if (field[k][l] != 0) {
                    flag = false;
                    break;
                }
            }

        }
        flag = true;
        l = j;
        for (int k = i + 1; k < m; k++) {
            l--;
            if (l>=0) {
                if (field[k][l] <=4 && field[k][l]>0) {
                    localCounter++;
                    flag = false;
                    break;
                }
                if (field[k][l] != 0) {
                    flag = false;
                    break;
                }
            }

        }
        flag = true;
        l=j;
        for (int k = i - 1; k >= 0; k--) {
            l--;
            if (l>=0) {
                if (field[k][l] <=4 && field[k][l]>0) {
                    localCounter++;
                    flag = false;
                    break;
                }
                if (field[k][l] != 0) {
                    flag = false;
                    break;
                }
            }

        }
        return localCounter;

    }
    public static int fortBlackCounter(int i, int j) {
        int localCounter = 0;
        for (int k = i + 1; k <m; k++) {
            if (field[k][j] <=4 && field[k][j] >0) {
                localCounter++;
                break;
            }
            if (field[k][j] != 0) {
                break;
            }
        }
        for (int k = i - 1; k >= 0; k--) {
            if (field[k][j] <=4 && field[k][j] >0) {
                localCounter++;
                break;
            }
            if (field[k][j] != 0) {
                break;
            }
        }
        for (int k = j + 1; k <n; k++) {
            if (field[i][k] <= 4 && field[i][k] >0) {
                localCounter++;
                break;
            }
            if (field[i][k] != 0) {
                break;
            }
        }
        for (int k = j - 1; k >=0; k--) {
            if (field[i][k] <= 4 && field[i][k] >0) {
                localCounter++;
                break;
            }
            if (field[i][k] != 0) {
                break;
            }
        }
        return localCounter;
    }
    public static int kingBlackCounter(int i, int j){
        int localCounter = 0;
        for (int k = i-1; k <= i+1; k++) {
            for (int l = j - 1; l <= j+1; l++) {
                if (k>=0 && k<m && l>=0 &&l<n) {
                    if (field[k][l] <= 4 && field[k][l] > 0) {
                        localCounter++;
                    }
                }
            }
        }
        return localCounter;
    }

}