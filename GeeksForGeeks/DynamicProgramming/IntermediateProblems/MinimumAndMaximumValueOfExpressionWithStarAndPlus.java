class Solution {
    void printMinAndMaxValueOfExp(String exp) {
        int [] num = new int[];
        char [] opr = new char[];
        String tmp = "";
    
        // store operator and numbers in different vectors 
        for (int i = 0; i < exp.length(); i++) {
            if (isOperator(exp[i])) {
                opr.push_back(exp[i]);
                num.push_back(Integer.parseInt(tmp)); 
                tmp = ""; 
            } else {
                tmp += exp[i];
            }
        }

        //  storing last number in vector 
        num.push_back(Integer.parseInt(tmp)); 
    
        int len = num.length; 
        int minVal[][] = new int[len][len];
        int maxVal[][] = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                minVal[i][j] = Integer.MAX_VALUE; 
                maxVal[i][j] = 0; 
    
                //  initializing main diagonal by num values 
                if (i == j) minVal[i][j] = maxVal[i][j] = num[i];
            }
        }
    
        // looping similar to matrix chain multiplication 
        // and updating both 2D arrays 
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len - L + 1; i++) {
                int j = i + L - 1;
                for (int k = i; k < j; k++) {
                    int minTmp = 0, maxTmp = 0;
                    if(opr[k] == '+') {
                        minTmp = minVal[i][k] + minVal[k + 1][j];
                        maxTmp = maxVal[i][k] + maxVal[k + 1][j];
                    }
    
                    // if current operator is '*', updating tmp 
                    // variable by multiplication 
                    else if (opr[k] == '*') {
                        minTmp = minVal[i][k] * minVal[k + 1][j];
                        maxTmp = maxVal[i][k] * maxVal[k + 1][j];
                    }
    
                    //  updating array values by tmp variables 
                    if (minTmp < minVal[i][j]) minVal[i][j] = minTmp;
                    if (maxTmp > maxVal[i][j]) maxVal[i][j] = maxTmp;
                }
            }
        }
    }
}
